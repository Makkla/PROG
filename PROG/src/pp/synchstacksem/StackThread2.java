package pp.synchstacksem;

public class StackThread2 extends Thread
{

    private SynchStack stack;

    public StackThread2(SynchStack stack)
    {
        this.stack = stack;
    }

    public void run()
    {

        while (true)
        {
            stack.push(12);
            stack.pop();

        }

    }

}
