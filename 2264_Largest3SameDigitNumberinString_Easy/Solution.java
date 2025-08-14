class Solution {
    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            StringBuilder goodNumberCandidate = new StringBuilder();
            char digit = (char) ('0' + i);
            goodNumberCandidate.append(digit).append(digit).append(digit);

            String candidateString = goodNumberCandidate.toString();

            if (num.contains(candidateString)) {
                return candidateString;
            }
        }
        return "";
    }
}