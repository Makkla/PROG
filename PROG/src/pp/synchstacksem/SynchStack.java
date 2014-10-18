package pp.synchstacksem;

public class SynchStack
{
    private final int n = 20;

    private int stackpointer = -1;

    private Object stack[] = new Object[n];

    private Semaphore semaphore1 = new Semaphore(1);

    private Semaphore semaphore2 = new Semaphore(1);

    private Semaphore semaphore3 = new Semaphore(0);

    public SynchStack()
    {

    }

    boolean isEmpty()
    {
        aquireStackpointer();
        boolean zwischenspeicher = (stackpointer == -1);
        releaseStackpointer();
        return zwischenspeicher;
    }

    public void push(Object newObject)
    {
        System.out.println("Push start");

        aquireStackpointer();
        aquireStack();
        stackpointer++;
        if (stackpointer == stack.length)
        { // Feld vergrößern
            Object neu[] = new Object[stack.length + n];
            for (int i = 0; i < stack.length; i++)
            {
                neu[i] = stack[i];
            }
            stack = neu;
        }
        stack[stackpointer] = newObject;
        System.out.println("Falls einer gewartet hat darf er weiter machen. StackPointer hat den wert: " + stackpointer);
        semaphore3.v();
        releaseStack();
        releaseStackpointer();

        System.out.println("Push ende");

    }

    public Object pop()
    {

        System.out.println("Pop start");
        Object zwischenspeicher;

        if (isEmpty())
        {
            System.out.println("pop on empty thread... warte...");
            semaphore3.p();
            System.out.println("pop on empty thread... Darf weiter machen...");

        }

        aquireStackpointer();
        System.out.println("habe stackpointer aquiriert: hat den Wert: " + stackpointer);
        aquireStack();

        stackpointer--;

        zwischenspeicher = stack[stackpointer + 1];
        releaseStack();
        releaseStackpointer();

        System.out.println("Pop ende");
        return zwischenspeicher;

    }

    public int aquireStackpointer()
    {
        semaphore1.p();
        return stackpointer;
    }

    public void releaseStackpointer()
    {
        semaphore1.v();
    }

    public Object[] aquireStack()
    {

        semaphore2.p();
        return stack;

    }

    public void releaseStack()
    {

        semaphore2.v();

    }

    public void aquireResources()
    {

        aquireStackpointer();
        aquireStack();

    }

    public void releaseResources()
    {

    }
}
