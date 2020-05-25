package com.zzt.Test;

import org.junit.Test;

import java.util.*;

public class mapTest {
    @Test
    public void map(){

        Map<Integer,Integer>map1=new HashMap<>();
        Map<Integer,Integer>map2=new HashMap<>();
        List<Integer> list=new ArrayList();
        int count = 0;
        map1.put(1,2312);
        map1.put(2,311);
        map1.put(3,3);
        map1.put(4,31);
        map2.put(1,2312);
        map2.put(3,3);
        map2.put(5,12);
        map2.put(2,311);
        Set<Integer> keySet= map1.keySet();
        for(Integer s:keySet){
            if(map2.containsKey(s)){
                map2.put(s,map2.get(s)+map1.get(s));
                list.add(s);

            }
        }
        System.out.println(list);
        for (Integer lis:list){
             count+=list.get(lis-1);
            map1.remove(lis);
        }
        System.out.println(count);
        System.out.println(map1);
        System.out.println(map2);
        map2.putAll(map1);
        System.out.println(map2);
    }
    @Test
    public void test(){
        Map<Integer,Integer>map1=new HashMap<>();
        Map<Integer,Integer>map2=new HashMap<>();
        map1.put(1,1);
        map1.put(2,2);
        map1.put(3,3);
        map2.put(1,4);
        for(Map.Entry<Integer,Integer> entry:map1.entrySet()){
            if(map2.containsKey(entry.getKey())){
                map2.put(entry.getKey(),map2.get(entry.getKey())+entry.getValue());
            }else{
                map2.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println(map2);
    }
}
