package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=1b5bcb5c";


    public void exibeMenu() {
        System.out.println("Digite o nome da serie que deseja buscar: ");
        var nomeSerie = scanner.nextLine();
        var json = consumoAPI.obterDados(
                ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie dadosSerie = conversor.converte(json, DadosSerie.class);
        System.out.println(dadosSerie);
    }
}
