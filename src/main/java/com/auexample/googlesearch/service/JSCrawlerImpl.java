package com.auexample.googlesearch.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

/**
 * Created by Ayhan.Ugurlu on 04/09/2018
 */
@Service
public class JSCrawlerImpl implements JSCrawler {


    public Map<String, Integer> searchJsInPage(String URL) {
        Map<String, Integer> jsLinkMap = new HashMap<>();
        try {
            // Fetch the HTML code
            Document document = Jsoup.connect(URL).get();
            // Parse the HTML to extract js
            Elements linksOnPage = document.select("script");

            // For each extracted JS adding to hashset
            for (Element page : linksOnPage) {
                String src = page.attr("src");
                int jsSrcCount = jsLinkMap.getOrDefault(src, 0);
                jsLinkMap.put(src, ++jsSrcCount);
            }
        } catch (IOException e) {
            System.err.println("For '" + URL + "': " + e.getMessage());
        }
        return jsLinkMap;
    }

}
