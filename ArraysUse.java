package UseOfJDK;

import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * description:
 * Created by gaoyw on 2018/5/3.
 */
public class ArraysUse {
    public static void testinitial(){
        String[] stringArray = { "a", "b", "c", "d", "e" };
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stringArray));
        arrayList.add("k");
        System.out.println(arrayList);
    }

    public static void main(String[] args) {
        testinitial();
    }
}
