package WeekOne.Algorithms.AVLTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    protected Node<T> root;

    protected T getMin(Node<T> node) {
        if(node.getLeftChild() != null){
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }

    protected T getMax(Node<T> node) {
        if(node.getRightChild() != null){
            return getMax(node.getRightChild());
        }
        return node.getData();
    }
// detailed implementations below
//    @Override
//    public Tree<T> insert(T data) {
//        if(isEmpty()){
//            root = new Node<>(data);
//        } else {
//            insert(data, root);
//        }
//        return this;
//    }
//
//    private void insert(T data, Node<T> node) {
//        if(data.compareTo(node.getData()) < 0){
//            // move to the left subtree
//            if(node.getLeftChild() == null){
//                // if left child is null, assign node to left child
//                node.setLeftChild(new Node<>(data));
//            } else {
//                insert(data, node.getLeftChild());
//            }
//        }
//        else if(data.compareTo(node.getData()) > 0){
//            // move to the right subtree
//            if(node.getRightChild() == null){
//                // if left child is null, assign node to left child
//                node.setRightChild(new Node<>(data));
//            } else {
//                insert(data, node.getRightChild());
//            }
//        }
//    }
    // Heavily recursive methods, same implementation as above
    public Tree<T> insert (T data){
        root = insert(data, root);
        return this;
    }

    public Node<T> insert(T data, Node<T> node){
        if(node == null){
            return new Node<>(data);
        }
        if(data.compareTo(node.getData()) < 0){
            node.setLeftChild(insert(data, node.getLeftChild()));
        }
        else if(data.compareTo(node.getData()) > 0){
            node.setRightChild(insert(data, node.getRightChild()));
        }
        return node;
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
    }

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
        return node;
    }

    @Override
    public void traverse() {
        traverseInOrder(root);
    }

    protected void traverseInOrder(Node<T> node) {
        if(node != null){
            traverseInOrder(node.getLeftChild());
            System.out.println(node);
            traverseInOrder(node.getRightChild());
        }
    }

    @Override
    public T getMax() {
        if(isEmpty()) return null;
        return getMax(root);
    }

    @Override
    public T getMin() {
        if (isEmpty()) return null;
        return getMin(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(10);
        binarySearchTree.insert(20);
        binarySearchTree.insert(30);
        binarySearchTree.insert(40);
        binarySearchTree.insert(50);
        System.out.println(" in order traversal : ");
        binarySearchTree.traverse();
    }
}
