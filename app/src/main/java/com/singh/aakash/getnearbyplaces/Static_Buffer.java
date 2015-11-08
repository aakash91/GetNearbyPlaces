package com.singh.aakash.getnearbyplaces;

import java.util.ArrayList;

/**
 * Created by aakash on 06-11-2015.
 */
public class Static_Buffer {

    private static ArrayList<String> stringBuffer=new ArrayList<>();

    public static ArrayList<String> getStringBuffer() {
        return stringBuffer;
    }

    public static void setStringBuffer(ArrayList<String> stringBuffer) {
        Static_Buffer.stringBuffer = stringBuffer;
    }
}
