import java.io.Serializable;
import java.rmi.Naming;
import java.util.*;
public class Aluno 
{
	private String matricula,nome;
	private Integer nota1,nota2,frequencia;
	public void setMatricula(String matricula)
	{
		this.matricula=matricula;
	}
	public void setNome(String nome)
	{
		this.nome=nome;
	}
	public void setNota1(int n1)
	{
		this.nota1=n1;
	}
	public void setNota2(int n2)
	{
		this.nota2=n2;
	}
	public void setFrequencia(int freq)
	{
		this.frequencia=freq;
	}
	public String getMatricula()
	{
		return this.matricula;
	}
	public String getNome()
	{
		return this.nome;
	}
	public Integer getNota1()
	{
		return this.nota1;
	}
	public Integer getNota2()
	{
		return this.nota2;
	}
	public Integer getFrequencia()
	{
		return this.frequencia;
	}
	public String toString()
	{
		return "\nNome: "+this.getNome()+" Matricula: "+this.getMatricula()+" Nota1: "+this.getNota1()+" Nota2: "+this.getNota2()+" Frequencia: "+this.getFrequencia();
	}
}
