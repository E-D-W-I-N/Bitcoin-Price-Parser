package com.vsk.serviceMix.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BitcoinPriceParser {

    private String prefix = "BitcoinPriceParser";

    public Object parse() throws IOException {

        URL url = new URL("https://capcoin.ru/kriptovalyuta/BTC");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line, html = "ERROR";
        while ((line = br.readLine()) != null) {
            if (line.contains("<span id=\"price\">"))
                html = line.substring(line.indexOf('$'), line.indexOf('.') + 2);
        }

        return prefix + " Current Bitcoin's Price is :  " + html;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
