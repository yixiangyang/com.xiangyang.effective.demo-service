package com.xiangyang.test;

import java.util.*;

public class StaticHashMapTest {

    public static void main(String[] args) {
//        Map<String, List<String>> map = new HashMap<>();
        NutritionFats nutritionFats = NutritionFats.builder().calories(10).servings(15).list(Arrays.asList("aaa,ddd".split(","))).build();
        nutritionFats.setList(Arrays.asList("ggg,hh".split(",")));
//        NutritionFats nutritionFats1 = new NutritionFats();
//        nutritionFats1.setList(Arrays.asList("ggg,hh".split(",")));
//        System.out.print(nutritionFats1.getCalories());
//        System.out.println(nutritionFats.getCalories());
//        System.out.println(nutritionFats.getList());
    }
}
