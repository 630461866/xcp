package shejimoshi.daili.dynamic;

//动态代理：JDK的方式
public class Client {

    public static void main(String[] args) {

        //创建目标对象
        ITeacherDao target = new TeacherDao();
        //给目标对象，创建代理对象，可以转成ITeacherDao
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();
        proxyInstance.teach();
        System.out.println(proxyInstance);

    }

}
