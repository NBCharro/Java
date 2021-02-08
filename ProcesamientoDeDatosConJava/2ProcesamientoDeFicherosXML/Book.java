
public class Book {
	String id;
	String Author;
	String Title;
	String Genre;
	String Price;
	String PublishDate;
	String Description;
	
	public String toString() {
		return Author + " " + Title + " " + Genre + " " + Price + " " + PublishDate + " " + Description;
	}
}