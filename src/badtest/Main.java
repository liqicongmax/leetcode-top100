package badtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        new Main().group();
    }

    public void group() {
        List<Order> original = new ArrayList<>();
        Order order = new Order();
        order.setId("1");
        order.setCompany("111");
        original.add(order);
        order = new Order();
        order.setId("2");
        order.setCompany("222");
        original.add(order);

        order = new Order();
        order.setId("1");
        order.setCompany("333");
        original.add(order);

        order = new Order();
        order.setId("3");
        order.setCompany("222");
        original.add(order);

        List<Function<Order, String>> list = new ArrayList<>();
        list.add(Order::getCompany);
        list.add(Order::getId);
        final List<List<Order>> results = new ArrayList<>();
        for (Function<Order, String> function : list) {
            Map<String, List<Order>> map = original.stream().collect(Collectors.groupingBy(function));
            List<Order> temp = new ArrayList<>();
            for (Map.Entry<String, List<Order>> entry : map.entrySet()) {
                List<Order> value = entry.getValue();
                temp.add(value.get(0));
            }
            results.add(temp);
        }

        results.forEach(System.out::println);
    }

}
