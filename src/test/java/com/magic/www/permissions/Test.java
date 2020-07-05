package com.magic.www.permissions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/26
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        Map<String,Object> strMap = new HashMap<String,Object>();
        for(int i=0;i<strs.length;i++){
            String[] strArr = strs[i].split("");
            strMap.put(i+"",strArr);
        }
        String[] aStr = (String[])strMap.get("0");

        boolean ifOver = false;
        for(int j=0;j< aStr.length;j++){

            if(ifOver){
                break;
            }
            for(int k=1;k<strMap.size();k++){
                String[] targetStr = (String[])strMap.get(k+"");
                if(!aStr[j].equals(targetStr[j])){
                    ifOver = true;
                    break;
                }
                if(k == strMap.size()-1){
                    result = result +aStr[j];
                }
                if(j == targetStr.length|| j == aStr.length){
                    break;
                }
            }
        }


        if(result.length()<=0){
            return "输入不存在公共前缀";
        }
        return result;

    }

    public static void main(String[] args) {
        Test t = new Test();
        String[] s = new String[]{"dog","racecar","car"};
        System.out.println(t.longestCommonPrefix(s));
    }
}
