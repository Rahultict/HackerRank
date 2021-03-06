package Interview;

public class BinaryTreeToDoublyLinkedList {
	
	public Node merge(Node left, Node right){

		if(left == null)
			return right;

		if(right == null)
			return left;

		Node head = left;

		while(left.getRight() != null)
			left = left.getRight();

		left.setRight(right);
		right.setLeft(left);

		return head;
	}
	
	
	public Node convertBTToDLL(Node root){

		if(root == null){
			return null;
		}

		Node left = convertBTToDLL(root.getLeft());
		Node right = convertBTToDLL(root.getRight());

		root.setLeft(null);
		root.setRight(null);

		Node leftList = merge(left, root);
		Node FinalList = merge(leftList, right);


		return FinalList;

	}
	
	public static void main(String[] args){
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		node3.setLeft(node1);
		node1.setRight(node2);
		
		node3.setRight(node5);
		node5.setLeft(node4);
		node5.setRight(node6);
		
		BinaryTreeToDoublyLinkedList algo = new BinaryTreeToDoublyLinkedList();
		Node head = algo.convertBTToDLL(node3);
		
		while(head.getRight() != null){
			System.out.println(head.getValue());
			head = head.getRight();
		}
		
	}

}
