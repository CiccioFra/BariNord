package cicciofr.barinord.model;

public class preventivo {
    private int id;
    private String nomeAzienda;
    private String nomePiano;
    private int nrMaxFermate;
    private int nrMaxFermateExtra;
    private int nrMaxZone;
    private double prezzo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public String getNomePiano() {
        return nomePiano;
    }

    public void setNomePiano(String nomePiano) {
        this.nomePiano = nomePiano;
    }

    public int getNrMaxFermate() {
        return nrMaxFermate;
    }

    public void setNrMaxFermate(int nrMaxFermate) {
        this.nrMaxFermate = nrMaxFermate;
    }

    public int getNrMaxFermateExtra() {
        return nrMaxFermateExtra;
    }

    public void setNrMaxFermateExtra(int nrMaxFermateExtra) {
        this.nrMaxFermateExtra = nrMaxFermateExtra;
    }

    public int getNrMaxZone() {
        return nrMaxZone;
    }

    public void setNrMaxZone(int nrMaxZone) {
        this.nrMaxZone = nrMaxZone;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public preventivo(int id, String nomeAzienda, String nomePiano, int nrMaxFermate, int nrMaxFermateExtra, int nrMaxZone, double prezzo) {
        this.id = id;
        this.nomeAzienda = nomeAzienda;
        this.nomePiano = nomePiano;
        this.nrMaxFermate = nrMaxFermate;
        this.nrMaxFermateExtra = nrMaxFermateExtra;
        this.nrMaxZone = nrMaxZone;
        this.prezzo = prezzo;


    }
}
