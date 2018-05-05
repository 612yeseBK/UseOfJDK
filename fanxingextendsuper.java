package UseOfJDK;

/**
 * description:
 * Created by gaoyw on 2018/5/5.
 */
public class fanxingextendsuper {

    static class Food{}
    static class Fruit extends Food{}
    static class Meat extends Food{}
    static class Apple extends Fruit{}
    static class Banana extends Fruit{}
    static class Pork extends Meat{}
    static class Beef extends Meat{}
    static class RedApple extends Apple{}
    static class GreenApple extends Apple{}

    static class Plate<T>{
        private T item;
        public Plate(T t){item=t;}
        public void set(T t){item=t;}
        public T get(){return item;}
    }
    public static void main(String[] args) {
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());
    }
}
