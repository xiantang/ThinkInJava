package util;

public class Ipv6Util {

    public static String ShorthandIpv6(String ipAddr){
        ipAddr = ipAddr.toLowerCase();
        String foldedIp = "";
        String[] ips = ipAddr.split(":");
        boolean flag = false;
        for(int i=0; i<ips.length; i++){

            while(ips[i].startsWith("0")&&ips[i].length()>0){
                // 如果长度为1并且起始为0 并且前面没有被缩写成为 ::
                if (!flag && ips[i].length() == 1) {
                    flag = true;
                    ips[i] = ips[i].substring(1);
                    // 地址前面被缩写成为 :: 只能将0000 缩写为 :0:
                } else if (flag && ips[i].length() == 1) {
                    break;
                } else {
                    ips[i] = ips[i].substring(1);
                }

            }
            foldedIp = foldedIp + ":" + ips[i];
        }
        return foldedIp.substring(1);
    }



    public static void main(String[] args) {
        String res = Ipv6Util.ShorthandIpv6("2409:8C4C:0E01:0100:8000:0000:FFFF");
        System.out.println(res);

    }
}
