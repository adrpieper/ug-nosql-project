package main;

import http.UberPickHttpClient;

import static main.PutSchema.fromFile;

/**
 * Created by Adrian on 2017-03-25.
 */
public class ShowRect {

    public static void main(String[] args) {

        UberPickHttpClient client = new UberPickHttpClient();
        String s = client.get(fromFile("query.json"));
        System.out.println(s);


    }
}
