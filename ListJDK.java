package UseOfJDK;


import java.io.*;
import java.util.*;


/**
 * description:这里是list的使用方法说明
 * Created by gaoyw on 2018/5/2.
 */
public class ListJDK {
    static List<Person> srcList;
    static {
        srcList=new ArrayList<Person>();
        Person p1=new Person(20,"123");
        Person p2=new Person(21,"ABC");
        Person p3=new Person(22,"abc");
        srcList.add(p1);
        srcList.add(p2);
        srcList.add(p3);
    }

    public static void initialize(){
        List<String> name2;
        System.out.println("一般初始化方法，使用add()：");
        List<String> name1 = new ArrayList();
        name1.add("xxx");
        name1.add("yyy");
        name1.add("zzz");
        Iterator<String> it1 = name1.iterator();
        while (it1.hasNext()) {
            System.out.print(it1.next()+" ");
        }
        System.out.println("\n使用过asList形成一个固定长度的list：");
        System.out.println("传入三个字符串xxx,yyy,zzz：");
        name2 = Arrays.asList("xxx","yyy","zzz");
//        name2.add("aaa");//使用这种固定长度的初始化方法初始化了list之后就不可以在添加了，这是一个定长list
//        name2.remove(0);//也不可以删除list
        name2.set(0,"aaa");//但是可以修改
        name2.stream().forEach(ele -> System.out.print(ele + " "));//jdk8的新特性，将list转成stream来处理
        System.out.println("\n传入数组String[]{aaa,bbb}：");
        name2 = Arrays.asList(new String[]{"aaa","bbb"});
        name2.stream().forEach(ele -> System.out.print(ele + " "));
        System.out.println("\n初始化长度为2，但是它会自动增长适应：");
        name2 = new ArrayList(2);//初始化长度并不会影响list存储的数目，它会自动增长
        name2.add("a");
        name2.add("b");
        name2.add("c");
        name2.stream().forEach(ele -> System.out.print(ele + " "));
    }

    /**
     * 在使用List集合时需要注意区分add(int index, Object obj)方法和set(int index, Object obj)方法，
     * 前者是向指定索引位置添加对象，其余位置对象后移，而后者是修改指定索引位置的对象
     */
    public static void addAndSet(){
        //set(index,object)
        System.out.println("原list是A E C");
        System.out.println("下面是测试set(1,B)");
        List<String> list = new LinkedList<String>();
        list.add("A");
        list.add("E");
        list.add("C");
        list.set(1, "B");// 将索引位置为1的对象e修改为对象b
        list.stream().forEach(ele -> System.out.print(ele + " "));
        System.out.println("\n下面是测试add(1,C)");
        //add(index,object)
        List<String> list2 = new LinkedList<String>();
        list2.add("A");
        list2.add("E");
        list2.add("C");
        list2.add(1, "C");// 将对象c添加到索引位置为2的位置
        list2.stream().forEach(ele -> System.out.print(ele + " "));
    }

    /**
     * 在使用List集合时需要注意区分indexOf(Object obj)方法和lastIndexOf(Object obj)方法，
     * 前者是获得指定对象的最小的索引位置，
     * 而后者是获得指定对象的最大的索引位置，前提条件是指定的对象在List集合中具有重复的对象，
     * 否则如果在List集合中有且仅有一个指定的对象，则通过这两个方法获得的索引位置是相同的
     */
    public static void IndexOf(){
        List<String> list = Arrays.asList("A","Repeat","B","Repeat","C","Repeat","D");
        System.out.println("list是：A Repeat B Repeat C Repeat D");
        System.out.println("Repeat的第一个位置下标是："+list.indexOf("Repeat"));
        System.out.println("Repeat的最后一个位置下标是："+list.lastIndexOf("Repeat"));
        System.out.println("B的第一个位置下标是："+list.indexOf("B"));
        System.out.println("B的最后一个位置下标是："+list.lastIndexOf("B"));
    }

    /**
     * sublist(startIndex,endIndex)是截取list的函数，截取list里面下标[startIndex,endIndex)之间的元素
     */
    public static void sublist(){
        List<String> list = Arrays.asList("A","Repeat","B","Repeat","C","Repeat","D");
        System.out.println("原list是：A Repeat B Repeat C Repeat D");
        List<String> list2;
        list2=list.subList(1,3);
        System.out.println("截取了[1,3)后的list为：");
        list2.stream().forEach(ele -> System.out.print(ele + " "));
        System.out.println("\n原来的list依然不变，为：");
        list.stream().forEach(ele -> System.out.print(ele + " "));
    }

