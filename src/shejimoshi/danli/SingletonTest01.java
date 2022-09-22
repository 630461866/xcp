package shejimoshi.danli;

public class SingletonTest01 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }


}

//饿汉式(静态变量)
class Singleton{

    //构造方法私有化，防止外部new
    private Singleton(){}

    //本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    //提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }

}
