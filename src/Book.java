import java.io.Serializable;


public class Book implements Serializable{
	
	private String title, author,description;

	public Book(){
		description = null;
		title = null;
		author = null;
	}
	
	public Book(String description, String title, String author){
		this.description = description;
		this.title = title;
		this.author = author;
	}
	
	@Override
	public String toString(){
		return "\nTitle: " + title + "\nAuthor: " + author +
				"\ndescription: " + description + "\n";
	}

}
