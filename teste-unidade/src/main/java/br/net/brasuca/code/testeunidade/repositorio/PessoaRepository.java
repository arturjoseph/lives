package br.net.brasuca.code.testeunidade.repositorio;


import br.net.brasuca.code.testeunidade.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
