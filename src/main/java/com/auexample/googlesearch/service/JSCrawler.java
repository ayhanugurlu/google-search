package com.auexample.googlesearch.service;

import java.util.Map;

/**
 * Created by Ayhan.Ugurlu on 04/09/2018
 */
public interface JSCrawler {

    Map<String, Integer> searchJsInPage(String url);

}
