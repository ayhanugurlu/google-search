package com.auexample.googlesearch;

import com.auexample.googlesearch.service.GoogleSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GoogleSearchApplication implements CommandLineRunner {

    @Autowired
    GoogleSearch googleSearch;

    public static void main(String[] args) {
        SpringApplication.run(GoogleSearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("Enter key: ");
        String key = "";
        while (!key.equals("q")) {
            Scanner scanner = new Scanner(System.in);
            key = scanner.nextLine();

            googleSearch.search(key);
            System.out.println("Your username is " + key);
        }


    }
}
