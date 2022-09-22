package shejimoshi.shipeiqi.test3;

//接口适配器
public class Client {

    public static void main(String[] args) {

        AbsAdapter absAdapter = new AbsAdapter() {
            @Override
            public void m1() {//子类自己去实现,这个匿名内部类就是这个抽象类的实现类
                System.out.println("使用了m1的方法，自己重写实现");
            }
        };
        absAdapter.m1();
    }
}
