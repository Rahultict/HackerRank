package Interview;

public class CheckIfBinaryTreeIsBinarySearchTree {

	public static boolean checkIfBST(Node root , Integer min, Integer max){

		if(root== null){
			return true;
		}

		if( (min != null && root.getValue() < min) || 
				(max != null && root.getValue() > max) ){
			return false;
		}

		if( !checkIfBST(root.getLeft(), min, root.getValue()) || 
				!checkIfBST(root.getRight(), root.getValue(), max)){
			return false;
		}else{
			return true;
		}

	}
	
	public static void main(String[] args) {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);

		node3.setLeft(node1);
		node1.setRight(node2);

		node3.setRight(node5);
		node5.setLeft(node4);
		node5.setRight(node7);

		node7.setRight(node8);
		node7.setLeft(node6);

		node8.setLeft(node9);
		
		boolean result = checkIfBST(node3,null,null);
		System.out.println(result);
		
	}

}