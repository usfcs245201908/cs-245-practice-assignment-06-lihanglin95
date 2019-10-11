
public class ArrayQueue<T> implements Queue<T> {
	
	T[] a;
	int front = 0;
	int back = 0;
	
	public ArrayQueue(){
		a = (T[]) new Object[10];
	}
	
	public boolean empty() {
		
		return front == back;
	}
	
	public T dequeue() throws Exception{
	
		if(empty())
			throw new Exception();
		T item = a[front];
		front =(front+1) % a.length;
		return item;
	}

	public void enqueue(T item) {
		
		//grow the array if the array is full
		if(front == (back+1) % a.length)
			growArray();
		a[back] = item;
		back = (back+1) % a.length;
	}
	
	protected void growArray() {
		T[] newArray = (T[]) new Object [a.length * 2];
		
		//copy from array a to newArray
		for(int i = 0; i< a.length; i++) {
			newArray[i] = a[front %a.length];
			front++;
		}
		front = 0;
		//question: why not back = a.length
		back = a.length-1;
		a = newArray;
		
	}
}
