package commandserver;
import com.rajeshpatkar.action.Action;
import com.rajeshpatkar.command.Action1;
import com.rajeshpatkar.command.DefaultAction;
import java.net.*;
import java.io.*;
public class CommandServer {
    public static void main(String[] args) throws Exception{
        System.out.println("Server Signing ON");
        ServerSocket ss  = new ServerSocket(9081);
        Socket soc = ss.accept();
        PrintWriter nos = new PrintWriter(
                              new BufferedWriter(
                                  new OutputStreamWriter(
                                          soc.getOutputStream()
                                  )
                              )
        ,true);
        BufferedReader nis = new BufferedReader(
                                 new InputStreamReader(
                                     soc.getInputStream()
                                 )
        );
        String str = nis.readLine();
        while(!str.equals("End")){
            System.out.println("Server received "+ str);
            try{
               Class c = Class.forName("com.rajeshpatkar.command."+str);
               Action a = (Action) c.newInstance();
               a.execute(nos);   
            }catch(ClassNotFoundException | 
                   InstantiationException | 
                   IllegalAccessException e)
            {
                DefaultAction b = new DefaultAction();
                b.execute(nos);
            }
            str = nis.readLine();
        }
        nos.println("End");
        System.out.println("Server Signing OFF");   
    }
}
