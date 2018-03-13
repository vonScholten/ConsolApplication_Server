package brugerautorisation.transport.rmi;

import brugerautorisation.data.Diverse;
import brugerautorisation.data.Bruger;
import java.rmi.Naming;

public class Brugeradminklient {
	public static void main(String[] arg) throws Exception {
		Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

		Bruger b = ba.hentBruger("s165228", "s165228");
		System.out.println("Fik bruger = " + b);
		System.out.println("Data: " + Diverse.toString(b));
	}
}
