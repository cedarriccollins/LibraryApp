package codechallenge;

/**
 * Created by Cedarric on 12/1/16.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class BookDao {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int save(Book b)
    {
        String sql="insert into Book( isbn,title, genre)values('"+ b.getIsbn() +"','" + b.getTitle() +"','"+ b.getGenre() +" ')";
        return template.update(sql);
    }
    public int update(Book b){
        String sql="update Book set isbn='"+b.getIsbn()+"', title='"+b.getTitle()+"', genre='"+b.getGenre()+"' where book_id="+b.getBook_id()+"";
        return template.update(sql);
    }
    public int delete(int id){
        String sql="delete from Book where book_id="+id+"";
        return template.update(sql);
    }
    public Book getBookById(int id){
        String sql="select * from Book where book_id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Book>(Book.class));
    }
    public List<Book> getBooks(){
        return template.query("select * from Book",new RowMapper<Book>()
        {
            public Book mapRow(ResultSet rs, int row) throws SQLException
            {
                Book book = new Book();
                book.setBook_id(rs.getInt(1));
                book.setIsbn(rs.getString(2));
                book.setTitle(rs.getString(3));
                book.setGenre(rs.getString(4));
                return book;
            }
        });
    }
}