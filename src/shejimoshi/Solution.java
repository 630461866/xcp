package shejimoshi;
class Solution {

    public static void main(String[] args) {
        String s = addBinary("123", "1123");
        System.out.println(s);
    }

    public static String addBinary(String a, String b) {
//        if (a == null)
//            return b;
//        if (b == null)
//            return a;   做非空判断抛出异常
        String tempa = "";
        for (int i = 0; i < a.length(); i++) {
            tempa = a.charAt(i) + tempa;
        }
        a = tempa;
        String tempb = "";
        for (int i = 0; i < b.length(); i++) {
            tempb = b.charAt(i) + tempb;
        }
        b = tempb;
        String res = "";
        int numa = 0, numb = 0, index = 0;
        for (int i = 0; i < a.length() || i < b.length() || index != 0; i++) {
            if (i < a.length()) {
                numa = Integer.parseInt(String.valueOf(a.charAt(i)));
            } else {
                numa = 0;
            }
            if (i < b.length()) {
                numb = Integer.parseInt(String.valueOf(b.charAt(i)));
            } else {
                numb = 0;
            }
            if (numa + numb + index < 2) {
                res = String.valueOf(numa + numb + index) + res;
                index = 0;
            } else {
                res = String.valueOf((numa + numb + index) % 2) + res;
                index = 1;
            }
        }
        return res;
    }
}