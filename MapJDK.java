package UseOfJDK;

import java.util.*;
/**
 * description:map的一些用法
 * Created by gaoyw on 2018/5/2.
 */
public class MapJDK {
    public static Map<String, String> map;
    static {
        map = new HashMap<String, String>();
        map.put("张三1","男");
        map.put("张三2女","女");
        map.put("张三3","男");
        map.put("张三4","男");
        map.put("张三5女","女");
    }
    public static void iterator() {
        System.out.println("=======通过map.keySet()去获取key值,然后通过键key获取到value值=======");
        for (String s : map.keySet()) {
            System.out.println("key : " + s + " value : " + map.get(s));
        }
//        下面这种使用stream的方法也可以使用
//        map.keySet().stream().forEach(ele -> System.out.println("key : " + ele + " value : " + map.get(ele)));

        System.out.println("=======第二种只遍历键或者值，通过加强for循环=======");
        for (String s1 : map.keySet()) {//遍历map的键
            System.out.println("键key ：" + s1);
        }
        for (String s2 : map.values()) {//遍历map的值
            System.out.println("值value ：" + s2);
        }

        //第三种方式Map.Entry<String, String>的加强for循环遍历输出键key和值value
        System.out.println("========Map.Entry<String, String>的加强for循环遍历输出键key和值value==========");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("键 key ：" + entry.getKey() + " 值value ：" + entry.getValue());
        }


        //第四种Iterator遍历获取，然后获取到Map.Entry<String, String>，再得到getKey()和getValue()
        System.out.println("========Iterator遍历,获取到Map.Entry<String, String>，再得到getKey()和getValue()========");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("键key ：" + entry.getKey() + " value ：" + entry.getValue());
        }
    }

    public static void getKey() {
        System.out.println("========从map里面根据value获取key的集合==========");
        String value = "男";
        String o = null;
        List all = new ArrayList(); // 建一个数组用来存放符合条件的KEY值
        /*
         * 这里关键是那个entrySet()的方法,它会返回一个包含Map.Entry集的Set对象.
         * Map.Entry对象有getValue和getKey的方法,利用这两个方法就可以达到从值取键的目的了 *
         */
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry.getValue().equals(value)) {
                o = (String)entry.getKey();
                all.add(o); // 把符合条件的项先放到容器中,下面再一次性打印出
            }
        }
        System.out.println("value值为男的key值集合为："+all);
    }


    public static void main(String[] args){
        iterator();
        getKey();
    }
}
