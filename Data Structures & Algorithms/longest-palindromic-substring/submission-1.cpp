class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        if (n == 0) return "";

        vector<vector<bool>> tick(n, vector<bool>(n, false));

        int start_index = 0;
        int max_length = 1;

        // Single characters
        for (int i = 0; i < n; i++) {
            tick[i][i] = true;
        }

        // DP filling
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j] && (j - i == 1 || tick[i + 1][j - 1])) {
                    tick[i][j] = true;
                    if (j - i + 1 > max_length) {
                        max_length = j - i + 1;
                        start_index = i;
                    }
                }
            }
        }

        return s.substr(start_index, max_length);
    }
};
