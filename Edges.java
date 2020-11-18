
public class Edges 
{
	private Arista firstEdge; 
	private Arista lastEdge; 
	private int length = 0;  
	private boolean empty = true; 
	
	public void addElement(Integer n1, Integer n2)
	{
		Arista Edge; 
		if(firstEdge == null)
		{
			firstEdge = new Arista(); 
			firstEdge.addEdge(n1, n2);
			length += 1; 
			lastEdge = firstEdge; 
			empty = false; 
		}
		
		else
		{
			Edge = new Arista(); 
			Edge.addEdge(n1, n2);
			length +=1; 
			lastEdge.addNextEdge(Edge);
			lastEdge = Edge; 
		}
	}
	

	public Arista getFirstEdge()
	{
		return firstEdge; 
	}
	
	public Arista getLastEdge()
	{
		return lastEdge; 
	}
	
	public Arista getElement(int index)
	{
		Arista element = null; 
		if(index <= length)
		{
			element = firstEdge; 
			for(int i = 1; i < index;i++)
			{
				element = element.getNextEdge(); 
			}
		}
		
		return element; 			
	}
	
	public Arista findEdge(Integer n1,Integer n2)
	{
		Arista currentEdge;		
		int[] v; 
		
		currentEdge = firstEdge;
		
		while(currentEdge !=null)
		{
			v = currentEdge.getVertice(); 
			if((v[0] == n1 || v[0] == n2) && (v[1] == n1 || v[1] == n2))
				break; 
			currentEdge = currentEdge.getNextEdge();  
		} 
		
		return currentEdge; 
		
	}
	public int size()
	{
		return length; 
	}
	
	public boolean empty()
	{
		return empty; 
	}
	
}
