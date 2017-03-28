package sql;

import dto.UberPickDTO;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import static dto.FormatterProvider.provideSQL;

/**
 * Created by Adrian on 2017-03-26.
 */
public class SqlClient {

    private InsertGenerator insertGenerator = new InsertGenerator();
    private DateTimeFormatter formatter = provideSQL();

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
            statement.close();
            c.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<UberPickDTO> select(String query) {
        try {
            Connection c = null;
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/uber",
                    "postgres", "system");
            Statement statement = c.createStatement();

            List<UberPickDTO> result = new ArrayList<>();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                UberPickDTO uberPickDTO = new UberPickDTO(
                        LocalDateTime.parse(rs.getString("data_time"), formatter),
                        rs.getFloat("longitude"),
                        rs.getFloat("latitude"),
                        rs.getString("base")
                );
                result.add(uberPickDTO);
            }
            statement.close();
            c.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
