package com.jyf.reggieproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jyf.reggieproject.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    
}
