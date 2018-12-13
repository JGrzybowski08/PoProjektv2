package sample.Java;

import java.sql.*;
import java.util.*;

public class dbController {
    public static Connection connect() throws SQLException {
        Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=root";
        return conn = DriverManager.getConnection(url);
    }

}
