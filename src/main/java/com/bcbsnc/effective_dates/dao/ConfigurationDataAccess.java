package com.bcbsnc.effective_dates.dao;


import com.bcbsnc.effective_dates.model.GithubModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


@Repository
public class ConfigurationDataAccess implements ConfigurationDataAccesInt {
    private Gson gson = new Gson();
    private  HttpClient client = HttpClient.newHttpClient();

    @Override
    public void configWriteToFile(String data) throws IOException, InterruptedException {
        Map<String, String> githubJsonPut = new HashMap<>();

        githubJsonPut.put("message", "New content");
        githubJsonPut.put("content", Base64.getEncoder().encodeToString(data.trim().getBytes()));
        githubJsonPut.put("sha", getSha());

        ObjectMapper objectMapper = new ObjectMapper();
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(githubJsonPut);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/repos/cflowerBCBS6/silver-spoon/contents/testfile"))
                .header("Authorization", "Bearer 3dde5e952290d8d52ec8ac5216c868920d175d41")
                .PUT(HttpRequest.BodyPublishers.ofString(reqBody))
                .build();

        HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::statusCode).thenAccept(System.out::println);
        System.out.println(getSha());
    }

    @Override
    public String configReadFromGit() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/repos/cflowerBCBS6/silver-spoon/contents/testfile"))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer 3dde5e952290d8d52ec8ac5216c868920d175d41")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
       GithubModel ghmodel = gson.fromJson(response.body(), GithubModel.class);
       String content = new String(Base64.getMimeDecoder().decode(ghmodel.getContent().trim())).replace("=", "");

        return content;
    }

    private String getSha() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/repos/cflowerBCBS6/silver-spoon/contents/testfile"))
                .header("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer 3dde5e952290d8d52ec8ac5216c868920d175d41")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        GithubModel ghmodel = gson.fromJson(response.body().trim(), GithubModel.class);

        return ghmodel.getSha();
    }
}

