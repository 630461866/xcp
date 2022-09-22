package shejimoshi.shipeiqi.mvc;

import java.util.ArrayList;
import java.util.List;

//自己实现Springmvc的适配器原理
public class DispatchServlet {

    public static List<HandlerAdapter> handlerAdapters = new ArrayList<HandlerAdapter>();

    public DispatchServlet() {
        handlerAdapters.add(new AnnotationHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
    }

    public void doDispatch() {
        //此处模拟SpringMVC从request取handler的对象,适配器可以获取到希望的Controller
        //HttpController controller = new HttpController();
        //SimpleController controller = new SimpleController();
        AnnotationController controller = new AnnotationController();
        //得到对应适配器
        HandlerAdapter adapter = getHandler(controller);
        //通过适配器执行对应的controller对应方法
        //本质:适配器变化了调用的方法也会变化  controller变化->HandlerAdapter也会变化->调用的方法也会变化
        adapter.handle(controller);
    }

    public HandlerAdapter getHandler(Controller controller) {
        for (HandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(controller)){
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new DispatchServlet().doDispatch();
    }

}
