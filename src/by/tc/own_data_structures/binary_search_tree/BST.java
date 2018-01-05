package by.tc.own_data_structures.binary_search_tree;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Y50-70 on 04.01.2018.
 */
public class BST <T extends Comparable<T>> {
    private Node<T> root;
    private List<T> traverseContent;

    public BST(){}

    public boolean add(T elem) {
        if (root != null) {
            root = add(root, elem);
        } else {
            root = new Node<>();
            root.elem = elem;
        }
        return true;
    }

    private Node<T> add(Node<T> node, T elem) {
        if (node == null) {
            node = new Node<T>();
            node.elem = elem;
        } else if (elem.compareTo(node.elem) < 0) {
            node.left = add(node.left, elem);
        } else {
            node.right = add(node.right, elem);
        }
        return node;
    }

    public boolean contains(T elem) {
        return contains(root, elem);
    }

    private boolean contains(Node<T> n, T elem) {
        if (n != null) {
            if (elem.equals(n.elem)) {
                return true;
            } else if (elem.compareTo(n.elem) < 0) {
                return contains(n.left, elem);
            } else {
                return contains(n.right, elem);
            }
        }
        return false;
    }

    public int size() {
        return inOrder().size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean remove(T elem) {
        if (!contains(elem)) {
            return false;
        }
        root = remove(root, elem);
        return true;
    }

    private Node<T> remove(Node<T> node, T elem) {
        if (elem.compareTo(node.elem) < 0) {
            node.left = remove(node.left, elem);
        } else if (elem.compareTo(node.elem) > 0) {
            node.right = remove(node.right, elem);
        } else if (node.left != null && node.right != null) {
            node.elem = findSuccessor(node.right).elem;
            node.right = remove(node.right, node.elem);
        } else {
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    private Node<T> findSuccessor(Node<T> node) {
        if (node.left != null) {
            node = findSuccessor(node.left);
        }
        return node;
    }

    public List<T> inOrder() {
        traverseContent = new ArrayList<>();
        inOrder(root);
        return traverseContent;
    }

    private void inOrder(Node<T> n) {
        if (n != null) {
            inOrder(n.left);
            traverseContent.add(n.elem);
            inOrder(n.right);
        }
    }

    public List<T> preOrder() {
        traverseContent = new ArrayList<>();
        preOrder(root);
        return traverseContent;
    }

    private void preOrder(Node<T> n) {
        if (n != null) {
            traverseContent.add(n.elem);
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public List<T> postOrder() {
        traverseContent = new ArrayList<>();
        postOrder(root);
        return traverseContent;
    }

    private void postOrder(Node<T> n) {
        if (n != null) {
            postOrder(n.left);
            postOrder(n.right);
            traverseContent.add(n.elem);
        }
    }

    private class Node<T>{
        private T elem;
        private Node<T> left, right;
        public Node(T data, Node<T> l, Node<T> r)
        {
            left = l; right = r;
            this.elem = data;
        }
        public Node(T data)
        {
            this(data, null, null);
        }
        public Node(){}
    }
}
