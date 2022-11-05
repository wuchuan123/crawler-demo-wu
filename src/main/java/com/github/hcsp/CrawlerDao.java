package com.github.hcsp;

import java.sql.SQLException;

public interface CrawlerDao {

    String getNextLinkThenDelete() throws SQLException;


    void insertNewsIntoDatabase(String url, String content, String title) throws SQLException;

    boolean isLinkProcessed(String link) throws SQLException;

    void insertProcessedLink(String link);

    void insertLinkToBeProcessed(String href);
}
