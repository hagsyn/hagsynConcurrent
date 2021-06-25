package cn.hagsyn;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Auther Hagsyn
 * @Date 2021/4/22 17:15
 */
public class Tests {


    public static void main(String[] args) {

    }

    public String getMiniumNumber(int[] number, int k) {

        // write your code here
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : number) {
            if (numMap.containsKey(num)) {
                numMap.put(num, numMap.get(num) + 1);
            } else {
                numMap.put(num, 1);
            }
        }
        return null;
    }

}

