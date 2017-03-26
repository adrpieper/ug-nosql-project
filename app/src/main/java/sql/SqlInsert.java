package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Adrian on 2017-03-26.
 */
public class SqlInsert {

    public static void main(String[] args) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/uber",
                            "postgres", "system");
            Statement statement = c.createStatement();
            String sql = "INSERT INTO public.pick( data_time, longitude, latitude, base)" +
                    "    VALUES ((TIMESTAMP '2011-05-16 15:36:38'), 4, 33.22, 'ssasa'), ((TIMESTAMP '2011-05-16 15:36:38'), 4, 23, 'sasass');";
            statement.executeUpdate(sql);
            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
