package com.auexample.googlesearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Created by Ayhan.Ugurlu on 04/09/2018
 */
@Service
public class AssessmentImpl implements Assessment {


    @Autowired
    GoogleSearch googleSearch;

    @Autowired
    JSCrawler jsCrawler;

    public void googleSearchAndFindJS(String query) {
        try {
            List<String> urlList = googleSearch.search(query);


            Map<String, Integer> map = urlList.stream().map(s -> {
                return jsCrawler.searchJsInPage(s);
            }).collect(Collectors.toList()).stream().flatMap(m -> m.entrySet().stream())
                    .collect(groupingBy(Map.Entry::getKey, summingInt(Map.Entry::getValue)));


            Map<String, Integer> result = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));


            Iterator<String> keySetIter = result.keySet().iterator();

            for (int i = 0; i < 5; i++) {
                String key = keySetIter.next();
                System.out.println(key + " " + result.get(key));
                if (!keySetIter.hasNext()) {
                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
