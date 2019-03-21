package io.github.evenX86.solution;

import java.util.HashMap;

public class SolutionIsAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for (Character a : s.toCharArray()) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        for (Character a : t.toCharArray()) {
            if (map.containsKey(a)) map.put(a,map.get(a) -1);
            else return false;
            if (map.get(a) == 0) map.remove(a);
        }
        if (map.isEmpty()) return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("sss","ttt"));
        int sum = 0;
        for (Character a : "sss".toCharArray()) {
            sum += a;
            System.out.println(sum);
        }
    }
}
