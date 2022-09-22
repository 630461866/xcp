package xiancheng;

import java.util.concurrent.*;

public class ThreadTest {

    public static void main(String[] args) {
//        test();
        //CallerRunsPolicy - 当触发拒绝策略，只要线程池没有关闭的话，则使用调用线程直接运行任务。一般并发比较小，性能要求不高，不允许失败。但是，由于调用者自己运行任务，如果任务提交速度过快，可能导致程序阻塞，性能效率上必然的损失较大
        //AbortPolicy - 丢弃任务，并抛出拒绝执行 RejectedExecutionException 异常信息。线程池默认的拒绝策略。必须处理好抛出的异常，否则会打断当前的执行流程，影响后续的任务执行。
        //DiscardPolicy - 直接丢弃，其他啥都没有
        //DiscardOldestPolicy - 当触发拒绝策略，只要线程池没有关闭的话，丢弃阻塞队列 workQueue 中最老的一个任务，并将新任务加入

        //CPU密集型：CPU核心个数
        //比如银行，要去取钱，直接找柜台人员
        //
        //
        //IO密集型：（线程等待时间 + CPU运算时间）* CPU核心个数 / CPU运算时间
        //比如银行，要去办卡，柜台人员需要等待
        //
        //
        //cpu密集型计算推荐设置线程池核心线程数为N，也就是和cpu的线程数相同，可以尽可能低避免线程间上下文切换。
        //io密集型计算推荐设置线程池核心线程数为2N，但是这个数一般根据业务压测出来的，如果不涉及业务就使用推荐。
        int cpuNum = Runtime.getRuntime().availableProcessors();
        System.out.println(cpuNum);
        //配置核心线程数
        int corePool = cpuNum/2 + 1;
        //最大线程数  cpuNum*2 = 32     corePool =  9
        //自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePool, cpuNum*2,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(300));

        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

    }

    private static void test(){

        //这种线程池内部没有核心线程，线程的数量是有没限制的。
        //在创建任务时，若有空闲的线程时则复用空闲的线程，若没有则新建线程。
        //没有工作的线程（闲置状态）在超过了60S还不做事，就会销毁。
        //public static ExecutorService newCachedThreadPool() {
        //        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
        //                                      60L, TimeUnit.SECONDS,
        //                                      new SynchronousQueue<Runnable>());
        //    }
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread());
                }
            });
        }

    }


    private static void test2(){
        //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        //new ThreadPoolExecutor(nThreads, nThreads,
        //                                      0L, TimeUnit.MILLISECONDS,
        //                                      new LinkedBlockingQueue<Runnable>());
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    private static void test3(){
        //支持定时和周期性执行的线程池。
        //此方法无论任务执行时间长短，都是当第一个任务执行完成之后，延迟指定时间再开始执行第二个任务。
        //在日常开发中，newScheduledThreadPool可以作为timer的替代品，对比timer，newScheduledThreadPool更安全更强大
        //super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
        //              new DelayedWorkQueue())
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        },3000, TimeUnit.MILLISECONDS);
    }


    private static void test4(){
        //此线程池是一个单线程化的线程池，它只会用唯一的工作线程来执行任务
        //new ThreadPoolExecutor(1, 1,
        //                                    0L, TimeUnit.MILLISECONDS,
        //                                    new LinkedBlockingQueue<Runnable>())
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        });
    }





}
