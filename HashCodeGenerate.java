/* COMP 352 - Assignment 4
 * 23/11/2018
 * Mohanad Arafe (ID: 40042922) & Hambrsoom Baboyan (ID: )
 * --------------Hash Code Generation--------------------
 * The HashCodeGenerate class will create random pairs of
 * of hash keys and implement a hash code using 
*/

import java.util.Random;
public class HashCodeGenerate{

	private Integer key;
	private String value;
	private final String[] arrayValues = {"COMP352", "COMP248", "COMP249", "SOEN228", "SOEN287", "SOEN341", "COMP335", "ENGR391", "ENGR371"};
	Random random = new Random();

	//Write a constructor that generates a new pair with a random Integer key
	public HashCodeGenerate(){
		key = random.nextInt();
		value = arrayValues[(int)(Math.random() * arrayValues.length)];
	}	

	//Generate hash code using Horner's rule
	public int hashCode(){
		String hashValue = key.toString();	
		int hashCode = hashValue.charAt(0);
		final int z = 41;
		for(int i = 1; i < hashValue.length(); i++){
			hashCode = hashCode + (int)((int)(hashValue.charAt(i)) + Math.pow(z, i));
		}
		return hashCode;
	}

	public static void main(String[] args){

		HashCodeGenerate hc = new HashCodeGenerate();
		System.out.println("Key is: " + (hc.key));
		System.out.println("Value is: " + (hc.value));
		System.out.println("Hash Code is: " + hc.hashCode());

	}

}
