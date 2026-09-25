class Solution {
    private final String[] LESS_THAN_20 = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private final String[] THOUSANDS = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder words = new StringBuilder();
        int unitIndex = 0;

        while (num > 0) {
            int chunk = num % 1000;
            if (chunk != 0) {
                StringBuilder chunkStr = new StringBuilder();
                helper(chunk, chunkStr);
                if (THOUSANDS[unitIndex].length() > 0) {
                    chunkStr.append(THOUSANDS[unitIndex]).append(" ");
                }
                words.insert(0, chunkStr);
            }
            num /= 1000;
            unitIndex++;
        }

        return words.toString().trim();
    }

    private void helper(int n, StringBuilder sb) {
        if (n == 0) {
            return;
        } else if (n < 20) {
            sb.append(LESS_THAN_20[n]).append(" ");
        } else if (n < 100) {
            sb.append(TENS[n / 10]).append(" ");
            helper(n % 10, sb);
        } else {
            sb.append(LESS_THAN_20[n / 100]).append(" Hundred ");
            helper(n % 100, sb);
        }
        
    }
}