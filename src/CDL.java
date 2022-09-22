import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class CDL {

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {

        //线程4执行完以后，线程1和线程5都会被唤醒
        //线程1
        countDownLatch.await();

        //线程5
        countDownLatch.await();

        //线程2
        countDownLatch.countDown();

        //线程3
        countDownLatch.countDown();

        //线程4
        countDownLatch.countDown();

        ArrayList arrayList = new ArrayList();

    }


}
