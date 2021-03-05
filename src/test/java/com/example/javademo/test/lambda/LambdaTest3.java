package com.example.javademo.test.lambda;


import com.example.javademo.service.LambdaService;

public class LambdaTest3 {

    public static void main(String[] args) {
        LambdaService.ReturnOneParam lambda1 = a -> doubleNum(a);
        System.out.println(lambda1.method(3));

        //lambda2 引用了已经实现的 doubleNum 方法
        LambdaService.ReturnOneParam lambda2 = LambdaTest3::doubleNum;
        System.out.println(lambda2.method(3));

        LambdaTest3 exe = new LambdaTest3();

        //lambda4 引用了已经实现的 addTwo 方法
        LambdaService.ReturnOneParam lambda4 = exe::addTwo;
        System.out.println(lambda4.method(2));
    }

    /**
     * 要求
     * 1.参数数量和类型要与接口中定义的一致
     * 2.返回值类型要与接口中定义的一致
     */
    public static int doubleNum(int a) {
        return a * 2;
    }

    public int addTwo(int a) {
        return a + 2;
    }

}
