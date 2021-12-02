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
        Collections.addAll(scoreList,score);
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

    public static void main(String[] args) {
        int[] score = {10, 3, 8, 9, 4};
        System.out.println(findRelativeRanks2(score));
    }
}
