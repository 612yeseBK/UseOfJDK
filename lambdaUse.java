package UseOfJDK;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * description:
 * Created by gaoyw on 2018/5/4.
 */
public class lambdaUse {
    static class Person implements Serializable {
        private int age;
        private String name;
        public Person() {
        }
        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public String getLastName(){
            return this.name;
        }
    }
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
    public static void main(String[] args) {
        List<Person> people = srcList;
        //这是匿名内部类的实例化方式
        Collections.sort(people, new Comparator<Person>() {
            public int compare(Person x, Person y) {
                return x.getLastName().compareTo(y.getLastName());
            }
        });

        //使用lambda表达式之后
        // 尽管代码简洁了很多，但它的抽象程度依然很差：开发者仍然需要进行实际的比较操作
        // （而且如果比较的值是原始类型那么情况会更糟），
        // 所以我们要借助 Comparator 里的 comparing 方法实现比较操作：
        Collections.sort(people, (Person x, Person y) -> x.getLastName().compareTo(y.getLastName()));

        //这是使用了Comparator 里的 comparing 方法返回了一个lambda表达式
        Collections.sort(people, comparing((Person p) -> p.getLastName()));


        //    在类型推导和静态导入的帮助下，我们可以进一步简化上面的代码：
        Collections.sort(people, comparing(p -> p.getLastName()));

//        我们注意到这里的 lambda 表达式实际上是 getLastName 的代理（forwarder），于是我们可以用方法引用代替它：
        Collections.sort(people, comparing(Person::getLastName));

// 最后，使用 Collections.sort 这样的辅助方法并不是一个好主意：它不但使代码变的冗余，也无法为实现 List 接口的数据结构提供特定（specialized）的高效实现，\
// 而且由于 Collections.sort 方法不属于 List 接口，用户在阅读 List 接口的文档时
// 不会察觉在另外的 Collections 类中还有一个针对 List 接口的排序（sort()）方法。
//  默认方法可以有效的解决这个问题，我们为 List 增加默认方法 sort()，然后就可以这样调用：
        people.sort(comparing(Person::getLastName));

// 此外，如果我们为 Comparator 接口增加一个默认方法 reversed()（产生一个逆序比较器），
// 我们就可以非常容易的在前面代码的基础上实现降序排序。
        people.sort(comparing(Person::getLastName).reversed());
    }



}
