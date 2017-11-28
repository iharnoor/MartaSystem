package LoginApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.dbConnection;

public class LoginModel {
    Connection connection;

    public LoginModel() {
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

    public boolean isLogin(String user, String pass, String opt) throws Exception {
        PreparedStatement prpStmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM login where username = ? and password =? and division =?";

        try {
            prpStmt = this.connection.prepareStatement(sql);
            prpStmt.setString(1, user);
            prpStmt.setString(2, pass);
            prpStmt.setString(3, opt);
            rs = prpStmt.executeQuery();
            boolean bool1;

            if (rs.next())
                return true;
            return false;

        } catch (SQLException e) {
//            e.printStackTrace();
            return false;
        } finally {
            {
                prpStmt.close();
                rs.close();
            }

        }
    }
}
