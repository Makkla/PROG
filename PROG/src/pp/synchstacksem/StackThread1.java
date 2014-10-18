package pp.synchstacksem;

public class StackThread1 extends Thread
{

    private SynchStack stack;

    public StackThread1(SynchStack stack)
    {
        this.stack = stack;
    }

    public void run()
    {

        while (true)
        {

            stack.pop();

            stack.push(12);

        }

    }

}
