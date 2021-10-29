package br.net.brasuca.code.testeunidade.controladores.configuracoes;

import br.net.brasuca.code.testeunidade.servico.exception.TelefoneNaoEncontradoException;
import br.net.brasuca.code.testeunidade.servico.exception.UnicidadeCpfException;
import br.net.brasuca.code.testeunidade.servico.exception.UnicidadeTelefoneException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroHandler {

    @ExceptionHandler(TelefoneNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> handle(TelefoneNaoEncontradoException exception) {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(UnicidadeCpfException.class)
    public ResponseEntity<ErroDTO> handle(UnicidadeCpfException exception) {
        return ResponseEntity.badRequest().body(new ErroDTO(exception.getMessage()));
    }
    @ExceptionHandler(UnicidadeTelefoneException.class)
    public ResponseEntity<ErroDTO> handle(UnicidadeTelefoneException exception) {
        return ResponseEntity.badRequest().body(new ErroDTO(exception.getMessage()));
    }
}
