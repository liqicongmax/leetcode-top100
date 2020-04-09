package badtest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        new Main().group();
        List<User> uzers=new ArrayList<>();
        //串行流对象
        Stream<User> stream=uzers.stream();

        //并行流对象
        Stream<User> parallelStream=uzers.parallelStream();

        //filter过滤出符合条件的
        List<User> users=stream.filter(user -> user.age>10&&user.name!=null).collect(Collectors.toList());

        //map遍历修改对象

        List<Integer> ages=stream.map(user -> user.age).collect(Collectors.toList());

        List<User> uzr=stream.sorted((user1,user2)->user1.age>user2.age?1:0).collect(Collectors.toList());

        Map<Integer,User> userMap=stream.collect(Collectors.toMap(user->user.age ,user->user));
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
