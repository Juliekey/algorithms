package datastruct.trees;

import datastruct.linkedlist.LinkedListQueue;

import java.util.NoSuchElementException;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.value = val;
            this.n = n;
        }

    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.n;
    }

    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node x) {
        if (x == null) {
            return null;
        }
        int compareInd = key.compareTo(x.key);
        if (compareInd == 0) {
            return x.value;
        } else if (compareInd < 0) {
            return get(key, x.left);
        }
        return get(key, x.right);
    }

    public void put(Key key, Value value) {
        root = put(key, value, root);
    }

    public Node put(Key key, Value value, Node x) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int compareInd = key.compareTo(x.key);
        if (compareInd > 0) {
            x.right = put(key, value, x.right);
        }
        if (compareInd < 0) {
            x.left = put(key, value, x.left);
        }
        x.value = value;
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");

        return min(root).key;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    private Node min(Node node) {
        return node.left == null ? node : min(node.left);
    }

    public Key max() {
        Node max = max(root);
        return max == null ? null : max.key;
    }

    private Node max(Node node) {
        if (node == null) {
            return null;
        }
        return node.right == null ? node : max(node.right);
    }

    public Value floor(Key key) {
        Node node = floor(key, root);
        return node == null ? null : node.value;
    }

    private Node floor(Key key, Node node) {
        if (node == null) {
            return null;
        }
        int compareInd = key.compareTo(node.key);
        if (compareInd < 0) {
            floor(key, node.left);
        }
        if (compareInd > 0) {
            floor(key, node.right);
        }
        return node.left;
    }

    /**
     * Return the kth smallest key in the symbol table.
     *
     * @param k the order statistic
     * @return the {@code k}th smallest key in the symbol table
     */

    public Key select(int k) {
        Node node = select(k, root);
        return node == null ? null : node.key;
    }

    private Node select(int k, Node node) {
        if (node == null) {
            return null;
        }
        int n = size(node.left);
        if (n < k) {
            select(k, node.left);
        }
        if (k < n) {
            select(k - n - 1, node.right);
        }
        return node;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;

        }
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(key, root);
    }

    private Node delete(Key key, Node node) {
        if (node == null) {
            return null;
        }
        int compareIndex = key.compareTo(node.key);
        if (compareIndex < 0) {
            node.left = delete(key, node.left);
        } else if (compareIndex > 0) {
            node.right = delete(key, node.right);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node t = node;
            node = min(node.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void printKeysInOrder() {
        inOrderTraversalPrint(root);
    }

    private void inOrderTraversalPrint(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversalPrint(node.left);
        System.out.println(node.key);
        inOrderTraversalPrint(node.right);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        LinkedListQueue<Key> queue = new LinkedListQueue<>();
        range(queue, root, lo, hi);
        return queue;
    }

    private void range(LinkedListQueue<Key> queue, Node node, Key lo, Key hi) {
        if (node == null) {
            return;
        }
        int compareLo = lo.compareTo(node.key);
        int compareHi = hi.compareTo(node.key);

        if (compareLo < 0) {
            range(queue, node.left, lo, hi);
        }
        if (compareHi <= 0 & +compareHi >= 0) {
            queue.enqueue(node.key);
        }
        if (compareHi > 0) {
            range(queue, node.right, lo, hi);
        }
    }
}
