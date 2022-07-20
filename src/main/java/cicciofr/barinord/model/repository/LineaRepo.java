package cicciofr.barinord.model.repository;

import cicciofr.barinord.model.Fermate;
import cicciofr.barinord.model.Linee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static cicciofr.barinord.costanti.DBConfig.*;

/**
 * Classe che gestisce le Linee
 */
public class LineaRepo {
    /**
     * Recupera dal DB le linee con le relative fermate
     * @return lista di linee con relative fermate
     */
    public static List<Linee> getLinee() {
        // creo una lista di linee con relative fermate da restituire
        List<Linee> linee = new ArrayList<>();
        try {
            // connessione al DB
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id_linea, nome FROM linee");
            ResultSet rs = stmt.executeQuery();
            // creazione delle liste delle linee
            while (rs.next()) {
                // prendo la lista delle fermate della specifica linea in base all'ID_linea
                // TODO crea istruzione che reperisce fermate in base alla linea
                List<Fermate> fermate = new ArrayList<>();
                // genero la lista delle linee
                Linee linea = new Linee(
                        rs.getInt("id_linea"),
                        rs.getString("nome"),
                        fermate
                );
                linee.add(linea);
            }
            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return linee;
    }
}
