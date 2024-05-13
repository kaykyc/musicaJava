package com.example.demo.principal;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

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
    }

    private void cadastrarMusica() {
    }

    private void cadastrarArtista() {
    }
}