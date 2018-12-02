import java.util.Random;
public class LinearProbing extends abstractHashTable {
	public HashCodeGenerate[] hashTable;
	public int collisions;
	public int currentSize;
	public LinearProbing(int capacity) {
		super(capacity);
		hashTable   = new HashCodeGenerate[capacity];
		collisions  = 0;
		currentSize = 0;
	}
	
//Get Method:
	public String get(Integer key) {
		long startTime = System.currentTimeMillis();
		
//Storing the hashValue of the key:
		int temp = hashValue(key);
		String value = null;
		
//empty Table:
		if(currentSize==0) {
			System.out.println("The table is empty");
			value = null;
		}
		
//There is nothing at that key index:
		else if(hashTable[temp]==null) {
			value = null;
		}

//Finding the value:
		else if(hashTable[temp].key.equals(key)) {
			value = hashTable[temp].value;
		}
		
//It was replaced somewhere else:
		else {
			int start = temp;
			String tempString =null;
			
//Linear Probing:
			temp = (temp+1)% capacity;
			
//if start == temp. Then we have passed through the whole Table:
			while (start !=temp) {
				if(hashTable[temp].key.equals(key)) {
					tempString = hashTable[temp].value;
					break;
				}
				else if(hashTable[temp]==null) {
					tempString = null;
					break;
				}
				else {
					temp = (temp + 1)%capacity;
				}
			}
			
			value = tempString;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("The execution of (get) method took : " + (endTime - startTime) + " (ms).");
		return value;
	}
	
//put method:
	public String put(Integer key, String value) {
		int temp                    = hashValue(key);
		int probingAttempts         = 0;
		String hashCodeGenerateTemp = null;
		long startTime              = System.currentTimeMillis();
		long endTime                = 0;
		boolean boom                = false;
		
//Store at the first located place:
		if(hashTable[temp]==null) {
			hashTable[temp]= new HashCodeGenerate(key,value);
			currentSize++;
			hashCodeGenerateTemp = null;
		}
//Store it also if that place contain the value Available: which means the element was deleted from here
		else if(hashTable[temp].value.equalsIgnoreCase("Available") && hashTable[temp].key==1) {
			currentSize++;
			hashTable[temp] = null;
			hashTable[temp] = new HashCodeGenerate(key,value);
			hashCodeGenerateTemp = null;
		}

//Replace the value if the key were exactly the same:
		else if(hashTable[temp].key.equals(key)) {
			hashCodeGenerateTemp = hashTable[temp].value;
			hashTable[temp].value= value;
			hashCodeGenerateTemp =  null;
		}
		
//Look where to put it
		else {
			int start = temp;
			probingAttempts += 1; 
			temp = (temp+1)% capacity;
			collisions+=1;
			while(temp !=start) {
				
 				if(hashTable[temp]==null) {
					currentSize++;
					hashTable[temp]= new HashCodeGenerate(key,value);
					break;
				}
				else if(hashTable[temp].value.equalsIgnoreCase("Available") && hashTable[temp].key==-1) {
					currentSize++;
					hashTable[temp] = null;
					hashTable[temp] = new HashCodeGenerate(key,value);
					break;
				}
				else if(hashTable[temp].key.equals(key)) {
					hashCodeGenerateTemp = hashTable[temp].value;
					
					hashTable[temp].value= value;
					break;
				}
				else {
					collisions++;
					temp = (temp + 1)%capacity;
					probingAttempts+=1;
				}
			}
			
		}
		endTime =System.currentTimeMillis();
		 
	        System.out.println("The execution of (put) method took : " + (endTime - startTime) + " (ms).");
	        System.out.println("The table's current size: " + capacity + ".");
	        System.out.println("It contains: " + currentSize + " element(s).");
	        System.out.println("There has been: " + collisions + " collision(s).");
	        System.out.println("There have been: " + probingAttempts + " linear probing attempt(s) to find an empty slot.");
	        System.out.println("------------------------------------------------------------");
		return hashCodeGenerateTemp;
	}
	
//remove method:
	public String remove(Integer key) {
		long startTime              = System.currentTimeMillis();
		long endTime                = 0;
		int temp                    = hashValue(key);
		String hashCodeGenerateTemp = null;
		
//The table is empty:
		if(currentSize==0) {
			hashCodeGenerateTemp = null;
		}
		
//There hasn't been any value with this key before
		else if(hashTable[temp]==null) {
			hashCodeGenerateTemp=null;
		}
//Delete the element at this index and replace its key by -1 and its value by Available
		else if(hashTable[temp].key.equals(key)) {
			currentSize--;
			hashCodeGenerateTemp = hashTable[temp].value;
			hashTable[temp].key=-1;
			hashTable[temp].value="Available";
		}
		
//Keep looking until you find the element with this key or won't find it.
		else {
			int start =temp;
			temp = (temp + 1) % capacity;
			while (temp!=start) {
				if(hashTable[temp]==null) {
					hashCodeGenerateTemp=null;
				}
				if(hashTable[temp].key.equals(key)) {
					currentSize--;
					hashCodeGenerateTemp = hashTable[temp].value;
					hashTable[temp].key=-1;
					hashTable[temp].value="Available";
					break;
				}
				else {
					temp = (temp + 1) % capacity;
				}
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("The execution of (remove) method took : " + (endTime - startTime) + " (ms).");
		return hashCodeGenerateTemp;
	}
	
//ToString:
	public String toString() {
		if(currentSize==0) {
			return "empty Table";
		}
		String line="";
		for(int i =0;i<capacity;i++) {
			if(hashTable[i]!=null) {
				line += "Index " + i + " => Key: " + hashTable[i].key + " Value: " + hashTable[i].value +  "\n ";  
			}
		}
		return line;
	}
	
//Size:
	public int Size() {
		return currentSize;
	}
	
//If the table is empty:
	public boolean isEmpty() {
		if(currentSize==0) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public void getCapacity1() {
		System.out.println("Doing nth");
		
	}
}
