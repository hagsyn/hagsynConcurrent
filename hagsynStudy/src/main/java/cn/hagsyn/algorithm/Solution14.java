package cn.hagsyn.algorithm;

/**
 *  [14]最长公共前缀
 * @author Hagsyn
 * @date 2021/11/30
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String pubPrefix = "";
        for (String str : strs) {
            if (pubPrefix!="") {
                if (!str.startsWith(pubPrefix)) {
                    //如果不含前缀，则需要进行切割
                    if (pubPrefix.length()==1) return "";
                    while (pubPrefix.length()>0) {
                        pubPrefix = pubPrefix.substring(0,pubPrefix.length()-1);
                        if (str.startsWith(pubPrefix)) {
                            break;
                        }
                    }
                } else {
                    continue;
                }
            }else {
                pubPrefix = str;
            }
        }
        return pubPrefix;
    }
}