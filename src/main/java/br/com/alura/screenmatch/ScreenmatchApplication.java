package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ConsumoAPI consumoAPI = new ConsumoAPI();
        var json = consumoAPI.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=1b5bcb5c");
        System.out.println(json);

        ConverteDados conversor = new ConverteDados();
        DadosSerie dadosSerie = conversor.converte(json, DadosSerie.class);
        System.out.println(dadosSerie);
        System.out.println("-------------------");

        json = consumoAPI.obterDados("http://www.omdbapi.com/?t=gilmore+girls&Season=1&Episode=1&apikey=1b5bcb5c");
        DadosEpisodio dadosEpisodio = conversor.converte(json, DadosEpisodio.class);
        System.out.println(dadosEpisodio);
        System.out.println("-------------------");

        for(int i =1; i <= dadosSerie.totalSeasons(); i++){
            json = consumoAPI.obterDados("http://www.omdbapi.com/?t=gilmore+girls&Season=" + i + "&apikey=1b5bcb5c");
            DadosTemporada dadosTemporadaLoop = conversor.converte(json, DadosTemporada.class);
            System.out.println("Temporada: " + i);
            for(DadosEpisodio episodio : dadosTemporadaLoop.episodios()){
                System.out.println(episodio);
            }
            System.out.println("-------------------");
        }

    }
}
