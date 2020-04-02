package com.persistent.basics;

/**
 * Hello world!
 *
 */
public class Parent 
{
    public static void main( String[] args )
    {
        System.out.println( "Main" );
    }
    
    public static void main( String arg1 )
    {
        System.out.println( "non string" );
    }
    
    public static void main( String[] args, String args2 )
    {
        System.out.println( "mulitple string" );
    }
}
