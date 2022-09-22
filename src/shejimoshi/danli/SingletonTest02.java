package shejimoshi.danli;

public class SingletonTest02 {

    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println(instance == instance2);
    }


}

//饿汉式(静态代码块)
class Singleton2{

    //构造方法私有化，防止外部new
    private Singleton2(){}

    //本类内部创建对象实例
    private final static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    //提供一个公有的静态方法，返回实例对象
    public static Singleton2 getInstance(){
        return instance;
    }

}
