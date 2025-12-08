package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
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
        Principal principal = new Principal();
        principal.exibeMenu();

//        List<DadosTemporada> temporadas = new ArrayList<>();
//
//        for(int i =1; i <= dadosSerie.totalSeasons(); i++){
//            json = consumoAPI.obterDados("http://www.omdbapi.com/?t=gilmore+girls&Season=" + i + "&apikey=1b5bcb5c");
//            DadosTemporada dadosTemporadaLoop = conversor.converte(json, DadosTemporada.class);
//            temporadas.add(dadosTemporadaLoop);
//        }
//        temporadas.forEach(System.out::println);
    }


}
