package com.lujun61.algorithm.sort;

public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 为了复用BST的逻辑代码，将AVL的逻辑代码加到此处
     * 平衡二叉树逻辑代码
     * AVL介绍：https://blog.csdn.net/jarvan5/article/details/112428036
     */


    /**
     * @return int
     * @description 返回以当前结点为根结点的树的高度
     * @author Jun Lu
     * @date 2022-05-08 14:50:21
     */
    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
    }

    public int leftHeight() {
        if (this.left == null) {
            return 0;
        }

        return this.left.height();
    }

    public int rightHeight() {
        if (this.right == null) {
            return 0;
        }

        return this.right.height();
    }

     /** 左旋转步骤：
      *    1、以当前【根结点】的值，创建一个新结点                 newNode(rootNode.val)
      *    2、把当前结点的左子树设置为新结点的左子树               newNode.left = currentNode.left
      *    3、把当前结点的右子树的左子树设置为新结点的右子树        newNode.right = currentNode.right.left
      *    4、将当前结点的右子树的值赋值给当前结点                 currentNode.val = currentNode.right.val
      *    5、把当前结点的右子树的右子树设置为当前结点的右子树      currentNode.right = currentNode.right.right
      *    6、把新结点设置为当前结点的左子树                      currentNode.left = newNode
      */
    public void leftRotate() {
        // 1、以当前【根结点】的值，创建一个新结点                 newNode(rootNode.val)
        Node newNode = new Node(this.value);

        //2、把当前结点的左子树设置为新结点的左子树               newNode.left = currentNode.left
        newNode.left = this.left;

        //3、把当前结点的右子树的左子树设置为新结点的右子树        newNode.right = currentNode.right.left
        newNode.right = this.right.left;

        //4、将当前结点的右子树的值赋值给当前结点                 currentNode.val = currentNode.right.val
        this.value = this.right.value;

        //5、把当前结点的右子树的右子树设置为当前结点的右子树      currentNode.right = currentNode.right.right
        this.right = this.right.right;

        //6、把新结点设置为当前结点的左子树                      currentNode.left = newNode
        this.left = newNode;
    }

    /** 右旋转步骤：
     *    1、以当前【根结点】的值，创建一个新结点                 newNode(rootNode.val)
     *    2、把当前结点的右子树设置为新结点的右子树               newNode.right = currentNode.right
     *    3、把当前结点的左子树的右子树设置为新结点的左子树        newNode.left = currentNode.left.right
     *    4、将当前结点的左子树的值赋值给当前结点                 currentNode.val = currentNode.left.val
     *    5、把当前结点的左子树的左子树设置为当前结点的左子树      currentNode.left = currentNode.left.left
     *    6、把新结点设置为当前结点的右子树                      currentNode.right = newNode
     */
    public void rightRotate() {
        // 1、以当前【根结点】的值，创建一个新结点                 newNode(rootNode.val)
        Node newNode = new Node(this.value);

        //2、把当前结点的右子树设置为新结点的右子树               newNode.right = currentNode.right
        newNode.right = this.right;

        //3、把当前结点的左子树的右子树设置为新结点的左子树        newNode.left = currentNode.left.right
        newNode.left = this.left.right;

        //4、将当前结点的左子树的值赋值给当前结点                 currentNode.val = currentNode.left.val
        this.value = this.left.value;

        //5、把当前结点的左子树的左子树设置为当前结点的左子树      currentNode.left = currentNode.left.left
        this.left = this.left.left;

        //6、把新结点设置为当前结点的右子树                      currentNode.right = newNode
        this.right = newNode;
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


    /**
     * BST逻辑代码
     */

    /**
     * @param node 待插入的结点
     * @description 添加元素（构建顺序二叉树）
     * @author Jun Lu
     * @date 2022-04-18 08:55:12
     */
    public void addNode(Node node) {
        if (node == null) {
            return;
        }

        // 左小右大
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else this.left.addNode(node);
        } else {  // >= 当前结点的结点都放在右子树
            if (this.right == null) {
                this.right = node;
            } else this.right.addNode(node);
        }


        /**
         * AVL树逻辑处理部分：左旋
         */
        /**
         * 基于左旋的双旋触发条件
         *      当前结点的右子树的 左子树的高度大于右子树高度
         *      此时，先对当前结点的右子树进行右旋，再对当前结点进行左旋
         */
        /* 注意：是递归！所以最后的this指向的是 root！（即：回退至root） */
        if (this.rightHeight() - this.leftHeight() > 1) {
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()) {
                this.right.rightRotate();
            }

            this.leftRotate();

            // 当前结点（此棵树）已经被平衡处理完毕，就不需要继续向下（右旋）考虑了。    及时return掉！！！
            return;
        }

        /**
         * AVL树逻辑处理部分：右旋
         */
        /**
         * 基于右旋的双旋触发条件:
         *      当前结点的左子树的 右子树的高度大于左子树高度
         *      此时，先对当前结点的左子树进行左旋，再对当前结点进行右旋
         */
        /* 注意：是递归！所以最后的this指向的是 root！（即：回退至root） */
        if (this.leftHeight() - this.rightHeight() > 1) {
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                this.left.leftRotate();
            }

            this.rightRotate();
        }
    }

    /**
     * 中序遍历
     */
    public void midTraverse() {
        if (this.left != null) {
            this.left.midTraverse();
        }

        System.out.print(this.value + " ");

        if (this.right != null) {
            this.right.midTraverse();
        }
    }

    /**
     * @param val 目标结点的val值
     * @return com.lujun61.algorithm.sort.Node 查找到的结点
     * @description 根据指定val值查找目标结点
     * @author Jun Lu
     * @date 2022-04-18 09:06:46
     */
    public Node selectNodeByVal(int val) {
        if (this.value == val) {
            return this;
        }

        if (val < this.value && this.left != null) {
            return this.left.selectNodeByVal(val);
        } else if (val >= this.value && this.right != null) {  // 与addNode方法的逻辑相对应  >= 当前结点value的，去当前结点的右子树上找
            return this.right.selectNodeByVal(val);
        } else return null;
    }


    /**
     * @param val 目标结点的val值
     * @return com.lujun61.algorithm.sort.Node 目标结点的父结点
     * @description 查找目标结点的父结点
     * @author Jun Lu
     * @date 2022-04-18 09:35:21
     */
    public Node selectNodeParentByVal(int val) {
        if ((this.left != null && this.left.value == val)
                || (this.right != null && this.right.value == val)) {
            return this;
        }

        if (val < this.value && this.left != null) {
            return this.left.selectNodeParentByVal(val);
        } else if (val >= this.value && this.right != null) {  // 与addNode方法的逻辑相对应  >= 当前结点value的，去当前结点的右子树上找
            return this.right.selectNodeParentByVal(val);
        } else return null;

    }

    public void deleteNode(int val) {
        Node tagNode = selectNodeByVal(val);
        Node tagParentNode = selectNodeParentByVal(val);

        // 没有对应的结点
        if (tagNode == null) return;

        if (tagNode.left == null && tagNode.right == null) {  // 目标结点左右子树为空：即-->该目标结点为叶子结点
            // 通过目标结点的父结点来删除目标结点
            // 判断是父结点的左子树还是右子树
            if (tagParentNode.left != null && tagParentNode.left.value == val) {  // 如果是左子树
                tagParentNode.left = null;
            } else if (tagParentNode.right != null && tagParentNode.right.value == val) {  // 如果是右子树
                tagParentNode.right = null;
            }

            // 将 右子树的最小值 或者 左子树的最大值 赋值给tagNode的value；还得删除拥有 最小/最大值 的结点
        } else if (tagNode.left != null && tagNode.right != null) { // 目标结点左右子树不为空：即-->该目标结点有两颗左右子树
            tagNode.value = delRightMinNode(tagNode.right);
        } else {  //目标结点只有一颗子树
            if (tagNode.left != null) {
                tagNode.value = delLeftMaxNode(tagNode.left);
            } else {
                tagNode.value = delRightMinNode(tagNode.right);
            }
        }
    }

    /**
     * @param node 起点结点
     * @return int 子树中最小结点的value值
     * @description 删除右子树中最小的结点；并将此结点的value值返回
     * @author Jun Lu
     * @date 2022-04-22 09:53:08
     */
    public int delRightMinNode(Node node) {
        Node temp = node;

        //BST的最深左叶子结点即为BST中最小的结点
        while (temp.left != null) {
            temp = temp.left;
        }

        deleteNode(temp.value);

        return temp.value;
    }


    /**
     * @param node 起点结点
     * @return int 子树中最大结点的value值
     * @description 删除左子树中最大的结点；并将此结点的value值返回
     * @author Jun Lu
     * @date 2022-04-22 09:53:08
     */
    public int delLeftMaxNode(Node node) {
        Node temp = node;

        //BST的最深右叶子结点即为BST中最大的结点
        while (temp.right != null) {
            temp = temp.right;
        }

        deleteNode(temp.value);

        return temp.value;
    }


}
