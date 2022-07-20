package cicciofr.barinord.model.repository;

import cicciofr.barinord.model.Fermate;
import cicciofr.barinord.model.Linee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static cicciofr.barinord.costanti.DBConfig.*;

/**
 * Classe che gestisce le Fermate
 */
public class FermataRepo {
    /**
     * Recupera dal DB le fermate
     * @return lista delle fermate
     */
    public static List<Fermate> getFermate() {
        // creo una lista da restituire
        List<Fermate> fermate = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id_fermata, nome, urbana, zona FROM fermate");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Fermate fermata = new Fermate(
                        rs.getInt("id_linea"),
                        rs.getString("nome"),
                        rs.getInt("urbana"),
                        rs.getString("zona")
                );
                // aggiungo alla lista
                fermate.add(fermata);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return fermate;
    }

    /**
     * recupera dal DB le fermate in base ad un ID_linea
     * @param linea ID della linea di cui reperire le fermate
     * @return restituisce un elenco di fermate di una determinata linea
     */
    public static List<Fermate> getFermateByLinea(int linea) {
        List<Fermate> fermate = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id_fermata FROM linee_fermate WHERE id_linea = ?");
            stmt.setInt(1, linea);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id_fermata = rs.getInt("id_fermata");
                // si aggiungono le fermate grazie al metodo che restituisce la tupla della tabella fermate in base all'id della fermata stessa
                fermate.add(getFermataByID(id_fermata));

            }
            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return fermate;
    }

    /**
     * Funzione che recupera la fermata con i relativi dettagli (la tupla) dalla tabella fermate
     * ricercando sulla scorta dell'id della fermata stessa
     * @param id_fermata ID della fermata di cui si cercano i dettagli
     * @return restituisce la fermata con i relativi dettagli (la tupla della tabella fermate in base all'id)
     */
    public static Fermate getFermataByID(int id_fermata){
        Fermate fermata = null;
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id_fermata, nome, urbana, zona FROM fermate WHERE id_fermata = ?");
            stmt.setInt(1, id_fermata);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fermata = new Fermate(
                        rs.getInt("id_fermata"),
                        rs.getString("nome"),
                        rs.getInt("urbana"),
                        rs.getString("zona"));
            }
            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return fermata;
    }
}
