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
	
	
	
	
	//sort stack using recursion
	public static void StackSortUsingRecusrion(Stack<Integer> stack){
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> s = new Stack<Integer>();
		
		s.add(10);
		s.add(4);
		s.add(3);
		s.add(15);
		s.add(34);
		s.add(1);
		
		System.out.println("Orig stack is " + s);
		Stack<Integer> sorted = sortStackWithAnotherStack(s);
		System.out.println("sorted  Stack is " + sorted);
		
		
		
	}

}