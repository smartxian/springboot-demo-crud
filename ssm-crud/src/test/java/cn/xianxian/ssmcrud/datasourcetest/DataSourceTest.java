package cn.xianxian.ssmcrud.datasourcetest;

import cn.xianxian.ssmcrud.repository.DeptRepository;
import cn.xianxian.ssmcrud.repository.EmpRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    @Autowired
    private EmpRepository empRepository;
    @Autowired
    private DeptRepository deptRepository;

//    @Test
//    public void getDepartmentTest() {
//        Employee employee = empRepository.getOne(1);
//        System.out.println(employee);
////        System.out.println(deptRepository.findById(employee.getDepartment().getDeptId()));
//    }



}