package com.jyf.reggieproject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jyf.reggieproject.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
