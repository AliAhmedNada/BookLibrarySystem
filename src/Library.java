import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Library extends Object implements Serializable {
	
	private List<Book> collection;

	public Library(){
		collection = new ArrayList<Book>();
	}
	
	public void addBook(Book book){
		collection.add(book);
	}

	public void changebook(int index,Book book){
		collection.set(index,book);
	}

	public void searchbook(Book bookname){
	System.out.println(collection.contains(bookname));
	}
	
	@Override
	public String toString() {
		int counter=0;
		String total = "\n";
		Iterator<Book> i = collection.iterator();
		while(i.hasNext()){
			Book b = (Book) i.next();
			total = total +counter+")"+b.toString()+"\n";
			counter=counter+1;
		}
		return total;
	}

}
