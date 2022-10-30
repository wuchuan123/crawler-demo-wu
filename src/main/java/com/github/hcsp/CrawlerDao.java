package com.github.hcsp;

import java.sql.SQLException;

public interface CrawlerDao {
    String getNextLink(String sql) throws SQLException;

    String getNextLinkThenDelete() throws SQLException;

    void updateDatabase(String link, String sql) throws SQLException;

    void insertNewsIntoDatabase(String url, String content, String title) throws SQLException;

    boolean isLinkProcessed(String link) throws SQLException;

}
