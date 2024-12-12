package br.com.alura.challenge_literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    private final URI ENDERECO = URI.create("https://gutendex.com/books/?search=");

    public String consumoApi (String busca) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ENDERECO + busca.replace(" ", "%20").toLowerCase()))
                .build();
        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            return json;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}