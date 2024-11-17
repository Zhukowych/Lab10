package org.example.decorator;

import lombok.SneakyThrows;

import java.sql.*;

public class DBConnection {

    private static DBConnection sigleton;
    private Connection connection;
    private static final String URL = "jdbc:sqlite:/home/zhukowych/Projects/ucu/OOP/Lab10/DecoratorPractice/cache.sqlite3";

    @SneakyThrows
    private DBConnection() {
        this.connection = DriverManager.getConnection(URL);
    }

    public static DBConnection getInstance() {
        if (sigleton == null)
            sigleton = new DBConnection();
        return sigleton;
    }

    @SneakyThrows
    public String getCachedDocument(String path) {
        PreparedStatement statement = connection.prepareStatement("select `document` from `document_cache` where `path`=?;");
        statement.setString(1, path);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.getString("document");
    }

    @SneakyThrows
    public void cacheDocument(String path, String document) {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO `document_cache` (`path`, `document`) VALUES (?, ?)");
        statement.setString(1, path);
        statement.setString(2, document);
        statement.executeUpdate();
        statement.close();
    }

}
