public class BucketHash{

	private MyArrayList<HashCodeGenerate> bucket;

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
		String value = "";
		if(bucket.isEmpty()){
			return "Empty list";
		}
		else{
			for(int i = 0; i < bucket.size(); i++){
				if(bucket.get(i).getKey() == key){
					value = bucket.get(i).value;
				}
			}
		}	
		return value;
	}

	public String put(Integer key, String value){ 
		System.out.println("ye");
		if(bucket.isEmpty()){
			return "Empty List.";
		}
		else{
			for(int i = 0; i < bucket.size(); i++){
				if(bucket.get(i).getKey() == key){
					String temp = bucket.get(i).getValue();
					bucket.get(i).setValue(value);
					return temp;
				}
			}	
			bucket.add(key,value);
			return null;
		}
	}

	public String remove(Integer key){
		if(bucket.isEmpty()){
			return "Empty List.";
		} else{
			for(int i = 0; i < bucket.size(); i++){
				if(bucket.get(i).getKey() == key){
					String temp = bucket.get(i).getValue();
					bucket.remove(i);
					return temp;
				}
			}
		}
		return null;
	}

}
