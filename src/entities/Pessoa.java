package entities;

public class Pessoa {

    private int id;
    private String nome;
    private String rua;
    private String cidade;


    public Pessoa(int id2, String nome2) {
    }

    public Pessoa(int id, String nome, String rua, String cidade) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
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


    public String getRua() {
        return rua;
    }


    public void setRua(String rua) {
        this.rua = rua;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String toCsv() {
        return id + ";" + nome + ";" + rua + ";" + cidade;
    }



    

    

    

}
