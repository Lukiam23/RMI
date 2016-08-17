import java.rmi.Naming;

import java.rmi.RemoteException;

public class Cliente {

	public static void main (String args[]) {

		try {


			Hello obj = (Hello) Naming.lookup("//localhost/HelloServer");

			String message = obj.sayHello();

			System.out.println(message);

		} catch (Exception e) {

			System.out.println("HelloApplet exception: " + e.getMessage());

			e.printStackTrace();

		}


	}
}