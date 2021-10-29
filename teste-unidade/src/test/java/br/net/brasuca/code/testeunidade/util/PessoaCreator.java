package br.net.brasuca.code.testeunidade.util;

import br.net.brasuca.code.testeunidade.modelo.Endereco;
import br.net.brasuca.code.testeunidade.modelo.Pessoa;
import br.net.brasuca.code.testeunidade.modelo.Telefone;

import java.util.Arrays;
import java.util.Optional;

public class PessoaCreator {

    public static Pessoa criarPessoaParaSerPersistido() {
    	Pessoa pessoa = new Pessoa("Artur", "12345678910");
    	Telefone telefone = new Telefone("011", "912345678");
        Endereco endereco = new Endereco("Rua 1", 10, "casa 1", "bairro 1", "cidade 1", "SP");
        
        pessoa.setTelefones(Arrays.asList(telefone));
        pessoa.setEnderecos(Arrays.asList(endereco));
        telefone.setPessoa(pessoa);
        endereco.setPessoa(pessoa);
        return pessoa;
    }

    public static Pessoa criarPessoaValida() {
        Telefone telefone = new Telefone("011", "912345678");
        Endereco endereco = new Endereco("Rua 1", 10, "casa 1", "bairro 1", "cidade 1", "SP");
        Pessoa pessoa = new Pessoa("Artur", "12345678910");
        pessoa.setCodigo(1L);
        pessoa.setTelefones(Arrays.asList(telefone));
        pessoa.setEnderecos(Arrays.asList(endereco));
        telefone.setPessoa(pessoa);
        endereco.setPessoa(pessoa);
        return pessoa;
    }

    public static Optional<Pessoa> criarPessoaValidaOptional() {
        Telefone telefone = new Telefone("011", "912345678");
        Endereco endereco = new Endereco("Rua 1", 10, "casa 1", "bairro 1", "cidade 1", "SP");
        Pessoa pessoa = new Pessoa("Artur", "12345678910");
        pessoa.setCodigo(1L);
        pessoa.setTelefones(Arrays.asList(telefone));
        pessoa.setEnderecos(Arrays.asList(endereco));
        telefone.setPessoa(pessoa);
        endereco.setPessoa(pessoa);
        return Optional.of(pessoa);
    }

    public static Pessoa criarPessoaAtualizada() {
        Telefone telefone = new Telefone("011", "912345678");
        Endereco endereco = new Endereco("Rua 1", 10, "casa 1", "bairro 1", "cidade 1", "SP");
        Pessoa pessoa = new Pessoa("Artur", "12345678910");
        pessoa.setCodigo(1L);
        pessoa.setTelefones(Arrays.asList(telefone));
        pessoa.setEnderecos(Arrays.asList(endereco));
        telefone.setPessoa(pessoa);
        endereco.setPessoa(pessoa);
        return pessoa;
    }
}

