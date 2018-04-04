package cn.xianxian.ssmcrud.service;

import cn.xianxian.ssmcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    void saveEmp(Employee employee);
    boolean checkUser(String empName);
    Employee getEmp(Integer id);
    void updateEmp(Employee employee);
    void deleteEmp(Integer id);
    void deleteBatch(List<Integer> ids);
}