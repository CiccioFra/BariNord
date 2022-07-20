package cicciofr.barinord.payload;

import cicciofr.barinord.model.Fermate;
import cicciofr.barinord.model.Linee;
import cicciofr.barinord.model.Preventivi;

import java.util.List;

public class LineaConPreventivo extends Linee{
    private Preventivi preventivo;

    public LineaConPreventivo(int id, String nome, List<Fermate> fermate, Preventivi preventivo) {
        super(id, nome, fermate);
        this.preventivo = preventivo;
    }

    // alternativo overriding in caso si passi direttamente l'oggetto
    public LineaConPreventivo(Linee linea, Preventivi preventivo) {
        super(linea.getId(), linea.getNome(), linea.getFermate());
        this.preventivo = preventivo;
    }

    public Preventivi getPreventivo() {
        return preventivo;
    }

    public void setPreventivo(Preventivi preventivo) {
        this.preventivo = preventivo;
    }
}
