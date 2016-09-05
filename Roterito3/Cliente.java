import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.*;
public class Cliente implements Serializable
{
	public String nome;
	public String mensagem="";
	public Cliente()
	{
		super();
	}
	public String getNome()
	{
		return this.nome;
	}
	public String toString()
	{
		return "\nNome: "+nome;
	}
	public void getMensagem(String msg)
	{
		mensagem = msg;
	}
	
	public static void main (String args[]) 
	{
		try 
		{
			int nsala = 0;
			Methods obj = (Methods) Naming.lookup("//localhost/Chat");
			System.out.print("Coloque o nome: ");
			Scanner catchname = new Scanner(System.in);
			String nome = catchname.nextLine();
			
			
			
			Cliente cliente = new Cliente();
			cliente.nome = nome;
			
			Thread checking = new Thread()
			{
				public void run()
				{
					while(true)
					{
						
						try 
						{
							if(obj.getMensagem()!=null)
							{
								System.out.println(obj.getMensagem());
							}
							Thread.sleep(10);
						} 
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}		
					
				}
			};
			
			Thread sender = new Thread()
			{
				public void run()
				{
					while(true)
					{
						System.out.println(cliente.nome+": ");
						Scanner catchmsg = new Scanner(System.in);
					
						String texto =catchmsg.nextLine();
						try {
							obj.encaminhaMensagem(0, texto,cliente.nome);
							Thread.sleep(10);
						} catch (RemoteException | InterruptedException e) {
							e.printStackTrace();
						}
					}					
				}
			};
			
			checking.start();
			sender.start();
			
			System.out.println("Escolha:\n1.Você gostaria de criar uma sala.\n2.Entrar em uma já existente.");
			Scanner catchchoice = new Scanner(System.in);
			int choice = catchchoice.nextInt();	
			if(choice==1)
			{
				Sala sala = obj.criarSala();
				obj.adicionar(0, cliente);
			}
			else if(choice==2)
			{
				System.out.println("Digite o número da sala: ");
				Scanner catchchoice2 = new Scanner(System.in);
				nsala = catchchoice2.nextInt();
				obj.adicionar(nsala, cliente);
			}

			else
			{
				System.out.println("Não há essa escolha");
			}
			


		} catch (Exception e) {

			System.out.println("Erro no Cliente: " + e.getMessage());

			e.printStackTrace();

		}


	}
	


}
