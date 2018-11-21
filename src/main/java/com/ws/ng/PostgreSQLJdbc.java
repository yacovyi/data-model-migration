package com.ws.ng;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class PostgreSQLJdbc {

    private String host;
    private String database;
    private String user;
    private String password;
    private boolean ssl;
    /***
     * PostgreSQLJdbc constructor
     * @param host data base url
     * @param user data base user
     * @param password data base user password
     */
    public PostgreSQLJdbc(String host, String database, String user, String password,boolean ssl) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
        this.ssl = ssl;
    }


    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        // check that the driver is installed
        try
        {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e)
        {
            throw new ClassNotFoundException("PostgreSQL JDBC driver NOT detected in library path.", e);
        }
        System.out.println("PostgreSQL JDBC driver detected in library path.");

        try
        {
            String url = String.format("jdbc:postgresql://%s/%s%s", host, database, ssl ? "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory" : "");

            // set up the connection properties
            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", password);


            //properties.setProperty("ssl", "true");

            // get connection
            connection = DriverManager.getConnection(url, properties);
        }
        catch (SQLException e)
        {
            throw new SQLException("Failed to create connection to database.", e);
        }
        System.out.println("Successfully created connection to database.");
        return connection;
    }


    public Integer update(String query, Object... params)  {
        Connection conn = null;
        PreparedStatement pst = null;
        Integer updatedRows = null;
        try  {
            conn = connect();
            pst = conn.prepareStatement(query);
            if (params != null){
                for(int i=0 ; i<params.length ; i++){
                    pst.setObject(i+1,params[i]);
                }
            }
            updatedRows = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(pst);
            DbUtils.closeQuietly(conn);
        }
        return updatedRows;
    }

    /***
     * select result set and return list of converted objects
     * @param query the select query
     * @param tClass class to be converted to
     * @param params params of the query
     * @param <T> generic type to be converted to
     * @return list of T objects --> List<T>
     */


    public <T> List<T> select(String query, Class<T> tClass, Object... params) {
        Connection conn = null;
        Statement pst = null;
        ResultSet rs = null;
        try{
            conn = connect();
            pst = conn.createStatement();
            rs = pst.executeQuery(query);

            QueryRunner queryRunner = new QueryRunner();

            ResultSetHandler<List<T>> resultSetHandler = new BeanListHandler<T>(tClass);
            return queryRunner.query(conn,query, resultSetHandler, params);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(pst);
            DbUtils.closeQuietly(conn);
        }
        return null;
    }
}


