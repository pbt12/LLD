import javax.management.relation.RelationNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        JoinTest test1 = new JoinTest(); // Test: Thread.join() -> will halt the processing of main thread that called this thread
        test1.test(); // if Thread.join() is not added, then main will not wait for this thread's execution.
    }
}
