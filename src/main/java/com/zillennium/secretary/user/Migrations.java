package com.zillennium.secretary.user;

import org.flywaydb.core.Flyway;

public class Migrations {
    public static void main(String[] args) throws Exception {
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgres://ec2-52-21-153-207.compute-1.amazonaws.com:5432/d8jhoof9ujfbef", "bektsdkfviscye", "8ecbe672b117dce4a29a99ead950c39fa60b1fffacd733973cbefc9e0e6fc754").load();
        flyway.migrate();
    }
}