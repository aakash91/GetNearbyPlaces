package com.singh.aakash.getnearbyplaces;

/**
 * Created by aakash on 06-11-2015.
 */
public class Counter_Class {

private static int count=0;

    public static void inc_counter(){
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Counter_Class.count = count;
    }



}
