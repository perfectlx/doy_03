package com.example.doy_03;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class JsoupTest {
    public static void main(String[] args) {
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&wq=%E6%89%8B%E6%9C%BA&pvid=8858151673f941e9b1a4d2c7214b2b52";
        test01(url);
        test02(url);
        test03(url);
    }
    public static void test01(String url){
        try
        {
            Document document = Jsoup.connect(url).get();
            Elements c = document.body().getElementsByClass("p-img");
            Elements img = c.select("img"); // a with href
            ArrayList<String> strings = new ArrayList<>();
            img.forEach(i->{
                String before = "https:";
                String s = i.attr("data-lazy-img");
                StringBuffer stringBuffer = new StringBuffer();
                String string = stringBuffer.append(before).append(s).toString();
                strings.add(string);
            });
            strings.forEach(System.out::println);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void test02(String url){
        try {
            Document document = Jsoup.connect(url).get();
            Elements select = document.body().getElementsByClass("p-name");
            Elements em = select.select("p-name");
            for(Element element :select){
                String text =element.text();
                System.out.println(text);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void test03(String url){
        try {
            Document document = Jsoup.connect(url).get();
            Elements select = document.body().getElementsByClass("p-price");
            Elements em = select.select("p-price");
            for(Element element :select){
                String text =element.text();
                System.out.println(text);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
