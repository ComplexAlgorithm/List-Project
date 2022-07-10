package nodeBasedPackage;

public interface ListInterface2<T> {
	//method headings
	
	public void add(T item);
	
	public boolean remove(T item);
	
	public boolean find(T item);
	
	public String toString();
	
	//returns the number of items on the list
	public int size();
}
