package LoginSuccessful;

import dbUtil.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSuccessModel {
    Connection connection;

    public LoginSuccessModel() {
        try {
            this.connection = dbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (this.connection == null) {
            System.exit(1);
        }
    }

    public boolean isDatabaseConnected() {
        return this.connection != null;
    }

    public String getFirstName(String user) throws Exception {
        PreparedStatement prpStmt = null;
        ResultSet rs = null;
        String sql = "SELECT firstname FROM login where username = ?";

        try {
            prpStmt = this.connection.prepareStatement(sql);
            prpStmt.setString(1, user);
            rs = prpStmt.executeQuery();
//            boolean bool1;
            return rs.getString(3);
//            return rs.next();
        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
        } finally {
            prpStmt.close();
            rs.close();
        }
        return "Not Found";
    }
}
