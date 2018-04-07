

public class BinarySearchTree {
    BSTNode root;

    public BinarySearchTree() {
       root = new BSTNode();

    }

    private boolean insert(int n, BSTNode ins) {
        if (ins.getValue() < n) {
            if (ins.right == null) {
                ins.right = new BSTNode(n);
                return true;
            }
            return insert(n, ins.right);
        } else {
            if (ins.left == null) {
                ins.left = new BSTNode(n);
                return true;
            }
            return insert(n, ins.left);
        }


    }

    public boolean insert(int n) {
    	if (this.root != null) return insert(n, this.root);
        else {
            root = new BSTNode(n);
        }
        return true;
    	
    }
    
   

    public BSTNode searchForValue(int n, BSTNode reference) {
        if (reference == null) {
            return null;
        }
        if (reference.getValue() == n) {
            return reference;
        } else if (reference.getValue() < n && reference.right != null) {
            return searchForValue(n, reference.right);
        } else if (reference.getValue() > n && reference.left != null) {
            return searchForValue(n, reference.left);
        } else 
        

        return null;
        
    }

    
    
    public BSTNode delete(BSTNode current, int n) {
    	if(current == null) {
    		return null;
    	}
    	if(current.getValue() > n) {
    		current.left =  delete(current.getLeft(), n);
    	}
    	else if(current.getValue() < n) {
    		current.right = delete(current.getRight(), n);
    	}
    	else {
    		if(current.getLeft() != null && current.getRight() != null) {
    			BSTNode temp = current;
    			BSTNode minRight = minVal(current.getRight());
    			current.setValue(minRight.getValue());
    			delete(current.getRight(), minRight.getValue());
    		}
    		
    		else if(current.getLeft() != null) {
    			current = current.getLeft();
    		}
    		else if(current.getRight() != null) {
    			current = current.getRight();
    		}
    		else
    			current = null;
    	}
    	return current;
    	
        }
    
    
    public BSTNode minVal(BSTNode current) {
    	if(current.getLeft() == null) {
    		return current;
    	}
    	return minVal(current.getLeft());
    }
    
    public BSTNode getRoot() {
    	return root;
    }
    


    }
