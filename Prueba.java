
public class Prueba {

	public static void main(String[] args) 
	{
		 ErdNerGenerator g1 = new ErdNerGenerator(); 
		 GilbertGenerator g2 = new GilbertGenerator();
		 GeoGenerator g3 = new GeoGenerator(); 
		 BarabasiGen g4 = new BarabasiGen();
		 PruebaEscritura pes = new PruebaEscritura(); 
		 Vertice s; 
		 Grafo grafo1,grafo2,grafo3,grafo4,g1BFS,g1DFS,g1DFSr; 
		 Grafo g2BFS,g2DFS,g2DFSr,g3BFS,g3DFS,g3DFSr,g4BFS,g4DFS,g4DFSr; 
		 int n = 30; 
		 grafo1 = g1.generate(n,100); 		 
		 //grafo1.printNodes();
		 //grafo1.printEdges();		 
		
		 grafo2 = g2.generate(n,0.2);		 
		 //grafo2.printNodes();
		 //grafo2.printEdges();
		 
		 grafo3 = g3.generate(n,0.2);
		 //grafo3.printNodes();
		 //grafo3.printEdges();
		 
		 grafo4 = g4.generate(n,2);
		 //grafo4.printNodes();
		 //grafo4.printEdges();
		 
		 s=grafo1.getNodes().getFirstNode(); 			 
		 g1BFS = grafo1.BFS(s);		 
		 g1DFS = grafo1.DFS(s);	
		 g1DFSr = grafo1.DFSr(s); 
		 
		 s=grafo2.getNodes().getFirstNode(); 			 
		 g2BFS = grafo2.BFS(s);		 
		 g2DFS = grafo2.DFS(s);	
		 g2DFSr = grafo2.DFSr(s); 
		
		 
		 s=grafo3.getNodes().getFirstNode(); 			 
		 g3BFS = grafo3.BFS(s);		 
		 g3DFS = grafo3.DFS(s);	
		 g3DFSr = grafo3.DFSr(s); 
		 
		 s=grafo4.getNodes().getFirstNode(); 			 
		 g4BFS = grafo4.BFS(s);		 
		 g4DFS = grafo4.DFS(s);	
		 g4DFSr = grafo4.DFSr(s); 
		
		 pes.generate("grafo1_30bfs.dot",g1BFS.getNodes()); 
		 pes.generate("grafo1_30dfs.dot",g1DFS.getNodes()); 
		 pes.generate("grafo1_30dfsr.dot",g1DFSr.getNodes()); 
		 
		 pes.generate("grafo2_30.dot",grafo2.getNodes());
		 pes.generate("grafo2_30bfs.dot",g2BFS.getNodes()); 
		 pes.generate("grafo2_30dfs.dot",g2DFS.getNodes()); 
		 pes.generate("grafo2_30dfsr.dot",g2DFSr.getNodes()); 
		 
		 pes.generate("grafo3_30.dot",grafo3.getNodes());
		 pes.generate("grafo3_30bfs.dot",g3BFS.getNodes()); 
		 pes.generate("grafo3_30dfs.dot",g3DFS.getNodes()); 
		 pes.generate("grafo3_30dfsr.dot",g3DFSr.getNodes()); 
		 
		 pes.generate("grafo4_30.dot",grafo4.getNodes());
		 pes.generate("grafo4_30bfs.dot",g4BFS.getNodes()); 
		 pes.generate("grafo4_30dfs.dot",g4DFS.getNodes()); 
		 pes.generate("grafo4_30dfsr.dot",g4DFSr.getNodes()); 
		 
		
	}

}
