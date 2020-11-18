import java.security.SecureRandom;
import java.util.ArrayList;

public class BarabasiGen 
{
	Grafo miGrafo; 
	public Grafo generate(int n,int d)
	{
		Nodes nodes; 
		Edges edges; 
		miGrafo = new Grafo(); 
		miGrafo.generate();		
		nodes = miGrafo.getNodes(); 
		edges = miGrafo.getEdges(); 
		int total= 0,number,n1,index=0;
		Vertice currentNode,node; 
		ArrayList<Integer> connections,connectedNodes; 
		SecureRandom r1 = new SecureRandom();
		connectedNodes = new ArrayList<Integer>(); 
		//Generación de d nodos iniciales 
		for(int i=0; i < d; i++) 
		{
			nodes.addElement();			
		}
		
		//Generacion de las primeras aristas
		currentNode = nodes.getFirstNode(); 
		while(currentNode != null)
		{
			connections = currentNode.getConnetions(); 
			if(connections.isEmpty())
			{
				number = currentNode.getNumber(); 
				do
				{
					n1=r1.nextInt(d)+1; 
				}while(number == n1); 
				
				edges.addElement(number,n1);
				node=nodes.findElement(number); 
				node.addConnetion(n1);
				node = nodes.findElement(n1); 
				node.addConnetion(number);
				connectedNodes.add(number); 
				connectedNodes.add(n1); 
			}
			
			currentNode = currentNode.getNextNode(); 
		}
		
		//Generación de lo n-d nodos restantes 
		for(int i = 0 ; i < n-d;i++)
		{
			nodes.addElement();
			currentNode = nodes.getLastNode(); 
			number = currentNode.getNumber(); 
			total = connectedNodes.size(); 
			
			for(int j = 0; j < d;j++)
			{
				if(j==0)
				{
					index = r1.nextInt(total);
					n1 = connectedNodes.get(index);
					edges.addElement(number, n1);
					node=nodes.findElement(number); 
					node.addConnetion(n1);
					node = nodes.findElement(n1); 
					node.addConnetion(number);
					connectedNodes.add(number); 
					connectedNodes.add(n1); 
					
				}
				else
				{
					connections = currentNode.getConnetions(); 
					do
					{
						index = r1.nextInt(total);
						n1 = connectedNodes.get(index);						
					}while(connections.contains(n1)); 
					
					edges.addElement(number, n1);
					node=nodes.findElement(number); 
					node.addConnetion(n1);
					node = nodes.findElement(n1); 
					node.addConnetion(number);
					connectedNodes.add(number); 
					connectedNodes.add(n1); 
				}
				
			}
		}
		
		return miGrafo; 
	}
	
}
