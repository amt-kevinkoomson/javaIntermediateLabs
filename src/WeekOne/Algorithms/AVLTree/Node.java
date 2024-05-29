package WeekOne.Algorithms.AVLTree;

import lombok.Data;

@Data
public class Node<T extends Comparable<T>> {
    private T data;
    private int height = 1;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
    }
}
