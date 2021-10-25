package br.net.brasuca.code.testeunidade.servico;


import br.net.brasuca.code.testeunidade.modelo.Pessoa;
import br.net.brasuca.code.testeunidade.repositorio.EnderecoRepository;
import br.net.brasuca.code.testeunidade.repositorio.PessoaRepository;
import br.net.brasuca.code.testeunidade.repositorio.TelefoneRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository pessoRepo;
    private EnderecoRepository enderecoRepo;
    private TelefoneRepository telefoneRepo;

    public PessoaService(PessoaRepository pessoRepo, EnderecoRepository enderecoRepo, TelefoneRepository telefoneRepo) {
        this.pessoRepo = pessoRepo;
        this.enderecoRepo = enderecoRepo;
        this.telefoneRepo = telefoneRepo;
    }

    public Pessoa cadastrar(Pessoa pessoa) {
        Pessoa pessoaCadastrada = pessoRepo.save(pessoa);
        enderecoRepo.saveAll(pessoa.getEnderecos());
        telefoneRepo.saveAll(pessoa.getTelefones());
        return pessoaCadastrada;
    }

    public List<Pessoa> buscar() {
        return pessoRepo.findAll();
    }

    public Pessoa buscarPor(Long codigo) {
        return pessoRepo.findById(codigo).orElseThrow(
                () -> new ObjectNotFoundException(codigo, "A Pessoa com o código: " + codigo + " não foi encontrada!")
        );
    }
}
