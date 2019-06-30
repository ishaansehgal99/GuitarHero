/**
 * This GuitarString object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarString 
{
    private RingBuffer Buffer; 
    private int countTicTimesCalled = 0; 
    private int capacity; 
    public GuitarString(double frequency) 
    {
        capacity = (int)((44100/frequency) + 0.5); 
        Buffer = new RingBuffer(capacity); 
       
    }

    public GuitarString(double[] array) 
    {
        capacity = array.length; 
        Buffer = new RingBuffer(capacity);
        for(int i = 0; i < capacity; i++){
            Buffer.add(array[i]); 

        }
    }

    public void pluck() 
    {
        for(int i = 0; i < capacity; i++){
            double random = (double)((Math.random() * 2) - 0.5);
            Buffer.add(random);
        }
    }

    // advance the simulation one time step
    public void tic() 
    {
        double x = Buffer.remove();
        double y = Buffer.peek();
        Buffer.add(((x + y)/2) * 0.994);
        countTicTimesCalled++; 
    }

    // return the current sample
    public double sample() 
    {
        return Buffer.peek();
    }

    // return number of times tic was called
    public int time() 
    {
        return countTicTimesCalled;
    }

    public static void main(String[] args) 
    {
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < 25; i++) 
        {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }
}
