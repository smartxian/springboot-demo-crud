package cn.xianxian.ssmcrud.service.impl;

import cn.xianxian.ssmcrud.entity.Department;
import cn.xianxian.ssmcrud.repository.DeptRepository;
import cn.xianxian.ssmcrud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DeptRepository deptRepository;
    @Override
    public List<Department> getDepts() {
        return deptRepository.findAll();
    }
}