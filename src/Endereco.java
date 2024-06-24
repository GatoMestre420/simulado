
public class Endereco {

private int id;
private String rua;
private String cidade;
private String pessoa;


public Endereco() {
}




public Endereco(int id, String rua, String cidade, String pessoa) {
    this.id = id;
    this.rua = rua;
    this.cidade = cidade;
    this.pessoa = pessoa;
}




public int getId() {
    return id;
}


public void setId(int id) {
    this.id = id;
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


public String getPessoa() {
    return pessoa;
}


public void setPessoa(String pessoa) {
    this.pessoa = pessoa;
}





}
