import java.util.ArrayList;

// Clase Grafo que contiene las variables de instancia nodes y edges
public class Grafo 
{
	 private Nodes nodes; 
	 private Edges edges; 

	public void generate()
	{
		nodes = new Nodes();
		edges = new Edges(); 
	}
	
	public Edges getEdges()
	{
		return edges; 
	}
	
	public Nodes getNodes()
	{
		return nodes; 
	}
	
	public void printNodes()
	{
		int l = 0; 
		Vertice node; 
		if(nodes != null)
		{
			if(!nodes.empty())
			{
				l = nodes.size(); 
				node = nodes.getFirstNode(); 
				for(int i = 0;i < l; i++)
				{
					System.out.printf("%d ",node.getNumber());
					node = node.getNextNode(); 
				}
				System.out.println();
			}
			else
			{
				System.out.print("No hay nodos\n");
			}
		}
		else
		{
			System.out.printf("El grafo no se ha generado\n"); 
		}
	}
	
	public void printEdges()
	{
		int l = 0; 
		Arista edge;
		int [] v; 
		if(edges != null)
		{
			if(!edges.empty())
			{
				l = edges.size(); 
				edge = edges.getFirstEdge(); 
				for(int i = 0;i < l; i++)
				{
					v = edge.getVertice(); 
					System.out.printf("(%d,%d)\t",v[0],v[1]);
					edge = edge.getNextEdge(); 
				}
				System.out.println();
			}
			else
			{
				System.out.print("No hay aristas\n");
			}
		}
		else
		{
			System.out.printf("El grafo no se ha generado"); 
		}
	}

	public void printConnections(Integer n)
	{
		ArrayList<Integer> connections;
		Vertice node; 
		if(nodes!=null)
		{
			if(!nodes.empty())
			{
				node = nodes.getElement(n); 
				if(node != null)
				{
					connections = node.getConnetions(); 
					for(int c : connections)
						System.out.printf("%d",c); 
				}
			}
			else
			{
				System.out.printf("No existen conexiones\n"); 
			}
		}
		
		else
		{
			System.out.printf("No se ha generado el grafo"); 
		}
	}



}
