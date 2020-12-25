package com.example.javademo.test.maptest;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.UUID;

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
}
