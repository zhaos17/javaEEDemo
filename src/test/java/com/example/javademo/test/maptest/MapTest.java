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

        final HashMap<String,String> map = new HashMap<String,String>();

        Thread t = new Thread(new Runnable(){
            @Override
            public  void run(){
                for(int x=0;x<10000;x++){
                    Thread tt = new Thread(new Runnable(){
                        @Override
                        public void run(){
                            map.put(UUID.randomUUID().toString(),"");
                        }
                    });
                    tt.start();
                    System.out.println(tt.getName());
                }
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
}
