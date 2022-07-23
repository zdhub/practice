package leetcode;

public class Solution72 {
    public static void main(String[] args) {
        String str1 = "lllo";
        String str2 = "lorll";
        int editDistance = minDistance(str1, str2);
        System.out.println(editDistance);
    }
    public static int minDistance(String word1, String word2) {
        if(word1 == null || word1.length() == 0) {
            if (word2 != null) {
                return word2.length();
            }
        }
        if (word2 == null || word2.length() == 0){
            return word1.length();
        }

        int[][] distance = new int[word2.length() + 1][word1.length()+1];

        int result = GetMinDistance(word1, word2, distance, word1.length(), word2.length());
        return result;
    }

    public static int GetMinDistance(String subStr1, String subStr2, int[][] distance, int length1, int length2){
        for(int i = 0; i < length1 + 1; i++){
            distance[0][i] = i;
        }
        for(int j = 0; j < length2 + 1; j++){
            distance[j][0] = j;
        }

        for(int i = 1; i < length2 + 1;i++){
            for(int j = 1; j < length1 + 1; j++){
                if(subStr2.charAt(i-1) == subStr1.charAt(j-1)){
                    distance[i][j] = distance[i-1][j-1];
                } else {
                    int distance1 = distance[i-1][j] + 1;
                    int distance2 = distance[i][j-1] + 1;
                    int distance3 = distance[i-1][j-1] + 1;
                    distance[i][j] = GetMin(distance1, distance2, distance3);
                }
            }
        }
        return distance[length2][length1];
    }

    public static int GetMin(int i, int j, int k){
        return Math.min(Math.min(i, j), k);
    }
}
