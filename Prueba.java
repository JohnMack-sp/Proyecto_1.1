
public class Prueba
{

	public static void main(String[] args) 
	{
		 ErdNerGenerator g1 = new ErdNerGenerator(); 
		 GilbertGenerator g2 = new GilbertGenerator();
		 GeoGenerator g3 = new GeoGenerator(); 
		 BarabasiGen g4 = new BarabasiGen();
		 Escritura pes = new Escritura(); 
		 Vertice s; 
		 Grafo grafo1,grafo2,grafo3,grafo4,g1MST,g2MST,g3MST,g4MST; 
		
		 int n = 30,maxW=10; 
		 grafo1 = g1.generate(n,30); 		 
		 grafo2 = g2.generate(n,0.5);		 
		 //grafo2.printNodes();
		 //grafo2.printEdges();
		 
		 grafo3 = g3.generate(n,0.5);
		 //grafo3.printNodes();
		 //grafo3.printEdges();
		 
		 grafo4 = g4.generate(n,2);
		 //grafo4.printNodes();
		 //grafo4.printEdges();
		 
		 grafo1.randWeights(maxW); //Generación de pesos aleatorios
		 s = grafo1.getNodes().findElement(3); 
		 g1MST= grafo1.Dijkstra(s,maxW); 
		 
		 grafo2.randWeights(maxW); //Generación de pesos aleatorios
		 s = grafo2.getNodes().findElement(3); 
		 g2MST= grafo2.Dijkstra(s,maxW); 
		 
		 grafo3.randWeights(maxW); //Generación de pesos aleatorios
		 s = grafo3.getNodes().findElement(3); 
		 g3MST= grafo3.Dijkstra(s,maxW); 
		 
		 grafo4.randWeights(maxW); //Generación de pesos aleatorios
		 s = grafo4.getNodes().findElement(3); 
		 g4MST= grafo4.Dijkstra(s,maxW); 
		
		 pes.generate("grafo1_30.dot",grafo1.getNodes()); 
		 pes.generate("G1mst_30.dot", g1MST.getNodes());
		 
		 pes.generate("grafo2_30.dot",grafo2.getNodes()); 
		 pes.generate("G2mst_30.dot", g2MST.getNodes());
		 
		 pes.generate("grafo3_30.dot",grafo3.getNodes()); 
		 pes.generate("G3mst_30.dot", g3MST.getNodes());
		 
		 pes.generate("grafo4_30.dot",grafo4.getNodes()); 
		 pes.generate("G4mst_30.dot", g4MST.getNodes());
		
	}

}
