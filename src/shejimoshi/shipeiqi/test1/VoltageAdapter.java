package shejimoshi.shipeiqi.test1;

//适配器类   继承了被适配的类
public class VoltageAdapter extends Voltage220V implements IVoltage5V{

    @Override
    public int output5V() {
        //获取220V电压
        int i = output220V();
        int result = i/44;
        return result;
    }
}
