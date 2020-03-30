package tree;

public class BSTree {


    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        bsTree.put(16);
        bsTree.put(14);
        bsTree.put(35);
        bsTree.put(12);
        bsTree.put(15);
        bsTree.put(25);
        bsTree.put(40);
        bsTree.put(10);
        bsTree.put(20);
        bsTree.put(27);
        bsTree.put(38);
        bsTree.put(41);
        bsTree.put(26);
        bsTree.put(30);
        bsTree.put(39);

//        bsTree.delete2(25);
        System.out.println(bsTree.parent);

    }


    Node parent;


    public Node test() {
        Node g = this.parent;
        while (g.left != null) {
            if (g.left != null) {
                g.left.value = 0;
                g = g.left;
            }
        }
        return g;
    }

    public boolean delete(int value) {
        Node target = this.parent;
        Node target_parent = null;

        while (target != null) {
            if (target.value > value) {
                target_parent = target;
                target = target.left;
            } else if (target.value < value) {
                target_parent = target;
                target = target_parent.right;
            } else break;
        }

        if (target == null) {
            return false;
        }

        if (target.left != null && target.right != null) {
            Node right_tree = target.right;
            Node right_tree_parent = null;
            while (right_tree.left != null) {
                right_tree_parent = right_tree;
                right_tree = right_tree.left;
            }

            target.value = right_tree.value;
            target = right_tree;
            target_parent = right_tree_parent;
        }

        Node children = null;

        if (target.left != null) {
            children = target.left;
        } else if (target.right != null) {
            children = target.right;
        }

        if (target_parent == null) {
            parent = target;
        } else if (target_parent.left == target) {
            target_parent.left = children;
        } else target_parent.right = children;
        return true;
    }



























   /* public void delete2(int value) {
        Node p = this.parent;
        Node p_parent = null;
        //找出该结点与其父结点
        while (p != null) {
            if (p.value > value) {
                p_parent = p;
                p = p.left;
            } else if (p.value < value) {
                p_parent = p;
                p = p.right;
            } else break;
        }

        if (p == null) {
            return;
        }
        Node child = null;
        //若该结点拥有两个子结点的情况下，遍历找出右子树中值最小的结点作为该节点的值，并修改父结点指针
        if (p.left != null && p.right != null) {
            Node rTree = p.right;
            Node rTree_parent = p;
            while (rTree.left != null) {
                rTree_parent = rTree;
                rTree = rTree.left;
            }

            //p指向了右子树中值最小的结点
            p.value = rTree.value;
            p = rTree;
            p_parent = rTree_parent;

        }

        //若该结点只有一个子结点的情况下，把要删除的结点的值改为其子结点的值即可
        if (p.right != null) {
            child = p.right;
        } else if (p.left != null) {
            child = p.left;
        }

        //执行删除
        if (p_parent == null) {
            parent = child;
        } else if (p_parent.left == p) {
            p_parent.left = child;
        } else {
            p_parent.right = child;
        }

    }*/

    public Node find(int value) {
        //因为当top.value大于或者小于value时，执行的语句是top = top.right或者 top = top.left，
        // top不再指向this.parent，top仅仅是指向的结点不同，并没有对结点的参数作任何修改
        //所以成员变量this.parent的值也不会有任何修改
        Node top = this.parent;
        while (top != null) {
            if (top.value < value) {
                top = top.right;
            } else if (top.value > value) {
                top = top.left;
            } else {
                return top;
            }
        }
        return top;
    }

    public boolean put(int value) {

        if (parent == null) {
            parent = createNode(value);
            return true;
        }
        Node pt = this.parent;

        while (pt != null) {
            if (pt.value > value) {
                if (pt.left == null) {
                    pt.left = createNode(value);
                    return true;
                }
                pt = pt.left;
            } else if (pt.value < value) {
                if (pt.right == null) {
                    pt.right = createNode(value);
                    return true;
                }
                pt = pt.right;
            }
        }
        return false;
    }


    private Node createNode(Node left, int value, Node right) {
        return new Node(left, value, right);
    }


    private Node createNode(int value) {
        return new Node(null, value, null);
    }


    private static class Node {
        private int value;

        private Node left;
        private Node right;

        protected Node(Node left, int value, Node right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
