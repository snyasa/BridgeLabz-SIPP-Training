public class Lexicographical {
    public static void main(String[] args) {
        String s1 = "apple";
        String s2 = "banana";

        int minLength = Math.min(s1.length(), s2.length());

        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) < s2.charAt(i)) {
                    System.out.println(s1 + " comes before " + s2);
                } else {
                    System.out.println(s2 + " comes before " + s1);
                }
                return;
            }
        }

        if (s1.length() < s2.length()) {
            System.out.println(s1 + " comes before " + s2);
        } else if (s1.length() > s2.length()) {
            System.out.println(s2 + " comes before " + s1);
        } else {
            System.out.println("Both strings are equal");
        }
    }
}
