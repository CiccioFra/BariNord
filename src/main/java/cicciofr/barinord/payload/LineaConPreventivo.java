package cicciofr.barinord.payload;

import cicciofr.barinord.model.Linee;
import cicciofr.barinord.model.Preventivi;

public class LineaConPreventivo extends Linee{
    private Preventivi preventivo;

    public LineaConPreventivo(int id, String nome, Preventivi preventivo) {
        super(id, nome);
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
