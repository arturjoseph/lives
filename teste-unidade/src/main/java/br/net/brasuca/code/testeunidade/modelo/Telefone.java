package br.net.brasuca.code.testeunidade.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Telefone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Integer ddd;
    private Integer numero;
    @JsonBackReference
    @ManyToOne
    private Pessoa pessoa;

    public Telefone(Integer ddd, Integer numero, Pessoa pessoa) {
        this.ddd = ddd;
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public Telefone() {
    }


    public Long getCodigo() {
        return codigo;
    }

    public Integer getDdd() {
        return ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

}
