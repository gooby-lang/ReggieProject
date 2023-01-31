package com.jyf.reggieproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyf.reggieproject.common.CustomException;
import com.jyf.reggieproject.entity.Category;
import com.jyf.reggieproject.entity.Dish;
import com.jyf.reggieproject.entity.Setmeal;
import com.jyf.reggieproject.mapper.CategoryMapper;
import com.jyf.reggieproject.service.CategoryService;
import com.jyf.reggieproject.service.DishService;
import com.jyf.reggieproject.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count = dishService.count(dishLambdaQueryWrapper);

        //查询当前分类是否关联菜品，如果已经关联，则抛出一个业务异常
        if (count > 0) {
            throw new CustomException("当前分类下关联菜品，不能删除");
        }

        //查询当前分类是否关联套餐，如果已经关联，则抛出一个业务异常
        LambdaQueryWrapper<Setmeal> mealPackageLambdaQueryWrapper = new LambdaQueryWrapper<>();
        mealPackageLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count1 = setmealService.count(mealPackageLambdaQueryWrapper);
        if (count1 > 0) {
            throw new CustomException("当前分类下关联套餐，不能删除");
        }
        //正常删除
        super.removeById(id);
    }
}
