package Interview;

/*
 * Find the closes common ancestor 
 */
public class LowestCommonAncestor {

	public Node getLowestCommonAncestor(Node root, Node node1, Node node2){
		
		if(root == null)
			return null;
		
		Node LCA;
		
		if(root.getValue() > node1.getValue() && root.getValue() > node2.getValue()){
			LCA = getLowestCommonAncestor(root.getLeft(), node1, node2);
		}else if(root.getValue() < node1.getValue() && root.getValue() < node2.getValue()){
			LCA = getLowestCommonAncestor(root.getRight(), node1, node2);
		}else{
			LCA = root;
		}
		
		return LCA;
	}
	
		
	public static void main(String[] args) {
		

		
		// TODO Auto-generated method stub
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		node3.setLeft(node1);
		node1.setRight(node2);
		
		node3.setRight(node5);
		node5.setLeft(node4);
		node5.setRight(node7);
		
		node7.setRight(node8);
		node7.setLeft(node6);
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		
		Node head = lca.getLowestCommonAncestor(node3, node8, node6);
		
		System.out.println("lca is " + head.getValue());
		
		

	

	}
	
	

}
