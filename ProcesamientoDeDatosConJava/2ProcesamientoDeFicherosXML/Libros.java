
public class Libros {
	String id;
	String Author;
	String Title;
	String Genre;
	String Price;
	String PublishDate;
	String Description;
	
	public String toString() {
		return "Author: " + Author + "\n" + 
				"  Title: " + Title + "\n" + 
				"  Genre: " + Genre + "\n" + 
				"  Price: " + Price + "\n" + 
				"  Publish date: " + PublishDate + "\n" + 
				"  Description: " + Description;
	}
}
