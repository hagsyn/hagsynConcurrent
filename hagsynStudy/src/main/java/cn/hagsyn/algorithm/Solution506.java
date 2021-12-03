package cn.hagsyn.algorithm;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * [506] 相对名次
 *
 * @author Hagsyn
 * @date 2021/12/2
 */
public class Solution506 {
    public static String[] findRelativeRanks(int[] score) {
        String[] retScore = new String[score.length];
//        键：值  值：索引
        Map<Integer, Integer> scoreMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < score.length; i++) {
            scoreMap.put(score[i], i);
            retScore[i] = score[i] + "";
        }
        AtomicInteger sortNum = new AtomicInteger(1);
        scoreMap.forEach((sco, index) -> {
            String sortStr = sortNum.get() + "";
            switch (sortNum.get()) {
                case 1:
                    sortStr = "Gold Medal";
                    break;
                case 2:
                    sortStr = "Silver Medal";
                    break;
                case 3:
                    sortStr = "Bronze Medal";
                    break;
                default:
                    break;
            }
            retScore[index] = sortStr;
            sortNum.getAndIncrement();
        });
        return retScore;
    }

    public static String[] findRelativeRanks2(int[] score) {
        //将数组转换为集合
        List scoreList = Arrays.stream(score).boxed().collect(Collectors.toList());
//        List scoreList = new ArrayList();
        Collections.addAll(scoreList, score);
        scoreList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int) o2 - (int) o1;
            }
        });
        String[] retScore = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int sortNum = i - (i - scoreList.indexOf(score[i])) + 1;
            String sortStr = sortNum + "";
            switch (sortNum) {
                case 1:
                    sortStr = "Gold Medal";
                    break;
                case 2:
                    sortStr = "Silver Medal";
                    break;
                case 3:
                    sortStr = "Bronze Medal";
                    break;
                default:
                    break;
            }
            retScore[i] = sortStr;
        }
        return retScore;
    }

    public static String[] findRelativeRanks3(int[] score) {
        String[] strs = new String[score.length];

        int maxNum = score[0];
        // 找到 nums 数组中的最大值
        for (int i : score) {
            maxNum = Math.max(maxNum, i);
        }
        // 创建哈希映射数组
        int[] bucket = new int[maxNum + 1];
        // 遍历 nums 数组，bucket 索引为 nums 元素，索引上的值为是否出现的标志
        for (int i : score) {
            bucket[i] = 1;
        }
        // 变量 j 定义名次
        int j = 1;
        // 在 bucket 数组中对出现的元素进行排序，从 1 开始
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] > 0) {
                bucket[i] = j++;
            }
        }
        // 遍历 nums 数组，根据元素值在 bucket 数组中取值，数值即为名次
        for (int i = 0; i < score.length; i++) {
            int k = bucket[score[i]];
            if (k > 3) {
                // 前 3 名之后的直接赋值名次
                strs[i] = Integer.toString(k);
            } else {
                // 前 3 名需要单独赋值特殊字符串
                if (k == 1) {
                    strs[i] = "Gold Medal";
                } else if (k == 2) {
                    strs[i] = "Silver Medal";
                } else {
                    strs[i] = "Bronze Medal";
                }
            }
        }
        return strs;
    }

    public static void main(String[] args) {
        int[] score = {10, 3, 8, 9, 4};
        System.out.println(findRelativeRanks2(score));
    }
}
