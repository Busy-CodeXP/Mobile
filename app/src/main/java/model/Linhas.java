package model;

/**
 * Created by dfernandes on 19/03/2018.
 */

public class Linhas {

    private String nomeLinha;
    private int imagem; // vai armazenar o identificador do recurso
    private String descricaoLinha;

    public Linhas (String nomeLinha, String descricaoLinha, int imagem) {
        this.nomeLinha = nomeLinha;
        this.descricaoLinha = descricaoLinha;
        this.imagem = imagem;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getDescricaoLinha() {
        return descricaoLinha;
    }

    public void setDescricaoLinha(String descricaoLinha) {
        this.descricaoLinha = descricaoLinha;
    }
}
