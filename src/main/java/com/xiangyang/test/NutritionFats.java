package com.xiangyang.test;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
//Builder 使用创建者模式又叫建造者模式。简单来说，就是一步步创建一个对象，它对用户屏蔽了里面构建的细节，但却可以精细地控制对象的构造过程
public class NutritionFats {
    private  int servingSize;

    private   int servings;

    private  int calories;

    @Singular(value = "a")
    private List<String> list;


}
