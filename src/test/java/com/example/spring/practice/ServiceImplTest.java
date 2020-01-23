package com.example.spring.practice;

import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Proxy;
import java.util.*;

public class ServiceImplTest {

    @Test
    public void add() {
    }

    @Test
    public void update() {
    }

    @Test
    public void InvocationTest(){
        Service service = new ServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        Service servicetest = (Service) handler.getProxyInstance();
        servicetest.add();

        byte[] testProxyBytes = ProxyGenerator.generateProxyClass("TestService", new Class[]{Service.class});
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("TestProxy.class");
            fileOutputStream.write(testProxyBytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//        Service serviceProxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), handler);
//        serviceProxy.add();
//        System.out.println("+++++++++++test+++++++++++++");
//        serviceProxy.update();
//    }

//    @Test
//    public String simplifyPath(String path) {
//        if(path == null || path.length() <= 1) return path;
//        StringBuffer sb = new StringBuffer();
//        for(int i = 0; i<path.length();i++){
//            char a = path.charAt(i);
//            if(a - '/' == 0){
//                if(i<path.length() - 1){
//                    if(path.charAt(i+1) - '/' == 0){
//                        if(sb.length() > 1){
//                            continue;
//                        }
//                    }
//                }
//                sb.append(path.charAt(i));
//            } else if( a - '.' == 0){
//                if(i<path.length() - 1){
//                    if(path.charAt(i+1) - '.' == 0){
//                        if(sb.length() > 2){
//                            sb.deleteCharAt(sb.length() -1);
//                            sb.deleteCharAt(sb.length() -1);
//                            continue;
//                        }
//                    }
//                }
//            } else {
//                sb.append(path.charAt(i));
//            }
//        }
//        return sb.toString();
//    }


//    @Test
//    public void testIp(){
//        System.out.println(restoreIpAddresses("0000"));
//    }
//    public List<String> restoreIpAddresses(String s) {
//        if(s == null || s.length() < 4) return null;
//        List<String> finalResult = new ArrayList<>();
//        for(int i = 1;i<s.length()-3;i++){
//            for(int j = i+1;j<s.length()-2;j++){
//                for(int k = j+1;k<s.length()-1;k++){
//                    String first = s.substring(0,i);
//                    String second = s.substring(i, j);
//                    String third = s.substring(j,k);
//                    String last = s.substring(k,s.length());
//                    if(!validNumber(first)) continue;
//                    if(!validNumber(second)) continue;
//                    if(!validNumber(third)) continue;
//                    if(!validNumber(last)) continue;
//                    String temp = getResult(first, second, third, last);
//                    finalResult.add(temp);
//                }
//            }
//        }
//        return finalResult;
//    }

    public static boolean validNumber(String number){
        char first = number.charAt(0);
        if(number.length() > 1 && first - '0' == 0) return false;
        if(number.length() > 3 ) return false;
        Integer num = Integer.parseInt(number);
        if(num > 255) return false;
        return true;
    }

    public static String getResult(String str1, String str2, String str3, String str4){
        return str1 + "." + str2 + "." + str3 + "." + str4;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums == null || nums.length < 3 || nums[0] + nums[1] + nums[2] > 0) return result;
        for(int i = 0;i<nums.length - 2;i++){
            if(i == 0 || (i>0 && nums[i] != nums[i-1])){
                int target = -nums[i];
                int start = i+1;
                int end = nums.length - 1;
                while(start < end){
                    List<Integer> temp = new ArrayList<>();
                    if(nums[start] + nums[end] == target){
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        result.add(temp);
                        while(start < end && nums[start] == nums[start+1]){
                            start++;
                        }
                        while(start < end && nums[end] == nums[end-1]){
                            end--;
                        }
                        start++;
                        end--;
                    }else if(nums[start] + nums[end] < target){
                        start++;
                    }else{
                        end--;
                    }

                }

            }
        }
        return result;
    }

    @Test
    public void testSum(){
        System.out.println(longestPalindrome("abccbb"));
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        int len = s.length();
        char[] extStr = new char[len * 2 + 1];
        boolean allDifferent = true;
        char blank = s.charAt(0);
        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0;i<extStr.length;i++){
            if(i%2==0){
                extStr[i] =blank;
            }else {
                extStr[i] = s.charAt(i/2);
                if(hashSet.contains((Character)s.charAt(i/2))){
                    allDifferent = false;
                }
                hashSet.add(s.charAt(i/2));
            }
        }

        if(allDifferent) return s.substring(0,1);

        int longestDiff = 1;
        int middleIndex = 0;
        for(int i = 1;i<extStr.length;i++){
            int tempLongest = 0;
            int start = i - 1;
            int end = i + 1;
            while(start >= 0 && end <= extStr.length - 1){
                if(extStr[start] - extStr[end] == 0){
                    tempLongest = tempLongest + 1;
                    if(tempLongest > longestDiff){
                        longestDiff = tempLongest;
                        middleIndex = i;
                    }
                } else break;
                start--;
                end++;
            }
        }
        String result = "";
        int startIndex = middleIndex - longestDiff;
        int endIndex = middleIndex + longestDiff;
        for(int i = startIndex;i<=endIndex;i++){
            if(i%2==1){
                result = result + extStr[i];
            }
        }
        return result;
    }

    @Test
    public void getInteger(){
        String s = "s   s";
        String c = s.trim();
        System.out.println(c);
    }

    public static void mySort(int low, int hi, int[] number){
        if(low >= hi || number == null || number.length <= 1) {
            return;
        }

        int pivot = number[(low + hi)/2];
        int start = low;
        int end = hi;
        while(start <= end){
            while(number[start] < pivot && start < end){
                start++;
            }
            while(number[end] > pivot && start < end){
                end--;
            }
            if(start < end){
                swap(start, end, number);
                start++;
                end--;
            } else if(start == end){
                break;
            }
        }
        mySort(low, start-1, number);
        mySort(start+1, hi, number);
    }

    public static void swap(int index1, int index2, int[]number){
        int temp = number[index1];
        number[index1] = number[index2];
        number[index2] = temp;
    }

    @Test
    public void testSort(){
        int[] number = {9,3,10,1,5};
        mySort(0, number.length - 1, number);
//        qSort(number, 0 , number.length - 1);
//        sort(number, 0 , number.length - 1);
        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }
    }

    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                //  ++i;
                break;
            }
        }
        qSort(arr, head, i-1);
        qSort(arr, i+1, tail);
    }



    public static int divide(int[] a, int start, int end){
        //每次都以最右边的元素作为基准值
        int base = a[end];
        //start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环。
        while(start < end){
            while(start < end && a[start] <= base)
                //从左边开始遍历，如果比基准值小，就继续向右走
                start++;
            //上面的while循环结束时，就说明当前的a[start]的值比基准值大，应与基准值进行交换
            if(start < end){
                //交换
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
                end--;
            }
            while(start < end && a[end] >= base)
                //从右边开始遍历，如果比基准值大，就继续向左走
                end--;
            //上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换
            if(start < end){
                //交换
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位
                start++;
            }

        }
        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
        return end;
    }

    /**
     * 排序
     * @param a
     * @param start
     * @param end
     */
    public static void sort(int[] a, int start, int end){
        if(start > end){
            //如果只有一个元素，就不用再排下去了
            return;
        }
        else{
            //如果不止一个元素，继续划分两边递归排序下去
            int partition = divide(a, start, end);
            sort(a, start, partition-1);
            sort(a, partition+1, end);
        }

    }
}