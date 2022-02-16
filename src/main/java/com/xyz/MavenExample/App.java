package com.xyz.MavenExample;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String str = "Facebook is showing information to help you better understand the purpose of a Page. See actions taken by the people who manage and post content.";
        String[] list = str.split("\\s");
        
        for(String S:list) {
        	System.out.println(S);
        }
        
        System.out.println("Number of words: "+ list.length);
        
        
    }
}
