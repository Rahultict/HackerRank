package Interview;

import java.util.Stack;

public class StackReverseSorting {
	
	public static void transfer(Stack<Integer> s1, Stack<Integer> s2, int numTransfer,int curMin){
	    
	    // s1 is full , s2 is empty
	    if(numTransfer==1){
	        s2.push(s1.pop());
	    }   
	        
	    int nextMin = Integer.MAX_VALUE;    
	    int numTransferCopy = numTransfer;
	    
	    while(!s1.isEmpty() && numTransferCopy > 0){
	            
	        int nextNum = (Integer) s1.pop();
	        if(nextNum < nextMin)
	            nextMin = nextNum;
	            
	        if(nextNum != curMin){
	        	s2.push(nextNum);
	        	numTransferCopy--;
	        }
	    }    
	    
	    s1.push(curMin);
	    
	   transfer(s2,s1,numTransfer-1,nextMin);  
	    
	}


	public static Stack<Integer> reverseSort(Stack s){
	    
	    if(s == null){
	        return null;
	    }
	    
	    Stack<Integer> s2 = new Stack<Integer>();
	    
	    int numElements = 0;
	    int minElement = Integer.MAX_VALUE;
	    while(!s.isEmpty()){
	        
	        int num = (Integer) s.pop();
	        s2.push(num);
	        numElements++;
	        if(num < minElement)
	            minElement = num;
	    }
	    
	    transfer(s2,s,numElements-1,minElement);
	    
	    return (s.isEmpty()?s2:s);
	}
	    
	public static void main(String[] args){
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		
		Stack<Integer> sortedStack = reverseSort(stack);
		
		while(!sortedStack.isEmpty())
			System.out.println(sortedStack.pop());
		
	}

}
