import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreateDatabase {

    public static void main(String[] args) {
        List<String> queries = new ArrayList<>();
        queries.add("create table users(id integer primary key, name text, email text);");
        queries.add("create table addresses(id integer primary key, " +
                "user_id integer not null, address text, city text, state text, zip integer);");

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db")){
            Class.forName("org.sqlite.JDBC");

            for (String sql : queries) {
                System.out.printf("Executing %s%n", sql);
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(sql);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}