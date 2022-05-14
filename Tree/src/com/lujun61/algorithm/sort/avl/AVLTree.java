package com.lujun61.algorithm.sort.avl;

import com.lujun61.algorithm.sort.Node;
import com.lujun61.algorithm.sort.bst.BST;

/**
 * @description 平衡二叉树相当于是二叉排序树的升级
 * @author Jun Lu
 * @date 2022-05-08 15:01:26
 */

/**  将BST构造为AVLTree。
 * 平衡二叉树的构造触发机制：
 *      当 当前结点的【左子树高度】 小于 【右子树高度】，且差值大于1时，进行左旋转
 *          左旋转步骤：
 *              1、以当前【根结点】的值，创建一个新结点                 newNode(rootNode.val)
 *              2、把当前结点的左子树设置为新结点的左子树               newNode.left = currentNode.left
 *              3、把当前结点的右子树的左子树设置为新结点的右子树        newNode.right = currentNode.right.left
 *              4、将当前结点的右子树的值赋值给当前结点                 currentNode.val = currentNode.right.val
 *              5、把当前结点的右子树的右子树设置为当前结点的右子树      currentNode.right = currentNode.right.right
 *              6、把新结点设置为当前结点的左子树                      currentNode.left = newNode
 */
public class AVLTree extends BST {
    public AVLTree() {
    }

    public AVLTree(Node root) {
        super(root);
    }

}














