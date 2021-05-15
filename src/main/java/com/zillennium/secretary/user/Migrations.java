package com.zillennium.secretary.user;

import org.flywaydb.core.Flyway;

public class Migrations {
    public static void main(String[] args) throws Exception {
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://${DB_HOST}:5432/${DB_NAME}", "bektsdkfviscye", "8ecbe672b117dce4a29a99ead950c39fa60b1fffacd733973cbefc9e0e6fc754").load();
        flyway.migrate();
    }
}