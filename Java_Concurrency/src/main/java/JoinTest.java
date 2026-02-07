public class JoinTest {
    public void test(){
        Runnable runnable = () ->{
            System.out.println("Started running!");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread worker = new Thread(runnable, "WorkerThread");
        worker.start();
        //worker.join(); // Comment this on or off, to see the output diff
        System.out.println("Main finished execution!");
    }
}
