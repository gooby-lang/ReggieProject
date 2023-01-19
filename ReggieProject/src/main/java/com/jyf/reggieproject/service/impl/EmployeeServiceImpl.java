package com.jyf.reggieproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyf.reggieproject.entity.Employee;
import com.jyf.reggieproject.mapper.EmployeeMapper;
import com.jyf.reggieproject.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
