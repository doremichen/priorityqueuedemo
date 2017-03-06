package com.adam.app.demo;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;


public class ThreadDemo1
{
    
    public static void main(String[] args)
    {
        int num = 10;
        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<Event>(num, new EventCompare());
        Thread[] threads = new Thread[5];
        
        for (int i = 0; i < threads.length; ++i) {
            Task task = new Task(i, queue);
            threads[i] = new Thread(task);
        }
        
        for (int i = 0; i < threads.length; ++i) {
            threads[i].start();
        }
        
        for (int i = 0; i < threads.length; ++i) {
            try
            {
                threads[i].join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
        int size = queue.size();
        System.out.println("queue size: " + size);
        while (size != 0) {
            
            Event event;
            try
            {
                event = queue.take();
                System.out.println("[" + event.getThread() + "]: " + event.getPriority());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            
            size = queue.size();
            
            
        }
    }
    
    private static class EventCompare implements Comparator<Event> {

        @Override
        public int compare(Event o1, Event o2)
        {
            return o1.getPriority() - o2.getPriority();
        }
        
    }
    
    private static class Event {
        private int mThread;
        private int mPriority;
        
        public Event(int thr, int p) {
            this.mThread = thr;
            this.mPriority = p;
        }
        
        public int getThread() {
            return this.mThread;
        }
        
        public int getPriority() {
            return this.mPriority;
        }
    }
    
    private static class Task implements Runnable {

        private int mId;
        private PriorityBlockingQueue<Event> mQueue;
        
        public Task(int id, PriorityBlockingQueue<Event> queue) {
            this.mId = id;
            this.mQueue = queue;
        }
        
        @Override
        public void run()
        {
            for (int i = 0; i < 5; ++i) {
                Event event = new Event(mId, i);
                mQueue.put(event);
            }
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
