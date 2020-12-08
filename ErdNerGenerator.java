import java.security.SecureRandom;


public class ErdNerGenerator 
{
	private Grafo miGrafo; 	

	public Grafo generate(Integer n, Integer m)
	{
		Nodes nodes; 
		Edges edges; 
		miGrafo = new Grafo(); 
		miGrafo.generate();		
		nodes = miGrafo.getNodes(); 
		edges = miGrafo.getEdges(); 
		SecureRandom r = new SecureRandom(); 
		Arista e = null; 
		Vertice v; 
		int n1,n2; 
		//Generación de nodos
		for(int i=0;i<n;i++)
		{
			nodes.addElement(i+1);
		}
		//Generación de aristas

		int num_max = (n*(n-1))/2; 

		if(m> num_max)
			m=num_max; 

		for(int i=0; i<m ; i++)
		{

			do
			{
				n1 = r.nextInt(n) +1; 
				n2 = r.nextInt(n) +1; 
				
				if(!edges.empty())
					e = edges.findEdge(n1,n2); 
			}while(n1 == n2 || e!=null); 

			edges.addElement(n1, n2);
			v = nodes.findElement(n1); 
			v.addConnetion(n2);
			v = nodes.findElement(n2); 
			v.addConnetion(n1);

		}



		return miGrafo; 
	}

}
