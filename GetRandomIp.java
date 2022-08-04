import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GetRandomIp {


    /**
     * 生成随机IP
     * <p>
     * 规则
     * 127.xxx.xxx.xxx 属于 “loopback” 地址，即只能你自己的本机可见，就是本机地址，比较常见的有 127.0.0.1
     * 192.168.xxx.xxx 属于 private 私有地址 (site local address)，属于本地组织内部访问，只能在本地局域网可见
     * 同样 10.xxx.xxx.xxx、从 172.16.xxx.xxx 到172.31.xxx.xxx 都是私有地址，也是属于组织内部访问
     * 169.254.xxx.xxx 属于连接本地地址(link local IP)，在单独网段可用
     * 从 224.xxx.xxx.xxx 到 239.xxx.xxx.xxx 属于组播地址
     * 比较特殊的 255.255.255.255 属于广播地址
     * 除此之外的地址就是点对点的可用的公开 IPv4 地址
     * </p>
     */
    public static String getRandomIp() {
        // 指定 IP 范围
        int[][] range = {
                {607649792, 608174079}, // 36.56.0.0-36.63.255.255
                {1038614528, 1039007743}, // 61.232.0.0-61.237.255.255
                {1783627776, 1784676351}, // 106.80.0.0-106.95.255.255
                {2035023872, 2035154943}, // 121.76.0.0-121.77.255.255
                {2078801920, 2079064063}, // 123.232.0.0-123.235.255.255
                {-1950089216, -1948778497}, // 139.196.0.0-139.215.255.255
                {-1425539072, -1425014785}, // 171.8.0.0-171.15.255.255
                {-1236271104, -1235419137}, // 182.80.0.0-182.92.255.255
                {-770113536, -768606209}, // 210.25.0.0-210.47.255.255
                {-569376768, -564133889}, // 222.16.0.0-222.95.255.255
        };

        Random random = new Random();
        int index = random.nextInt(10);
        String ip = num2ip(range[index][0] + random.nextInt(range[index][1] - range[index][0]));
        return ip;
    }

    /**
     * 将十进制转换成IP地址
     */
    public static String num2ip(int ip) {
        int[] b = new int[4];
        b[0] = (ip >> 24) & 0xff;
        b[1] = (ip >> 16) & 0xff;
        b[2] = (ip >> 8) & 0xff;
        b[3] = ip & 0xff;
        // 拼接 IP
        String x = b[0] + "." + b[1] + "." + b[2] + "." + b[3];
        return x;
    }




    public static void main(String[] args) {
        int count = 10000;
        Set<String> ips = new HashSet();
        for (int i = 0; i < count; i++) {
            String randomIp = getRandomIp();
            ips.add(randomIp);
            System.out.println(randomIp);
        }
        System.out.println(ips.size());
    }
}
