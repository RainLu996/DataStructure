package com.lujun61.algorithm.hashtable;

/**
 * @description 存放Student学生类型的链表
 * @author Jun Lu
 * @date 2021-08-19 20:09:18
 */
public class StudentLinkedList {
    private Student head;

    /**
     * @param stu 传入的Student类型的数据
     * @return void
     * @description 给哈希表中的链表添加值
     * @author Jun Lu
     * @date 2021-08-19 19:27:51
     */
    public void add(Student stu) {
        if (head == null) {
            head = stu; //哈希表中不要求有头结点，所以将头结点也赋上具体的值
            return;
        }

        /*不可取（不知道为什么）
        Student temp = head.next;
        while (temp != null) {
            temp = temp.next;
        }
        temp = stu;*/

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = stu;
    }

    /**
     * @param no 哈希表中的数组编号（通过哈希函数算出来的结果）
     * @return void
     * @description 遍历输出哈希表中所有的数据
     * @author Jun Lu
     * @date 2021-08-19 19:40:20
     */
    public void traverse(int no) {
        if (head == null) {
            System.out.print("第<" + no + ">条链表为空！");
        }

        Student temp = head;
        while (temp != null) {
            System.out.print("学生编号为：" + temp.id + "，学生姓名为：" + temp.name + "\t");

            temp = temp.next;
        }

        System.out.println();
    }

    /**
     * @param id 学员编号
     * @return com.lujun61.algorithm.hashtable.Student
     * @description 根据学员编号查询对应的结点
     * @author Jun Lu
     * @date 2021-08-19 19:47:26
     */
    public Student findByID(int id) {
        if (head == null) {
            throw new DoNotElementException("此链表为空！");
        }

        Student temp = head;
        while (temp != null) {
            if (this.head.id == id) {
                return temp;
            }

            temp = temp.next;
        }
        return null;
    }
}
