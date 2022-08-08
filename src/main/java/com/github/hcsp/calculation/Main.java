package com.github.hcsp.calculation;

public class Main {
    // 返回number乘以16的结果
    // 请不要使用乘号
    public static int multiply16(int number) {
        if (number<0){
            number = ~number + 1;
            number = number <<4;
            number = ~number + 1;
            return number;
        }
        return number <<4;
    }
    // 返回number除以16的结果
    // 请不要使用除号
    public static int divide16(int number) {
        if (number<0) {
            number = ~number + 1;
            number = number >>>4;
            number = ~number + 1;
            return number;
        }
        return number >>>4;
    }

    public static void main(String[] args) {
        System.out.println(multiply16(10));
        System.out.println(divide16(1600));
    }
}
