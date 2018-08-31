package com.auexample.googlesearch.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Ayhan.Ugurlu on 31/08/2018
 */
@Getter
@Setter
public class ResponseData {
    private List<Result> results;

    public String toString() {
        return "Results[" + results + "]";
    }

}
