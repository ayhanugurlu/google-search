package com.auexample.googlesearch.service;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ayhan.Ugurlu on 31/08/2018
 */
public interface GoogleSearch {

    List<String> search(String searchKey) throws IOException;

}
