package cn.xianxian.ssmcrud.controller;

import cn.xianxian.ssmcrud.entity.Employee;
import cn.xianxian.ssmcrud.model.Result;
import cn.xianxian.ssmcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * restful的uri
 * /emp/{id}  GET   查询员工信息
 * /emp    POST   保存员工信息
 * /emp/{id}   PUT  更新员工信息
 * /emp/{id}   DELETE  删除员工信息
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

//    @RequestMapping("/emps")
    public String getEmps(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("emps",employees);
        return "list";
    }

    @ResponseBody
    @RequestMapping("/emps")
    public Result getEmpsWithJSON() {
        List<Employee> employees = employeeService.findAll();
//        return employees;
        return Result.success().add("emps",employees);
    }

    /**
     * 保存员工
     * @return
     */
    @ResponseBody
    @PostMapping("/emp")
    public Result saveEmp(@Valid Employee employee, BindingResult result) {
//        System.out.println("要保存的员工数据：" + employee);
        if(result.hasErrors()) {
            Map<String,Object> map = new HashMap<>();
            //校验失败
            List<FieldError> errors = result.getFieldErrors();
            for(FieldError fieldError:errors) {
//                System.out.println("字段名:" + fieldError.getField());
//                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Result.fail().add("errorFields",map);
        } else {
            employeeService.saveEmp(employee);
            return Result.success();
        }
    }

    /**
     * 检查用户名是否可用
     * @param empName
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkuser")
    public Result checkUser(@RequestParam("empName") String empName) {
        //判断用户名是否是合法的表达式
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if(!empName.matches(regx)) {
            return Result.fail().add("va_msg","用户名必须是2-5位中文或者6-16位英文和数字的组合");
        }
        //数据库用户名重复校验
        boolean b = employeeService.checkUser(empName);
        if(b) {
            return Result.success();
        } else {
            return Result.fail().add("va_msg","用户名不可用");
        }
    }

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/emp/{id}")
    public Result getEmp(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmp(id);
//        System.out.println(employee.toString());
        return Result.success().add("emp",employee);
    }

    /**
     * 如果直接发送ajax=PUT请求
     * 封装的数据，将要更新的员工数据:Employee{empId=11, empName='null', gender='null', email='null', department=null}
     * 请求体中有数据，但是Employee对象封装不上
     *
     * 员工更新
     * @param employee
     * @return
     */
    @ResponseBody
    @PutMapping("/emp/{empId}")
    public Result saveEmp(@Validated Employee employee) {
        System.out.println("将要更新的员工数据:" + employee);
        Employee employee1 = employeeService.getEmp(employee.getEmpId());
        employee.setEmpName(employee1.getEmpName());
        employeeService.updateEmp(employee);
        return Result.success();
    }


    /**
     * 根据员工id删除单个员工
     * @param id
     * @return
     */
//    @ResponseBody
//    @DeleteMapping("/emp/{id}")
//    public Result deleteEmpById(@PathVariable("id") Integer id) {
//        employeeService.deleteEmp(id);
//        return Result.success();
//    }


    /**
     * 批量删除和单个员工删除二合一
     * 批量删除 1-2-3-4
     * 单个删除 1
     * @param ids
     * @return
     */
    @ResponseBody
    @DeleteMapping("/emp/{ids}")
    public Result deleteEmpById(@PathVariable("ids") String ids) {
        if(ids.contains("-")) {
            String[] str_ids = ids.split("-");
            List<Integer> del_ids = new ArrayList<>();
            for(String id:str_ids) {
                del_ids.add(Integer.parseInt(id));
            }
            employeeService.deleteBatch(del_ids);
        } else {
            Integer id = Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }
        return Result.success();
    }


}