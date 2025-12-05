package br.com.alura.screenmatch.service;

public interface iConverteDados {
    <T> T converte(String json, Class<T> classe);
}
