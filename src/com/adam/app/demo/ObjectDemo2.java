package com.adam.app.demo;

import java.util.Comparator;
import java.util.PriorityQueue;


public class ObjectDemo2
{
    
    public static void main(String[] args)
    {
        int num = 1;
        PriorityQueue<COMMAND>  pQ = new PriorityQueue<COMMAND>(num, new CommendCompare());
        
        COMMAND.ONE.setPriority(100);
        COMMAND.TWO.setPriority(50);
        COMMAND.THREE.setPriority(1);
        
        pQ.offer(COMMAND.ONE);
        pQ.offer(COMMAND.TWO);
        pQ.offer(COMMAND.THREE);
        
        COMMAND commend = null;
        while ((commend = pQ.poll()) != null) {
            System.out.println("[" + commend.toString() + "]: " + commend.getPriority());
        }
        
        
    }
    
    private static class CommendCompare implements Comparator<COMMAND> {

        @Override
        public int compare(COMMAND arg0, COMMAND arg1)
        {
        
            return arg0.getPriority() - arg1.getPriority();
        }
        
    }
    
    
    
    public enum COMMAND {
        
        ONE {

            @Override
            public void setPriority(int p)
            {
                mPriority = p;
            }

            @Override
            public int getPriority()
            {
            
                return mPriority;
            }

            @Override
            public String toString()
            {
            
                return "ONE";
            }

        },
        TWO {

            @Override
            public void setPriority(int p)
            {
                mPriority = p;
            }

            @Override
            public int getPriority()
            {
            
                return mPriority;
            }
            
            @Override
            public String toString()
            {
            
                return "TWO";
            }
        },
        THREE {

            @Override
            public void setPriority(int p)
            {
                mPriority = p;
            }

            @Override
            public int getPriority()
            {
            
                return mPriority;
            }
            
            @Override
            public String toString()
            {
            
                return "THREE";
            }
        };
        
        protected int mPriority = -1;
        
        public abstract void setPriority(int p);
        
        public abstract int getPriority();
    }
}

/*
 * ===========================================================================
 * 
 * Revision history
 * 
 * ===========================================================================
 */
