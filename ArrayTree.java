package hw3_skeleton;

import java.util.Arrays;

class ArrayTree<K extends Comparable<K>, V> {
    TreeElement<K, V>[] tree;

    // Sets up an initial array for the tree with 1 slot for the root
    @SuppressWarnings("unchecked")
    public ArrayTree() {
        tree = (TreeElement<K, V>[]) new TreeElement[1];
    }

    public TreeElement<K, V> getLeft(int loc) {
        return locToElement(getLeftLoc(loc));
    }

    public TreeElement<K, V> getRight(int loc) {
        return locToElement(getRightLoc(loc));
    }

    public TreeElement<K, V> getParent(int loc) {
        return locToElement(getParentLoc(loc));
    }

    public int getLeftLoc(int loc) {
        return 2 * loc + 1;
    }

    public int getRightLoc(int loc) {
        return 2 * loc + 2;
    }

    public int getParentLoc(int loc) {
        return (loc - 1) / 2;
    }

    // returns the element stored at a location
    public TreeElement<K, V> locToElement(int loc) {
        if (loc >= tree.length || loc < 0)
            return null;
        else
            return tree[loc];
    }

    // only method that actually adds things to the array
    public void setLoc(int loc, TreeElement<K, V> e) {
        if (loc < 0)
            throw new IndexOutOfBoundsException("Tree locations must be 0 or more");
        // if we're adding something beyond the length of the tree array, then we must
        // grow the array
        if (loc >= tree.length)
            resize();
        tree[loc] = e;
        e.setTreeLocation(loc);
    }

    // takes a location in the tree and a new Element
    // makes that element the left child of the node at loc
    public void setLeft(int loc, TreeElement<K, V> e) {
        setLoc(getLeftLoc(loc), e);
    }

    // takes a location in the tree and a new Element
    // makes that element the right child of the node at loc
    public void setRight(int loc, TreeElement<K, V> e) {
        setLoc(getRightLoc(loc), e);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        // double the size of the array
        // adds just enough spaces for one more full level of a complete tree
        int new_length = tree.length * 2 + 1;
        // create new array
        TreeElement<K, V>[] temp_tree = (TreeElement<K, V>[]) new TreeElement[new_length];
        // copy contents of old array to new array
        for (int i = 0; i < tree.length; i++) {
            temp_tree[i] = tree[i];
        }
        // set replace old array with the new one
        tree = temp_tree;
    }

    @Override
    public String toString() {
        // returns string representation of tree array which holds nodes in complete
        // order
        // I.e. left to right, top to bottom
        return "ArrayTree " + Arrays.toString(tree);
    }

    public TreeElement<K, V> getUncle(int loc) {
        // TODO
    	if(locToElement(getParentLoc(getParentLoc(loc))) == null)
    		return null;
    	if(getRightLoc(getParentLoc(getParentLoc(loc)))!=getParentLoc(getParentLoc(loc)) )
    		return locToElement(getRightLoc(getParentLoc(getParentLoc(loc))));
    	if(getLeftLoc(getParentLoc(getParentLoc(loc)))!=getParentLoc(getParentLoc(loc)) )
    		return locToElement(getLeftLoc(getParentLoc(getParentLoc(loc)))); 	
    	
    	return null;
    }

    public boolean isMinHeap(int loc) {
        // TODO
        return false;
    }
}