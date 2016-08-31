import java.util.ArrayList;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class Servidor extends UnicastRemoteObject implements Methods{

	
	public Servidor() throws RemoteException {
		super();
	}
	ArrayList <Sala> salas = new ArrayList<Sala>();
	public void criarSala() throws RemoteException 
	{
		Sala sala = new Sala(salas.size());		
	}
	public void removerSala(int sala) throws RemoteException 
	{
		salas.remove(sala);
	}
	public String listarSalas() throws RemoteException {
		
		return null;
	}
	public void adicionar() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	public void remover() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listar() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void encaminhaMensagem() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
