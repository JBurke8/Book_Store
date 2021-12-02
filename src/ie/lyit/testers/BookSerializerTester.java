package ie.lyit.testers;


import ie.lyit.book.Menu;
import ie.lyit.serialize.BookSerializer;



public class BookSerializerTester {
	public static void main(String[] args) {
		BookSerializer bookSerializer = new BookSerializer();

		// Read the ArrayList from the File in Employees
		// THIS DESERIALIZES THE ARRAYLIST
		bookSerializer.deserializeBooks();

		// Create a Menu Object
		Menu menu = new Menu();	//PART 2
		//Create an object of the BookSerializer class,
		do {
			menu.display();
			menu.readOption();
			
			switch(menu.getOption()) {
			
			case 1:
				bookSerializer.add();
				break;
			case 2:
				bookSerializer.list();
				break;
			case 3:
				bookSerializer.view();
				break;
			case 4:
				bookSerializer.edit();
				break;
			case 5:
				bookSerializer.delete();
				break;
			case 6:
				break;
				default: System.out.println("Invalid");
			
			}
	
			
		} while(menu.getOption()!=6);

		bookSerializer.serializeBooks(); //can do this after add,edit,delete or at 6, anything when array changes
		
		
		
	}

}
