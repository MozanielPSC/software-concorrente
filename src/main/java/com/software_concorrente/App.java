package com.software_concorrente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Queries query = new Queries();
        String[] teste = query.signIn();
        query.login(teste);
    }
}
