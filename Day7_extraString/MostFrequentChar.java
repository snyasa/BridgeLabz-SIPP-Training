public class MostFrequentChar {
    public static void main(String[] args) {
        String str = "success";
        int maxCount = 0;
        char mostFrequent = ' ';

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == current) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = current;
            }
        }

        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
    }
}
