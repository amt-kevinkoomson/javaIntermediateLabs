package WeekOne.Algorithms.AVLTree;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    public AVLTree() {}

    @Override
    public Tree<T> insert(T data) {
        root = insert(data, root);
        return this;
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
    }

    @Override
    public Node<T> insert(T data, Node<T> node){
        if(node == null){
            return new Node<>(data);
        }
        if(data.compareTo(node.getData()) < 0){
            node.setLeftChild(insert(data, node.getLeftChild()));
        }
        else if(data.compareTo(node.getData()) > 0){
            node.setRightChild(insert(data, node.getRightChild()));
        } else return node;
        updateHeight(node);
        return applyRotation(node);
    }

    @Override
    protected Node<T> delete (T data, Node<T> node){
        if(node == null){
            // if root is null, return null. if node arrived at is null, return null
            return null;
        }
        // keep searching for the node until found
        if(data.compareTo(node.getData()) < 0){
            // recursively call delete method for returning children of deleted node
            node.setLeftChild(delete(data, node.getLeftChild()));
        } else if(data.compareTo(node.getData()) > 0){
            // recursively call delete method for returning children of deleted node
            node.setRightChild(delete(data, node.getRightChild()));
        } else { // node found
            // if found node has one child or is a leaf node (no children)
            if(node.getLeftChild() == null) {
                return node.getRightChild();
            }
            else if(node.getRightChild() == null) {
                return node.getLeftChild();
            }
            // if node found has  two children, assign either predecessor(left child) or successor(right child) to node
            node.setData(getMax(node.getLeftChild()));
            // delete child node which is now a duplicate (done by recursively calling this method, which does assigning
            // won't recursively delete all nodes with given value
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private void updateHeight(Node<T> node){
        // the height of a node is the maximum height of its children plus 1
        // max height of either child nodes
        int maxHeight = Math.max(
                height(node.getLeftChild()),
                height(node.getRightChild())
        );
        // assign new height to max height plus one
        node.setHeight(maxHeight + 1);
    }
    private int height(Node<T> node){
        return node != null ? node.getHeight() : 0;
    }
    private Node<T> applyRotation(Node<T> node){
        int balance = balance(node);
        if(balance > 1){ // node is left-heavy
            if(balance(node.getLeftChild()) < 0){
                // if balance of left child of main node is opposite to balance of main node, rotate left child left
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        if(balance < -1){
            // node is right-heavy
            if(balance(node.getRightChild()) > 0){
                // if balance of right node of main node is opposite to balance of main node, rotate right child right
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }

        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.getLeftChild(); // to become root node, therefore, to be returned
        Node<T> centerNode = leftNode.getRightChild(); // to become child of new right node
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.getRightChild();
        Node<T> centerNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private int balance(Node<T> node) {
        // the balance of a node is the height of the left child minus that of the right child
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        System.out.println(" in order traversal : ");
        avlTree.traverse();
        System.out.println(avlTree.root.getData() + " root data");
        System.out.println("Max node: " + avlTree.getMax());
        System.out.println("Min node: " + avlTree.getMin());
    }

}
