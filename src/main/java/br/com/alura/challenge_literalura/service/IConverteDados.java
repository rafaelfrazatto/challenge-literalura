package br.com.alura.challenge_literalura.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}

