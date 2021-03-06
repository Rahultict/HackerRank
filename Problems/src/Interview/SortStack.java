package Interview;

import java.util.Stack;

public class SortStack {

	//sort stack using another stack
	public static Stack<Integer> sortStackWithAnotherStack(Stack<Integer> s){
		Stack<Integer> s2 = new Stack<Integer>();
		while(!s.isEmpty()){
			int nextInt = s.pop();
			while(!s2.isEmpty() && s2.peek() > nextInt){
				s.push(s2.pop());
			}
			s2.push(nextInt);
		}
		return s2;
	}
	
	
	
	
	public static Stack<Integer> sortStackInDescendingWithoutRecursion(Stack<Integer> inputStack){

		if(inputStack == null)
			return null;
		
		Stack<Integer> bufferStack = new Stack<Integer>();
		
		while(!inputStack.isEmpty()){
			
			int next = inputStack.pop();
			
			while(!bufferStack.isEmpty() && bufferStack.peek() > next ){
				inputStack.push(bufferStack.pop());
			}
			
			bufferStack.push(next);
			
		}
		
		return bufferStack;
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> s = new Stack<Integer>();
		
		s.push(10);
		s.push(4);
		s.push(3);
		s.push(15);
		s.push(34);
		s.push(1);
		
		System.out.println("Orig stack is " + s);
		//Stack<Integer> sorted = sortStackWithAnotherStack(s);
		Stack<Integer> sorted = sortStackInDescendingWithoutRecursion(s);
		//System.out.println("sorted  Stack is " + sorted);
		
		while(!sorted.isEmpty()){
			System.out.println(sorted.pop());
		}
		
		
	}

}
