package nodeBasedPackage;

import arrayBasedPackage.ListInterface;

public class NodeBasedList<T> extends Object implements ListInterface<T>, ListInterface2<T> {
	//instance variables
	private int numberOfItems;
	private Node list;
	
	//default constructor
	public NodeBasedList() {
		super();
		numberOfItems = 0;
		list = null;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfItems;
	}

	@Override
	public void add(T item) {
		// TODO Auto-generated method stub
		Node currentNode = new Node(item);
		if(list == null && numberOfItems == 0) {
			list = currentNode;
			numberOfItems++;
		}
		else {
			currentNode.setLink(list); 
			list = currentNode;  
			numberOfItems++;
		}
	}
	
	//returns the location of the Node object that holds the item if it exists
	//otherwise returns null to represent the item is not on the list
	private Node locate(T item) {
		boolean found = false;
		Node currentNode = list; //reference is created to keep track of where we are in the list
		while(!found && currentNode != null) {
			if(currentNode.getData().equals(item)) {
				found = true;
			}
			else {
				currentNode = currentNode.getLink(); //move to the next node in the chain, move to the next item on the list
			}
		}
		return currentNode;
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		Node currentNode = locate(item);
		boolean removed = false;
		if(currentNode != null) {
			if(currentNode == list) {
				list = list.getLink(); //remove the first item on the list
				removed = true;
				numberOfItems--;
			}
			else { //remove any other item on the list
				//remove the item
				//to find the item that is directly before/previous to the currentNode 
				Node previousNode = list;
				while(previousNode.getLink() != currentNode) { //as long as I haven't the Node directly before the currentNode
					previousNode = previousNode.getLink(); //move previous to the next node in the chain
				}
				previousNode.setLink(currentNode.getLink());
				removed = true;
				numberOfItems--;
			}
		}
		return removed;
	}

	@Override
	public boolean find(T item) {
		// TODO Auto-generated method stub
		Node currentNode = locate(item);
		boolean found = false;
		if(currentNode != null) {
			found = true;
		}
		return found;
	}
	
	public String toString() {
		//call the recursive method passing list as an argument to the recursiveToString method
		//have that method produce the String that has all the items on the list
		//and take the String returned from that method and return it
		//to the wherever this method was called from 
		return recursiveToString(list);
		
		//iterative solution to toString
		/*(String allItems = "";
		Node currentNode = list; //creates a reference to refer to what list is referring to
		while(currentNode != null) {
			allItems = allItems+ "\n" + currentNode.getData().toString();
			currentNode = currentNode.getLink();
		}
		return allItems;*/
		
	}
	
	private String recursiveToString(Node currentNode) {
		String allItems = "";
		if(currentNode == null) { //the list is empty or we've reached the end of the list
			return allItems;
		}
		else {
			return allItems + "\n" + currentNode.getData() + recursiveToString(currentNode.getLink()); //call the recursive method, but go to the next node
		}
	}
	
	//inner class is a class that exists inside of another class
	private class Node extends Object {
		//instance variables
		private T data;
		private Node link; //reference to a Node object
		
		//constructor 
		public Node(T newData) {
			super();
			data = newData;
			link = null;
		}
		
		//non-static methods
		public void setData(T newData) {
			data = newData;
		}
		
		public T getData() {
			 return data;
		}
		
		public void setLink(Node otherNode) {
			this.link = otherNode;
		}
		
		public Node getLink() {
			return link;
		}
	}
}
