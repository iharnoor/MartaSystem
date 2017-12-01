package LoginSuccessful;

import dbUtil.dbConnection;

import java.sql.*;

public class LoginSuccessModel {
//    Connection connection;

//    dbConnection dBC;
//
//    public LoginSuccessModel() {
//        try {
//            dBC = new dbConnection();
////            this.connection = dbConnection.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
////        if (this.connection == null) {
//            System.exit(1);
//        }
//    }
//
//    public boolean isDatabaseConnected() {
//        return this.connection != null;
//    }
//
//    public String getFirstName(String user) throws Exception {
//        PreparedStatement prpStmt = null;
//        ResultSet rs = null;
//        String sql = "SELECT firstname FROM login where username = ?";
//
//        try {
//            prpStmt = this.connection.prepareStatement(sql);
//            prpStmt.setString(1, user);
//            rs = prpStmt.executeQuery();
//
//        } catch (SQLException e) {
//        } finally {
//            prpStmt.close();
//            rs.close();
//        }
//        return "Not Found";
//    }
}
