package com.lujun61.algorithm.huffman.code;

import java.util.*;

/**
 * @description 哈夫曼编码的结点类
 * @author Jun Lu
 * @date 2022-03-05 15:42:19
 */
public class HuffmanCodeTree {
    /**
     * @param dataArrays 字符数组
     * @description 统计各个字符出现的次数；制造单独的结点
     * @author Jun Lu
     * @date 2022-03-05 19:33:01
     */
    public List<HuffmanCodeNode> getNodeWeight(Byte[] dataArrays) {
        /**
         * key---字符
         * value---出现次数
         */
        Map<Byte, Integer> counts = new HashMap<>();

        /* 赋值 */
        for (Byte data : dataArrays) {
            Integer count = counts.get(data);
            if (count == null) {
                counts.put(data, 1);
            } else counts.put(data, count + 1);
        }

        /* 创建结点对象 */
        List<HuffmanCodeNode> nodes = new LinkedList<>();
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanCodeNode(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }



    /* To be continue~ */
}
