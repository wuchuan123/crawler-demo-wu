package com.github.hcsp;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> linkPool = new ArrayList<>();
        Set<String> processedLinks = new HashSet<>();
        linkPool.add("https://sina.cn");
        while (true) {
            if (linkPool.isEmpty()) {
                break;
            }
            String link = linkPool.remove(linkPool.size() - 1);
            if (processedLinks.contains(link)) {
                continue;
            }
            if ( (link.contains("news.sina.cn") || "https://sina.cn".equals(link))) {
                CloseableHttpClient httpclient = HttpClients.createDefault();

                if (link.startsWith("//")) {
                    link = "https:" + link;
                }
                HttpGet httpGet = new HttpGet(link);
                httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36");
                try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                    System.out.print(link);
                    System.out.println(response1.getStatusLine());
                    HttpEntity entity1 = response1.getEntity();
                    String html = EntityUtils.toString(entity1);
                    Document doc = Jsoup.parse(html);
                    ArrayList<Element> links = doc.select("a");
                    for (Element aTag : links) {
                        linkPool.add(aTag.attr("href"));
                    }
                    ArrayList<Element> articleTags = doc.select("article");
                    if (!articleTags.isEmpty()) {
                        for (Element articleTag : articleTags) {
                            System.out.print("");
                        }
                    }
                    processedLinks.add(link);
                }
            }
        }
    }
}
