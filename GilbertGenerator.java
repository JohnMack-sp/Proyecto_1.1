import java.security.SecureRandom;


public class GilbertGenerator 
{
	private Grafo miGrafo; 

	public Grafo generate(Integer n,double p)	
	{
		Nodes nodes; 
		Edges edges; 
		miGrafo = new Grafo(); 
		miGrafo.generate();		
		nodes = miGrafo.getNodes(); 
		edges = miGrafo.getEdges(); 
		SecureRandom r = new SecureRandom(); 
		Vertice currentNode,v;
		
		double rand = 0;
		int n1=0,n2=0; 
		
		//Generación de nodos
		for(int i=0;i<n;i++)
		{
			nodes.addElement();
		}
		
		//Generacion de aristas		
		
		currentNode = nodes.getFirstNode(); 
			
		while(currentNode != null)
		{
			n1 = currentNode.getNumber(); 
			v = currentNode.getNextNode(); 
			
			while(v !=null)
			{
				n2 = v.getNumber(); 
				rand = r.nextDouble(); 
				
				if(rand<p)
				{
					edges.addElement(n1, n2);						
					currentNode.addConnetion(n2);
					v.addConnetion(n1);						
				}
				
				v = v.getNextNode(); 					
			}
			currentNode = currentNode.getNextNode(); 
		}

		return miGrafo;
	}

}
