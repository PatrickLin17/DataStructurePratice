package tree;

import org.junit.Test;

public class AvlTree<T extends Comparable> {
    //定义平衡二叉树根结点
    private AvlNode tree ;


    /**
     * 计算一个结点的高度
     */



    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
      /*  avlTree.insert(tree, 10);
        avlTree.insert(tree, 12);
        avlTree.insert(tree, 10);
        avlTree.insert(tree, 10);*/
        tree.insert(10);
        tree.insert(12);

        System.out.println(tree);
    }

    private void test(AvlNode avlNode) {
        if (avlNode == null) {
            avlNode = new AvlNode();

        }
        avlNode.setData(5);

    }

    private int height(AvlNode node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 计算AVL树的高度
     *
     * @return
     */
    public int height() {
        return height(tree);
    }

    /**
     * 采用中序遍历
     *
     * @param node
     */

    public void inOrder(AvlNode node) {
        //递归调用，如果遇到左或者右为空就跳出递归
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.getData() + "-->");
        inOrder(node.right);
    }

    @Override
    public String toString() {
        inOrder(tree);
        return "";
    }

    private int getMax(int h1, int h2) {
        return h1 > h2 ? h1 : h2;
    }


    /**
     * ll旋转
     *
     * @param node 失衡的结点
     * @return 左左旋转后的根结点
     */
    public AvlNode ll(AvlNode node) {
        AvlNode node_left = node.left;
        node.left = node_left.right;
        node_left.right = node;

        node.height = getMax(height(node_left), height(node.right)) + 1;
        node_left.height = getMax(height(node_left.left), height(node_left.right)) + 1;
        return node_left;

    }

    /**
     * rr旋转
     *
     * @param node 失衡的结点
     * @return 右右旋转后的根结点
     */
    public AvlNode rr(AvlNode node) {
        AvlNode node_right = node.right;
        node.left = node_right.left;
        node_right.left = node;

        node.height = getMax(height(node.left), height(node.right)) + 1;
        node_right.height = getMax(height(node_right.right), height(node_right.left)) + 1;
        return node_right;
    }

    /**
     * LR 旋转
     *
     * @param node
     * @return
     */
    public AvlNode lr(AvlNode node) {
        //RR
        node.left = rr(node.left);
        //LL
        AvlNode avlNode = ll(node);
        return avlNode;
    }

    /**
     * RL 旋转
     *
     * @param node
     * @return
     */
    public AvlNode rl(AvlNode node) {
        //LL
        node.right = ll(node.right);
        //RR
        AvlNode avlNode = ll(node);
        return avlNode;
    }


    private void insert(T data){
        insert(this.tree,data);
    }

    private AvlNode insert(AvlNode avlNode, T data) {
        if (this.tree == null) {
            this.tree = new AvlNode(data);
        } else {
            int compared = data.compareTo(this.tree.getData());
            if (compared > 0) {
                this.tree.right = insert(this.tree.right, data);
                if (height(this.tree.right) - height(this.tree.left) == 2) {
                    if (data.compareTo(this.tree.right.getData()) > 0) {
                        //RR
                        this.tree = this.rr(this.tree);
                    } else {
                        //RL
                        this.tree = this.rl(this.tree);
                    }
                }
            } else if (compared < 0) {
                this.tree.left = insert(this.tree.left, data);
                if (height(this.tree.left) - height(this.tree.right) == 2) {
                    if (data.compareTo(this.tree.left.getData()) > 0) {
                        //LR
                        this.tree = this.lr(this.tree);
                    } else {
                        //LL
                        this.tree = this.ll(this.tree);
                    }
                }
            } else {
                return this.tree;
            }
        }
        this.tree.height = getMax(height(this.tree.left), height(this.tree.right)) + 1;
        return this.tree;
    }


    class AvlNode<T extends Comparable> {
        //存放数据
        private T data;

        //左子结点
        private AvlNode<T> left;
        //右子结点
        private AvlNode<T> right;
        //结点高度
        private int height;

        public AvlNode() {
        }

        public AvlNode(T data, AvlNode<T> left, AvlNode<T> right, int height) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = height;
        }

        public AvlNode(T data, AvlNode<T> left, AvlNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public AvlNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public AvlNode<T> getLeft() {
            return left;
        }

        public void setLeft(AvlNode<T> left) {
            this.left = left;
        }

        public AvlNode<T> getRight() {
            return right;
        }

        public void setRight(AvlNode<T> right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
