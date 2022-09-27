package dataStructures.binary_tree;

public class Node {
    int key;
    Node p;
    Node right;
    Node left;

    static void inorderTreeWalk(Node x) {
        if (x != null) {
            inorderTreeWalk(x.left);
            System.out.println(x.key);
            inorderTreeWalk(x.right);
        }
    }

    static Node treeSearch(Node x, int key) {
        if (x == null || x.key == key) {
            return x;
        }
        if (key < x.key) {
            return treeSearch(x.left, key);
        } else {
            return treeSearch(x.right, key);
        }
    }

    static Node iterativeTreeSearch(Node x, int key) {
        while (x != null && x.key != key) {
            if (x.key < key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    static Node treeMinimum(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    static Node treeMaximun(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    static Node treeSuccessor(Node x) {
        if (x.right != null) {
            return treeMaximun(x.right);
        }
        Node y = x.p;
        while (y != null && x == y.right) {
            x = y;
            y = y.p;
        }
        return y;
    }

    static Node treePredecessor(Node x) {
        if (x.left != null) {
            return treeMaximun(x.left);
        }
        Node y = x.p;
        while (y != null && x == y.left) {
            x = y;
            y = y.p;
        }
        return y;
    }

    /*
    z contains object with not null key ans lef and right for this object are null
    */
    static Node root(Node x) {
        while (x != null && x.p != null) {
            x = x.p;
        }
        return x;
    }

    static void treeInsert(Node t, Node z) {
        Node y = null;
        Node x = root(t);
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.p = y;
        if (y == null) {
            t = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    static void transplant(Node u, Node v) {
        if (u.p == null) {
            v.p = null;
        } else if (u == u.p.left) {
            u.p.left = v;
        } else {
            u.p.right = v;
        }
        if (v != null) {
            v.p = u.p;
        }
    }

    static void treeDelete(Node z) {
        if (z.left == null) {
            transplant(z, z.right);
        } else if (z.right == null) {
            transplant(z, z.left);
        } else {
            Node y = treeMinimum(z.right);
            if(y.p!=z){
                transplant(y, y.right);
                y.right = z.right;
                y.right.p = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.p = y;
        }
    }
}
