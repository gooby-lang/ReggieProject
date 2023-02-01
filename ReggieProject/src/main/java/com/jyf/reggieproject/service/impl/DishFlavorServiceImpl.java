package com.jyf.reggieproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyf.reggieproject.entity.DishFlavor;
import com.jyf.reggieproject.mapper.DishFlavorMapper;
import com.jyf.reggieproject.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
