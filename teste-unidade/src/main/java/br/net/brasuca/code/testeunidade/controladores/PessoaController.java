package br.net.brasuca.code.testeunidade.controladores;

import br.net.brasuca.code.testeunidade.modelo.Pessoa;
import br.net.brasuca.code.testeunidade.modelo.Telefone;
import br.net.brasuca.code.testeunidade.servico.PessoaService;
import br.net.brasuca.code.testeunidade.servico.exception.TelefoneNaoEncontradoException;
import br.net.brasuca.code.testeunidade.servico.exception.UnicidadeCpfException;
import br.net.brasuca.code.testeunidade.servico.exception.UnicidadeTelefoneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService servico;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        return ResponseEntity.ok(servico.buscar());
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody Pessoa pessoa, UriComponentsBuilder uriBuilder)
            throws UnicidadeCpfException, UnicidadeTelefoneException {

        Pessoa pessoaCadastrada = this.servico.cadastrar(pessoa);
        URI uri = uriBuilder.path("pessoas/{codigo}").buildAndExpand(pessoa.getCodigo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pessoa> buscarPor(@PathVariable Long codigo) {
        return ResponseEntity.ok(servico.buscarPor(codigo));
    }

    @GetMapping("telefone/{DDD}/{numero}")
    public ResponseEntity<Pessoa> buscarPor(@PathVariable("DDD") String ddd,
                                            @PathVariable("numero") String numero)
            throws TelefoneNaoEncontradoException {
        return ResponseEntity.ok(servico.buscarPor(new Telefone(ddd, numero)));
    }
}
