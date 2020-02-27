package com.github.hcsp.calculation;

public class Main {
    // 返回number乘以16的结果
    // 请不要使用乘号
    public static int multiply16(int number) {
        return number<<4;
    }
    // 返回number除以16的结果
    // 请不要使用除号
    public static int divide16(int number) {
        return number>>4;
    }
    /*
    >>  ：算术右移运算符，也称带符号右移。用最高位填充移位后左侧的空位。
    >>>：逻辑右移运算符，也称无符号右移。只对位进行操作，用0填充左侧的空位。
    区别：
    逻辑右移就是不考虑符号位，右移一位，左边补零即可。
    算术右移需要考虑符号位，右移一位，若符号位为1，就在左边补1,；否则，就补0。
    所以算术右移也可以进行有符号位的除法，右移,n位就等于除2的n次方。也就是说可以对负数操作
    比如-3变为-1，-2变为-1，而-1比较特殊，右移还是-1.

   */

    public static void main(String[] args) {
        System.out.println(multiply16(10));
        System.out.println(divide16(1600));
    }
}
