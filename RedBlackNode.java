package hw3_skeleton;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class RedBlackNode<K extends Comparable<K>, V> extends TreeNode<K, V> {
	// red node if this is true, black if false
	private boolean red;
	private int totalblacks;

	// default to red
	public RedBlackNode(K key, V value) {
		super(key, value);
		red = true;
	}

	// can take a string to set color
	// this makes things a little easier when testing
	public RedBlackNode(K key, V value, String color) {
		super(key, value);
		if (color.equalsIgnoreCase("black"))
			setBlack();
		else if (color.equalsIgnoreCase("red"))
			setRed();
		else
			throw new InvalidParameterException("color must be red or black");
	}

	public boolean isRed() {
		return red;
	}

	public boolean isBlack() {
		return !red;
	}

	public void setRed() {
		this.red = true;
	}

	public void setBlack() {
		this.red = false;
	}

	public RedBlackNode<K, V> getLeft() {
		return (RedBlackNode<K, V>) left;
	}

	public RedBlackNode<K, V> getRight() {
		return (RedBlackNode<K, V>) right;
	}

	public RedBlackNode<K, V> getParent() {
		return (RedBlackNode<K, V>) parent;
	}

	@Override
	public String toString() {
		return "TreeNode [red=" + red + ", " + "key=" + getKey() + ", value=" + getValue() + "]";
	}


    public Boolean isRedBlackTree() {
        //totalblacks = -1;
        
        if (this.isRed())
            return false;

        int currentblacks = 0;

        return this.isRBThelp(currentblacks,-1);
    }

    private Boolean isRBThelp(int cb,int totalblacks) {
        
        if (this.isBlack()) {
            cb++; 
            if (this.getLeft() != null)
                if (!this.getLeft().isRBThelp(cb,totalblacks)) {
                    
                    return false;
                }

            if (this.getRight() != null)
                if (!this.getRight().isRBThelp(cb,totalblacks)) {
                    
                    return false;
                }
            if (this.getLeft() == null && this.getRight() == null) {
                if (totalblacks == -1){
                    totalblacks = cb;
                    
                }
                else {
                    if (cb != totalblacks) {
                        
                        
                        return false;
                    } else
                        return true;
                }
            }
        }
        if (this.isRed()) {
            if (this.getLeft() != null) {
                if (this.getLeft().isBlack()) {
                    if (!this.getLeft().isRBThelp(cb,totalblacks)) {
                        
                        return false;
                    }
                } else {
                    
                    return false;
                }
            }
                if (this.getRight() != null) {
                    if (this.getRight().isBlack()) {
                        if (!this.getRight().isRBThelp(cb,totalblacks)) {
                            
                            return false;
                        }
                    } else {
                        
                        return false;
                    }
                }
                
                if (this.getLeft() == null && this.getRight() == null) {
                    
                    if (totalblacks == -1){
                        totalblacks = cb;
                        
                    }
                    else {
                        if (cb != totalblacks) {
                            
                            return false;
                        } else
                            return true;
                    }
                }

            }


        return true;
    }
}