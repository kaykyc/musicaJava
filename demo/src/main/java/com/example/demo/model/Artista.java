package com.example.demo.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String nome;
    @Enumerated (EnumType.STRING)
    private TipoArtista tipo;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musica = new ArrayList<>();

    public Artista(){}

    public Artista(String nome, TipoArtista tipo) {
        this.nome =nome;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public void setTipo(TipoArtista tipo) {
        this.tipo = tipo;
    }

    public List<Musica> getMusicas() {
        return musica;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musica = musica;
    }

    @Override
    public String toString() {
        return "Artista{" +
                ", Artista='" + nome + '\'' +
                ", tipo=" + tipo +
                ", musicas=" + musica ;
    }
}
