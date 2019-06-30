/**
 * This RingBuffer object . . .
 * 
 * @author  
 * @version 
 */
public class RingBuffer 
{
    private int front, rear, size; 
    private double array[]; 
    public RingBuffer(int capacity)
    {
        array = new double[capacity];
        
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public boolean isFull()
    {
        return (size == array.length);
    }

    public void add(double value)
    {
        array[rear] = value; 
        rear++; 
        if(rear == array.length){
            rear = 0; 
        }
        size++; 
    }

    public double peek()
    {
        if(front == array.length){
            front = 0; 
        }
        return array[front];
    }

    public double remove()
    {
        if(front == array.length){
            front = 0; 
        }
        double temp = array[front];
        array[front] = 0;  
        front++; 
        size--; 
        return temp;
    }

    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) 
    {
        int capacity = 100;
        RingBuffer buffer = new RingBuffer(capacity);  
        for (int i = 1; i <= capacity; i++) 
            buffer.add(i);

        double t = buffer.remove();
        buffer.add(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) 
        {
            double x = buffer.remove();
            double y = buffer.remove();
            buffer.add(x + y);
        }
        System.out.println(buffer.peek());
    }

}
