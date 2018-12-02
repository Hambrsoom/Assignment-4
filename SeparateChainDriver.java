import java.util.Random;
import java.io.*;

public class SeparateChainDriver{

	public static void main(String[] args){

		SeparateChain separateChain = new SeparateChain(100);
		Random random = new Random();
		int[] keys = new int[50];
		PrintWriter pw = null;		

		try{
			pw = new PrintWriter(new FileOutputStream("collisions.txt"));
		} catch(FileNotFoundException e){
			System.out.println(e.getStackTrace());
		}

		//Putting 50 values in the table
		System.out.println("---------PUT(K,V) 50 VALUES-------");
		for(int i = 0; i < keys.length; i++){
			int key = random.nextInt();
			keys[i] = key;
			String value   = "word_"+i;
	      separateChain.put(key, value);
		}

		//Getting 50 values from the table
		System.out.println("---------GET(K) 50 VALUES-------");
		for(int i = 0; i < keys.length; i++){
			System.out.println(separateChain.get(keys[i]));
		}

		//Remove first 25 values
		System.out.println("---------REMOVE(K) 25 VALUES-------");
		for(int i = 0; i < 25; i++){
			System.out.println(separateChain.remove(keys[i]));
		}

		separateChain = new SeparateChain(100);
		int[] input = new int[150];
		for(int i = 0; i < input.length; i++){
			int key = random.nextInt();
			String value = "word_"+i;
			input[i] = key;
			separateChain.put(key, value);
			pw.println(separateChain.collisions);		
		}
		pw.close();
	}

}
