package com.lujun61.dataStructure.linked;

import com.lujun61.dataStructure.runtimeException.DoNotMatchingException;
import com.lujun61.dataStructure.runtimeException.LinkedListIsEmptyException;

/*
    根据带有头部的单链表，实现商品增删改查，并且针对商品id进行从小到大排序，完成排行榜
 */
//总结：涉及到两个结点时，带上next;未然则不带
public class LinkedList {
    private final Node head = new Node(0, null, 0.0);

    /**
     * 直接将结点进行尾插
     * @param node 将插入的目标结点
     */
    public void tailInsert(Node node) {
        Node temp = this.head;//为了不改变head指针的值

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 按照商品id值从小到大进行插入
     * @param node 将插入的目标结点
     */
    public void upForIdInsert(Node node) {
        //此布尔标记是把关商品id是否重复
        Node temp = this.head;
        boolean isRepeat = false;
        while (temp.next != null) {
            if (temp.next.id > node.id) {//如果下一个结点的id大于当前结点，则退出循环，往当前结点后插入值
                break;
            } else if(temp.next.id == node.id){//如果两结点id相等，则重复了，这里就需要去重了
                isRepeat = true;
                break;
            }
            temp = temp.next;
        }

        if (isRepeat) {
            //throw new ProductRepeatException("此商品已存在！");
            return; //如果不想抛出异常，直接return掉（无操作）即可
        } else {
            //往当前结点后插入值（即：替换掉原先的结点）
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 判断当前链表是否为空
     * @return 如果为空则返回true，不为空则返回false
     */
    public boolean isEmpty() {
        return this.head.next == null;
    }

    /**
     * 修改结点
     * 1、先找到链表中的目标结点
     * 2、根据新的数据进行修改
     * 3、根据商品编号进行查找
     * @param node 目标修改的结点模式
     */
    public void updateList(Node node) {
        Node temp = this.head;
        if (this.isEmpty()) {
            throw new LinkedListIsEmptyException("链表为空！");
        }

        boolean isMatch = false;//设置布尔标记，若匹配到对应的结点，则修改为true
        while (temp != null) {
            if (temp.id == node.id) {
                isMatch = true;
                break;
            }
            temp = temp.next;
        }

        if (isMatch) {
            //找到了目标结点，则修改数据
            temp.name = node.name;
            temp.price = node.price;
        }  else {
            throw new DoNotMatchingException("未在链表中找到目标结点！");
        }
    }

    /**
     * 删除指定结点
     * @param id 目标删除结点的id
     */
    public void deleteNode(int id) {
        Node temp = this.head;
        boolean isMatch = false;

        while (temp.next != null) {//temp是被删除结点(temp.next)前的结点，如果被删除结点(temp.next)不存在，那就是没找到
            if (temp.next.id == id) {
                isMatch = true;
                break;
            }
            temp = temp.next;
        }

        if (isMatch) {
            temp.next = temp.next.next;
        } else {
            throw new DoNotMatchingException("未在链表中找到目标结点！");
        }
    }

    /**
     * 遍历输出链表中的所有元素
     */
    public void traverse() {
        if (this.isEmpty()) {
            throw new LinkedListIsEmptyException("链表为空！");
        }

        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    /**
     * 统计链表中的元素个数
     * @return 返回链表中的元素个数
     */
    public int getListLength() {
        if (this.isEmpty()) {
            throw new LinkedListIsEmptyException("链表为空！");
        }

        int count = 0;
        Node temp = this.head;
        while (temp.next != null) {//不算头结点
            temp = temp.next;
            count++;
        }

        return count;
    }
}