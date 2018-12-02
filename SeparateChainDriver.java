import java.util.Random;

public class SeparateChainDriver{

	public static void main(String[] args){

		SeperateChain seperateChain = new SeperateChain(100);
		Random random = new Random();
		int[] keys = new int[50];
		
		//Putting 50 values in the table
		for(int i = 0; i < keys.length; i++){
			int key = random.nextInt();
			keys[i] = key;
			String value   = "word_"+i;
	      seperateChain.put(key, value);
		}

	}

}
