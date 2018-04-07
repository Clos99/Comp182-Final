
public class BSTNode {
	 int value;
	    BSTNode left;
	    BSTNode right;
	    BSTNode parent;


	    public BSTNode(int val) {
	    	value = val;
	    	left = null;
	    	right = null;
	    	parent = null;
	    }
	    
	    public BSTNode() {
	    	left = null;
	    	right = null;
	    	parent = null;
	    }

	    public int getValue() {
	        return value;
	    }

	    public void setValue(int value) {
	        this.value = value;
	    }

	    public BSTNode getLeft() {
	        return left;
	    }

	    public void setLeft(int val) {
	        this.left = new BSTNode(val);
	    }

	    public BSTNode getRight() {
	        return right;
	    }

	    public void setRight(int val) {
	        this.right = new BSTNode(val);
	    }

	    public BSTNode getParent() {
	        return parent;

	    }

	    public void setParent(BSTNode parent) {
	        this.parent = parent;
	    }


	}
