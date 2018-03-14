
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
        java.rmi.registry.LocateRegistry.createRegistry(3097);
        
        ConsolI con = new ConsolImpl();
        //178.62.24.12 i stedet når den køre på vores webserver
        System.setProperty("java.rmi.server.hostname", "ubuntu4.saluton.dk");
        Naming.rebind("rmi://localhost:3097/ConsolApplication", con);
        System.out.println("ConsolServer.main()");
    }
}
