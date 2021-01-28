
public class Prueba
{

	public static void main(String[] args) 
	{
		 ErdNerGenerator g1 = new ErdNerGenerator(); 
		 GilbertGenerator g2 = new GilbertGenerator();
		 GeoGenerator g3 = new GeoGenerator(); 
		 BarabasiGen g4 = new BarabasiGen();
		 PruebaEscritura pes = new PruebaEscritura(); 
		 Vertice s; 
		 Grafo grafo1,grafo2,grafo3,grafo4,g1MST,g2MST,g3MST,g4MST; 
		
		 int n = 10,maxW=10; 
		 grafo1 = g1.generate(n,10); 		 
		 grafo2 = g2.generate(n,0.5);			 
		 grafo3 = g3.generate(n,0.5);		 
		 grafo4 = g4.generate(n,2);
		
		 grafo1.randWeights(maxW); //Generación de pesos aleatorios
		 s = grafo1.getNodes().findElement(3);
		 g1MST=grafo1.Prim(s, maxW); 
		 
		
		 grafo2.randWeights(maxW); //Generación de pesos aleatorios
		 s = grafo2.getNodes().findElement(3); 
		 g2MST= grafo2.Prim(s,maxW); 
		 
		 grafo3.randWeights(maxW); //Generación de pesos aleatorios
		 s = grafo3.getNodes().findElement(3); 
		 g3MST= grafo3.Prim(s,maxW); 
		 
		 grafo4.randWeights(maxW); //Generación de pesos aleatorios
		 s = grafo4.getNodes().findElement(3); 
		 g4MST= grafo4.Prim(s,maxW); 
		
		 
		 pes.generate("grafo1_10_prim.dot",grafo1.getNodes()); 
		 pes.generate("G1mst_10_prim.dot", g1MST.getNodes());
		 
		 pes.generate("grafo2_10_prim.dot",grafo2.getNodes()); 
		 pes.generate("G2mst_10.dot", g2MST.getNodes());
		 
		 pes.generate("grafo3_10_prim.dot",grafo3.getNodes()); 
		 pes.generate("G3mst_10_prim.dot", g3MST.getNodes());
		
		 pes.generate("grafo4_10_prim.dot",grafo4.getNodes()); 
		 pes.generate("G4mst_10_prim.dot", g4MST.getNodes());
		
	}

}
