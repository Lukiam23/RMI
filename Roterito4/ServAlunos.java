import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;
import java.util.Set;
import java.util.Iterator;
public class ServAlunos extends UnicastRemoteObject implements Interface_Remota
{
	public ServAlunos() throws RemoteException 
	{
		super();
	}

	Hashtable<String,Aluno> collection =  new Hashtable<String,Aluno>();

	@Override
	public void adicionaAluno(Aluno aluno) throws RemoteException 
	{
		collection.put(aluno.getNome(), aluno);
	}

	@Override
	public void removeAluno(Aluno aluno) throws RemoteException 
	{
		collection.remove(aluno);
	}

	@Override
	public void alteraAluno(String alunoNome,String nome, String matricula, Integer n1,Integer n2,Integer freq) throws RemoteException 
	{
		Aluno aluno = collection.get(alunoNome);
		if(nome!=null)
		{
			aluno.setNome(nome);
		}
		else if(matricula!=null)
		{
			aluno.setMatricula(matricula);
		}
		else if(n1!=null)
		{
			aluno.setNota1(n1);
		}
		else if(n2!=null)
		{
			aluno.setNota1(n2);
		}
		else if(freq!=null)
		{
			aluno.setFrequencia(freq);
		}
	}

	@Override
	public String listarAluno() throws RemoteException 
	{
		String lista = "";
		String str;
		Set<String> keys = collection.keySet();

		Iterator<String> itr = keys.iterator();

		while (itr.hasNext()) 
		{ 
			str = itr.next();
			Aluno aluno = collection.get(str);
			lista += "\nNome: "+str+" Matricula: "+aluno.getMatricula()+" Nota1: "+aluno.getNota1()+" Nota2: "+aluno.getNota2()+" Frequencia: "+aluno.getFrequencia();
		} 
		return lista;
	}
	public String consultaAluno(String matricula)
	{
		Set<String> keys = collection.keySet();
		String str,resposta = null;
		Iterator<String> itr = keys.iterator();

		while (itr.hasNext()) 
		{ 
			str = itr.next();
			Aluno aluno = collection.get(str);
			if(aluno.getMatricula()==matricula)
			{
				resposta = aluno.toString();
			}
		} 
		return resposta;
	}
	public static void main(String args[]) throws MalformedURLException
	{
		ServAlunos obj;
		try {
			obj = new ServAlunos();
			Naming.rebind("//localhost/Roteiro4", obj);
		} catch (RemoteException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
