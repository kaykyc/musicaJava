package com.example.demo.repository;


import com.example.demo.model.Artista;
import com.example.demo.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNomeContainingIgnoreCase(String nome);

    List<Musica> buscarMusicaPorArtista
}