    /**
     * A.retainAll(B),A中只保留B中有的元素，重复的都会保留
     * A.removeAll(B),A中去除B的所有元素
     * A.addAll(B),A中增加B的所有元素，可以增加相同的
     */
    public static void betweenList(){
        Long[] id ={1L,2L,3L,4L,5L,6L};
        Long[] ids ={1L,2L,7L,8L,9L,10L};
        //Arrays.asList(id)把数组转出List集合
        List<Long> oldUserId = new ArrayList<>(Arrays.asList(id));
        List<Long> newUserId = new ArrayList<>(Arrays.asList(ids));
        List<Long> intersectionUserId = new ArrayList<>();
        System.out.println("原集合为："+oldUserId+";"+newUserId);
        intersectionUserId.addAll(oldUserId);
        //1.2 取出交集
        intersectionUserId.retainAll(newUserId);
        System.out.println("交集"+intersectionUserId);
        oldUserId.removeAll(intersectionUserId);  //需要删除的信息
        System.out.println("oldUserId去除交集元素的集合"+oldUserId);
        newUserId.removeAll(intersectionUserId);  //需要添加的数据
        System.out.println("newUserId去除交集元素的集合"+newUserId);
    }

    /**
     * 数组转list：Arrays.asList(s)
     * list转数组：s1.toArray()，再加个强制类型转换
     */
    public static void Arrar2List(){
        Long[] id ={1L,2L,3L,4L,5L,6L};
        //Arrays.asList(id)把数组转出List集合
        List<Long> oldUserId = new ArrayList<>(Arrays.asList(id));
        String[] s ={"a","b","c","d"};
        List<String> s1 = Arrays.asList(s);
        System.out.println(s1);
        //下面是listtoarray
        System.out.println("List转成数组，无参方法：");
        s = (String[])s1.toArray();
        Arrays.stream(s).forEach(ele -> System.out.print(ele + " "));
        System.out.println("\n传入存放对象的方式，存放数组对象长度不够会自动增加：");
        s = s1.toArray(new String[s1.size()-2]);//这里的长度显然是不够的
        Arrays.stream(s).forEach(ele -> System.out.print(ele + " "));
    }

    public static void getSetFromList(){
        List<String> list = Arrays.asList("A","Repeat","B","Repeat","C","Repeat","D");
        List list1 = new ArrayList(new HashSet(list));
        list1.stream().forEach(ele -> System.out.print (ele+" "));
    }

    /**
     * 获取list里面的互不相同的元素，并保留原有顺序
     */
    public static void getUniqueList(){
        List<String> list = Arrays.asList("A","Repeat","B","Repeat","C","Repeat","D");
        //方法1
        List listRe = new ArrayList();
        Set set = new HashSet(list);
        for (String s : list){
            if (set.contains(s)){
                listRe.add(s);
                set.remove(s);
            }
        }
        System.out.println("去重后的集合： " +listRe);

        //方法2
        Set set2 = new  HashSet();
        List newList = new  ArrayList();
        for (String cd:list) {
            if(set2.add(cd)){
                newList.add(cd);
            }
        }
        System.out.println( "去重后的集合： " + newList);
    }


    public static void lowcopy(){
        System.out.println("====使用addAll进行的是浅拷贝====");
        List<Person> destList=new ArrayList<Person>();
        destList.addAll(srcList);
        System.out.println("更改之前");
        destList.stream().forEach(ele->System.out.print(ele.toString()+" "));
        srcList.get(0).setAge(100);
        System.out.println("\n更改原版之后");
        destList.stream().forEach(ele->System.out.print(ele.toString()+" "));
        srcList.get(0).setAge(20);
        System.out.println("\n====使用clone()和System.arraycopy进行的是浅拷贝====");
        Person[] srcPersons=srcList.toArray(new Person[0]);
        Person[] destPersons=new Person[srcPersons.length];
        //以下2种方法都是不行的
        System.arraycopy(srcPersons, 0, destPersons, 0, srcPersons.length);
        destPersons=srcPersons.clone();


        System.out.println("更改之前");
        for (Person p:destPersons){
            System.out.print(p.toString()+" ");
        }
        srcPersons[0].setAge(100);
        System.out.println("\n更改原版之后");
        for (Person p:destPersons){
            System.out.print(p.toString()+" ");
        }

//        List<Person> destList=Arrays.asList(destPersons);
//        printList(destList);
    }

    /**
     * 基本上大多数拷贝方法都是浅拷贝，有时我们需要深度拷贝
     *
     */
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }
    public static void depcopyUse() throws IOException, ClassNotFoundException {
        List<Person> destList=deepCopy(srcList);
        System.out.println("更改之前");
        destList.stream().forEach(ele->System.out.print(ele.toString()+" "));
        srcList.get(0).setAge(100);
        System.out.println("\n更改原版之后");
        destList.stream().forEach(ele->System.out.print(ele.toString()+" "));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        initialize();
//        addAndSet();
//        IndexOf();
//        sublist();
//        betweenList();
//        Arrar2List();
//        getUniqueList();
//        getSetFromList();
//        depcopyUse();
        lowcopy();
    }

    static class Person implements Serializable{
        private int age;
        private String name;

        public Person(){};
        public Person(int age,String name){
            this.age=age;
            this.name=name;
        }

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String toString(){
            return this.name+"-->"+this.age;
        }

    }
}
