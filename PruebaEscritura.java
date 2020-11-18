import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class PruebaEscritura {

	private File archivo;

	public void generate(String ruta,Nodes list) {
		try {
			Vertice currentNode; 
			BufferedWriter bw;
			this.archivo = new File(ruta);
			int number=0; 
			ArrayList<Integer> connections; 

			if (archivo.exists()) 
			{
				bw = new BufferedWriter(new FileWriter(archivo));

				currentNode = list.getFirstNode(); 
				bw.write("digraph sample {");
				bw.newLine();
				while(currentNode !=null)
				{
					number = currentNode.getNumber(); 
					connections = currentNode.getConnetions();						
					bw.write(number+"-> {"); 
					for(int c : connections)
						bw.write(c+" ;");
					bw.write("}");
					bw.newLine();
					currentNode = currentNode.getNextNode(); 
				}
				bw.write("}");
				System.out.printf("El archivo existe\n"); 

			} 
			else 
			{
				bw = new BufferedWriter(new FileWriter(archivo));

				currentNode = list.getFirstNode(); 
				bw.write("digraph sample {");
				bw.newLine();
				while(currentNode !=null)
				{
					number = currentNode.getNumber(); 
					connections = currentNode.getConnetions();						
					bw.write(number+"-> {"); 
					for(int c : connections)
						bw.write(c+" ;");
					bw.write("}");
					bw.newLine();
					currentNode = currentNode.getNextNode(); 
				}
				bw.write("}");
				System.out.printf("Se creo un archivo nuevo\n"); 
			}
			bw.close();

		} catch (Exception e) {
			System.out.printf("Hubo un error\n");

		}

	}

}
