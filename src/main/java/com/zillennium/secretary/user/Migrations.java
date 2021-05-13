package com.zillennium.secretary.user;

import org.flywaydb.core.Flyway;

public class Migrations {
    public static void main(String[] args) throws Exception {
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://ec2-52-21-153-207.compute-1.amazonaws.com:5432", "bektsdkfviscye", "8ecbe672b117dce4a29a99ead950c39fa60b1fffacd733973cbefc9e0e6fc754").load();
        /*flyway.setDataSource(System.getenv(),
                             System.getenv(),
                             System.getenv());*/
        flyway.migrate();
    }
}