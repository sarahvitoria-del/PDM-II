package com.example.projetopdm_ii;

public class Slide {
    private String nome;
    private int imagem;
    private String texto;

    //______________________________________________________________________________

    public Slide (String nome, int imagem){ ///*metodo construtor tem que, obrigatoriamente, o mesmo nome da classe. *Metodo construtor nunca tera return
        this.nome = nome;
        this.imagem = imagem;

    }
    //______________________________________________________________________________
    public Slide (String nome, int imagem, String texto) {
        this.nome = nome;
        this.imagem = imagem;
        this.texto = texto;
}


//______________________________________________________________________________

    public String getNome() {
        return nome;
    }
//______________________________________________________________________________

    public void setNome(String nome) {
        this.nome = nome;
    }
//______________________________________________________________________________

    public int getImagem() {
        return imagem;
    }
//______________________________________________________________________________

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
//______________________________________________________________________________

    public String getTexto() {
        return texto;
    }
//______________________________________________________________________________

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

//______________________________________________________________________________
