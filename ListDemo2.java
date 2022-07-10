package arrayBasedPackage;


import java.util.Scanner;
import nodeBasedPackage.NodeBasedList;
import nodeBasedPackage.ListInterface2;
public class ListDemo2 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		ListInterface2<Fruit> myFavoriteFruitList = new NodeBasedList<Fruit>();
		int option;
		
		do {
			System.out.println("Press 1 to add a fruit to the list");
			System.out.println("Press 2 to remove an existing fruit from the list");
			System.out.println("Press 3 to find whether a fruit is already on the list");
			System.out.println("Press 4 to display all the fruits on the list");
			System.out.println("Press 5 to display the number of items on the list");
			System.out.println("Press 6 to end the program");
			option = keyboard.nextInt();
			keyboard.nextLine(); //go to the next line
			if(option == 1) {
				System.out.println("What is the name of the fruit that you want to add to the list?");
				String name = keyboard.nextLine();
				
				System.out.println("What is the color of the fruit that you want to add to this list?");
				String color = keyboard.nextLine();
				
				Fruit currentFruit = new Fruit(name,color);
				myFavoriteFruitList.add(currentFruit);
			}
			else if(option == 2) {
				System.out.println("What is the name of the fruit that you are trying to remove from the list?");
				String name = keyboard.nextLine();
				
				System.out.println("What is the color of the fruit that you are trying to remove from the list?");
				String color = keyboard.nextLine();
				
				Fruit removeFruit = new Fruit(name,color);
				if(myFavoriteFruitList.remove(removeFruit)) {
					System.out.println("Your fruit has been removed!");
				}
				else {
					System.out.println("This fruit could not be removed because the fruit is not on the list!");
				}
			}
			else if(option == 3) {
				System.out.println("What is the name of the fruit that you are trying to find on the list?");
				String name = keyboard.nextLine();
				
				System.out.println("What is the color of the fruit that you are trying to find on the list?");
				String color = keyboard.nextLine();
				
				Fruit findFruit = new Fruit(name,color);
				if(myFavoriteFruitList.find(findFruit)) {
					System.out.println("This fruit is on the list!");
				}
				else {
					System.out.println("This fruit is not on the list!");
				}
			}
			else if(option == 4) {
				System.out.println(myFavoriteFruitList.toString());
			}
			else if(option == 5) {
				System.out.println("Number of items: " + myFavoriteFruitList.size());
			}
			else if(option == 6) {
				System.out.println("Thank you for using our program!");
			}
			else {
				System.out.println("Error! Invalid option! Try again!");
			}
		}while(option != 6);

	}

}
