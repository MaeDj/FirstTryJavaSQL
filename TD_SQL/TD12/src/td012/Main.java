/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package td012;


import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author mae
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String connectUrl = "jdbc:mysql://mysql-dugouamae.alwaysdata.net:3306/dugouamae_film";
        String username = "dugouamae", password = "ecE8iTiwiWnediQ";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            con =DriverManager.getConnection(connectUrl, username, password);
            System.out.println("Database connection established.");
            Statement stmt =con.createStatement();
            String query = "SELECT distinct id_user FROM users ORDER BY id_user ASC";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Integer> idusers = new ArrayList<>();
            while (rs.next()) {
                idusers.add(rs.getInt("id_user"));
}
} catch (Exception e) {
            System.out.println("erreur");
        } finally { //finally désigne un bloc d’instructions toujours exécuté quand il y a try … catch
// à la fin, on ferme la connection avec la BdD
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Database connection terminated.");
                } catch (Exception e) {
                    /* ignore close errors */ }
            }
        }
    }

}
