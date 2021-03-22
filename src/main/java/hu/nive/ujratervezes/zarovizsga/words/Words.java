package hu.nive.ujratervezes.zarovizsga.words;

public class Words {
    public boolean hasMoreDigits(String s) {
        String digits = "0123456789";
        int sum = 0;
        if (s.isBlank()) {
            return false;
        } else {
            String[] tmp = s.split("");
            sum = countDigits(digits, sum, tmp);
            return sum > (tmp.length - sum);
        }
    }

    private int countDigits(String digits, int sum, String[] tmp) {
        for (String str : tmp) {
            if (digits.contains(str)) {
                sum++;
            }
        }
        return sum;
    }
}
