package com.rajeshpatkar.command;
import com.rajeshpatkar.action.Action;
import java.io.PrintWriter;
public class DefaultAction implements Action{
    @Override
    public void execute(PrintWriter out) {
       out.println("This is is Default Action");
       out.println("The action you desired is not yet implemented.");
       out.println("Sorry...");
       out.println("Default Action Ends");
    }
    
}
