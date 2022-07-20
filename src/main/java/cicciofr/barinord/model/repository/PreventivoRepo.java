package cicciofr.barinord.model.repository;

import cicciofr.barinord.model.Preventivi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static cicciofr.barinord.costanti.DBConfig.*;

public class PreventivoRepo {
    public static List<Preventivi> getPreventivi() {
        // creo una lista da restituire
        List<Preventivi> preventivi = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id_preventivo, nome_azienda, nome_piano, nr_max_fermate," +
                    "nr_max_fermate_extra, nr_max_zone, prezzo from preventivi");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // creo un preventivo con i dati del DB

                Preventivi preventivo = new Preventivi(
                        rs.getInt("id_preventivo"),
                        rs.getString("nome_azienda"),
                        rs.getString("nome_piano"),
                        rs.getInt("nr_max_fermate"),
                        rs.getInt("nr_max_fermate_extra"),
                        rs.getInt("nr_max_zone"),
                        rs.getDouble("prezzo")
                );
                // aggiungo alla lista
                preventivi.add(preventivo);
            }
            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return preventivi;
    }
}
