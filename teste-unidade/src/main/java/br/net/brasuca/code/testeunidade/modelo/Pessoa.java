package br.net.brasuca.code.testeunidade.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @NonNull
    private String nome;
    @NonNull
    private String cpf;
    @JsonManagedReference
    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> enderecos = new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "pessoa")
    private List<Telefone> telefones = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void adicionarTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
