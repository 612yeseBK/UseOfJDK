package UseOfJDK;

import java.util.*;


/**
 * description:
 * Created by gaoyw on 2018/5/4.
 */
public class fanxingUse {
    static class Test<T> {
        private T ob; // 定义泛型成员变量
        public Test(T ob) {
            this.ob = ob;
        }
        public T getOb() {
            return ob;
        }
        public void setOb(T ob) {
            this.ob = ob;
        }
        public void showType() {
            System.out.println("T的实际类型是: " + ob.getClass().getName());
        }
    }


    @org.junit.Test
    public void testfx() {
        // 定义泛型类Gen的一个Integer版本
        Test<Integer> intOb = new Test<>(88);
        List l  = new ArrayList();
        intOb.showType();
        int i = intOb.getOb();
        System.out.println("value= " + i);
        System.out.println("----------------------------------");
        // 定义泛型类Gen的一个String版本
        Test<String> strOb = new Test<>("Hello Gen!");
        strOb.showType();
        String s = strOb.getOb();
        System.out.println("value= " + s);
    }

    //使用extends限制传入的类型
    static class CollectionGenTest<T extends Collection> {
        private T x;
        public CollectionGenTest(T x) {
            this.x = x;
        }
        public T getX() {
            return x;
        }
        public void showType() {
            System.out.println("T的实际类型是: " + x.getClass().getName());
        }
        public void setX(T x) {
            this.x = x;
        }
    }

    @org.junit.Test
    public void testextends() {
        String[] stringArray = { "a", "b", "c", "d", "e" };
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stringArray));

        //传入的类型指定可以在引用类型里面指定，
        CollectionGenTest<ArrayList> listTest= null;
        listTest = new CollectionGenTest<>(arrayList);
        listTest.showType();
        ArrayList arrayList1 = listTest.getX();
        arrayList1.forEach(System.out::print);
        System.out.println();

        //瞎指名也可以这是为什么
//        CollectionGenTest<LinkedList> listTest1 = null;
//        listTest1=new CollectionGenTest(arrayList);
//        LinkedList arrayList2 = listTest1.getX();//此处取出来的是LinkedList，并在运行时出错
//        arrayList2.stream().forEach(System.out::print);

        //如果不在引用类型里面指明T的类型的话，会使用extends后面的Collection作为默认类型,取出来的也是Collection
        //实例化的类型不会被接受
        CollectionGenTest listTest2 = null;
        listTest2=new CollectionGenTest<ArrayList>(arrayList);
        //listTest2.getX()返回的是collection类
        ArrayList arrayList3 = new ArrayList(listTest2.getX());
        listTest2.showType();
        arrayList3.forEach(System.out::print);
    }


    //虽然Java泛型简单的用 extends 统一的表示了原有的 extends 和 implements 的概念，
    // 但仍要遵循应用的体系，Java 只能继承一个类，但可以实现多个接口，
    // 所以你的某个类型需要用 extends 限定，且有多种类型的时候，只能存在一个是类，
    // 并且类写在第一位，接口列在后面，也就是：
    //<T extends SomeClass & interface1 & interface2 & interface3>


}
