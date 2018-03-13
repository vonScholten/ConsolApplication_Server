
import brugerautorisation.data.Bruger;
import brugerautorisation.data.Diverse;
import brugerautorisation.transport.rmi.Brugeradmin;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alt
 */
public class ConsolImpl extends UnicastRemoteObject implements ConsolI {

    ArrayList<String> data = new ArrayList<>();
    
    public ConsolImpl() throws java.rmi.RemoteException{
    }
    
    @Override
    public void addData(String name) {
        data.add(name);
        System.out.println("ConsolImpl.addData()");
    }

    @Override
    public void removeData(String name) {
        data.remove(name);
        System.out.println("ConsolImpl.removeData()");
    }

    @Override
    public ArrayList<String> getData() throws RemoteException {
        System.out.println("ConsolImpl.getData()");
        return data;
    }

    @Override
    public String login(String user, String passwd) throws RemoteException {
        
        Brugeradmin ba;
        Bruger b;
        String loginData = null;
        
        try {
            ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
            b = ba.hentBruger(user, passwd);
            
            loginData = "User: " + b + ", " + "Data: " + Diverse.toString(b);

        } catch (NotBoundException | MalformedURLException ex) {
            Logger.getLogger(ConsolImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
		return loginData;
    }
    
}
