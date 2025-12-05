package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
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
        System.out.println(dadosSerie
        );
        json = consumoAPI.obterDados("http://www.omdbapi.com/?t=gilmore+girls&Season=1&Episode=1&apikey=1b5bcb5c");
        DadosEpisodio dadosEpisodio = conversor.converte(json, DadosEpisodio.class);
        System.out.println(dadosEpisodio);

    }
}
