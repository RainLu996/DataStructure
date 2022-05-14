package com.lujun61.arrays.compare.test;

import com.lujun61.arrays.compare.test.pojo.Student;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // 创建四个学生对象 存储到集合中
        ArrayList<Student> list = new ArrayList<Student>();

        list.add(new Student("rose",18));
        list.add(new Student("jack",16));
        list.add(new Student("abc",16));
        list.add(new Student("ace",17));
        list.add(new Student("mark",16));


        /*
          让学生 按照年龄排序 升序
         */
        //Collections.sort(list);//要求 该list中元素类型  必须实现比较器Comparable接口


        list.sort((o1, o2) -> {
            // 年龄降序
            int result = o2.getAge() - o1.getAge();//年龄降序
            if (result == 0) {//第一个规则判断完了 下一个规则 姓名的首字母 升序
                result = o1.getName().charAt(0) - o2.getName().charAt(0);
            }
            return result;
        });
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
