package com.mimosa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        NodesOperationRequestBuilder nodeBuilder =new NodesInfoRequestBuilder();
//        Node node = nodeBuilder..clusterName("escluster2").client(true).node();
//        Client client = node.client();
//        System.out.println("Hello World!");
        String a = "abcdeqfjlaabbcvceeddaa";
//      Map<String,Integer> map = Arrays.asList(a.split("")).stream().collect(Collectors.toMap(k->k,v->v.length(),(k1,k2)->k1));
        Map<String, Integer> map = Arrays.asList(a.split("")).stream().
                collect(Collectors.toMap(Function.identity(),
                        k -> k.length(),(v1,v2)->{return v1+v2;}
                        ));
        System.out.println(map);
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService es = Executors.newFixedThreadPool(7);
        es.submit(() -> {
        });
    }
}
