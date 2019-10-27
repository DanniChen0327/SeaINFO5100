package assignment6;

import java.util.Arrays;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.equals(schar,tchar);
    }

    public static void main(String[] args){
        IsAnagram test = new IsAnagram();
        System.out.println(test.isAnagram("", ""));
        System.out.println(test.isAnagram("cat", "rta"));
        System.out.println(test.isAnagram("anagram", "nagaram"));
    }
}

