/**COSC 310-002 Assignment 3
 * SLList.java
 * 
 * This class creates a linked list
 * that stores all of the employee
 * objects
 * 
 * @author Josh Wayland
 *
 */
public class SLList<E extends Comparable> 
{
	private Node<E> head;
	private Node<E> tail;
    private int size;
    private E[] list;
    public SLList()
    {
        head = null;
        size = 0;
    }
    public void add(E item) 
    {
    	if(head == null)
		{
			head = new Node<E>(item, null);
			size++;
		}
    	else
		{
			Node<E> p = head;
			while( p.next != null )
			{
				p = p.next;
			}
			p.next = new Node<E>( item, null );
			size++;
		}
    }
    public E get( int index )
	{
		if( index < 0 || index >= size )
			throw new IndexOutOfBoundsException( Integer.toString(index));
		
		Node<E> p = head;
		for( int i = 0; i < index && p != null; i++ )
			p = p.next;
		return p.data;
	}
    public int size()
    {
        return size;
    }
    public int indexOf( E target )
    {
        Node<E> p = head;
        int index = 0;
        while( p != null )
        {
            if( target.compareTo( p.data ) == 0 )
            {
                return index;
            }
            p = p.next;
            index++;
        }
        return -1;
    }   
    public String toString()
    {
        Node<E> p = head;
        String str = "";
        
        while( p != null )
        {
            str = str + p.data.toString() + "\n";
            p = p.next;
        }
        return str;
    }
    private static class Node<E>
	{
		private E data;
		private Node<E> next;
		private Node(E data, Node<E> next)
		{
			super();
			this.data = data;
			this.next = next;
		}
	}
}
