/**
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author Jumaira Miller, 983101
 * <p>No copyright</p>
 * @version 1.0.0
 * @since 21/03/2019 
 * <p>Last Modified: 21/03/2019</p>
 *
 */

import java.util.NoSuchElementException;

public class Queue<T> {

	private QueueElement<T> head, tail;
	
	/**
	 * Constructs an empty Queue.
	 */
	public Queue() {
		this.tail = null;
		this.head = null;
	}

	/**
	 * Returns true if the queue is empty
	 * <p>No parameters.</p>
	 * @return whether the queue is empty of not
	 */
	public boolean isEmpty() {
		/* only if the head and the tail refer to nothing, the queue is empty */
		if (head == null && tail == null) {
			return true;
		/* false otherwise */
		} else {
			return false;
		}
	}

	/**
	 * Returns the element at the head of the queue
	 * <p>No parameters.</p>
	 * @return The updated element at the head position
	 */
	public T peek() {
		/* error case */
		if (isEmpty()) {
			throw new NoSuchElementException("No element found at this position");
		}else {	/* otherwise returns the element at the head*/
			return head.getElement(); 
		}
	}
		
	/**
	 * Removes the front element of the queue
	 * <p>No parameters.</p>
	 * <p>Does not return anything</p>
	 */
	public void dequeue() {
		/* error case */
		if (isEmpty()) {
			throw new NoSuchElementException("No element found at this position");
		}else { /* updates the element to the head as the next element */
			this.head = this.head.getNext();
		}
		/* if the head refers to nothing, then the tail refers to nothing (empty queue) */
		if(this.head== null) {
			this.tail = null;
		}
	}

	/**
	 * Puts an element on the back of the queue.
	 * @param element The element to be added to the tail of the queue
	 */
	public void enqueue(T element) {
		QueueElement<T> tmp = new QueueElement<>(element, null);
		if(this.tail==null) {
			this.head = this.tail = tmp;
		} else {
			this.tail.setNext(tmp);
			this.tail = tmp;
		}
	}

	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print() {
		if (this.head==null) {
			System.out.println("The queue is empty.");
		} else {
			System.out.println("The queue is not empty.");
			QueueElement<T> current = this.head;
			
			while(current != null) {
				System.out.println(current.getElement());
				current = current.getNext();
			}
			
		}
	}
}
