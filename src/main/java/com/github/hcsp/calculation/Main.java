package com.github.hcsp.calculation;

public class Main {
    // 返回number乘以16的结果
    // 请不要使用乘号
    static int add(int num1, int num2){
        if(num2 == 0)
            return num1;
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return add(sum, carry);
    }
    static int subtract(int num1, int num2){
        int subtract = add(~num2, 1);// 先求减数的补码（取反加一）
        int result = add(num1, subtract); // add()即上述加法运算　　
        return result ;
    }
    public static int multiply16(int number) {
        int multiplicand = number < 0 ? add(~number, 1) : number;
        int multiplier = 16;
        //计算绝对值的乘积　　
        int product = 0;
        while(multiplier>0) {
            if((multiplier & 0x1) > 0) {// 每次考察乘数的最后一位　　　　
                product = add(product, multiplicand);
            }
            multiplicand = multiplicand << 1;// 每运算一次，被乘数要左移一位　　　　
            multiplier = multiplier >> 1;// 每运算一次，乘数要右移一位（可对照上图理解）　　
        }
        //计算乘积的符号　　
        if((number ^ 16) < 0) {
            product = add(~product, 1);
        }
        return product;
    }
    // 返回number除以16的结果
    // 请不要使用除号
    public static int divide16(int number) {

        // 先取被除数和除数的绝对值
        int dividend = number > 0 ? number : add(~number, 1);
        int divisor = 16;
        int quotient = 0;// 商
        for(int i = 31; i >= 0; i--) {
            if((dividend >> i) >= divisor) {
                quotient = add(quotient, 1 << i);
                dividend = subtract(dividend, divisor << i);
            }
        }
        // 确定商的符号
        if((number ^ 16) < 0){
            // 如果除数和被除数异号，则商为负数
            quotient = add(~quotient, 1);
        }
        return quotient;// 返回商
    }

    public static void main(String[] args) {
        System.out.println(multiply16(10));
        System.out.println(divide16(1600));
    }
}
