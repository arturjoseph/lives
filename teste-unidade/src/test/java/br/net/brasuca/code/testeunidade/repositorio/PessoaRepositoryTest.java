package br.net.brasuca.code.testeunidade.repositorio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.net.brasuca.code.testeunidade.modelo.Pessoa;
import br.net.brasuca.code.testeunidade.util.PessoaCreator;

@DataJpaTest
@DisplayName("Testes para o repositório Pessoa")
public class PessoaRepositoryTest {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Test
	@DisplayName("Deve salvar Pessoa com sucesso")
	void deveSalvarPessoaComSucesso() {
		// instacias
		Pessoa pessoa = PessoaCreator.criarPessoaParaSerPersistido();
		//execução
		Pessoa pessoaPersistida = this.pessoaRepository.save(pessoa);
		//verifica
		assertThat(pessoaPersistida).isNotNull();
		assertThat(pessoaPersistida.getCodigo()).isNotNull();
		assertThat(pessoaPersistida.getNome()).isEqualTo(pessoa.getNome());
	}
	
	 @Test
	 @DisplayName("Deve remover Pessoa com sucesso")
	 void deveRemoverPessoaComSucesso() {
		 Pessoa pessoa = PessoaCreator.criarPessoaParaSerPersistido();
		 Pessoa pessoaPersistida = this.pessoaRepository.save(pessoa);

	        this.pessoaRepository.delete(pessoaPersistida);
	     
	        Optional<Pessoa> pessoaOptional = this.pessoaRepository
	        		.findById(pessoaPersistida.getCodigo());

	        assertThat(pessoaOptional).isEmpty();
	    }

}
