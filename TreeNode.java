package hw3_skeleton;

public class TreeNode<K extends Comparable<K>, V> {
    
    // pointers shared with subclasses
    protected TreeNode<K, V> left;
    protected TreeNode<K, V> right;
    protected TreeNode<K, V> parent;
    private K key;
    private V value;

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
        parent = null;
    }

    public TreeNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<K, V> node) {
        node.setParent(this);
        this.left = node;
    }

    public TreeNode<K, V> getRight() {
        return right;
    }

    public void setRight(TreeNode<K, V> node) {
        node.setParent(this);
        this.right = node;
    }

    public TreeNode<K, V> getParent() {
        return parent;
    }

    public void setParent(TreeNode<K, V> parent) {
        this.parent = parent;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public String printSubTree() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(this.toString());
        buffer.append('\n');

        if (left != null) {
            if (right != null) {
                left.print(buffer, childrenPrefix + "|--left| ", childrenPrefix + "│   ");
            } else {
                left.print(buffer, childrenPrefix + "|--left| ", childrenPrefix + "    ");
            }
        }
        if (right != null) {
            right.print(buffer, childrenPrefix + "|--right| ", childrenPrefix + "    ");
        }
    }

    @Override
    public String toString() {
        return "TreeNode [key=" + key + ", value=" + value + "]";
    }

    public TreeNode<K, V> getUncle() {
        // TODO
    	if(this.getParent().getParent() == null)
    		return null;
    	if(this.getParent().getParent().getRight() != this.getParent()) {
    		return this.getParent().getParent().getRight();
    	}
    	if(this.getParent().getParent().getLeft() != this.getParent())
    		return this.getParent().getParent().getLeft();
    	return null;
    }

    public TreeNode<K, V> nextInOrder() {
        // TODO
    	TreeNode<K, V> n = this;
    	if(n.getRight()!=null) {
    		n=n.getRight();
    		while(n.getLeft()!=null) {
    			n=n.getLeft();
    		}
    		return n;
    	}
    	else {
    		/*
    		 * 
    		 */
    		while(n == n.getParent().getRight())
    		{
    			n=n.getParent();
    			if(n.getParent()==null)
    				return null;
    		}
    		return n.getParent();
    	}
    		
    }

    boolean isBST()  { 
    	TreeNode<K, V> root = this;
        return isBSTUtil(root, Integer.MIN_VALUE, 
                               Integer.MAX_VALUE); 
                               
    } 
  
   
    boolean isBSTUtil(TreeNode<K, V> node, int min, int max) 
    { 
       int data = (int) node.getKey();
       
      //  if (node == null) 
       //     return true; 
        
  
        
        if (data < min || data > max) 
            return false; 
  
       
        return (isBSTUtil(node.left, min, data-1) && 
                isBSTUtil(node.right, data+1, max)); 
    } 
    
    
    }