package shejimoshi.danli;

public class SingletonTest07 {

    public static void main(String[] args) {
        Singleton7 instance = Singleton7.INSTANCE;
        Singleton7 instance2 = Singleton7.INSTANCE;
        System.out.println(instance == instance2);
        instance.sayOK();
    }


}

//枚举实现单例
enum Singleton7 {
    INSTANCE;
    public void sayOK(){
        System.out.println("ok");
    }
}

