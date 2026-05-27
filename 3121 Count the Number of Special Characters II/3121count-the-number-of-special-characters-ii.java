import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> validLowers = new HashSet<>();
        Set<Character> uppers = new HashSet<>();
        Set<Character> broken = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                if (uppers.contains(Character.toUpperCase(ch))) {
                    broken.add(ch);
                } else {
                    validLowers.add(ch);
                }
            } else {
                
                uppers.add(ch);
            }
        }

        int specialCount = 0;
        for (char ch : validLowers) {
            if (!broken.contains(ch) && uppers.contains(Character.toUpperCase(ch))) {
                specialCount++;
            }
        }

        return specialCount;
    }
}
