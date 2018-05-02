package theuseofjdk;

/**
 * description:这里是string的一些方法的使用说明
 * Created by gaoyw on 2018/5/2.
 */
public class StringJDK {
    /**
     * 将字符串变成一个字符数组
     */
    public static void tocharyArry() {
        String str = "helloWorld";
        char c[] = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.println("转为数组输出:" + c[i]);
        }
    }
    /**
     * 从字符串中取出指定位置的字符
     */
    public static void tocharAt() {
        String str = "helloWorld";
        char c = str.charAt(3);
        System.out.println("指定字符为：" + c);
    }
    /**
     * 将字符串变成一个byte数组
     */
    public static void tobyte() {
        String str = "helloWorld";
        byte b[] = str.getBytes();
        System.out.println("转换成byte数组输出为：" + new String(b));
    }
    /**
     * 取得一个字符串的长度
     */
    public static void tolength() {
        String str = "helloWorld";
        int l = str.length();
        System.out.println("这个字符串的长度为：" + l);
    }
    /**
     * 查找一个指定的字符串是否存在，返回的是字符串的位置，如果不存在，则返回-1
     */
    public static void toindexOf() {
        String str = "helloWorld";
        int a1 = str.indexOf("e");// 查找字符e的位置
        int a2 = str.indexOf("l", 2);// 查找l的位置，从第3个开始查找
        System.out.println("e的位置为:" + a1);
        System.out.println("l的位置为:" + a2);
    }
    /**
     * 去掉字符串左右空格
     */
    public static void totrim() {
        String str = "helloWorld";
        String str1 = "       hello         ";
        System.out.println("去掉左右空格后输出:" + str1.trim());
    }
    /**
     * 字符串的截取
     */
    public static void tosubstring() {
        String str = "helloWorld";
        System.out.println("截取后的字符为：" + str.substring(0, 3));// 截取[0,3)个位置的内容
        System.out.println("从第3个位置开始截取：" + str.substring(2));// 从第3个位置开始截取[2,end]
    }
    /**
     * 按照指定的字符串拆分字符，拆分的数据将以字符串数组的形式返回
     */
    public static void tosplit() {
        String str = "helloWorld";
        String s[] = str.split("e");// 按hello中的e进行字符串拆分
        for (int i = 0; i < s.length; i++) {
            System.out.println("拆分后结果为：" + s[i]);
        }
    }
    /**
     * 将字符串进行大小写转换
     */
    public static void tochange() {
        String str = "helloWorld";
        System.out.println("将\"hello\"转换成大写为：" + str.toUpperCase());// 将hello转换成大写
        System.out.println("将\"HELLO\"转换成大写为：" + str.toUpperCase().toLowerCase());// 将HELLO转换成小写
    }
    /**
     * 判断是否以指定的字符串开头或者结尾
     */
    public static void tostartsWithOrendWith() {
        String str = "helloWorld";
        if(str.startsWith("he"))//判断字符串是否以he开头
        {
            System.out.println("字符串是以he开头");
        }
        if(str.endsWith("lo"))
        {
            System.out.println("字符串是以lo结尾");
        }
    }
    /**
     * 两个String类型内容比较
     */
    public static void toequals() {
        String str = "helloWorld";
        String str3="world";
        if(str.equals(str3))
        {
            System.out.println("这俩个String类型的值相等");
        }
        else
            System.out.println("这俩个String类型的不值相等");
    }
    /**
     * 两个字符串不区分大小写进行比较
     */
    public static void toequalslgnoreCase() {
        String str = "helloWorld";
        String str4="HELLO";
        if(str.equalsIgnoreCase(str4))
        {
            System.out.println("hello和HELLO忽略大小写比较值相等");
        }
    }
    /**
     * 将一个指定得到字符串替换成其他字符串
     */
    public static void toreplaceAll() {
        String str = "helloWorld";
        String str5=str.replaceAll("l", "a");
        System.out.println("替换后的结果为："+str5);
    }
    public static void main(String[] args) {
        tocharyArry();
        tocharAt();
        tobyte();
        tolength();
        toindexOf();
        totrim();
        tosubstring();
        tosplit();
        tochange();
        tostartsWithOrendWith();
        toequals();
        toequalslgnoreCase();
        toreplaceAll();
    }
}
