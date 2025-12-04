package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record dadosSerie(@JsonAlias("Title") String title,
                         @JsonAlias("Year")Integer year,
                         @JsonAlias("imdbRating")String rating,
                         @JsonAlias("totalSeasons")Integer totalSeasons,
                         @JsonProperty("Response")String response) {


}
