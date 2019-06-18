package leetcode;

/**
 * @ClassName Solution6
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/31
 **/
public class Solution6 {
    public static String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder sb = new StringBuilder();
        int curLen = 2 * numRows - 2;
        for(int i = 1 ;i<=numRows;i++){
            if(i==1){
                for(int j = 0;j<(s.length() + curLen - 1)/curLen;j++){
                    if(j*curLen < s.length()){
                        sb.append(s.charAt(j*curLen));
                    }
                }
                System.out.println( 1+ sb.toString());
            } else if(i==numRows){
                for(int j = 0;j<(s.length() + curLen - 1)/curLen;j++){
                    if(curLen * j + (numRows - 1) < s.length()){
                        sb.append(s.charAt(curLen * j + (numRows - 1)));
                    }
                }
                System.out.println( 2+ sb.toString());
            } else {
                for(int j = 0;j<(s.length() + curLen - 1)/curLen;j++){
                    if(j*curLen + i - 1 < s.length() && j*curLen + i - 1 >= 0){
                        sb.append(s.charAt(j*curLen + i - 1 ));
                    }
                    if((j+1)*curLen- i + 1 < s.length() && (j+1)*curLen- i + 1 >=0 ){
                        sb.append(s.charAt((j+1)*curLen- i + 1));
                    }
                }
                System.out.println( 3+ sb.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("123456789", 4));
        String str = "00123";
        System.out.println(Long.parseLong(str));
        int x= 13;
        String s = String.valueOf(13);
        char[] chars = s.toCharArray();
        System.out.println(s);
    }
}
