package br.net.brasuca.code.testeunidade.repositorio;


import br.net.brasuca.code.testeunidade.modelo.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
