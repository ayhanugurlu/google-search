package com.auexample.googlesearch.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * Created by Ayhan.Ugurlu on 31/08/2018
 */
public interface GoogleSearch {

    void search(String searchKey) throws IOException;

}
