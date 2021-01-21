
public class Arista 
{
	private int weight; 
	private int []edge;
	private Arista nextEdge; 
	
	public void addEdge(Integer n1,Integer n2)
	{
		edge = new int[2]; 
		edge[0] = n1; 
		edge[1] = n2; 
	}
	
	public void addWeight (int w)
	{
		weight = w; 
	}
	public void addNextEdge(Arista nextEdge)
	{
		this.nextEdge = nextEdge; 
	}
	public int[] getVertice()
	{
		return edge; 
	}
	
	public int getWeight()
	{
		return weight; 
	}
	
	public Arista getNextEdge()
	{
		return nextEdge; 
	}

}
