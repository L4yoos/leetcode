import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private static final double EPSILON = 1e-5;

    public boolean judgePoint24(int[] cards) {
        List<Double> doubleCards = new ArrayList<>();
        for (int card : cards) {
            doubleCards.add((double) card);
        }
        return solve(doubleCards);
    }

    private boolean solve(List<Double> cards) {
        if (cards.size() == 1) {
            return Math.abs(cards.get(0) - 24) < EPSILON;
        }

        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                double num1 = cards.get(i);
                double num2 = cards.get(j);

                List<Double> nextCards = new ArrayList<>();
                for (int k = 0; k < cards.size(); k++) {
                    if (k != i && k != j) {
                        nextCards.add(cards.get(k));
                    }
                }

                nextCards.add(num1 + num2);
                if (solve(nextCards)) {
                    return true;
                }
                nextCards.remove(nextCards.size() - 1);

                nextCards.add(num1 - num2);
                if (solve(nextCards)) {
                    return true;
                }
                nextCards.remove(nextCards.size() - 1);

                nextCards.add(num2 - num1);
                if (solve(nextCards)) {
                    return true;
                }
                nextCards.remove(nextCards.size() - 1);

                nextCards.add(num1 * num2);
                if (solve(nextCards)) {
                    return true;
                }
                nextCards.remove(nextCards.size() - 1);

                if (num2 != 0) {
                    nextCards.add(num1 / num2);
                    if (solve(nextCards)) {
                        return true;
                    }
                    nextCards.remove(nextCards.size() - 1);
                }

                if (num1 != 0) {
                    nextCards.add(num2 / num1);
                    if (solve(nextCards)) {
                        return true;
                    }
                    nextCards.remove(nextCards.size() - 1);
                }
            }
        }
        return false;
    }
}
