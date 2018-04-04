package cn.xianxian.ssmcrud.service.impl;

import cn.xianxian.ssmcrud.entity.Employee;
import cn.xianxian.ssmcrud.repository.EmpRepository;
import cn.xianxian.ssmcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmpRepository empRepository;

    @Override
    public List<Employee> findAll() {
        return empRepository.findAll();
    }

    /**
     * 员工保存
     */
    @Override
    public void saveEmp(Employee employee) {
        empRepository.save(employee);
    }

    /**
     * 检验用户名是否可用
     * @param empName
     * @return
     * true 代表当前姓名可用，false 代表不可用
     */
    @Override
    public boolean checkUser(String empName) {
        List<Employee> employees = empRepository.findAllByEmpName(empName);
//        System.out.println(employees);
        return employees.isEmpty();
    }

    /**
     *按照员工id查询员工
     * @param id
     * @return
     */
    @Override
    public Employee getEmp(Integer id) {
        //这里必须要用findOne，用getOne会将department对象的具体数据返回给前端，而使用findOne则会将department的id返回给前端
        Employee employee = empRepository.findOne(id);

        return employee;
    }

    /**
     * 员工更新
     * @param employee
     */
    @Override
    public void updateEmp(Employee employee) {
//        Employee employee1 = empRepository.findOne(employee.getEmpId());
//        employee.setEmpName(employee1.getEmpName());
        empRepository.save(employee);
    }

    @Override
    public void deleteEmp(Integer id) {
        empRepository.delete(id);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        for(Integer id:ids) {
            empRepository.delete(id);
        }
    }
}