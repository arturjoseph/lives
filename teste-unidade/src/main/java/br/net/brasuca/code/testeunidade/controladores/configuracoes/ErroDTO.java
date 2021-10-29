package br.net.brasuca.code.testeunidade.controladores.configuracoes;

public class ErroDTO {
    private String mensagem;

    public ErroDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
