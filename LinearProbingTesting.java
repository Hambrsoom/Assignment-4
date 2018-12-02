import java.util.Random;
public class LinearProbingTesting {

	public static void main(String[] args) {
		
		 LinearProbing linearProbing = new LinearProbing(100);
	        Random random = new Random();
	        int[] keys = new int[50];
	        
//Putting the elements in the Table:
	        for (int i = 0; i < keys.length; i++) {
	            int key = random.nextInt();
	            keys[i]=key;
	            String value   = "word_"+i;
	            linearProbing.put(key, value);
	        }
	        
//Getting the elements from the table of the keys:
	        for (int i =0; i<keys.length;i++) {
	        	linearProbing.get(keys[i]);
	        }
	       
//Removing the first 25 elements:
	        for(int i =0; i<25;i++) {
	        	linearProbing.remove(keys[i]);
	        }
	        System.out.print(linearProbing);

//Step5:
	     /*   LinearProbing linearProbing1 = new LinearProbing(100);
	        for (int i = 0; i < 150; i++) {
	            int key = random.nextInt();
	            String value   = "word_"+i;
	            linearProbing1.put(key, value);
	        }*/
	
	}

}
