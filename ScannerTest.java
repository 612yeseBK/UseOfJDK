package UseOfJDK;

import java.util.Arrays;
import java.util.Scanner;

/**
 * description:
 * Created by gaoyw on 2018/4/30.
 */
public class ScannerTest {

    public static void testScanner(){
        Scanner reader=new Scanner(System.in);
        double sum=0;
        int m=0;
        while(reader.hasNextDouble()) {
            double x=reader.nextDouble();
            m=m+1;
            sum=sum+x;
        }
        System.out.printf("%d个数的和为%f\n",m,sum);
        System.out.printf("%d个数的平均值是%f\n",m,sum/m);
    }

    public static void testNextLine(){
        String s1,s2;
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入第一个字符串：");
        s1=sc.next();//next()之后cursor会依然指向本行，读取空格前的字符
        System.out.print("请输入第二个字符串：");
        //由于cursor没有换行，所以仍然有一个换行符存在，nextLine()会依据这个换行符自动读取当前行
        // 需要读取实际意义的下一行，可以在之前先调用sc.nextLine()
        s2=sc.nextLine();
        System.out.println("输入的字符串是："+s1+" "+s2);
    }

    public static void testNextLine2(){
        String s1,s2;
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入第一个字符串：");
        s1=sc.nextLine();
        System.out.print("请输入第二个字符串：");
        s2=sc.next();
        System.out.println("输入的字符串是："+s1+" "+s2);
    }

    public static void testNextLine3(){
        String s1,s2;
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入第一个字符串：");
        s1=sc.next();
        sc.nextLine();//这里是读取了之前没有被读取的换行符
        System.out.print("请输入第二个字符串：");
        s2=sc.nextLine();
        System.out.println("输入的字符串是："+s1+" "+s2);
    }

    public static void testWhile(){
        Scanner in = new Scanner(System.in);
        // 一个while就是一个测试用例
        while(in.hasNext()){
            int n = in.nextInt(); // 该测试用例后续接收的参数个数
            long[] array = new long[n];
            String[] arrayStr = new String[n];
            for(int i=0; i<n; i++){
                arrayStr[i] = in.next();
            }
            for(int i=0; i<n; i++){
                array[i] = in.nextLong();// 取下一个元素转换成long类型
            }
            System.out.println(Arrays.toString(array)+" "+ Arrays.toString(arrayStr));
        }
    }

    public static void testBreak(){
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("break")) {
            String input = sc.next();
            if (input.equals("finish")) break;
            System.out.println(input);
        }
        System.out.println("loop has finished");
    }

    public static void main(String[] args){
//        testScanner();
        testNextLine();
//        testNextLine2();
//        testNextLine3();
//        testWhile();
//        testBreak();
    }
}
