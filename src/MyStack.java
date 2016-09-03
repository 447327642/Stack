public class MyStack {

	private int maxSize = 10;
	private int[] stackArray;
	private int top;

	public MyStack() {
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int j) {
		stackArray[++top] = j;
	}

	public int pop() {
		return stackArray[top--];
	}

	public int peek() {
		return stackArray[top];
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
	      return (top == maxSize - 1);
	}
	
	public int maxSize() { // added for visibility to test overflow
		return maxSize;
	}

}