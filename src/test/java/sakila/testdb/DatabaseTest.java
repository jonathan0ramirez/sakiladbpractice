package sakila.testdb;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import com.sakila.practice.DatabaseConnector;


@SpringBootTest(classes = DatabaseConnector.class)
@ActiveProfiles("dev")
class DatabaseTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Test
  public void testDatabaseConnection(){
    String sqlQuery = "SELECT 1";
    Integer result = jdbcTemplate.queryForObject(sqlQuery, Integer.class);
    assertEquals(1, result, "Database connectivity test failed. The result is not 1.");
  }
  
  @Test
  public void testActorTableData() {
    String sqlQuery = "SELECT * FROM actor";
    List<?> actors = jdbcTemplate.queryForList(sqlQuery);
    System.out.println("size is : " + actors.size());
    assertTrue(actors.size() > 1, "The 'actor' table does not contain more than one row");
  }
  
  
}


