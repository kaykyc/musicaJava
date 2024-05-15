package com.example.demo.principal;

import com.example.demo.model.Artista;
import com.example.demo.model.Musica;
import com.example.demo.model.TipoArtista;
import com.example.demo.repository.ArtistaRepository;
import org.springframework.expression.spel.ast.OpOr;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final ArtistaRepository repositorio;
    private Scanner leitura = new Scanner(System.in);

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 9) {
            var menu = """
                    Digite a sua opcao:
                                        
                    1- Cadastrar artista
                    2- Cadastrar música
                    3- Listar musicas
                    4- Buscar musica por artista
                    5- Pesquisar dados de um artista
                                        
                    9- Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusica();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    pesquisarDadosDeUmArtista();
                    break;
                case 9:
                    System.out.println("Encerrando aplicação");
                    break;
                default:
                    System.out.println("Opcão invalida");
            }
        }
    }

    private void pesquisarDadosDeUmArtista() {
    }

    private void buscarMusicaPorArtista() {
    }

    private void listarMusica() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a-> a.getMusicas().forEach(System.out::println));
    }

    private void cadastrarMusica() {
        System.out.println("Digite o nome do artista que deseja cadastrar:");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);

        if(artista.isPresent()){
            System.out.println("Digite o nome da musica para cadastrar");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        }else {
            System.out.println("Artista não encontrado!");
        }
    }

    private void cadastrarArtista() {
        var castratrarNovo = "S";
        while (castratrarNovo.equalsIgnoreCase("s")){
            System.out.println("Informe o nome do artista");
            var nome = leitura.nextLine();
            System.out.println("Infome o tipo do artista (SOLO, DUPLA OU BANDA)");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repositorio.save(artista);
            System.out.println("Cadastrar um novo artista (S/N)?");
            castratrarNovo = leitura.nextLine();
        }

    }
}