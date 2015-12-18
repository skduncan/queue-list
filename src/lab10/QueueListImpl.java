package lab10;

import java.util.*;

public class QueueListImpl <T> implements QueueList <T>
{
	private Node <T> first;
	private Node <T> last;
	private int count;
	private int MaxSize;
	
	public QueueListImpl()
	{
		this.first = null;
		this.last = null;
		this.count = 0;
		MaxSize = 5;
	}
	//Pre: none
	//Post: Converts list into readable String
	public String toString()
	{
		String temp = "";
		if(isEmpty() == true)
		{
			temp = "**Empty List**";
			return temp;
		}
		for(Node<T>node1 = this.first; node1 != null; node1 = node1.link)
		{
			temp += node1.data + "\n";
		}
		return temp;
	}
	/** tests to see if the Queue has 0 elements
	 *@ return true if the Queue is empty (has 0 elements) false otherwise;
	 */
	public boolean isEmpty() {
		int temp = size();
		if(temp == 0)
		{
			return true;
		}
		else
		{
		return false;
		}
	}

	/** tests to see if the Queue size() has reached max size, if so return
	  * true, return false if no max set or size is not at max if set.
	 * @return - true if max reached, false otherwise
	 */
	public boolean isFull() {
		int temp = size();
		if(temp == getMaxSize())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/** returns number of elements currently in this Queue
	 *@return - number of elements in list (always <= maxElements)
	 */
	public int size() {
		return this.count;
	}

	/** returns max allowable elements in this Queue.
	 *@return - maximum number of elements allowed in queue
	 */
	public int getMaxSize() {
		return this.MaxSize;
	}

	/** sets max allowable elements in this Queue
	 * truncates queue (at tail or rear) if max allowable is
	 *  less than current size of this Queue
	 *  @param - newSize - max allowable elements to set max to.
	 */
	public void setMaxSize(int newSize) {
		if(newSize<count)
		{
			int i = 0;
			Node <T> node2 = new Node <T>();
			node2 = this.first;
			while(i < newSize)
			{
				this.last = node2;
				node2 = node2.link;
				i++;
			}
			count = newSize;
			this.last.link = null;
		}
		this.MaxSize = newSize;
	}

	/** places item at the end (rear or tail) of this Queue
	 *  inserts item at end of this Queue returns true if room to add
	 *  false if this queue is full.  
	 *@param element - item to be inserted at rear of this Queue
	 *@return - true if add is successful, false otherwise
	  */
	public boolean add(T element) {
		if(this.isFull())
		{
			throw new RuntimeException();
		}
		Node <T> node = new Node<T>();
		node.data = element;
		if(this.isEmpty())
		{
			this.first = node;
			this.last = node;
			this.count++;
		}
		else
		{
			this.last.link = node;
			this.last = node;
			this.count++;
		}
		return true;
	}

	/** removes head (first) item from this Queue if this Queue is
	 * not empty. 
	 * @throws - a RuntimeException on an empty queue 
	 * @return - Object that is removed if Queue is not empty.
	 *
	 */
	public T remove() {
		if(this.isEmpty())
		{
			throw new RuntimeException();
		}
		T item = this.first.data;
		this.first = this.first.link;
		if(this.first == null)
			this.last = null;
		this.count--;
		return item;
	}

	/** returns head (first) item from this Queue if this Queue is
	 * not empty. 
	 * @throws - RuntimeException if Queue is empty
	 * @return - Object that is at the front of this queue, does NOT remove it.
	 */
	public T front() {
		if(this.isEmpty())
		{
			throw new RuntimeException();
		}
		return this.first.data;
	}

	/** returns tail (last) item from this Queue if this Queue is
	 * not empty. 
	 * @throws - RuntimeException if Queue is empty
	 * @return - Object that is at the front of this queue, does NOT remove it.
	 */
	public T last() {
		if(this.isEmpty())
		{
			throw new RuntimeException();
		}
		return this.last.data;
	}

	/** removes all items from this Queue, making it empty.
	 */
	public void clear() {
		this.first = null;
		this.last = null;
		this.count = 0;
	}

}
