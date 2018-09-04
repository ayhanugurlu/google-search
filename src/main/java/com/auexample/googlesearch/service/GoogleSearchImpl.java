package com.auexample.googlesearch.service;

import com.auexample.googlesearch.dto.GoogleResults;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayhan.Ugurlu on 31/08/2018
 */

@Service
public class GoogleSearchImpl implements GoogleSearch {

    @Value("${api-key}")
    private String API_KEY;



    @Override
    public List<String> search(String qry) throws IOException {

        List<String> results = new ArrayList<>();

        URL url = new URL(
                "https://www.googleapis.com/customsearch/v1?key="+API_KEY+ "&cx=013036536707430787589:_pqjad5hr1a&q="+ qry + "&alt=json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {

            if(output.contains("\"link\": \"")){
                String link=output.substring(output.indexOf("\"link\": \"")+("\"link\": \"").length(), output.indexOf("\","));
                System.out.println(link);       //Will print the google search links
                results.add(link);
            }
        }
        conn.disconnect();
        return results;
    }
}
