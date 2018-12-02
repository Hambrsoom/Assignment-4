public class BucketHash{

	public MyArrayList<HashCodeGenerate> bucket;

	BucketHash(){
		bucket = new MyArrayList<>();
	}

	public int size(){
		return bucket.size();
	}

	public boolean isEmpty(){
		return bucket.size() == 0;
	}

	public String get(Integer key){
		for(int i = 0; i < bucket.size(); i++){
			if(bucket.get(i).getKey().equals(key)){
				return bucket.get(i).getValue();
			}
		}	
		return null;
	}

	public String put(Integer key, String value){
		HashCodeGenerate pair = new HashCodeGenerate();
		pair.setKey(key); pair.setValue(value); 
		for(int i = 0; i < bucket.size(); i++){
			if(bucket.get(i).getKey().equals(key)){
				String temp = bucket.get(i).getValue();
				bucket.get(i).setValue(value);
				return temp;
			}
		}	
		bucket.add(0,pair);
		return null;
	}

	public String remove(Integer key){
		for(int i = 0; i < bucket.size(); i++){
			if(bucket.get(i).getKey().equals(key)){
				String temp = bucket.get(i).getValue();
				bucket.remove(bucket.get(i));
				return temp;
			}
		}
		return null;
	}

}
