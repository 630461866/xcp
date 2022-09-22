import java.util.concurrent.Semaphore;

public class SNP {

    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) throws InterruptedException {

        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();
        ////申请许可第四个就阻塞了，也就是到这里
        semaphore.acquire();
        //这里是释放信号量，然后上面的acquire就能拿到，
        semaphore.release();
    }

}
