package br.net.brasuca.code.testeunidade.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    @JsonBackReference
    @ManyToOne
    private Pessoa pessoa;

    public Endereco(String logradouro, Integer numero, String complemento, String bairro, String cidade, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public Integer getNumero() {
        return numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

	public void setPessoa(Pessoa pessoa) {
this.pessoa = pessoa;		
	}
}
