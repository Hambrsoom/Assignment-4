
public abstract class abstractHashTable {
	private static int capacity;
	public abstractHashTable() {
		capacity=128;
	}
	public abstractHashTable(int capacity) {
		this.capacity= capacity;
	}
	public abstract void getCapacity();
	
	public int getCapacity1() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity=capacity;
	}
	public static int hashValue(Integer key) {
		return Math.abs(HashCodeGenerate.hashCode(key))% capacity;
			
	}
	
}
