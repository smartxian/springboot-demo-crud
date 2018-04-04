package cn.xianxian.ssmcrud.controller;

import cn.xianxian.ssmcrud.entity.Department;
import cn.xianxian.ssmcrud.model.Result;
import cn.xianxian.ssmcrud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理和部门有关的请求
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Result getDepts() {
        //查出所有部门信息
        List<Department> list = departmentService.getDepts();
        return Result.success().add("depts",list);
    }
}