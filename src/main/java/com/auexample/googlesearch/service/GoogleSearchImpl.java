package com.auexample.googlesearch.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayhan.Ugurlu on 31/08/2018
 */

@Service
public class GoogleSearchImpl implements GoogleSearch {

    @Value("${api-key}")
    private String API_KEY;

    @Value("${googleSearchUrl}")
    private String GOOGLE_SEARCH_URL;

    @Override
    public List<String> search(String qry) throws IOException {

        List<String> results = new ArrayList<>();

        URL url = new URL(
                GOOGLE_SEARCH_URL+API_KEY+ "&cx=013036536707430787589:_pqjad5hr1a&q="+ qry + "&alt=json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        String output;
        while ((output = br.readLine()) != null) {
            //System.out.println(output);
            if(output.contains("\"link\": \"")){
                String link=output.substring(output.indexOf("\"link\": \"")+("\"link\": \"").length(), output.indexOf("\","));
                results.add(link);
            }
        }
        conn.disconnect();
        return results;
    }
}
