package ie.lyit.serialize;

import ie.lyit.book.*;


import java.io.*;
import java.util.*;


//This class will contain
//the code that will enable an ArrayList of Book objects to be written to file,
//read from file, edited, deleted, viewed etc.
public class BookSerializer {
	private ArrayList<Book> books;
	private final String FILENAME = "books.ser";	
	
	public BookSerializer () {
		books = new ArrayList<Book>();
		
	}
	
	
	public void add() {
		//Create a Book object,
		Book aBook = new Book();		
		//Call it’s read() method, to read the Book details from the user,	
		aBook.read();
		//Add that Book object to the ArrayList instance variable using the
		//ArrayList add() method	
		books.add(aBook);
	}
	
	//LIST
	public void list() {
		for(Book tmpBook:books)
			System.out.println(tmpBook);
	}
	
	public Book view() {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("ENTER Library NUMBER : ");
		int bookToView = keyboard.nextInt();

		for (Book tmpBook : books) {

			if (tmpBook.getLibraryNumber() == bookToView) {
				// display it and...
				System.out.println(tmpBook);
				// return it
				return tmpBook;
			}
		}
		return null;
	}
	public void delete() {
		// Call view() to find, display, & return the Book to delete
		Book tempBook = view();

		// If the Employee != null, i.e. it was found then...
		if (tempBook != null)
			// ...remove it from employees
			books.remove(tempBook);
	}
	
	
	
	//edit
	public void edit() {
		// Call view() to find, display, & return the Book to edit
		Book tempBook = view();

		// If the Employee != null, i.e. it was found then...
		if (tempBook != null) {
			// get it's index
			int index = books.indexOf(tempBook); /////get index in ARRAY
			// read in a new Employee and...
			tempBook.read();
			// reset the object in Employee
			books.set(index, tempBook);
		}
	}
	
	public void serializeBooks(){
		ObjectOutputStream os=null;
		try {
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
			os = new ObjectOutputStream(fileStream);
				
			os.writeObject(books);
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file " + FILENAME + ".");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		finally {
			try {
				os.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}}
		}
	
	
	
	// This method will deserialize the books ArrayList when called, 
		// i.e. it will restore the ArrayList from the file books.ser
		public void deserializeBooks(){
			ObjectInputStream is=null;
			
			try {
				// Deserialize the ArrayList...
				FileInputStream fileStream = new FileInputStream(FILENAME);
			
				is = new ObjectInputStream(fileStream);
					
				books = (ArrayList<Book>)is.readObject();	
			}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file " + FILENAME + ".");
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			finally {
				try {
					is.close();
				}
				catch(IOException ioE){
					System.out.println(ioE.getMessage());
				}
			}
		}
	}