package de.hfu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App 
{
    public static void main( String[] args )
    {
        String eingabe =null;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try {
		eingabe=br.readLine();
	} catch (IOException e) {
		e.printStackTrace();
	}
	eingabe=eingabe.toUpperCase();
	System.out.println(eingabe);

    }
}
