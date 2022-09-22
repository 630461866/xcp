package shejimoshi.shipeiqi.test1;

public class Client {
    //类适配器
    public static void main(String[] args) {
        System.out.println("类适配器模式");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }

}



