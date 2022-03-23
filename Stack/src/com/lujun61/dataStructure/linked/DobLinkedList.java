package com.lujun61.dataStructure.linked;

import com.lujun61.dataStructure.runtimeException.DoNotMatchingException;
import com.lujun61.dataStructure.runtimeException.LinkedListIsEmptyException;
import com.lujun61.dataStructure.runtimeException.ProductRepeatException;

public class DobLinkedList {
    DobNode head = new DobNode(0, null, 0.0);

    /**
     * 尾插
     */
    public void addTail(DobNode node) {
        DobNode temp = this.head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 升序插
     */
    public void addOrderUp(DobNode node) {
        DobNode temp = this.head;
        boolean isRepeat = false;

        while (temp.next != null) {
            if (temp.next.id > node.id) {
                break;
            }
            if (temp.id == node.id) {
                isRepeat = true;//如果两结点重复了，则需要去重
                break;
            }
            temp = temp.next;
        }

        if (isRepeat) {
            throw new ProductRepeatException("此商品已存在！");
        } else {
            //处理后置结点
            node.next = temp.next;
            temp.next = node;

            //处理前置结点
            temp.next.pre = node;
            node.pre = temp;
        }
    }

    /**
     * 判断是否为空
     * @return 为空返回true，否则返回false
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 修改结点
     */
    public void updateNode(DobNode node) {
        if (this.isEmpty()) {
            throw new LinkedListIsEmptyException("链表为空！");
        }

        DobNode temp = this.head.next;
        boolean flg = false;

        while (temp != null) {
            if (temp.id == node.id) {
                flg = true;
                break;
            }
            temp = temp.next;
        }

        if (flg) {
            temp.name = node.name;
            temp.price = node.price;
        } else {
            throw new DoNotMatchingException("未找到相匹配的结点！");
        }
    }

    /**
     * 删除结点
     * @param id 只需要传入结点id即可（结点有着唯一性）
     */
    public void deleteNode(int id) {
        DobNode temp = this.head.next;
        boolean flg = false;

        while (temp != null) {
            if (temp.id == id) {
                flg = true;
                break;
            }
            temp = temp.next;
        }

        if (flg) {
            temp.pre.next = temp.next;
            if (temp.next != null) {//如果后继结点不存在，则：temp.next == null; null.pre ==> NullPointerException!
                temp.next.pre = temp.pre;
            }
        } else {
            throw new DoNotMatchingException("未找到指定的元素！");
        }
    }

    /**
     * 遍历输出所有元素
     */
    public void traverse() {
        DobNode temp = this.head.next;

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 统计链表中所有元素的个数
     * @return 返回链表中所有元素的个数
     */
    public int getLength() {
        DobNode temp = this.head.next;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
