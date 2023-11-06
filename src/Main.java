import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("123");
        ds.setServerName("LAPTOP-POT66FBA");
        ds.setPortNumber(1433);
        ds.setDatabaseName("test");
        ds.setEncrypt(false);
        try (Connection conn = ds.getConnection()) {
            System.out.println("Connection success");
            System.out.println(conn.getMetaData());

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException  throwables) {
            throwables.printStackTrace();
        }
    }
}
