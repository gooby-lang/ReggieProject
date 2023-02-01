package com.jyf.reggieproject.dto;

import com.jyf.reggieproject.entity.Dish;
import com.jyf.reggieproject.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
