package com.calculator;

public class App {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Divide by zero");
        return a / b;
    }

    public static void main(String[] args) {
        App calc = new App();
        System.out.println("May tinh dang hoat dong!");
        System.out.println("KET QUA THUAT TOAN MAY : ");
        System.out.println("Phep cong (10+5): " + calc.add(10, 5));
        System.out.println("Phep tru (10-5): " + calc.subtract(10, 5));
        System.out.println("Phep nhan (10*5): " + calc.multiply(10, 5));
        System.out.println("Phep chia (10/5): " + calc.divide(10, 5));
    }
}