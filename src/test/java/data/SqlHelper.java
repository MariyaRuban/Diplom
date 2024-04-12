package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlHelper {

    private static final QueryRunner run = new QueryRunner();

    private SqlHelper() {
    }

    private static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(System.getProperty("db.url"), "app", "pass");
    }

    @SneakyThrows
    public static String getStatusPay() {
        Thread.sleep(10000);
        var codeSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        var conn = getConnect();
        var status = run.query(conn, codeSQL, new ScalarHandler<String>());
        return status;
    }

    @SneakyThrows
    public static String getStatusCredit() {
        Thread.sleep(10000);
        var codeSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        var conn = getConnect();
        var status = run.query(conn, codeSQL, new ScalarHandler<String>());
        return status;
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var conn = getConnect();
        run.execute(conn, "DELETE FROM payment_entity");
        run.execute(conn, "DELETE FROM credit_request_entity");
        run.execute(conn, "DELETE FROM order_entity");
    }
}