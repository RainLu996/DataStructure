package com.lujun61.algorithm.threaded;

/**
 * @description 线索化二叉树结点
 * @author Jun Lu
 * @date 2021-08-24 13:58:02
 */
public class ThreadedNode {
    private int no;
    private String name;
    private ThreadedNode left;
    private ThreadedNode right;

    private int preNum = 0; //值为0：有左右叶子结点   值为1：没有左右叶子结点，设置了前驱结点   值为3：为第一个前驱为空的结点
    private int sucNum = 0; //值为0：有左右叶子结点   值为2：没有左右叶子结点，设置了后继结点

    public ThreadedNode() {
    }

    public ThreadedNode(int no, String name) {
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

    public ThreadedNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedNode left) {
        this.left = left;
    }

    public ThreadedNode getRight() {
        return right;
    }

    public void setRight(ThreadedNode right) {
        this.right = right;
    }

    public int getPreNum() {
        return preNum;
    }

    public void setPreNum(int preNum) {
        this.preNum = preNum;
    }

    public int getSucNum() {
        return sucNum;
    }

    public void setSucNum(int sucNum) {
        this.sucNum = sucNum;
    }

    @Override
    public String toString() {
        return "ThreadedNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * @param id 删除的目标结点的no值
     * @return void
     * @description  删除结点（自己不能删除自己，所以通过当前结点的上一个结点来删除自己）
     * @author Jun Lu
     * @date 2021-08-24 14:06:44
     */
    public void deleteNode(int id) {
        /**
         * 如果查询到了对应的子树，就通过它的上级将它置为null
         * 否则：继续向左、向右进行递归遍历
         */
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

    /**
     * @return void
     * @description 前序遍历
     * @author Jun Lu
     * @date 2021-08-24 14:17:28
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
     * @description 中序遍历
     * @author Jun Lu
     * @date 2021-08-24 14:17:28
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
     * @description 后序遍历
     * @author Jun Lu
     * @date 2021-08-24 14:17:28
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
     * @param id 目标结点的no值
     * @return com.lujun61.algorithm.threaded.ThreadedNode
     * @description 以前序遍历的方式，根据结点no值查找对应的结点
     * @author Jun Lu
     * @date 2021-08-24 15:05:03
     */
    public ThreadedNode searchById(int id) {
        ThreadedNode node = null;

        if (this.no == id) {
            return this;
        }

        if (this.left != null) {
            if ((node = this.left.searchById(id)) != null) {
                return node;
            }
        }

        if (this.right != null) {
            node = this.right.searchById(id);
        }
        return node;
    }
}
