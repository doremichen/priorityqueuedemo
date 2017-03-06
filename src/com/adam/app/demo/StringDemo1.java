package com.adam.app.demo;

import java.util.PriorityQueue;


public class StringDemo1
{
    
    public static void main(String[] args)
    {
        PriorityQueue<String> pQ = new PriorityQueue<String>();
        
        pQ.offer("z");
        pQ.offer("j");
        pQ.offer("a");
        pQ.offer("c");
        pQ.offer("i");
        pQ.offer("p");
        pQ.offer("q");
        pQ.offer("o");
        pQ.offer("r");
        pQ.offer("w");
        pQ.offer("b");
        pQ.offer("k");
        
        String s = null;
        while ((s = pQ.poll()) != null) {
            System.out.println("s = " + s);
        }
        
    }
    
}

/*
 * ===========================================================================
 * 
 * Revision history
 * 
 * ===========================================================================
 */
