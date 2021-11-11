package Algorithm.Bit;

/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 */
public class WithOutFourArithmetic {
    public int Add(int num1,int num2) {
        int result = 0;
        int carry = 0;
        do{
            result = num1 ^ num2;       //不带进位的加法
            carry = (num1 & num2) << 1; //进位
            num1 = result;
            num2 = carry;
        }while(carry != 0); // 进位不为0则继续执行加法处理进位
        return result;
    }
    public int Add2(int a, int b) {
        if (a == 0 || b == 0)
            return a ^ b;
        return Add2(a ^ b, (a & b) << 1);
    }
}
