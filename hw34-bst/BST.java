/*****************************************************
 * Judy Liu
 * APCS2
 * HW34-- Algorithm as DataS Structure
 * 2017 - 05 - 03
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST 
{
    //instance variables / attributes of a BST:
    TreeNode root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
	root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) 
    {
	root = insertH(root, newVal);
    }

    public TreeNode insertH( TreeNode node, int newVal){
	if (node == null){
	    node = new TreeNode(newVal);
	    return node;
	}
	if( newVal < node.getValue() ){
	    node.setLeft(insertH(node.getLeft(), newVal));
	}
	else {
	    node.setRight(insertH(node.getRight(), newVal));
	}
	return node;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav(){
	preHelper(root);
    }
    
    public void preHelper(TreeNode root){
	if (root == null){
	    return;
	}
	System.out.print(root.getValue() + " ");
	preHelper(root.getLeft());
	preHelper(root.getRight());
    }

    public void inOrderTrav(){
	inHelper(root);
    }
    
    public void inHelper(TreeNode root){
	if (root == null){
	    return;
	}
	inHelper(root.getLeft());
	System.out.print(root.getValue() + " ");
	inHelper(root.getRight());
    }

    public void postOrderTrav(){
        postHelper(root);
    }

    public void postHelper(TreeNode root){
	if (root == null){
	    return;
	}
	postHelper(root.getLeft());
	postHelper(root.getRight());
	System.out.print(root.getValue() + " ");
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) 
    {
	BST arbol = new BST();


	  arbol.insert( 4 );
	  arbol.insert( 2 );
	  arbol.insert( 5 );
	  arbol.insert( 6 );
	  arbol.insert( 1 );
	  arbol.insert( 3 );

	  System.out.println( "\npre-order traversal:" );
	  arbol.preOrderTrav();

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav();
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav();
	  /*
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class
