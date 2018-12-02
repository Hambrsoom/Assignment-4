import java.util.Random;
import java.util.Random;
public class QuadraticProbingTesting {
	public static void main(String[] args) {
		
		 QuadraticProbing quadraticProbing = new QuadraticProbing(100);
	        Random random = new Random();
	        int[] keys = new int[50];
	        
//Putting the elements in the Table:
	        for (int i = 0; i < keys.length; i++) {
	            int key = random.nextInt();
	            keys[i]=key;
	            String value   = "word_"+i;
	            quadraticProbing.put(key, value);
	        }
	        
//Getting the elements from the table of the keys:
	        for (int i =0; i<keys.length;i++) {
	        	quadraticProbing.get(keys[i]);
	        }
	       
//Removing the first 25 elements:
	        for(int i =0; i<25;i++) {
	        	quadraticProbing.remove(keys[i]);
	        }
	        System.out.print(quadraticProbing);
	        
//For Step 5:
	      /* QuadraticProbing quadraticProbing1 = new QuadraticProbing(100);
	        for (int i = 0; i < 150; i++) {
	            int key = random.nextInt();
	            String value   = "word_"+i;
	            quadraticProbing1.put(key, value);
	        }
	        */
	}

}
