import java.security.SecureRandom;
public class GeoGenerator 
{
	private Grafo miGrafo;
	public Grafo generate(int n,double r)
	{
		Nodes nodes; 
		Edges edges; 
		miGrafo = new Grafo(); 
		miGrafo.generate();		
		nodes = miGrafo.getNodes(); 
		edges = miGrafo.getEdges(); 
		SecureRandom r1 = new SecureRandom();
		float x=0,y=0;
		double d=0; 
		float []px = new float[n];
		float []py = new float[n]; 
		boolean exist = true; 
		Vertice v; 
		//Generación de nodos
		for(int i=0;i<n;i++)
		{
			nodes.addElement();
			x = r1.nextFloat();
			y = r1.nextFloat(); 
			if(i == 0)
			{
				px[i] = x; 
				py[i] = y; 
			}

			else
			{
				//Rutina para verificar si existen posiciones repetidas 

				while(exist == true)
				{
					for(int j = 0; j< i; j++)
					{
						if(px[j] == x && py[j] == y)
						{
							x = r1.nextFloat();
							y = r1.nextFloat(); 
							exist = true; 
							break; 
						}
						else
						{
							exist = false; 
						}
					}

					if(exist == true)
					{
						x = r1.nextFloat();
						y = r1.nextFloat(); 
					}

				}
				
				px[i] = x; 
				py[i] = y; 		

			}
			
			//System.out.printf("nodo %d posicion=(%f,%f)\n",i+1,x,y); 

		}

		//Generación de aristas

		for(int i = 0; i< n; i ++) 
		{
			for(int j =i+1; j < n; j++)
			{
				  
				 d = Math.pow((px[j]-px[i]), 2); 
				 d += Math.pow((py[j]-py[i]), 2); 
				 d = Math.sqrt(d); 
				 //System.out.printf("d nodo %d y nodo %d = %f \n",i+1,j+1,d); 
				 
				 if(d <= r)
				 {
					 edges.addElement(i+1,j+1);
					 v = nodes.findElement(i+1); 
					 v.addConnetion(j+1);
				 }
			
			}
		}

		return miGrafo; 
	}
}
