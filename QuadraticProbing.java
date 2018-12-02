
public class QuadraticProbing extends abstractHashTable {
		public HashCodeGenerate[] hashTable;
		public int collisions;
		public int currentSize;
		public QuadraticProbing(int capacity) {
			super(capacity);
			hashTable = new HashCodeGenerate[capacity];
			collisions=0;
			currentSize=0;
		}
		
//Get Method:
		public String get(Integer key) {
			long startTime = System.currentTimeMillis();

//Storing the key's hashValue:
			int temp = hashValue(key);
			String value = null;
			
//number of attempts that would be used later:
			int attempts=0;
			
//The table is empty:
			if(currentSize==0) {
				System.out.println("The table is empty");
				value = null;
			}
			
//The index at this hashValue is never being used:
			else if(hashTable[temp]==null) {
				value = null;
			}
			
//found the value at the first hashValue:
			else if(hashTable[temp].key.equals(key)) {
				value = hashTable[temp].value;
			}
			
//Looking where the value with this key has been stored in the table using
//quadraticProbing:
			else {
				int start         = temp;
				String tempString = null;
				attempts         += 1;
				temp              = (hashValue(key) + (int)Math.pow(attempts, 2)) % capacity;
				while (start !=temp) {
					if(hashTable[temp].key.equals(key)) {
						tempString = hashTable[temp].value;
						break;
					}
					else if(hashTable[temp]==null) {
						tempString=null;
						break;
					}
					else {
						attempts += 1;
						temp      = (hashValue(key) + (int)Math.pow(attempts, 2)) % capacity;
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
			
			if(hashTable[temp]==null) {
				hashTable[temp] = new HashCodeGenerate(key,value);
				currentSize++;
				hashCodeGenerateTemp = null;
			}
			else if(hashTable[temp].value.equalsIgnoreCase("Available") && hashTable[temp].key==1) {
				currentSize++;
				hashTable[temp]      = null;
				hashTable[temp]      = new HashCodeGenerate(key,value);
				hashCodeGenerateTemp = null;
			}
			else if(hashTable[temp].key.equals(key)) {
				hashCodeGenerateTemp  = hashTable[temp].value;
				hashTable[temp].value = value;
				hashCodeGenerateTemp  =  null;
			}
			else {
				int start = temp;
				probingAttempts += 1; 
				temp             = (hashValue(key) + (int)Math.pow(probingAttempts, 2)) % capacity;
				collisions+=1;
				while(temp != start) {
					
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
						collisions+=1;
						probingAttempts += 1;
						temp = (hashValue(key) + (int)Math.pow(probingAttempts, 2)) % capacity;
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
			int attempts=0;
			if(currentSize==0) {
				hashCodeGenerateTemp = null;
			}
			else if(hashTable[temp]==null) {
				hashCodeGenerateTemp=null;
			}
			else if(hashTable[temp].key.equals(key)) {
				hashCodeGenerateTemp = hashTable[temp].value;
				hashTable[temp].key=-1;
				hashTable[temp].value="Available";
				currentSize--;
			}
			else {
				int start =temp;
				attempts+=1;
				temp = (hashValue(key) + (int)Math.pow(attempts, 2)) % capacity;
				while (temp!=start) {
					if(hashTable[temp]==null) {
						hashCodeGenerateTemp=null;
					}
					if(hashTable[temp].key.equals(key)) {
						hashCodeGenerateTemp = hashTable[temp].value;
						hashTable[temp].key=-1;
						hashTable[temp].value="Available";
						currentSize--;
						break;
					}
					else {
						attempts+=1;
						temp = (hashValue(key) + (int)Math.pow(attempts, 2)) % capacity;
					}
				}
			}
			endTime = System.currentTimeMillis();
			System.out.println("The execution of (remove) method took : " + (endTime - startTime) + " (ms).");
			return hashCodeGenerateTemp;
		}
		
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
		public int Size() {
			return currentSize;
		}
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
		
	public static void main(String[] args) {
		

	}

}

