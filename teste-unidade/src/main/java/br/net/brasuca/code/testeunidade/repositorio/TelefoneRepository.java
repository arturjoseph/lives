package br.net.brasuca.code.testeunidade.repositorio;

import br.net.brasuca.code.testeunidade.modelo.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
