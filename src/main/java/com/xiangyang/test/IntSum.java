package com.xiangyang.test;

import static java.lang.Integer.MAX_VALUE;

public class IntSum {
    public static void main(String[] args) {
        /*Long intSum = 0l;
        for(int i=1;i<2;i++){
            intSum += i;

        }
        System.out.print(intSum);*/
        System.out.println("开始后 -----");
        Long sum =0l;
        for (Long i = 0l; i< MAX_VALUE; i++){
            sum +=i;
        }
        System.out.println("结束---------");
        System.out.println(sum);

    }
}
