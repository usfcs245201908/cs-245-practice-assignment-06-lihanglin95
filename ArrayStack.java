import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
	T[] a;
	int top = -1;
	
	public ArrayStack() {
		a = (T[]) new Object [10];
	}
	
	public boolean empty() {
		return top == -1;
	}
	
	void growArray() {
		T[] newArray = (T[]) new Object[a.length * 2];
		System.arraycopy(a, 0, newArray, 0, a.length);
		a = newArray;
	}
	
	public void push(T item) {
		if(top == a.length -1)
			growArray();
		a[++top] = item;

	}
	
	public T pop() throws Exception{
		if(!empty())
			return a[top--];
		throw new Exception();
	}
	
	public T peek() throws Exception {
		if(!empty())
			return a[top];
		throw new Exception();
	}
	

}
