package arrayBasedPackage;


public class Fruit extends Object implements Comparable {
	//instance variables have to be private to allow this class to immutable
	//name 
	//color
	private String name;
	private String color;
	
	//constructor with two parameters newName, newColor
	public Fruit(String newName, String newColor) {
		name = newName;
		color = newColor;
	}
	
	//non-static methods (immutable class)
	//immutable class is a class in which objects of that class cannot have their instance variables
	//after the object has been created because there no mutator or set methods 
	//none
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return name;
	}
	
	//override the toString method from the Object class
	public String toString() {
		return "Name: " + name + " Color: " + color;
	}
	
	//override the equals method from the Object
	public boolean equals(Object otherObject) {
		boolean areTheyEqual = false;
		if(otherObject != null && otherObject instanceof Fruit) {
			Fruit otherFruit = (Fruit)otherObject;
			if(this.name.equals(otherFruit.name) &&
					this.color.equals(otherFruit.color)) {
				areTheyEqual = true;
			}
		}
		return areTheyEqual;
	}

	@Override
	//-1 Object o comes before the Object that this method 
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int result = 0;
		if(o != null && o instanceof Fruit) {
			Fruit otherFruit = (Fruit)o;
			if(this.name.compareTo(otherFruit.name) < 0) {
				result = -1;
			}
			else if(this.name.compareTo(otherFruit.name) > 0) {
				result = 1;
			}
		}
		return 0;
	}
}

