import java.util.Random;

public class DynamicHashingTesting {

	public static void main(String[] args) {

	        
	   	 DynamicHashing dynamicProbing = new DynamicHashing(128);
	        Random random = new Random();
	        int[] keys = new int[10000];
	        
//Putting the elements in the Table:
	        for (int i = 0; i < keys.length; i++) {
	            int key = random.nextInt();
	            keys[i]=key;
	            String value   = "word_"+i;
	            dynamicProbing.put(key, value);
	        }
	       
	}
	
	

}
