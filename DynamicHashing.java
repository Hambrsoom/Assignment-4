
public class DynamicHashing extends LinearProbing {
	public DynamicHashing(int capacity){
        super(capacity);
    }
	
	public void reHashing() {
		capacity = capacity*2;
		DynamicHashing hashTableTemp     = new DynamicHashing(capacity);
		HashCodeGenerate[] arr           = new HashCodeGenerate[capacity];
		int j                            = 0;
		
		for (int i=0; i<hashTable.length;i++) {
			if(hashTable[i]!=null) {
				arr[j] = new HashCodeGenerate(hashTable[i].key,hashTable[i].value);
 				j++;
			}	
		}
		
		hashTable                        = null;
		hashTable                        = new HashCodeGenerate[capacity];
		currentSize                      = 0;
		for(int i=0; i<arr.length;i++) {
			if(arr[i]!=null) {
				this.put(arr[i].key,arr[i].value);
			}
		}		
	}
	
//loadFactor:
	 public double getLoadFactor(){
	        return ((double) currentSize)/(double)capacity;
	    }
	 
//adding reHashing on the put method:
	@Override
	 public String put(Integer key, String value) {
			String value1 = super.put(key, value);
        
	        if(getLoadFactor() >= 0.5) {
	            reHashing();
	        }
	        return value1;
	    }

}
