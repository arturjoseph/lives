package br.net.brasuca.code.testeunidade;

import br.net.brasuca.code.testeunidade.modelo.Endereco;
import br.net.brasuca.code.testeunidade.modelo.Pessoa;
import br.net.brasuca.code.testeunidade.modelo.Telefone;
import br.net.brasuca.code.testeunidade.repositorio.EnderecoRepository;
import br.net.brasuca.code.testeunidade.repositorio.PessoaRepository;
import br.net.brasuca.code.testeunidade.repositorio.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TesteDeUnidadeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TesteDeUnidadeApplication.class, args);
	}

	@Autowired
	private PessoaRepository pessoaRepo;
	@Autowired
	private EnderecoRepository enderecoRepo;
	@Autowired
	private TelefoneRepository telefoneRepo;

	@Override
	public void run(String... args) throws Exception {
		Pessoa artur = new Pessoa("Artur","12345678910");
		Pessoa ze = new Pessoa("Ze","78945612310");
		pessoaRepo.saveAll(Arrays.asList(artur,ze));

		Endereco end1 = new Endereco("Rua 1",10,"casa 1","bairro 1","cidade 1", "SP",artur);
		Endereco end2 = new Endereco("Rua 2",20,"casa 2","bairro 2","cidade 1", "SP",ze);
		enderecoRepo.saveAll(Arrays.asList(end1,end2));

		Telefone tel1 = new Telefone(11,912345678,artur);
		Telefone tel2 = new Telefone(11,987654321,ze);
		telefoneRepo.saveAll(Arrays.asList(tel1,tel2));

	}
}
