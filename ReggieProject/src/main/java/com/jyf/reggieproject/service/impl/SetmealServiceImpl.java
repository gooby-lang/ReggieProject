package com.jyf.reggieproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyf.reggieproject.entity.Setmeal;
import com.jyf.reggieproject.mapper.SetmealMapper;
import com.jyf.reggieproject.service.SetmealService;
import org.springframework.stereotype.Service;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
