/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajeshpatkar.command;
import com.rajeshpatkar.action.Action;
import java.io.PrintWriter;
public class Action1 implements Action{
    @Override
    public void execute(PrintWriter out) {
       out.println("This is is Action1");
       for(int i=0;i<5;i++){
           out.println("Action1 "+i);
       }
       out.println("Action1 Ends");
    }
    
}
