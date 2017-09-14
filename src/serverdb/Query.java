/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorke11
 */
public class Query {

    ConnectionSqlLite db = new ConnectionSqlLite();

    public Query() {

    }

    public String getClients() {

        ArrayList<String> res = new ArrayList<>();
        List resp = new ArrayList();
        String concate = "";
        Statement stmt = null;

        Connection conn = this.db.connect();
        try {
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM account;");
            int cont = 0;
            while (rs.next()) {
//                resp.add(rs.getString("number") + "," + rs.getString("property") + "," + rs.getDouble("value"));
                concate += rs.getString("number") + "," + rs.getString("property") + "," + rs.getDouble("value") + "\n";
                System.out.println(concate);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }

        return concate;
    }

    public void getSaldo() {
        System.out.println("desde getSaldo");
    }

    public int setAccount(String numer, String property, String value) {

        String sql = "INSERT INTO account(number,property,value) VALUES(?,?,?)";
        int response = 1;
        try (Connection conn = this.db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numer);
            pstmt.setString(2, property);
            pstmt.setString(3, value);
            pstmt.executeUpdate();
            response = 5;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return response;
    }
}
