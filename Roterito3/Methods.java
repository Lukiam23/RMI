import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Methods  extends Remote
{
	void criarSala()throws RemoteException;

	void removerSala(int sala)throws RemoteException;

	String listarSalas()throws RemoteException;

	void adicionar()throws RemoteException;

	void remover()throws RemoteException;

	String listar()throws RemoteException;

	void encaminhaMensagem ()throws RemoteException;
}
