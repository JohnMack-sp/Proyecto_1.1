
public class Prueba {

	public static void main(String[] args) 
	{
		 ErdNerGenerator g1 = new ErdNerGenerator(); 
		 GilbertGenerator g2 = new GilbertGenerator();
		 GeoGenerator g3 = new GeoGenerator(); 
		 BarabasiGen g4 = new BarabasiGen();
		 PruebaEscritura pes = new PruebaEscritura(); 
		 
		 Grafo grafo1,grafo2,grafo3,grafo4; 
		
		 grafo1 = g1.generate(500,100); 		 
		 grafo1.printNodes();
		 grafo1.printEdges();		 
		
		 grafo2 = g2.generate(500,0.1);		 
		 //grafo2.printNodes();
		 //grafo2.printEdges();
		 
		 grafo3 = g3.generate(500,0.2);
		 grafo3.printNodes();
		 grafo3.printEdges();
		 
		 grafo4 = g4.generate(500,2);
		 grafo4.printNodes();
		 grafo4.printEdges();
		 
		 pes.generate("grafo1_500.dot",grafo1.getNodes());
		 pes.generate("grafo2_500.dot",grafo2.getNodes());
		 pes.generate("grafo3_500.dot",grafo3.getNodes());
		 pes.generate("grafo4_500.dot",grafo4.getNodes());

	}

}
