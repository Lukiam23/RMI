import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Methods extends Remote
{
	void AdicionarAluno(String nome,int codigo,String n1,String n2,String n3,String freq)throws RemoteException;
	String RemoverAluno(int codigo) throws RemoteException;
	Aluno ConsultarAluno(int codigo) throws RemoteException;
	String Info() throws RemoteException;
}
