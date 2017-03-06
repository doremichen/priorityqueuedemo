package com.adam.app.demo;

import java.util.Comparator;
import java.util.PriorityQueue;


public class ObjectDemo3
{
    
    public static void main(String[] args)
    {
        int num = 10;
        PriorityQueue<Command> pQ = new PriorityQueue<Command>(num, new CommandCompare());
        
        Command command1 = new Command("A");
        Command command2 = new Command("B");
        Command command3 = new Command("C");
        Command command4 = new Command("D");
        Command command5 = new Command("E");
        
        command1.setPriority(100);
        command2.setPriority(50);
        command3.setPriority(90);
        command4.setPriority(25);
        command5.setPriority(1);
        
        pQ.offer(command1);
        pQ.offer(command2);
        pQ.offer(command5);
        pQ.offer(command4);
        pQ.offer(command3);
        
        Command c = null;
        while ((c = pQ.poll()) != null) {
            System.out.println("[" + c.getCommand() +"]: " + c.getPriority());
        }
        
    
    }
    
    private static class CommandCompare implements Comparator<Command> {

        @Override
        public int compare(Command o1, Command o2)
        {
        
            return o1.getPriority() - o2.getPriority();
        }
        
    }
    
    private interface ICommand {
        
        void setPriority(int p);
        int getPriority();
        String getCommand();
    }
    
    public static class Command implements ICommand {

        private int mPriority;
        private String mName;
        
        public Command(String name) {
            this.mName = name;
        }
        
        @Override
        public void setPriority(int p)
        {
            this.mPriority = p;
        }

        @Override
        public int getPriority()
        {
        
            return this.mPriority;
        }

        @Override
        public String getCommand()
        {
        
            return this.mName;
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
