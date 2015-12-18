package lab10;

public interface QueueList <T>
{

/** tests to see if the Queue has 0 elements
 *@ return true if the Queue is empty (has 0 elements) false otherwise;
 */
public boolean isEmpty();


/** tests to see if the Queue size() has reached max size, if so return
  * true, return false if no max set or size is not at max if set.
 * @return - true if max reached, false otherwise
 */
  public boolean isFull();


/** returns number of elements currently in this Queue
 *@return - number of elements in list (always <= maxElements)
 */
  public int size();

  
/** returns max allowable elements in this Queue.
 *@return - maximum number of elements allowed in queue
 */
  public int getMaxSize();

  
/** sets max allowable elements in this Queue
 * truncates queue (at tail or rear) if max allowable is
 *  less than current size of this Queue
 *  @param - newSize - max allowable elements to set max to.
 */
  public void setMaxSize(int newSize); 
  
  
/** places item at the end (rear or tail) of this Queue
 *  inserts item at end of this Queue returns true if room to add
 *  false if this queue is full.  
 *@param element - item to be inserted at rear of this Queue
 *@return - true if add is successful, false otherwise
  */
  public boolean add(T element);

  
/** removes head (first) item from this Queue if this Queue is
 * not empty. 
 * @throws - a RuntimeException on an empty queue 
 * @return - Object that is removed if Queue is not empty.
 *
 */
 public T remove(); 

 
/** returns head (first) item from this Queue if this Queue is
 * not empty. 
 * @throws - RuntimeException if Queue is empty
 * @return - Object that is at the front of this queue, does NOT remove it.
 */
  public T front();


/** returns tail (last) item from this Queue if this Queue is
 * not empty. 
 * @throws - RuntimeException if Queue is empty
 * @return - Object that is at the front of this queue, does NOT remove it.
 */
  public T last();

  
/** removes all items from this Queue, making it empty.
 */
  public void clear();

}
