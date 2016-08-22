import java.rmi.Naming;
import java.util.*;

import java.rmi.RemoteException;

public class Cliente {

	public static void main (String args[]) 
	{

		try {

			while(true)
			{
				Hello obj = (Hello) Naming.lookup("//localhost/HelloServer");
				System.out.println("Coloque o texto a se enviado: ");
				Scanner msg = new Scanner(System.in);
				String texto =msg.nextLine();
				obj.sayHello(texto);
			}
			

		} catch (Exception e) {

			System.out.println("HelloApplet exception: " + e.getMessage());

			e.printStackTrace();

		}


	}
}