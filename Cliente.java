import java.rmi.Naming;
import java.util.*;

import java.rmi.RemoteException;

public class Cliente {

	public static void main (String args[]) 
	{
		System.out.println("Coloque o nome");
		Scanner catchname = new Scanner(System.in);
		String nome = catchname.nextLine();

		try {

			while(true)
			{
				Hello obj = (Hello) Naming.lookup("//localhost/HelloServer");
				System.out.println("Coloque o texto a se enviado: ");
				Scanner catchmsg = new Scanner(System.in);
				
				String texto =catchmsg.nextLine();
				obj.enviarMensagem(nome, texto);
				obj.sayHello(texto);
			}
			

		} catch (Exception e) {

			System.out.println("HelloApplet exception: " + e.getMessage());

			e.printStackTrace();

		}


	}
}