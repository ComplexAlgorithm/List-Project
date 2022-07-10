package nodeBasedPackage;

public class ListDemo3 {

	public static void main(String[] args) {
		
		ListInterface2<String> myFavoriteBandList = new NodeBasedList<String>();
		myFavoriteBandList.add("The Byrds");
		myFavoriteBandList.add("Van Halen");
		myFavoriteBandList.add("Rush");
		myFavoriteBandList.add("The Police");
		
		System.out.println(myFavoriteBandList.toString());
		
		System.out.println(myFavoriteBandList.find("Van Halen"));
		System.out.println(myFavoriteBandList.find("Iron Maiden"));
		
		System.out.println(myFavoriteBandList.remove("Van Halen"));
		System.out.println(myFavoriteBandList.remove("The Police"));
		
		System.out.println(myFavoriteBandList.find("Van Halen"));
		System.out.println(myFavoriteBandList.find("The Police"));
		
		System.out.println(myFavoriteBandList.toString());

	}



	

}
