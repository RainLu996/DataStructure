package com.lujun61.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
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

        HashSet<String> temp = new HashSet<>();
        ArrayList<String> ansArea = new ArrayList<>();
        String key = null;
        int preKeySize = 0;
        while (!areaList.isEmpty()) {

            for (String broadcastKey : broadcasts.keySet()) {
                temp.clear();
                temp.addAll(broadcasts.get(broadcastKey));
                temp.retainAll(areaList);
                if (temp.size() > 0 && (key == null || temp.size() > preKeySize)) {
                    key = broadcastKey;
                    preKeySize = temp.size();
                }
            }

            if (key != null) {
                ansArea.add(key);
                areaList.removeAll(broadcasts.get(key));
                key = null;
            }
        }

        System.out.println(ansArea);
    }

}
