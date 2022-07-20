package cicciofr.barinord.model;

import java.util.List;

public class Linee {
    private int id;
    private String nome;
    private List<Fermate> fermate;

    public Linee(int id, String nome, List<Fermate> fermate) {
        this.id = id;
        this.nome = nome;
        this.fermate = fermate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Fermate> getFermate() {
        return fermate;
    }

    public void setFermate(List<Fermate> fermate) {
        this.fermate = fermate;
    }
}
