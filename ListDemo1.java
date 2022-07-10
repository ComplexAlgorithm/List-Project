package arrayBasedPackage;

public class ListDemo1 {

	public static void main(String[] args) {
		ListInterface<String> fruitList = new ArrayBasedList<String>();
		fruitList.add("Mango");
		fruitList.add("Strawberry");
		fruitList.add("Peach");
		fruitList.add("Apple");
		fruitList.add("Pineapple");
		fruitList.add("Cantaloupe");
		
		System.out.println(fruitList.remove("Peach"));
		System.out.println(fruitList.remove("Pineapple"));
		
		System.out.println(fruitList.find("Pineapple"));
		System.out.println(fruitList.find("Apple"));

	}



}


