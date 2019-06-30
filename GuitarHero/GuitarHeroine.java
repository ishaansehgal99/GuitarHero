/**
 * This GuitarHeroine object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarHeroine
{
    public static void main(String[] args) 
    {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        // Create two guitar strings, for concert A and C
        double CONCERT_A = 440.0;

        GuitarString[] Strings = new GuitarString[37]; 

        for(int i = 0; i < Strings.length; i++){
            Strings[i] = new GuitarString(440 * (Math.pow(1.05956, i - 24)));

        }

        // the main input loop
        while (true) 
        {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) 
            {
                // the user types this character
                char key = StdDraw.nextKeyTyped();

                if(keyboard.indexOf(key) < 0){

                }

                else{
                    Strings[keyboard.indexOf(key)].pluck(); 
                }

            }

            // compute the superposition of the samples
            double sample = 0; 
            for(GuitarString String: Strings){
                sample += String.sample(); 

            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(GuitarString String: Strings){
                String.tic(); 

            }
        }
    }

}
