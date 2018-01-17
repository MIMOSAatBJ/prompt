package com.mimosa;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Mongo mongo=new Mongo();
        MongoClient client;
        System.out.println( "Hello World!" );
    }
}
