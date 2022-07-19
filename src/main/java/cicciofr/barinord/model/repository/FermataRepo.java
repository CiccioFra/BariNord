package cicciofr.barinord.model.repository;

import cicciofr.barinord.model.Fermate;
import cicciofr.barinord.model.Linee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static cicciofr.barinord.costanti.DBConfig.*;

public class FermataRepo {
    public static List<Fermate> getFermate() {
        // creo una lista da restituire
        List<Fermate> fermate = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id_fermata, nome, urbana, zona");
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return fermate;
    }
}
