package br.net.brasuca.code.testeunidade.servico;


import br.net.brasuca.code.testeunidade.modelo.Pessoa;
import br.net.brasuca.code.testeunidade.modelo.Telefone;
import br.net.brasuca.code.testeunidade.repositorio.EnderecoRepository;
import br.net.brasuca.code.testeunidade.repositorio.PessoaRepository;
import br.net.brasuca.code.testeunidade.repositorio.TelefoneRepository;
import br.net.brasuca.code.testeunidade.servico.exception.TelefoneNaoEncontradoException;
import br.net.brasuca.code.testeunidade.servico.exception.UnicidadeCpfException;
import br.net.brasuca.code.testeunidade.servico.exception.UnicidadeTelefoneException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private TelefoneRepository telefoneRepository;

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa cadastrar(Pessoa pessoa) throws UnicidadeCpfException, UnicidadeTelefoneException {
        Telefone telefone = pessoa.getTelefones().get(0);
        if(this.pessoaRepository.findByCpf(pessoa.getCpf()).isPresent()) {
            throw new UnicidadeCpfException("Não é possível cadastrar duas Pessoas com o mesmo cpf");
        }
        if (this.pessoaRepository.findByTelefoneDddAndTelefoneNumero(telefone.getDdd(), telefone.getNumero()).isPresent()) {
            throw new UnicidadeTelefoneException("Não é possível cadastrar duas Pessoas com o mesmo numero de telefone");
        }
        Pessoa pessoaPersistida = this.pessoaRepository.save(pessoa);
        this.enderecoRepository.saveAll(pessoa.getEnderecos());
        this.telefoneRepository.saveAll(pessoa.getTelefones());
        return pessoaPersistida;
    }

    public List<Pessoa> buscar() {
        return this.pessoaRepository.findAll();
    }

    public Pessoa buscarPor(Long codigo) {
        return pessoaRepository.findById(codigo).orElseThrow(
                () -> new ObjectNotFoundException(codigo, "A Pessoa com o código: " + codigo + " não foi encontrada!")
        );
    }

    public Pessoa buscarPor(Telefone telefone) throws TelefoneNaoEncontradoException {
        return pessoaRepository
                .findByTelefoneDddAndTelefoneNumero(telefone.getDdd(), telefone.getNumero())
                .orElseThrow(() -> new TelefoneNaoEncontradoException("Não existe pessoa com o telefone " +
                        "(" + telefone.getDdd() + ")" + telefone.getNumero()));

    }
}
