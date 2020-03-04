package badtest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/4 10:53
 */
public class Wdnmd {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("cbda", 1);
        map.put("cwrb", 2);
        map.put("rgx", 3);
        map.put("rgxcfhcfh", 4);
        map.put("qw", 5);


        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> item = iterator.next();
            System.out.println(item.getKey().hashCode());
            System.out.println(item.getKey() + " " + item.getValue());
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
