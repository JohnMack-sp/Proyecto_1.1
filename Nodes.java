
public class Nodes 
{
	private Vertice firstNode;
	private Vertice lastNode; 
	private int length = 0;  
	private boolean empty = true; 
	
	public void addElement(int n)
	{
		Vertice node; 
		if(firstNode == null)
		{
			firstNode = new Vertice(); 
			firstNode.putNumber(n);
			lastNode = firstNode; 
			length += 1;
			empty = false; 
		}
		else 
		{
			node = new Vertice(); 	
			node.putNumber(n);
			lastNode.addNextNode(node);
			node.addLastNode(lastNode);
			lastNode = node; 
			length += 1;
		}
	}
	
	public Vertice findElement(int n)
	{
		Vertice v; 
		v = firstNode; 
		while(v !=null && v.getNumber() !=n)
			v = v.getNextNode(); 
		return v; 
	}
	
	public Vertice getFirstNode()
	{
		return firstNode; 
	}
	
	public Vertice getLastNode()
	{
		return lastNode; 
	}
	
	public Vertice getElement(int index)
	{
		Vertice element = null; 
		if(index <= length)
		{
			element = firstNode; 
			for(int i = 1; i < index;i++)
			{
				element = element.getNextNode(); 
			}
		}
		
		return element; 			
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
