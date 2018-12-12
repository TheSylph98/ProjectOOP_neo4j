package com.group.oop20181project.Project_oop_neo4j;

import connect.ConnectDataBase;

public class App 
{
    public static void main( String[] args )
    {
    	ConnectDataBase connect = new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
    	
    	connect.close();
    }
}
