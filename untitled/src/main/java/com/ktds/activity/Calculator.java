package com.ktds.boardprac.activity;

public class Calculator {
    //정수형 덧셈 메서드

    public int add(int a, int b) {

        System.out.println("1 정수형 덧셈 메서드 호출");

        return a + b;

    }



    //실수형 덧셈 메서드

    public double add(double a, double b) {

        System.out.println("2 실수형 덧셈 메서드 호출");

        return a + b;

    }



    //문자열 덧셈 메서드

    public String add(String a, String b) {

        System.out.println("3 문자열 덧셈 메서드 호출");

        return a + b;

    }



    public static void main(String[] args) {

        Calculator calculator = new Calculator();



        calculator.add(2.3, 5.4);

        calculator.add(1, 2);

        calculator.add(1.3, 2);

        calculator.add("Hello, ", "World");

    }
}
