package sql;

import dto.UberPickDTO;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Created by Adrian on 2017-03-26.
 */
public class SqlClient {

    private InsertGenerator insertGenerator = new InsertGenerator();

    public void insert(List<UberPickDTO> picks) {
        update(insertGenerator.generate(picks));
    }

    public void clear() {
        update("DELETE FROM public.pick");
    }

    public void select() {
        String sql = "Select * from public.pick";
        try {
            Connection c = null;
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/uber",
                    "postgres", "system");
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void update(String sql) {
        try {
            Connection c = null;
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/uber",
                    "postgres", "system");
            Statement statement = c.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
