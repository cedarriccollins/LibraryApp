package codechallenge;

/**
 * Created by terrell on 11/30/16.
 */
public class Book {

    private int book_id;
    private String isbn;
    private String title;
    private String genre;


    public int getBook_id()
    {
        return this.book_id;
    }

    public  String getIsbn()
    {
        return isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setBook_id(int id)
    {
        this.book_id = id;
    }


    public void setIsbn(String isbn)
    {
        this.isbn = isbn;

    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;

    }

    public String toString() {
        return String.format("[ %s- %s - %s - %s]",  book_id, isbn, title, genre);
    }



}
