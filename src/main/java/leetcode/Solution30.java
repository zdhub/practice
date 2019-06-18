package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName Solution
 * @Descirption 串联所有单词的子串 做的时候，超时
 * @Author yizhendong
 * @Date 2019/5/30
 **/
@Hard
@TriedButFaild
public class Solution30 {
    public static void main(String[] args) {
        String[] words = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        List<Integer> result = findSubstringV2(s, words);
        result.stream().forEach(item -> System.out.println(item));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        HashSet<Integer> result = new HashSet<>();
        if (s == null || s.length() == 0) return new ArrayList<>();
        int wordsLength = 0;
        HashSet<String> wordSet = new HashSet<>();
        for (int i = 0;i<words.length;i++){
            wordsLength += words[i].length();
            wordSet.add(words[i]);
        }
        if (wordsLength > s.length()) return new ArrayList<>();
        for (int i = 0;i<words.length;i++){
            if (!s.contains(words[i])) return new ArrayList<>();
        }
        List<String> wordList = new ArrayList<>();
        if (words.length > 1){
            generate(wordList, words, 0, words.length - 1);
        } else if (words.length == 1){
            wordList.add(words[0]);
        } else {
            return new ArrayList<>();
        }
        for (String item : wordList){
            if (s.contains(item)){
                int startIndex = 0;
                while (s.indexOf(item, startIndex) != -1){
                    Integer index = s.indexOf(item, startIndex);
                    result.add(index);
                    startIndex = index+1;
                }
            }
        }
        return new ArrayList<>(result);
    }

    private static void generate(List<String> wordList, String[] words, int from, int end) {
        if (end <= 0) return;
        if (from == end){
            StringBuilder s = new StringBuilder();
            for (int i = 0;i<words.length;i++){
                s = s.append(words[i]);
            }
            wordList.add(s.toString());
        }else {
            for (int i= from;i<=end;i++){
                swap(words, i, from);
                generate(wordList, words, from + 1, end);
                swap(words, i, from);
            }
        }
    }

    private static void swap(String[] words, int from, int end) {
        String s = words[from];
        words[from] = words[end];
        words[end] = s;
    }


    public static List<Integer> findSubstringV2(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();
        int wordNum = words.length;
        int strLength = s.length();
        if (wordNum == 0 || strLength == 0) {
            return answer;
        }
        int wordLength = words[0].length();
        for (int i = 0; i <= strLength - wordNum * wordLength; i = i + 1) {
            String subString = s.substring(i, i + wordNum * wordLength);
            List<String> list = new ArrayList<>();
            for( int k=0;k<wordNum;k++)
                list.add(subString.substring(wordLength*k, wordLength*(k+1)));
            for (int j = 0; j < wordNum; j++) {
                if(list.contains(words[j])) {
                    list.remove(words[j]);
                }else {
                    break;
                }
            }

            if (list.isEmpty())
                answer.add(i);
        }
        return answer;
    }
}
