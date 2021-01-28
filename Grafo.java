import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
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
					v = edge.getArista(); 
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






	public Grafo BFS(Vertice s)
	{

		int number = 0, n=0; 
		ArrayList<Integer> addedNodes,connections; 
		addedNodes = new ArrayList<Integer>(); 
		Nodes nodes; 
		Edges edges; 

		//Creacion del grafo BFS
		Grafo Gbfs = new Grafo(); 
		Gbfs.generate();
		nodes = Gbfs.getNodes(); 
		edges = Gbfs.getEdges(); 

		//Variable auxiliar para el recorrido
		Vertice currentNode,v;

		//Se agrega el nodo del primer nivel
		number = s.getNumber(); 
		nodes.addElement(number); //Crea un nuevo nodo en el arbol 
		addedNodes.add(number);  // Añade el nombre de nodo a la lista de nodos agregados	


		currentNode = nodes.getFirstNode();   //empiezo en el nodo fuente 

		while(currentNode!= null)
		{
			//Nodo a examinar actual
			n = currentNode.getNumber();
			//busqueda del nodo en el grafo original
			v = this.nodes.findElement(n); 			
			connections = v.getConnetions(); 

			for(int i=0; i<connections.size();i++)
			{
				number = connections.get(i); 
				//Verifica que el nodo no este agregado al arbol
				if(!addedNodes.contains(number))
				{
					nodes.addElement(number); //Agrego el nodo al arbol 
					edges.addElement(n,number);// Agrego una arista con el nodo correspondiente al nivel anterior
					addedNodes.add(number);    //Lo agrego a la lista de nodos añadidos
					currentNode.addConnetion(number); //Actualizo la lista del nodo de la capa anterior
					nodes.getLastNode().addConnetion(n); // Actualizo la lista de conexiones del nodo recien añadido
				}
			}

			currentNode = currentNode.getNextNode(); 
		}


		return Gbfs; 
	}

	public Grafo DFS(Vertice s)
	{

		int number = 0, n=0;
		boolean camino = false; 
		ArrayList<Integer> addedNodes,connections; 
		addedNodes = new ArrayList<Integer>(); 
		Nodes nodes; 
		Edges edges; 
		Vertice currentNode,v; 

		//Creacion del grafo DFS
		Grafo Gdfs = new Grafo(); 
		Gdfs.generate();
		nodes = Gdfs.getNodes(); 
		edges = Gdfs.getEdges();

		//Añadiendo el primer nodo
		number = s.getNumber(); 
		nodes.addElement(number);
		addedNodes.add(number);  //Lista de nodos añadidos al arbol 
		currentNode = nodes.getFirstNode();

		//Mientras exista un camino segira creando el arbol hacia adelante
		while(currentNode !=null)
		{
			//Nodo a examinar
			n = currentNode.getNumber(); 
			//Busca el nodo en el grafo original
			v = this.nodes.findElement(n);
			//Obtengo las conexiones
			connections = v.getConnetions(); 
			camino = false;
			for(int i = 0; i < connections.size(); i++)
			{
				number = connections.get(i); 
				if(!addedNodes.contains(number))
				{
					nodes.addElement(number); //Agrego el nodo al arbol 
					edges.addElement(n,number);// Agrego una arista con el nodo correspondiente al nivel anterior
					addedNodes.add(number);    //Lo agrego a la lista de nodos añadidos
					currentNode.addConnetion(number); //Actualizo la lista del nodo de la capa anterior
					nodes.getLastNode().addConnetion(n); // Actualizo la lista de conexiones del nodo recien añadido
					camino = true; 
					break; 
				}
			}


			if(camino)			
				currentNode = nodes.getLastNode(); 		
			else
				currentNode = currentNode.getLastNode(); 

		}

		return Gdfs;
	}

	public Grafo DFSr(Vertice s)
	{

		//Creacion del grafo DFS
		Grafo Gdfs = new Grafo(); 
		Gdfs.generate();

		addNodeDFS(s,Gdfs); 
		return Gdfs;

	}

	private void addNodeDFS(Vertice s,Grafo g)
	{
		int n,n2; 
		ArrayList<Integer> connections; 
		Vertice v,v1; 

		n = s.getNumber(); 
		connections = s.getConnetions(); 
		g.nodes.addElement(n);

		for(int i=0;i<connections.size();i++)
		{
			n2 = connections.get(i); 
			if(g.nodes.findElement(n2) == null)
			{
				g.edges.addElement(n,n2);
				v1 = g.nodes.findElement(n); 
				v1.addConnetion(n2);
				v= this.nodes.findElement(n2); //Busco en el grafo original 				
				addNodeDFS(v,g); 
			}
		}

	}

	public void randWeights(int maxValue)
	{
		//Creación de un objeto tipo arista
		Arista edge = null; 
		SecureRandom r = new SecureRandom(); 
		int w; 
		if(edges==null)
		{
			System.out.printf("El grafo no contiene aristas"); 
		}
		else 
		{
			edge = edges.getFirstEdge(); 
			while(edge!=null)
			{
				w = 1+r.nextInt(maxValue);
				edge.addWeight(w);
				edge=edge.getNextEdge(); 
			}
		}

	}

	public void printWeights()
	{
		int l = 0; 
		Arista edge;
		int [] v; 
		float w=0; 
		if(edges != null)
		{
			if(!edges.empty())
			{
				l = edges.size(); 
				edge = edges.getFirstEdge(); 
				for(int i = 0;i < l; i++)
				{
					v = edge.getArista(); 
					w = edge.getWeight(); 
					System.out.printf("(%d,%d) w=%f\t",v[0],v[1],w);
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

	public Grafo Dijkstra(Vertice s,int maxValue)
	{
		//Creacion del grafo a entregar
		Grafo Gmst = new Grafo(); 
		Gmst.generate(); 
		ArrayList<Integer> S = new ArrayList<Integer>();
		ArrayList<Integer> addedNodes = new ArrayList<Integer>(); 
		ArrayList<Integer> connections; 
		Queue<Vertice> q = new PriorityQueue<Vertice>();
		Vertice currentNode,v,up,vp;
		Arista e; 
		int w,du,dv,le,inf,n,node;

		currentNode = nodes.getFirstNode();
		inf = maxValue*edges.size(); 

		while(currentNode!=null)
		{
			currentNode.addPriority(inf+1);
			q.add(currentNode); 
			currentNode = currentNode.getNextNode(); 
		}

		s.addPriority(0); // Fija la prioridad del nodo fuente a cero 		
		q.remove(s);	 //Lo remuevo de la cola 
		q.add(s); 		//Actualizo su valor
		S.clear(); 		//Inicializo al conjunto cero con el conjunto vacio

		while (!q.isEmpty()) 
		{
			System.out.printf("last node=%d\n",nodes.getLastNode().getPriority()); 
			currentNode = q.remove(); //Retiro el primer elemento de la cola
			System.out.printf("Nodo=%d p=%d\n",currentNode.getNumber(),currentNode.getPriority()); 
			S.add(currentNode.getNumber()); //Agrego el nodo al conjunto S
			Gmst.nodes.addElement(currentNode.getNumber()); //Agrego nodo al nuevo grafo
			Gmst.nodes.getLastNode().addPriority(currentNode.getPriority());
			connections = currentNode.getConnetions(); 
			System.out.printf("last node=%d\n",nodes.getLastNode().getPriority()); 
			for(int c : connections)
			{
				if(!S.contains(c))
				{
					v = nodes.findElement(c); 
					e = edges.findEdge(currentNode.getNumber(), v.getNumber()); 
					w = e.getWeight();
					dv=v.getPriority();
					du=currentNode.getPriority(); 
					le=w+du; 	        
					System.out.printf("Nodo encontrado=%d\n",v.getNumber()); 
					if(dv>le)
					{
						System.out.printf("n=%d dv=%d -> dv=%d\n",v.getNumber(),dv,le); 
						v.addPriority(le);	            			
						q.remove(v); //Elimino al nodo de la lista para poder actualizar su valor
						q.add(v);	//Actualizo el valor 

					}
				}


			}            

		}


		n = S.get(0);	//Tomo el primer nodo de la lista 
		S.remove(0); 	//Lo elimino 
		addedNodes.add(n); 

		while(!S.isEmpty())
		{
			n = S.get(0);	//Tomo el primer nodo de la lista 
			S.remove(0); 	//Lo elimino 
			addedNodes.add(n); 
			currentNode = nodes.findElement(n); 
			connections = currentNode.getConnetions(); 
			w=inf; 
			node =0; 
			for(int element : addedNodes)
			{
				if(connections.contains(element))
				{
					v = nodes.findElement(element); 
					le = currentNode.getPriority()-v.getPriority(); //Obtengo la longitud del camino
					e = edges.findEdge(element,n);  //Obtengo el valor del camino
					w = e.getWeight(); 
					if(le==w)
					{
						node = element; 
						break; 
					}

				}
			}

			Gmst.edges.addElement(node,n);			
			Gmst.edges.getLastEdge().addWeight(w);
			vp = Gmst.nodes.findElement(n); 
			//up = Gmst.nodes.findElement(node); 
			vp.addConnetion(node);
			//up.addConnetion(n);
		}
		return Gmst; 
	}


	public Grafo Kruskal()
	{
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>(); 
		ArrayList<Integer> V,A,B; 
		Arista e;  
		Vertice currentNode,u,v; 
		e=edges.getFirstEdge(); 
		int [] a; 
		int n,i1=0,i2=0; 

		//Creacion del grafo a entregar
		Grafo Gmst = new Grafo(); 
		Gmst.generate(); 

		while(e!=null)
		{
			aristas.add(e); 
			e = e.getNextEdge();
		}

		Collections.sort(aristas);
		currentNode = nodes.getFirstNode(); 
		while(currentNode!=null)
		{
			n = currentNode.getNumber(); 
			Gmst.nodes.addElement(n);
			V = new ArrayList<Integer>(); 
			V.add(n); 
			sets.add(V); 
			currentNode = currentNode.getNextNode(); 
		}

		for(Arista ed : aristas)
		{
			a=ed.getArista();
			i1 = findSet(sets,a[0]); 
			i2 = findSet(sets,a[1]);
			if(i1!=i2)
			{
				u=Gmst.nodes.findElement(a[0]); 
				v=Gmst.nodes.findElement(a[1]);			
				Gmst.edges.addElement(a[0],a[1]);
				u.addConnetion(a[1]);
				v.addConnetion(a[0]);
				A = sets.get(i1); 
				B = sets.get(i2); 
				A.addAll(B); 
				sets.remove(B);  
			}
		}

		return Gmst; 
	}

	private int findSet (ArrayList<ArrayList<Integer>> sets,int nodo) 
	{
		int index=0; 
		for(ArrayList<Integer> set: sets)
		{
			if(set.contains(nodo))
			{
				index = sets.indexOf(set); 
				break; 
			}
		}
		return index; 
	}

	public Grafo Kruskali()
	{
		/*Genero el arbol a entregar*/
		Grafo Gmst = new Grafo(); 
		Gmst.generate();

		int l=0,n,i1,i2,n1,n2;
		Vertice v;
		Vertice u; 
		ArrayList<Integer>c1,c2; 
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		ArrayList<Arista> aristas2 = new ArrayList<Arista>();
		Arista e;
		Vertice currentNode; 
		int [] a; 
		Grafo G1,G2; 
		/*Copio todos los nodos al nuevo grafo*/
		currentNode = nodes.getFirstNode(); 
		while(currentNode!=null)
		{
			n = currentNode.getNumber(); 
			Gmst.nodes.addElement(n);
			currentNode = currentNode.getNextNode(); 
		}

		/*Copio las aristas*/
		e=edges.getFirstEdge(); 
		while(e!=null)
		{
			aristas.add(e); 
			a = e.getArista(); 
			u=Gmst.nodes.findElement(a[0]); 
			v=Gmst.nodes.findElement(a[1]);
			u.addConnetion(a[1]);
			v.addConnetion(a[0]);
			e = e.getNextEdge();
		}
		Collections.sort(aristas);
		l=aristas.size();
		for(int i=l-1;i>=0;i--)
		{
			e = aristas.get(i);
			a = e.getArista(); 
			u = Gmst.nodes.findElement(a[0]);
			v = Gmst.nodes.findElement(a[1]);
			c1 = u.getConnetions(); 
			c2 = v.getConnetions(); 

			i1 = c1.indexOf(a[1]); 
			i2 = c2.indexOf(a[0]); 
			c1.remove(i1); /*Elimino la arista del grafo original*/ 
			c2.remove(i2);

			G1=Gmst.BFS(u); 
			G2=Gmst.BFS(v); 
			n1=G1.nodes.size(); 
			n2=G2.nodes.size(); 
			n= nodes.size(); 
			System.out.printf("n=%d n1=%d n2=%d \n",n,n1,n2); 
			if(n1!=n || n2!=n)
			{
				c1.add(a[1]); 	//Regreso la arista 
				c2.add(a[0]);
				aristas2.add(e); //Añado a la lista de aristas que no puedo eliminar 		

			}


		}

		for(Arista ed: aristas2)
		{
			a = ed.getArista(); 
			Gmst.edges.addElement(a[0],a[1]);
			Gmst.edges.getLastEdge().addWeight(ed.getWeight());

		}
		return Gmst; 

	}

	public Grafo Prim(Vertice s,int maxValue)
	{
		/*Genero el arbol a entregar*/
		Grafo Gmst = new Grafo(); 
		Gmst.generate();

		int inf=0,u,w=0; 
		Vertice currentNode,v,up,vp; 
		Arista edge; 
		ArrayList<Integer> connections; 
		Queue<Vertice> q = new PriorityQueue<Vertice>();
		currentNode = nodes.getFirstNode();
		inf = maxValue*edges.size(); 

		while(currentNode!=null)
		{
			currentNode.addPriority(inf+1);
			currentNode.addFather(null);
			q.add(currentNode);		
			currentNode = currentNode.getNextNode(); 
		}


		s.addPriority(0); // Fija la prioridad del nodo fuente a cero 		
		q.remove(s);	 //Lo remuevo de la cola 
		q.add(s); 		//Actualizo su valor

		while (!q.isEmpty()) 
		{
			currentNode = q.poll(); 
			u = currentNode.getNumber(); 
			connections = currentNode.getConnetions(); 
			for(int node: connections)
			{
				v = nodes.findElement(node);			
				edge = edges.findEdge(u,node); 
				w = edge.getWeight(); 
				if(q.contains(v) &&(v.getPriority()>w))
				{
					v.addFather(currentNode);
					v.addPriority(w);
					q.remove(v);
					q.add(v); 
				}
			}
			
		}
		
		currentNode = nodes.getFirstNode(); 
		while(currentNode!=null)
		{
			u = currentNode.getNumber(); 
			Gmst.nodes.addElement(u);
			up = Gmst.nodes.getLastNode(); 
			v = currentNode.getFather(); 
			if(v!=null)
			{
				vp = nodes.findElement(v.getNumber());
				if(vp == null)
				{
					Gmst.nodes.addElement(v.getNumber());
					vp = Gmst.nodes.getLastNode(); 
				}
				
				Gmst.edges.addElement(v.getNumber(),u);
				up.addConnetion(vp.getNumber());
				vp.addConnetion(up.getNumber());
			}
			
			currentNode = currentNode.getNextNode(); 
		}
		
		return Gmst; 

	}
	
	public void printTotalWeights()
	{
		int suma; 
		Arista e; 
		
		e = edges.getFirstEdge(); 
		suma = 0; 
		while(e!=null)
		{
			suma+= e.getWeight(); 
		}
		
		System.out.printf("Wtotal=%d",suma); 
	}

}