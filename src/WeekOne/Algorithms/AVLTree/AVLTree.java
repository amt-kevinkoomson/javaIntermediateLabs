package WeekOne.Algorithms.AVLTree;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
    @Override
    public Tree<T> insert(T data) {
        root = insertAVL(data, root);
        return this;
    }
    @Override
    public void delete(T data) {
        root = deleteAVL(data, root);
    }

    private Node<T> insertAVL(T data, Node<T> node){
        Node<T> updatedNode = insert(data, node);
        updateHeight(updatedNode);
        return applyRotation(updatedNode);
    }
    private Node<T> deleteAVL(T data, Node<T> node){
        Node<T> updatedNode = delete(data, node);
        updateHeight(updatedNode);
        return applyRotation(updatedNode);
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
        return null;
    }

    private int balance(Node<T> node) {
        // the balance of a node is the height of the left child
        return node != null
                ? height(node.getLeftChild()) - height(node.getRightChild())
                : 0;
    }
}
