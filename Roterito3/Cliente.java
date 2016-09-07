import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.*;
public class Cliente implements Serializable
{
	public String nome;
	public int nsala;
	public static int id=1;
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
			ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();
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
							Mensagem mens = obj.getMensagem();
							if(mens.getId()>id && mens.getNsala()==cliente.nsala)
							{
								System.out.println(mens.getMsg());
								id=mens.getId();
							}
							Thread.sleep(10);
						}
						catch(Exception e)
						{
							System.out.println("Erro na thread cheking: "+e);
							e.printStackTrace();
						}
					}
				}
			};
			Thread sending = new Thread()
			{
				public void run()
				{
					while(true)
					{
						try
						{
							System.out.println(cliente.getNome()+" : ");
							Scanner scan = new Scanner(System.in);
							String msg = scan.nextLine();
							obj.encaminhaMensagem(cliente.nsala, msg, cliente);
							Thread.sleep(10);
						}
						catch(Exception e)
						{
							System.out.println("Erro na thread cheking: "+e);
							e.printStackTrace();
						}
					}
				}
			};



			System.out.println("Escolha:\n1.Você gostaria de criar uma sala.\n2.Entrar em uma já existente.");
			Scanner catchchoice = new Scanner(System.in);
			int choice = catchchoice.nextInt();	
			if(choice==1)
			{
				Sala sala = obj.criarSala();
				cliente.nsala = sala.getId();
				obj.adicionar(cliente.nsala, cliente);
				System.out.println("O número da sua sala e: "+sala.getId());
			}
			else if(choice==2)
			{
				System.out.println("Digite o número da sala: ");
				Scanner catchchoice2 = new Scanner(System.in);
				cliente.nsala = catchchoice2.nextInt();
				obj.adicionar(nsala, cliente);
			}
			else
			{
				System.out.println("Não há essa escolha");
			}
			checking.start();
			sending.start();
			
		} catch (Exception e) {

			System.out.println("Erro no Cliente: " + e.getMessage());

			e.printStackTrace();

		}


	}



}
