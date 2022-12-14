package shejimoshi.shipeiqi.test2;

//适配器类
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;

    //通过构造器，传入一个实例，这个实例就是被适配的类
    public VoltageAdapter(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (null != voltage220V){
            int src = voltage220V.output220V();
            System.out.println("使用对象适配器");
            dst = src / 44;
            System.out.println("适配完成，输出的电压为="+dst);
        }
        return dst;
    }
}
