class Solution {
    public boolean isAllLower(String word) {
        for(int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c >= 'A' && c <= 'Z') return false;
        }
        return true;
    }
    public boolean isAllUpper(String word) {
        for(int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c >= 'a' && c <= 'z') return false;
        }
        return true;
    }
    public boolean detectCapitalUse(String word) {
        char first = word.charAt(0);
        if(first >= 'a' && first <= 'z') return isAllLower(word);
        else return isAllLower(word) || isAllUpper(word);
    }
}
