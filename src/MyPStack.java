import java.util.NoSuchElementException;

public class MyPStack {

	private int maxSize = 10;
	private int[] stackArray;
	private int top;
	private IDataBase db;
	private String id;
	private static int nextId = 1;

	public MyPStack(IDataBase stackDB) {
		db = stackDB;
		stackArray = new int[maxSize];
		top = -1;
		id = new Integer(nextId).toString();
		nextId++;
	}
	

	public void push(int j) throws OverflowException {
		if (isFull()) throw new OverflowException();
		stackArray[++top] = j;
		if (size() == 1) {
			db.create(id, j);
		} else {
			db.update(id,  j);
		}
	}

	public int pop() throws InvalidOperationException {
		if (isEmpty()) throw new InvalidOperationException ();
		int poppedVal = stackArray[top--];
		if (isEmpty()) {
			db.delete(id);
		} else
		{
			db.update(id, peek());
		}
		return poppedVal;
	}

	public int peek() throws InvalidOperationException {
		if (isEmpty()) throw new InvalidOperationException ();
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

	public String getId() {
		return id;
	}

	public void reset() {
		if (isEmpty() || size() == 1) return;
		stackArray[0] = db.read(id);
		top = 0;
	}

}