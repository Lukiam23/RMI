import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Interface_Remota extends Remote
{
	public void adicionaAluno(Aluno aluno) throws RemoteException;
	public void removeAluno(Aluno aluno) throws RemoteException;
	public void alteraAluno(String alunoNome,String nome, String matricula, Integer n1,Integer n2,Integer freq) throws RemoteException;
	public String listarAluno() throws RemoteException;
	public String consultaAluno(String matricula) throws RemoteException;
}
