package LoginApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.dbConnection;

public class LoginModel {
    private Connection connection;

    // class to get check the connection with the dbc and

    //get connection on creating object
    LoginModel() {
        try {
            this.connection = dbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (this.connection == null) {
            System.exit(1);
        }
    }

    //check if dbc is connected
    boolean isDatabaseConnected() {
        return this.connection != null;
    }

    //  check if the userid password is correct in the DBC
    boolean isLogin(String user, String pass) throws Exception {
        PreparedStatement prpStmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM login where username = ? and password =?";

        try {
            prpStmt = this.connection.prepareStatement(sql);
            prpStmt.setString(1, user);
            prpStmt.setString(2, pass);
            rs = prpStmt.executeQuery();
            boolean bool1;

            return rs.next();
        } catch (SQLException e) {
//            e.printStackTrace();
            return false;
        } finally {
            prpStmt.close();
            rs.close();
        }
    }
}
