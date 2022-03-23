package com.lujun61.algorithm.tree;

/**
 * @description 树结点
 * @author Jun Lu
 * @date 2021-08-20 19:08:05
 */
public class Node {
    private int no;
    private String name;

    private Node left;
    private Node right;

    public Node() {
    }

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "no=" + no +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * @return void
     * @description 前序遍历树结点
     * @author Jun Lu
     * @date 2021-08-20 19:19:50
     */
    public void preTraverse() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preTraverse();
        }

        if (this.right != null) {
            this.right.preTraverse();
        }
    }

    /**
     * @return void
     * @description 中序遍历树结点
     * @author Jun Lu
     * @date 2021-08-20 19:21:44
     */
    public void midTraverse() {
        if (this.left != null) {
            this.left.midTraverse();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.midTraverse();
        }
    }

    /**
     * @return void
     * @description 后序遍历树结点
     * @author Jun Lu
     * @date 2021-08-20 19:22:05
     */
    public void postTraverse() {
        if (this.left != null) {
            this.left.postTraverse();
        }

        if (this.right != null) {
            this.right.postTraverse();
        }

        System.out.println(this);
    }

    /**
     * @param id 目标元素的id
     * @return com.lujun61.algorithm.tree.Node
     * @description 前序遍历的形式查找结点
     * @author Jun Lu
     * @date 2021-08-20 20:39:51
     */
    public Node preSearchNodeById(int id) {
        Node node = null;

        if (this.no == id) {//当前结点等于id则返回
            return this;
        }

        if (this.left != null) {//当前结点左子树不为空，则继续递归遍历
            if((node = this.left.preSearchNodeById(id)) != null) {
                return node;
            }
        }

        if (this.right != null) {//当前结点右子树不为空，则继续递归遍历
             node = this.right.preSearchNodeById(id);
        }
        return node;
    }

    /**
     * @param id 目标元素的id
     * @return com.lujun61.algorithm.tree.Node
     * @description 中序遍历的形式查找结点
     * @author Jun Lu
     * @date 2021-08-20 20:39:51
     */
    public Node midSearchNodeById(int id) {
        Node node = null;

        if (this.left != null) {
            if((node = this.left.preSearchNodeById(id)) != null) {
                return node;
            }
        }

        if (this.no == id) {
            return this;
        }

        if (this.right != null) {
            node = this.right.midSearchNodeById(id);
        }
        return node;
    }

    /**
     * @param id 目标元素的id
     * @return com.lujun61.algorithm.tree.Node
     * @description 后序遍历的形式查找结点
     * @author Jun Lu
     * @date 2021-08-20 20:39:51
     */
    public Node postSearchNodeById(int id) {
        Node node = null;

        if (this.left != null) {
            if((node = this.left.preSearchNodeById(id)) != null) {
                return node;
            }
        }

        if (this.right != null) {
            if((node = this.right.preSearchNodeById(id)) != null) {
                return node;
            }
        }

        if (this.no == id) {
            return this;
        }
        return node;
    }

    /**
     * @param id 传入的结点id
     * @return void
     * @description 根据结点id删除结点    【只能通过当前结点的左右结点来删除对应的结点】
     * @author Jun Lu
     * @date 2021-08-23 19:14:17
     */
    public void deleteNode(int id) {
        if (this.left != null && this.left.no == id) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == id) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.deleteNode(id);
        }

        if (this.right != null) {
            this.right.deleteNode(id);
        }
    }
}