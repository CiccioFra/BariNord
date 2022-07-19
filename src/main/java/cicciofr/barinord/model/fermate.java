package cicciofr.barinord.model;

public class fermate {
    private int id;
    private String nome;
    private int urbana;
    private char zona;

    public fermate(int id, String nome, int urbana, char zona) {
        this.id = id;
        this.nome = nome;
        this.urbana = urbana;
        this.zona = zona;
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

    public int getUrbana() {
        return urbana;
    }

    public void setUrbana(int urbana) {
        this.urbana = urbana;
    }

    public char getZona() {
        return zona;
    }

    public void setZona(char zona) {
        this.zona = zona;
    }
}
