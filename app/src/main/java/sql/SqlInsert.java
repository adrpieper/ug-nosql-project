package sql;

import dto.UberPickDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Adrian on 2017-03-26.
 */
public class SqlInsert {

    private InsertGenerator insertGenerator = new InsertGenerator();

    public void insert(List<UberPickDTO> picks) {
        try {
            Connection c = null;
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/uber",
                    "postgres", "system");
            Statement statement = c.createStatement();
            statement.executeUpdate(insertGenerator.generate(picks));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    }
}
