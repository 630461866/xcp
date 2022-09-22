package shejimoshi.shipeiqi.mvc;

public interface Controller {

}

class HttpController implements Controller{

    public void doHttpHandler(){
        System.out.println("http...");
    }

}

class SimpleController implements Controller{

    public void doSimpleController(){
        System.out.println("simple...");
    }

}

class AnnotationController implements Controller{

    public void doAnnotationController(){
        System.out.println("annotation..");
    }

}



