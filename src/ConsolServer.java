
import java.rmi.Naming;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alt
 */
public class ConsolServer {
    
    public static void main(String[] arg) throws Exception{
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        
        ConsolI con = new ConsolImpl();
        //188.166.168.107 i stedet for localhost når den køre på vores webserver
        //System.setProperty("java.rmi.server.hostname", "188.166.168.107");
        Naming.rebind("rmi://localhost:1099/ConsolApplication", con);
        System.out.println("ConsolServer.main()");
    }
}
