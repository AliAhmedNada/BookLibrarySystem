import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainSystem {

	static String fileName = null;
	static Library lib = new Library();
	static Scanner in = new Scanner(System.in).useDelimiter("\n");
	static Boolean running = true;

	public static void main(String[] args) {
		while (running) {
			System.out.println("\nEnter 0 Load Seralized Library."
					+ "\nEnter 1 Exit and Save"
					+ "\nEnter 2 List All books"
					+ "\nEnter 3 Add new Book"
					+ "\nEnter 4 Edit From Book list"
					+"\nEnter 5 to search for Book");

			int answer = in.nextInt();
			switch (answer) {
			case 0:
				System.out.println("Enter the file name to load");
				loadScript(in.next());
				break;

			case 1:
				saveAndQuit();
				break;
			case 2:
				System.out.println(lib.toString());
				break;
			case 3:
				addBook();
				break;
			case 4 :
					System.out.println(lib.toString());
					System.out.println("Please Enter the book Index");
				    int index = in.nextInt();
				    //System.out.println(index);
				changebook(index);
				break;

				case 5:
					System.out.println("Please Enter bookname you want to search for");
					String bookname = in.next();
					booksearch(bookname);
					break;

			}
		}
		System.exit(0);
	}

	public static void addBook() {
		String title, author,description;

		System.out.println("\nEnter Title: ");
		title = in.next();

		System.out.println("\nEnter Author: ");
		author = in.next();


		System.out.println("\nEnter description: ");
		description = in.next();


		Book b = new Book(description, title, author);
		lib.addBook(b);
	}

	/**/
	public static void changebook(int index) {
		String title, author,description;

		System.out.println("\nEnter Title: ");
		title = in.next();

		System.out.println("\nEnter Author: ");
		author = in.next();

		System.out.println("\nEnter description: ");
		description = in.next();

		Book b = new Book(description, title, author);
		lib.changebook(index,b);
	}
/**/

	public static void booksearch(String bookname){
		Book b = new Book(null,bookname,null);
			lib.searchbook(b);
	}

	private static void saveAndQuit() {
		// TODO Auto-generated method stub
		System.out.println("Enter file name: ");
		fileName = in.next() + ".ser";
		running = false;
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(lib);
			fos.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void loadScript(String name) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		ObjectInputStream in = null;
		File file = new File(name + ".ser");
		if (file.exists()) {
			try {
				fis = new FileInputStream(file);
				in = new ObjectInputStream(fis);
				lib = (Library) in.readObject();
				fis.close();
				in.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("\nThe file does not exist!");
		}
	}

}
