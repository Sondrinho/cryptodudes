package com.cryptodudes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DbConnection

{
private Object userName;
private Object password;
private String dbms;
private String serverName;
private String portNumber;
private String dbName;


//LVS;Not ready for use
public  Connection Connection() throws SQLException {

	
	//TODO move to properties file
	serverName = "crypto.cscddufwrpnn.eu-central-1.rds.amazonaws.com";
	portNumber="3306";
	dbName="crypto";
	dbms="mysql";
	userName="admin";
	password="123Banan";
    Connection conn = null;
    Properties connectionProps = new Properties();
    connectionProps.put("user", this.userName);
    connectionProps.put("password", this.password);
    conn = DriverManager.getConnection(
                   "jdbc:" + this.dbms + "://" +
                   this.serverName +
                   ":" + this.portNumber + "/",
                   connectionProps);
  
    System.out.println("Connected to database");
    return conn;
}

}