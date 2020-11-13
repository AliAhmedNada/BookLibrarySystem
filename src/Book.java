import java.io.Serializable;


public class Book implements Serializable{
	public int Id;
	private String title, author,description;

	public Book(){
		description = null;
		title = null;
		author = null;
		Id=0;
	}
	
	public Book(String description, String title, String author,int Id){
		this.description = description;
		this.title = title;
		this.author = author;
		this.Id=Id;
	}
	
	@Override
	public String toString(){
		return "\nTitle: " + title + "\nAuthor: " + author +
				"\ndescription: " + description + "\n"+
				"Id: "+Id+"\n";
	}

}
