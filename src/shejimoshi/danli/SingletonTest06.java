package shejimoshi.danli;

public class SingletonTest06 {

    public static void main(String[] args) {
        Singleton6 instance = Singleton6.getInstance();
        Singleton6 instance2 = Singleton6.getInstance();
        System.out.println(instance == instance2);
    }


}

//静态内部类实现单例
class Singleton6{

    //构造方法私有化，防止外部new
    private Singleton6(){}

    //静态内部类
    private static class SingletonInstance {
        private static final Singleton6 INSTANCE = new Singleton6();
    }


    //提供一个公有的静态方法，当使用该方法时，才去创建   加入同步锁，线程安全
    public static Singleton6 getInstance(){
        return SingletonInstance.INSTANCE;
    }

}
