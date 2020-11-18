import java.util.ArrayList;

//Clase vertice  que tiene dos variables de intancia (atributos), numero y connections
//La variables numero indica en número de nodo y la variable connections sus conexiones
public class Vertice 
{
	private int number;			// El numero del nodo
	private Vertice nextNode; 
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
	
		
	public Integer getNumber()
	{
		return number; 
	}
	public Vertice getNextNode()
	{
		return nextNode; 
	}
	public  ArrayList<Integer> getConnetions()
	{
		return connections;
	}
}
