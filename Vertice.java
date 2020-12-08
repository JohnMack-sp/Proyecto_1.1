import java.util.ArrayList;

//Clase vertice  que tiene dos variables de intancia (atributos), numero y connections
//La variables numero indica en n�mero de nodo y la variable connections sus conexiones
public class Vertice 
{
	private int number;			// El numero del nodo
	private Vertice nextNode;   //Conexion al siguiente nodo
	private Vertice lastNode;	//Conexion al ancestro
	private ArrayList<Integer> connections = new ArrayList<Integer>(); 
	
	public void addConnetion(Integer node)
	{
		connections.add(node); 
	}
	
	public void putNumber(Integer number)
	{
		this.number = number;  
	}
	public void addNextNode(Vertice nextNode)
	{
		this.nextNode = nextNode;  
	}
	
	public void addLastNode(Vertice lastNode)
	{
		this.lastNode = lastNode;  
	}
	
		
	public Integer getNumber()
	{
		return number; 
	}
	public Vertice getNextNode()
	{
		return nextNode; 
	}
	public Vertice getLastNode()
	{
		return lastNode; 
	}
	
	public  ArrayList<Integer> getConnetions()
	{
		return connections;
	}
}
