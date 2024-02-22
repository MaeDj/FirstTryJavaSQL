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
        String connectUrl = "jdbc:mysql://mysql-dugouamae.alwaysdata.net:3306/dugouamae_films";
        String username = "dugouamae", password = "ecE8iTiwiWnediQ";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(connectUrl, username, password);
            System.out.println("Database connection established.\n\n");
            Statement stmt = con.createStatement();


            System.out.println("Donner les noms et prénoms des internautes auvergnats (i.e. de la région Auvergne).\n");
            ResultSet result = stmt.executeQuery("""
                                               SELECT nom,prenom FROM `Internaute` WHERE region='auvergne';""");

            while (result.next()) {
                System.out.println(result.getString("nom") + " " + result.getString("prenom"));

            }
            System.out.println("\n\n");

            System.out.println("Donner le titre et l'année de tous les drames, triés par année ascendante. Donner ensuite le tri\n"
                    + "par année descendante.\n");
            result = stmt.executeQuery("""
                                                SELECT titre,annee FROM `Film`WHERE genre='drame' ORDER BY annee DESC;""");
            System.out.println("Resultats par ordre decroissant");
            while (result.next()) {
                System.out.println(result.getString("titre") + " " + result.getString("annee"));

            }

            result = stmt.executeQuery("""
                                                SELECT titre,annee FROM `Film`WHERE genre='drame' ORDER BY annee ASC;""");
            System.out.println("Resultats par ordre croissant");
            while (result.next()) {
                System.out.println(result.getString("titre") + " " + result.getString("annee"));

            }
            System.out.println("\n\n");

            System.out.println(". Donner tous les genres de films.");
            result = stmt.executeQuery("""
                                                 SELECT genre FROM `Film`; """);
            while (result.next()) {
                System.out.println(result.getString("genre"));

            }
            System.out.println("\n\n");

            System.out.println("Donner le nom et l'année de naissance des artistes nés avant 1950.\n");
            result = stmt.executeQuery("""
                                                SELECT nom,anneeNaiss FROM `Artiste` WHERE anneeNaiss<1950;""");
            while (result.next()) {
                System.out.println(result.getString("nom") + " " + result.getString("anneeNaiss"));

            }
            System.out.println("\n\n");
            System.out.println("Donner le titre et l'année de tous les films parus entre 1960 et 1980.\n");
            result = stmt.executeQuery("""
                                                SELECT titre, annee FROM `Film` WHERE annee<1980 AND annee>1960;""");
            while (result.next()) {
                System.out.println(result.getString("titre") + " " + result.getString("annee"));

            }
            System.out.println("\n\n");
            System.out.println("Donner les acteurs dont on ignore l'année de naissance (valeur absente).\n");
            result = stmt.executeQuery("""
                                                 SELECT nom FROM `Artiste` WHERE anneeNaiss=NULL;""");
            while (result.next()) {
                System.out.println(result.getString("nom"));

            }
            System.out.println("\n\n");
            System.out.println("Donner le nom et le prénom de celui qui a joué le rôle de « Morpheus ».\n");
            result = stmt.executeQuery("""
                                                 SELECT DISTINCT nom,prenom,nomrole FROM `Artiste`,`Role`WHERE `Artiste`.idArtiste=`Role`.idActeur AND Role.nomrole='Morpheus';""");
            while (result.next()) {
                System.out.println(result.getString("nom") + " " + result.getString("prenom") + " " + result.getString("nomrole"));

            }
            System.out.println("\n\n");
            System.out.println("Donner le nom et le prénom du réalisateur de « Alien ».\n");
            result = stmt.executeQuery("""
                                                 SELECT nom, prenom FROM Artiste, Film WHERE Artiste.idArtiste = Film.idMES AND
                                                 Film.titre = 'Alien';""");
            while (result.next()) {
                System.out.println(result.getString("nom") + " " + result.getString("prenom"));

            }
            System.out.println("\n\n");
            System.out.println("""
                               Donner le nom, le pr\u00e9nom des internautes ayant donn\u00e9 une note de 4 \u00e0 un film, ainsi que le
                               titre de ce film.
                               """);
            result = stmt.executeQuery("""
                                       SELECT DISTINCT nom, prenom, titre FROM Internaute, Notation, Film WHERE
                                       Internaute.email=Notation.email AND Notation.idFilm=Film.idFilm AND note=4 ;""");
            while (result.next()) {
                System.out.println(result.getString("nom") + " " + result.getString("prenom") + " " + result.getString("titre"));

            }
            System.out.println("\n\n");

            System.out.println("Donner les titres des films avec Bruce Willis ainsi que ses rôles dans ces films.\n");
            result = stmt.executeQuery("""
                                       SELECT titre, nomRole FROM Artiste, Role, Film WHERE 
                                       Artiste.idArtiste=Role.idActeur AND Role.idFilm=Film.idFilm AND Artiste.nom='Willis' 
                                       AND Artiste.prenom='Bruce';""");
            while (result.next()) {
                System.out.println(result.getString("titre") + " " + result.getString("nomRole"));

            }
            System.out.println("\n\n");

            System.out.println("Donner tous les titres de films\n");
            result = stmt.executeQuery("SELECT titre FROM `Film`;");
            while (result.next()) {
                System.out.println(result.getString("titre"));
            }
            System.out.println("\n\n");
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
