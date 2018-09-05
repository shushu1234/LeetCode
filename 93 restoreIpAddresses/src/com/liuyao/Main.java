package com.liuyao;

import java.util.LinkedList;
import java.util.List;

/**
 *
 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

 示例:

 输入: "25525511135"
 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.restoreIpAddresses("25525511135"));
    }
    static class Solution {
        public static List<String> list=new LinkedList<String>();
        public static List<String> restoreIpAddresses(String s) {
            if (s==null || s.equals("")){
                return list;
            }
            getAllIPAddress(s,0,"",0);
            return list;
        }

        private static void getAllIPAddress(String ip,int idx,String restored,int count) {
            if (count > 4) {
                return;
            }
            if (count==4 && idx==ip.length()){
                list.add(restored);
            }
            for (int i = 1; i < 4; i++) {
                if (idx+i > ip.length()){
                    break;
                }
                String s=ip.substring(idx,idx+i);
                if ((s.startsWith("0") && s.length()>1)||(i==3 && Integer.parseInt(s)>=256)){
                    continue;
                }
                getAllIPAddress(ip,idx+i,restored+s+(count==3?"":"."),count+1);
            }
        }
    }
}
