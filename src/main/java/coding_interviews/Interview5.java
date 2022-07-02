package coding_interviews;

public class Interview5 {

    public static String replace(StringBuffer sb){
        if (sb == null) {
            return null;
        }

        // 统计个数
        int spaceNum = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' '){
                spaceNum++;
            }
        }
        if (spaceNum == 0) {
            return sb.toString();
        }

        int oldP = sb.length() -1;
        sb.setLength(sb.length() + spaceNum * 2);
        int newP = sb.length() - 1;
        while (oldP >= 0 && newP > oldP){
            if (sb.charAt(oldP) == ' '){
                sb.setCharAt(newP--, '0');
                sb.setCharAt(newP--, '2');
                sb.setCharAt(newP--, '%');
                // 这里的移动index也很容易出错，我第一次按照这种思路写的时候，写的就是2;
                // 如果上面都改成newP--,就可以避免这个问题
                //newP = newP - 3;
            } else {
                sb.setCharAt(newP--, sb.charAt(oldP));
            }
            oldP--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("asdf asd");
        String s = replace(sb);
        System.out.println(s);
    }
}
