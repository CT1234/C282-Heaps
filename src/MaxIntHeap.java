/* NAME: CHRIS TUFENKJIAN
 * DUE DATE: 09/30/2014
 * COMP282 - PROJECT 2
 */

public class MaxIntHeap 
{
	int [] heap;
	private int heap_size;

	public MaxIntHeap()
	{
		heap = new int [20];
	}
	
	public MaxIntHeap(int m)	
	{
		if (m <= 0)
		{
			heap = new int [20];
		}
		else
		{
			heap = new int [m];
		}
	}
	
	public boolean isEmpty()
	{
		if (heap_size == 0)
			return true;
		else 
			return false;
	}
	
	public int size() 
	{
		return heap_size;
	}

	public void heapInsert(int v) throws HeapException 
	{
		if( heap_size == heap.length )
		{
			throw new HeapException("Error: Heap is full, cannot insert " + v + ".");
		}
		else
		{
			heap[heap_size] = v;
			trickleUp(heap_size);
		}
		heap_size++;
	}
	
	private void swap_parent (int i)
	{	
		heap[i] 		    = heap[i] + heap[get_Parent(i)];
		heap[get_Parent(i)] = heap[i] - heap[get_Parent(i)];
		heap[i]			    = heap[i] - heap[get_Parent(i)];		
	}

	private void swap (int i, int j)
	{	
		heap[i] = heap[i] + heap[j];
		heap[j] = heap[i] - heap[j];
		heap[i]	= heap[i] - heap[j];
	}
	
	public int removeMax() throws HeapException
	{
		if( size() == 0 )
		{
			throw new HeapException("Heap is empty, cannot remove max.");
		}
		else
		{
			int removedValue = heap[0];
			
			heap[0] = heap[heap_size-1];	
			heap_size--;
			trickleDown(0);
			
			return removedValue;	
		}
	}

	public int max() throws HeapException
	{
		if (heap_size == 0)
		{
			throw new HeapException("Heap is empty, cannot retrieve max.");
		}
		else
		return heap[0];
	}

	public void modifyHeap (int k, int newvalue) throws HeapException
	{
		if (k <0 || k >= heap.length )
		{
			throw new HeapException("Index value " + k + " is beyond "
					+ "heap limit, thus cannot exist nor be modified.");
		}
		else if (k <0 || k >= size() )    	//	10/09/2014:	else if (k <0 || k >= (size()-1) )
		{
			throw new HeapException("Node index " + k + " currently does "
					+ "not exist in this heap, thus cannot be modified.");
		}
		else 
		{
			heap[k] = newvalue;
			trickleUp(k);
			trickleDown(k);	
		}
	}
	
	private void trickleUp(int k)
	{
		if (k == 0){}
		else if( heap[k] > heap[get_Parent(k)] )
		{
			swap_parent(k);
			k = get_Parent(k); 
			trickleUp(k);
		}
	}
	
	private void trickleDown(int k)
	{	
		if ( get_rightChild(k) < heap_size && get_leftChild(k) < heap_size
				&& heap[get_rightChild(k)] > heap[k] 
						&&  heap[get_rightChild(k)] > heap[get_leftChild(k)])
		{
				swap( k, get_rightChild(k) );
				trickleDown(get_rightChild(k));
		}
		if (get_leftChild(k) < heap_size
				&& heap[get_leftChild(k)] > heap[k])
		{
				swap( k , get_leftChild(k));
				trickleDown(get_leftChild(k));
		}
	}
	
	private int get_leftChild(int parent_Node)	
	{
		return 2*(parent_Node) + 1; 
	}
	private int get_rightChild(int parent_Node)	
	{
		return 2*(parent_Node) + 2;
	}
	private int get_Parent(int i)
	{
		return (i-1)/2;
	}
	
	public int[] getHeapArray()
	{
		int [] truncated_heap = new int[size()];  
		for (int i = 0; i < size(); i++)
			truncated_heap[i] = heap[i];
		return truncated_heap;
	}
}