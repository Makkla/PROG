package pp.synchstacksem;

public class SynchTest
{

    public static void main(String[] args)
    {

        SynchStack stack = new SynchStack();

        StackThread1 thread1 = new StackThread1(stack);
        StackThread2 thread2 = new StackThread2(stack);

        thread1.start();
        thread2.start();
    }

}
