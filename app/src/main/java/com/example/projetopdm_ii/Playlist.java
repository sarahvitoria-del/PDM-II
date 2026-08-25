package com.example.projetopdm_ii;

public class Playlist {
    private String nome;
    private int musica;
    public Playlist (String nome, int musica) {
        this.nome = nome;
        this.musica = musica;
    }



    //_______________getNome____________________________________________________________________________________________________________

    public String getNome() {
        return nome;
    }
    //______________setNome_____________________________________________________________________________________________________________

    public void setNome(String nome) {
        this.nome = nome;
    }
    //_______________getMusica____________________________________________________________________________________________________________

    public int getMusica() {
        return musica;
    }
    //_________________setMusica__________________________________________________________________________________________________________

    public void setMusica(int musica) {
        this.musica = musica;
    }
}
