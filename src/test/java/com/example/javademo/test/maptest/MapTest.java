package com.example.javademo.test.maptest;

import com.example.javademo.modal.Foundational;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author: zhaos
 * @date: 2020/12/11
 */
public class MapTest {

    @Test
    public void hashMap() throws InterruptedException {

        final HashMap<String,String> map = new HashMap<>();

        Thread t = new Thread(() -> {
            for(int x=0;x<10000;x++){
                Thread tt = new Thread(() -> map.put(UUID.randomUUID().toString(),""));
                tt.start();
                System.out.println(tt.getName());
            }
        });
        t.start();
        t.join();
        System.out.println(map.size());
    }

    @Test
    public void hashTable () {
        Hashtable hashtable = new Hashtable();
        hashtable.put("b",20);
        hashtable.forEach((k,v) -> {
            System.out.println("key:" + k);
            System.out.println("value:" + v);
        });
    }

    @Test
    public void copyTest() {
        List<Foundational> list1 = new ArrayList<>();
        list1.add(new Foundational(1,1.0,false));
        list1.add(new Foundational(2,2.0,false));

        List<Foundational> list2 = new ArrayList<>(list1);
        list2.get(0).setId(11);
        list2.add(new Foundational(3,3.0,false));

        System.out.println(list1);
        System.out.println(list2);

    }

    @Test
    public void test01() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1","1");


        ArrayList<Object> objects = new ArrayList<>();

        HashSet<String> hashSet = new HashSet<>();
        Iterator<String> iterator = hashSet.iterator();
    }

    public static void main(String[] args) {
        double f = 0.5585;

        System.out.println(String.format("%.2f", f));
    }
}
