package algorithm.offer3;

import com.google.common.net.InetAddresses;

import java.net.InetAddress;

public class No28 {

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 例如输入字符串 abc， 则打印出由字符串 a、b、c 所能
     * 排列出来的所有字符串 abc、acb、bac、bca、cab 和 cba
     */
    // TODO 需要复习一下 这个是道好题

    /**
     *     画一画递归树
     *                 *
     *     a->a       a->b         a->c
     *     abc        bac          cba
     * b->b    b->c a->a   a->c   b->b   b->a
     * abc     acb  bac    bca    cba    cab
     * @param args
     */


    public static String shorthandIpv6(String ipAddr){
        ipAddr = ipAddr.toLowerCase();
        String foldedIp = "";
        String[] ips = ipAddr.split(":");
        for(int i=0; i<ips.length; i++){

            while(ips[i].startsWith("0")&&ips[i].length()>1){
                // ?????1?????0 ??????????? ::
                ips[i] = ips[i].substring(1);
            }
            foldedIp = foldedIp + ":" + ips[i];
        }
        foldedIp = foldedIp.substring(1);
        return foldedIp.replaceFirst("(^|:)(0+(:|$)){2,8}",  "::");
    }
    public static void main(String[] args) {
        String subjectString = "fe80:0:1:0:204:61ff:0:0";
//        String resultString = subjectString.replaceAll("((?::0\\b){2,}):?(?!\\S*\\b\\1:0\\b)(\\S*)", "::$2");
//        System.out.println(resultString);
        InetAddress inetAddress = InetAddresses.forString("fe80:0:0:0:204:61ff:0:0");
        System.out.println(InetAddresses.toAddrString(inetAddress));
        System.out.println(shorthandIpv6(subjectString));
    }

    private static void myPrint(String str) {
        if (str == null) {
            return;
        }
        char[] chs = str.toCharArray();
        myPrint(chs, 0);
    }

    private static void myPrint(char[] str, int i) {
        if (i >= str.length) {
            return;
        }
        if (i == str.length - 1) {
            System.out.println(String.valueOf(str));
            return;
        }

        for (int j = i; j < str.length; j++) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            myPrint(str, i + 1);
            tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }


}
