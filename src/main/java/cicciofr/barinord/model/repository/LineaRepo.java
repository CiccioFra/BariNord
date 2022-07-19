package cicciofr.barinord.model.repository;

import cicciofr.barinord.model.Linee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static cicciofr.barinord.costanti.DBConfig.*;

public class LineaRepo {
    public static List<Linee> getLinee() {
        // creo una lista da restituire
        List<Linee> linee = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id_linea,nome");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Linee linea = new Linee(
                        rs.getInt("id_linea"),
                        rs.getString("nome")
                );
                linee.add(linea);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return linee;
    }
}
