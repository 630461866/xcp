package shejimoshi.danli;

public class SingletonTest03 {

    public static void main(String[] args) {
        Singleton3 instance = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();
        System.out.println(instance == instance2);
    }


}

//懒汉式(线程不安全)
class Singleton3{

    //构造方法私有化，防止外部new
    private Singleton3(){}

    //本类内部创建对象实例
    private static Singleton3 instance;


    //提供一个公有的静态方法，当使用该方法时，才去创建
    public static Singleton3 getInstance(){
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }

}
