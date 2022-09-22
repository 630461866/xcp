package shejimoshi.danli;

public class SingletonTest04 {

    public static void main(String[] args) {
        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();
        System.out.println(instance == instance2);
    }


}

//懒汉式(线程安全，同步方法)
class Singleton4{

    //构造方法私有化，防止外部new
    private Singleton4(){}

    //本类内部创建对象实例
    private static Singleton4 instance;


    //提供一个公有的静态方法，当使用该方法时，才去创建   加入同步锁，线程安全
    public static synchronized Singleton4 getInstance(){
        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
    }

}
