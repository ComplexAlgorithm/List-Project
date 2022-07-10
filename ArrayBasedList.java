package arrayBasedPackage;

public class ArrayBasedList<T> extends Object implements ListInterface<T> {
	//instance variables
	private int numberOfItems;
	private T[] list; //reference to an array of Objects which are of type T
	
	//default constructor
	public ArrayBasedList() {
		super();
		numberOfItems = 0;
		list = (T[])new Object[5];
	}
	
	//overloaded constructor
	public ArrayBasedList(int size) {
		super();
		numberOfItems = 0;
		if(size > 0) {
			list = (T[])new Object[size];
		}
		else {
			list = (T[])new Object[5];
		}
	}
	
	@Override
	public void add(T item) {
		// TODO Auto-generated method stub
		if(numberOfItems < list.length) {
			list[numberOfItems] = item;
			numberOfItems++;
		}
		else {
			T[] largerList = (T[])new Object[list.length + list.length]; //local variable
			for(int index = 0; index < list.length; index++) {
				largerList[index] = list[index]; //copy the items in the corresponding locations
			}
			largerList[numberOfItems] = item; //places the item into the largerList
			numberOfItems++;
			list = largerList;
		}
	}
	
	//create a locate method to return the index of the item that is being searched for if the
	//item exists on the list otherwise return -1 to represent the item is not on the list
	//private methods are not accessible outside the class, they are sometimes referred to as
	//"helper" methods because they can only be called by other methods in the class and they
	//help those methods accomplish their tasks
	private int locate(T item) {
		int index = 0;
		boolean found = false;
		while(!found && index < numberOfItems) {
			if(list[index].equals(item)) {
				found = true;
			}
			else {
				index++;
			}
		}
		if(!found) {
			index = -1; //the item does not exist on the list, because -1 is never an index of an array
		}
		return index;
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		int index = locate(item);
		boolean removed = false;
		if(index != -1) {
			 list[index] = null; //remove the item at the index
			 numberOfItems--; //there is one less item on the list
			 list[index] = list[numberOfItems]; //copy the last item on the list to the location where the item was removed
			 list[numberOfItems] = null;
			 removed = true;
		}
		return removed;
	}

	@Override
	public boolean find(T item) {
		// TODO Auto-generated method stub
		int index = locate(item);
		boolean found = false;
		if(index != -1) {
			found = true;
		}
		return found;
		/*int index = 0;
		boolean found = false;
		while(!found && index < numberOfItems) {
			if(list[index].equals(item)) {
				found = true;
			}
			else {
				index++;
			}
		}
		return found;*/
	}
	
	//override the toString method from the Object class
	public String toString() {
		String allItems = "";
		for(int index = 0; index < numberOfItems; index++) {
			allItems = allItems + "\n" + list[index].toString();
		}
		return allItems;
	}

}