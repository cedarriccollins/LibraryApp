package codechallenge;

/**
 * Created by terrell on 11/30/16.
 */



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * This console application demonstrates how to do CRUD operations using JDBC
 * with Spring framework.
 * @author Cedarric Collins
 *
 */
public class MyLibraryJDBCDriver {

    public static void main(String[] args) throws SQLException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new com.mysql.jdbc.Driver());
        dataSource.setUrl("jdbc:mysql://localhost/bookdb");
        dataSource.setUsername("root");
        dataSource.setPassword("!Beer");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sqlInsert = "INSERT INTO Book ( isbn, title, genre)"
                + " VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlInsert,  "1234567", "Bible", "Holy");

        String sqlUpdate = "UPDATE Book set title=? where genre=?";
        jdbcTemplate.update(sqlUpdate, "KJV Bible", "Holy");

        String sqlSelect = "SELECT * FROM Book";
        List<Book> listBook = jdbcTemplate.query(sqlSelect, new RowMapper<Book>() {

            public Book mapRow(ResultSet result, int rowNum) throws SQLException {
                Book book = new Book();

                book.setIsbn(result.getString("isbn"));
                book.setTitle(result.getString("title"));
                book.setGenre(result.getString("genre"));

                return book;
            }

        });

        for (Book aBook : listBook) {
            System.out.println(aBook);
        }

        String sqlDelete = "DELETE FROM Book where title=?";
        jdbcTemplate.update(sqlDelete, "Bible");
    }

}