class Solution {
    public boolean isValid(String s) {
        if(s.charAt(0) == '0') return false;
        if(Integer.parseInt(s) > 255) return false;
        return true;
    }
    public void solve(String s, int idx, String ipSoFar, int parts, List<String> res) {
        if(idx == s.length() && parts == 4) {
            res.add(ipSoFar.substring(0, ipSoFar.length() - 1));
            return;
        }
        if(idx + 1 <= s.length()) solve(s, idx + 1, ipSoFar + s.charAt(idx) + ".", parts + 1, res);
        if(idx + 2 <= s.length() && isValid(s.substring(idx, idx + 2))) solve(s, idx + 2, ipSoFar + s.substring(idx, idx + 2) + ".", parts + 1, res);
        if(idx + 3 <= s.length() && isValid(s.substring(idx, idx + 3))) solve(s, idx + 3, ipSoFar + s.substring(idx, idx + 3) + ".", parts + 1, res);
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        solve(s, 0, "", 0, res);
        return res;
    }
}
