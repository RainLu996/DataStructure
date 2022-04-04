package com.lujun61.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Goal {
    public static void main(String[] args) {

        //存放所有地区的集合
        ArrayList<String> areaList = new ArrayList<>();
        areaList.add("北京");
        areaList.add("上海");
        areaList.add("天津");
        areaList.add("广州");
        areaList.add("深圳");
        areaList.add("成都");
        areaList.add("杭州");
        areaList.add("大连");

        //电台1
        HashSet<String> area1 = new HashSet<>();
        area1.add("北京");
        area1.add("上海");
        area1.add("天津");

        //电台2
        HashSet<String> area2 = new HashSet<>();
        area2.add("广州");
        area2.add("北京");
        area2.add("深圳");

        //电台3
        HashSet<String> area3 = new HashSet<>();
        area3.add("成都");
        area3.add("上海");
        area3.add("杭州");

        //电台4
        HashSet<String> area4 = new HashSet<>();
        area4.add("天津");
        area4.add("上海");

        //电台5
        HashSet<String> area5 = new HashSet<>();
        area5.add("杭州");
        area5.add("大连");


        //存储广播台和覆盖范围的关系
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        broadcasts.put("K1", area1);
        broadcasts.put("K2", area2);
        broadcasts.put("K3", area3);
        broadcasts.put("K4", area4);
        broadcasts.put("K5", area5);

        //用于存储符合要求（最优）的电台
        ArrayList<String> keyList = new ArrayList<>();

        //用于存储与每一轮遍历areaList所得到的交集最多的电台
        String key = null;
        //用于临时存储电台覆盖的城市
        HashSet<String> temp = new HashSet<>();

        int preKeySize = 0;

        //结束条件是areaList没有任何数据，即说明每个城市都被覆盖了。
        while (!areaList.isEmpty()) {

            for (String broadcastKey : broadcasts.keySet()) {
                //清空temp临时存储的变量
                temp.clear();
                //将当前电台覆盖的城市添加到临时存储的变量中
                temp.addAll(broadcasts.get(broadcastKey));
                //temp与areaList集合取交集，交集结果再赋值给temp
                temp.retainAll(areaList);

                //判断temp大小是否大于0，以及key值是否为空.如果不为空就判断本轮的交集大小是否大于上一次存储的key
                //key值对应的电台覆盖城市，大于就重新赋值新的最优结果
                /*  贪心：temp.size() > broadcasts.get(key).size())---->每次只选取【最优的解】保存 */
                if (temp.size() > 0 && (key == null || temp.size() > preKeySize)) {
                    key = broadcastKey;
                    preKeySize = temp.size();
                }
            }

            /*
                一轮遍历完之后，判断key是否为空，不为空就将key存储keyList集合中，表示符合要求的电台。最后
                讲符合要求的电台所覆盖的城市从areaList集合中移除掉，说明这些城市已经被覆盖。
             */
            if (key != null) {
                keyList.add(key);
                areaList.removeAll(broadcasts.get(key));
                key = null;
            }

        }

        System.out.println(keyList.toString());

    }

}
