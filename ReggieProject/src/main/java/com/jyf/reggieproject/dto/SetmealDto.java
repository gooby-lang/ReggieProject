package com.jyf.reggieproject.dto;

import com.jyf.reggieproject.entity.Setmeal;
import com.jyf.reggieproject.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
