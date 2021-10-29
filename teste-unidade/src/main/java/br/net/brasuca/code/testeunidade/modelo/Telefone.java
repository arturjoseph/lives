package br.net.brasuca.code.testeunidade.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Telefone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String ddd;
    private String numero;
    @JsonBackReference
    @ManyToOne
    private Pessoa pessoa;

    public Telefone(String ddd, String numero, Pessoa pessoa) {
        this.ddd = ddd;
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public Telefone(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public Telefone() {
    }


    public Long getCodigo() {
        return codigo;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

	public void setPessoa(Pessoa pessoa) {
this.pessoa = pessoa;		
	}

}
