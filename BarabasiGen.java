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
		//Lista de nodos que se encuentran conectados en el grafo, mientras mas conexiones mas ocurrencias en la lista
		connectedNodes = new ArrayList<Integer>(); 
	 
		//Generación de d nodos iniciales 
		for(int i=0; i < d; i++) 
		{
			nodes.addElement(i+1);			
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
		
		//Obtención del numero del nodo d (el ultimo hasta ahora)
		currentNode=nodes.getLastNode(); 
		number = currentNode.getNumber();   	 
		
		//Generación de lo n-d nodos restantes 
		for(int i = 0 ; i < n-d;i++)
		{
			nodes.addElement(number +1);
			currentNode = nodes.getLastNode(); //Obtiene la direccion del nuevo nodo agregado 
			number = currentNode.getNumber();  //Obtiene su numero asignado
			total = connectedNodes.size();	   //Obtiene el tamaño actual de la lista de nodos conectados
			
			//Seccion que crea d conexiones con el nuevo nodo, según la probabilidad de los nodos existentes
			for(int j = 0; j < d;j++)
			{
				if(j==0)
				{
					index = r1.nextInt(total);	//Obtiene un indice aleatorio del total de nodos que haya conectados
					n1 = connectedNodes.get(index); //Obtiene el numero del nodo
					edges.addElement(number, n1);  //Crea la arista
					currentNode.addConnetion(n1);  //Agrega el nodo n1 a la lista de conexiones del nodo nuevo
					node = nodes.findElement(n1); //Busca el nodo n1
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
					currentNode.addConnetion(n1);
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
