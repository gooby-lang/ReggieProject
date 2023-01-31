package com.jyf.reggieproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyf.reggieproject.entity.Dish;
import com.jyf.reggieproject.mapper.DishMapper;
import com.jyf.reggieproject.service.DishService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
