package binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> {
    
    // binarySearchTree class variables
    private int nodeCount = 0; // tracks the number of nodes in the BST
    private Node root = null; // root of the binary search tree

    //////////////////////////////////////////////////////////////////////////////
    
    // node class
    private class Node {
        T data; //data stored withing the node
        private Node left, right; // left and right child node of this node
        
        public Node(Node left, Node right, T data) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////
    
    // returns whether or not the tree is empty
    public boolean isEmpty() {return (size() == 0);}
    
    // return the number of node within the tree
    public int size() {return this.nodeCount;}
    
    // adds an element to the binarySearchTree
    // return true if insertion was successful
    public boolean add(T element) {
        
        // check to see if the tree contains the given element
        // if it does then the dont add the element
        if (contains(element)) return false;
        
        // add the element to the tree if not already found in tree
        root = add(root, element);
        this.nodeCount++;
        return true;
        
    }
    
    private Node add(Node node, T element) {
        
        // check to see if the tree is empty
        if (node == null) node = new Node(null, null, element);
        else {
            if (element.compareTo(node.data) < 0) node.left = add(node.left, element);
            else node.right = add(node.right, element);
        }
        return node;
        
    }
    
    // removes an element from the binarySearchTree if it exists
    public boolean remove(T element) {
        
        // return false if the element is not found within the tree
        if (!contains(element)) return false;
        
        // if found remove the element from within the tree
        root = remove(root, element);
        this.nodeCount--;
        return true;
        
    }
    
    private Node remove(Node node, T element) {
        
        if (node == null) return null;
        
        // traverse the tree to find the element 
        // traverse left subtree if element if less than nodes data
        // traverse right subtree if element if greater than nodes data
        if (element.compareTo(node.data) < 0) node.left = remove(node.left, element);
        else if (element.compareTo(node.data) > 0) node.right = remove(node.right, element);
        
        // found the node you with to remove
        else {
            
            // the case in which the element only has a right subtree
            // or no subtree. Just swap the node with its right child node
            if (node.left == null) {
                Node rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;
            }
            // the case in which the element only has a left subtree
            // or no subtree. Just swap the node with its left child node
            else if (node.right == null) {
                Node leftChild = node.left;
                node.data = null;
                node = null;
                return leftChild;
            }
            // the case in which the element has both a right and a left
            // subtree. The successor to the removed node can either be
            // the largest node from the left subtree or the smallest node 
            // from the right subtree
            else {
                // find the leftmost node of the right subtree
                Node temp = digLeft(node.right);
                
                // swap the elements 
                node.data = temp.data;
                
                // go into the right subtree and delete the node that we just
                // found and stored into temp
                node.right = remove(node.right, temp.data);
            }
            
        }
        
        return node;
        
    }
    
    // helper method that find the smallest node within the right subtree
    private Node digLeft(Node node) {
        
        while (node.left != null) node = node.left;
        return node;
        
    }
    
    // return true or false whether an element is contained within the tree or not
    public boolean contains(T element) {return contains(root, element);}
    
    // recursive method to find an element within a tree
    private boolean contains(Node node, T element) {
        
        if (node == null) return false;
        
        // if elements value is less than current nodes data value traverse left
        if (element.compareTo(node.data) < 0) return contains(node.left, element);
        // if elements value is greater than current nodes data value traverse right
        else if (element.compareTo(node.data) > 0) return contains(node.right, element);
        // if equal to return true
        else return true;
        
    }
    
    // preOrder traversal
    public void preOrder() {
        if(isEmpty()) {
            System.out.println("[NULL]");
            return;
        }
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print("[" + node.data + "]");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    // inOrder traversal
    public void inOrder() {
        if(isEmpty()) {
            System.out.println("[NULL]");
            return;
        }
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print("[" + node.data + "]");
            inOrder(node.right);
        }
    }
    
    // postOrder traversal
    public void postOrder() {
        if(isEmpty()) {
            System.out.println("[NULL]");
            return;
        }
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print("[" + node.data + "]");
        }
    }
}
