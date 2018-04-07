
public abstract class Element implements Comparable<Integer>{
	private int key;
	//I'm not sure if this how the element class should look like soooo...
	public int compareTo(int n) {
		if(this.key > n) {
			return 1;
		}
		if(this.key < n) {
			return -1;
	 }
	 return 0;} 
}
