package com.ws.ng;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class JdbcSSLTest {

    //azure host
    private static String host = "wsng-postgresql-dev.postgres.database.azure.com";
    private static String database = "ws-ng-42";
    private static String user = "wsng@wsng-postgresql-dev";
    private static String password = "Ws1337ng";

    private static PostgreSQLJdbc postgreSQLJdbc;
    @BeforeAll
    public static void beforeAll(){
        postgreSQLJdbc = new PostgreSQLJdbc(host, database,user,password,true);
    }
    @Test
    public void sslTest() throws SQLException, ClassNotFoundException {
        String insert = " insert into public.chapter (chapter_description, chapter_name, created_by, updated_by, investigation_wsid, chapter_wsid) values (? ,?, ?, ?, ?, ?)";
        try(Connection conn = postgreSQLJdbc.connect()){
            PreparedStatement pst = conn.prepareStatement(insert);
            pst.setObject(1, "desc");
            pst.setObject(2, "name");
            pst.setObject(3, "by");
            pst.setObject(4, "updated by");
            pst.setObject(5, "IN2");
            pst.setObject(6, UUID.randomUUID().toString());
            pst.execute();
        };

    }
}
