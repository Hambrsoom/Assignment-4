public class SeparateChain extends abstractHashTable{

	public BucketHash[] table;
	public int currentSize;
	public int collisions;


	public SeperateChain(int capacity){
		super(capacity);
		table = new BucketHash[capacity];
		collisions = 0;
		currentSize = 0;
	}

	public String get(Integer key){

		long startTime = System.nanoTime();
		int hashedKey = hashValue(key);
		String value = "";
		
		if(table[hashedKey] == null){
			return null;
		} else{
			value = table[hashedKey].get(key);
		}	
		long endTime = System.nanoTime();
		System.out.println("This method took : " + (endTime - startTime) + " ns.");
		return value;

	}

	public String put(Integer key, String value){

		long startTime = System.nanoTime();
		int hashedKey = hashValue(key);
		int oldSize = table[hashedKey].size();
		
		//Insert in bucket & keep track of size
		String temp = table[hashedKey].put(key, value);
		int newSize = table[hashedKey].size();

		if(newSize > oldSize)
			currentSize++;
		if(newSize > oldSize && oldSize != 0)
			collisions++;

		long endTime = System.nanoTime();
		System.out.println("The current size of the table is: " + getCapacity());
		System.out.println("There are " + currentSize + " elements in the table");
		System.out.println("There is a total of " + collisions + " collisions in the table");
		System.out.println("There currently are  " + newSize + " elements in this bucket");	
		System.out.println("This method took : " + (endTime - startTime) + " ns.");

		return temp;	
	
	}

	public String remove(Integer key){
		long startTime = System.nanoTime();
		int hashedKey = hashValue(key);

		//Remove the element
		String temp = table[hashedKey].remove(key);
		long endTime = System.nanoTime();
		System.out.println("This method took : " + (endTime - startTime) + " ns.");

		return temp;
	}


}
