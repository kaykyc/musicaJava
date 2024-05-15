package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;

    @ManyToOne
    private Artista artista;

    public Musica(){}
    public Musica(String nomeMusica) {
        this.titulo = nomeMusica;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Nome da Musica='" + titulo + '\'' +
                ", artista=" + artista.getNome() +
                '}';
    }
}
