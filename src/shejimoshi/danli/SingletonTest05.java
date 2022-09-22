package shejimoshi.danli;

public class SingletonTest05 {

    public static void main(String[] args) {
        Singleton5 instance = Singleton5.getInstance();
        Singleton5 instance2 = Singleton5.getInstance();
        System.out.println(instance == instance2);
    }


}

//懒汉式(双重校验锁) DCL 两次检查加一把锁
class Singleton5{

    //构造方法私有化，防止外部new
    private Singleton5(){}

    //本类内部创建对象实例
    private static volatile Singleton5 instance;


    //提供一个公有的静态方法，当使用该方法时，才去创建   加入同步锁，线程安全
    public static Singleton5 getInstance(){
        //第一次检查的目的是保证只有第一次并发的时候才会阻塞，提高性能
        if (instance == null){
            //锁的是对象，也可以理解为是方法的调用者
            synchronized (Singleton5.class){
                //第二次检查是为了保证单例，避免去重复创建单例对象
                if (instance == null){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

}
