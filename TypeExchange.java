package UseOfJDK;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.*;

/**
 * description:
 * Created by gaoyw on 2018/5/2.
 */
public class TypeExchange {
    /**
     * Integer转换成int的方法
     **/
    public static void Integer2Int(){
        System.out.println("========Integer转成int类型=========");
        Integer i = new Integer(10);
        int k = i.intValue();
        System.out.println(k);
    }


    /**
     * int转换成Integer的方法
     **/
    public static void Int2Integer(){
        System.out.println("========int转换成Integer的方法=========");
        int i = 10;
        Integer it = new Integer(i);
        System.out.println(it);
    }



    /**
     * int转换成String
     **/
    public static void int2String(){
        int i = 10;
        System.out.println("========int转换成String=========");
        String s1 = String.valueOf(i);
        System.out.println(s1);
        String s2 = Integer.toString(i);
        System.out.println(s2);
        String s3 = "" + i;
        System.out.println(s3);
    }


    /**
     * String转换成Integer
     **/
    public static void String2Integer(){
        System.out.println("========String转换成Integer=========");
        String str = "10";
        Integer it = Integer.valueOf(str);
        System.out.println(it);
    }



    /**
     * Integer转换成String
     **/
    public static void Integer2String(){
        System.out.println("========Integer转换成String=========");
        Integer it = new Integer(10);
        String str = it.toString();
        System.out.println(str);
    }

    /**
     * String转换成BigDecimal
     **/
    public static void String2BigDecimal(){
        System.out.println("========String转换成BigDecimal=========");
        String str = "aaa";
        BigDecimal bd = new BigDecimal(str);
        System.out.println(bd);
    }


    /**String2Char
     * 在Java中将String转换为char是非常简单的。
     1. 使用String.charAt(index)（返回值为char）可以得到String中某一指定位置的char。
     2. 使用String.toCharArray()（返回值为char[]）可以得到将包含整个String的char数组。
     这样我们就能够使用从0开始的位置索引来访问string中的任意位置的元素。
     */


    /**
     * char转换为String

     将char转换为String大致有6种方法。总结如下：

     1. String s = String.valueOf('c'); //效率最高的方法

     2. String s = String.valueOf(new char[]{'c'}); //将一个char数组转换成String

     3. String s = Character.toString('c');
     // Character.toString(char)方法实际上直接返回String.valueOf(char)

     4. String s = new Character('c').toString();

     5. String s = "" + 'c';
     // 虽然这个方法很简单，但这是效率最低的方法
     // Java中的String Object的值实际上是不可变的，是一个final的变量。
     // 所以我们每次对String做出任何改变，都是初始化了一个全新的String Object并将原来的变量指向了这个新String。
     // 而Java对使用+运算符处理String相加进行了方法重载。
     // 字符串直接相加连接实际上调用了如下方法：
     // new StringBuilder().append("").append('c').toString();


     6. String s = new String(new char[]{'c'});
     */


    /**比较字符串大小
     * 使用 String.compareTo 方法：

     compareTo() 的返回值是int, 它是先比较对应字符的大小(ASCII码顺序)
     1、如果字符串相等返回值0
     2、如果第一个字符和参数的第一个字符不等,结束比较,返回他们之间的差值（ascii码值）（负值前字符串的值小于后字符串，正值前字符串大于后字符串）
     3、如果第一个字符和参数的第一个字符相等,则以第二个字符和参数的第二个字符做比较,以此类推,直至比较的字符或被比较的字符有一方全比较完,这时就比较字符的长度.

     例:
     String s1 = "abc";
     String s2 = "abcd";
     String s3 = "abcdfg";
     String s4 = "1bcdfg";
     String s5 = "cdfg";
     System.out.println( s1.compareTo(s2) ); // -1 (前面相等,s1长度小1)
     System.out.println( s1.compareTo(s3) ); // -3 (前面相等,s1长度小3)
     System.out.println( s1.compareTo(s4) ); // 48 ("a"的ASCII码是97,"1"的的ASCII码是49,所以返回48)
     System.out.println( s1.compareTo(s5) ); // -2 ("a"的ASCII码是97,"c"的ASCII码是99,所以返回-2)
     */
    public static void main(String[] args) {

    }
}
