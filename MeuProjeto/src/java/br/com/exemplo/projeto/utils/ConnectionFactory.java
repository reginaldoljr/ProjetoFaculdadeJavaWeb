package br.com.exemplo.projeto.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author reginaldo
 */
public class ConnectionFactory {

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/bddisc", "postgres", "root");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs)
            throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    // overload
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }

    public static void closeConnection(Connection conn, Statement stmt)
            throws Exception {
        close(conn, stmt, null);
    }

    public static void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }

    
    
    
    
}
