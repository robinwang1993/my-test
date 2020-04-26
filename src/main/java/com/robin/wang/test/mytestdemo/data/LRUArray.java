package com.robin.wang.test.mytestdemo.data;

import java.util.Arrays;
import java.util.HashMap;

public class LRUArray {
    private int[] cache;
    int head;

    LRUArray(int size) {
        this.cache = new int[size];
        this.head = 0;
    }

    void put(int value) {
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == value && i != head-1) {
                shiftArray(cache, i, head);
            }else if (cache[i] == value && i==head-1){
                return;
            }
        }
        cache[head % cache.length] = value;
        head = (head + 1) % (cache.length);
    }

    private void shiftArray(int[] cache, int i, int head) {
        if (i < head) {
            for (int index = i; i <= head; i++) {
                cache[index] = cache[index + 1];
            }
            head = head - 1;
            return;
        }
        for (int index = i; index < cache.length; index++) {
            cache[index] = cache[(index + 1) % cache.length];
        }
        for (int index = 0; index < head; index++) {
            cache[index] = cache[index + 1];
        }
        head = (cache.length + head - 1) % cache.length;
        return;
    }

    public static void main(String[] args) {
        LRUArray lruArray = new LRUArray(8);
        for (int i = 0; i < 10; i++) {
            Long round = Math.round(10 * Math.random());
            lruArray.put(round.intValue());
            System.out.println(Arrays.toString(lruArray.cache)+",head:"+lruArray.head+",cache[head]:"+lruArray.cache[(lruArray.head+lruArray.cache.length-1)%lruArray.cache.length]);
        }
    }

}
