import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;



import entities.Pessoa;

public class MergeFiles {

    public static void main(String[] args) throws Exception {

        String pessoasFile = "C:/_ws/pessoa.csv";
        String enderecoFile = "C:/_ws/endereco.csv";
        String pessoaComEnderecoFile = "C:/_ws/pessoaComEndereco.csv";

        List<Pessoa> pessoas = lerPessoas(pessoasFile);
        List<Endereco> enderecos = lerEnderecos(enderecoFile);
        List<String> pessoaComEnderecoLinhas = combinarPessoasEnderecos(pessoas, enderecos);

        escreverPessoasComEndereco(pessoaComEnderecoFile, pessoaComEnderecoLinhas);

        System.out.println("Arquivo pessoaComEndereco.csv criado com sucesso.");
    
    }
    private static List<Pessoa> lerPessoas(String pessoasFile) {
        List<Pessoa> pessoas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pessoasFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0].trim());
                String nome = parts[1].trim();
                pessoas.add(new Pessoa(id, nome));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    private static List<Endereco> lerEnderecos(String enderecoFile) {
        List<Endereco> enderecos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(enderecoFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String rua = parts[0].trim();
                String cidade = parts[1].trim();
                int idPessoa = Integer.parseInt(parts[2].trim());
                enderecos.add(new Endereco(rua, cidade, idPessoa));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return enderecos;
    }

    private static List<String> combinarPessoasEnderecos(List<Pessoa> pessoas, List<Endereco> enderecos) {
        List<String> pessoaComEnderecoLinhas = new ArrayList<>();
        for (Endereco endereco : enderecos) {
            for (Pessoa pessoa : pessoas) {
                if (endereco.getIdPessoa() == pessoa.getId()) {
                    String linha = pessoa.getId() + ";" + pessoa.getNome() + ";" + endereco.getRua() + ";" + endereco.getCidade();
                    pessoaComEnderecoLinhas.add(linha);
                }
            }
        }
        return pessoaComEnderecoLinhas;
    }

    private static void escreverPessoasComEndereco(String pessoaComEnderecoFile, List<String> pessoaComEnderecoLinhas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pessoaComEnderecoFile))) {
            for (String linha : pessoaComEnderecoLinhas) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   




