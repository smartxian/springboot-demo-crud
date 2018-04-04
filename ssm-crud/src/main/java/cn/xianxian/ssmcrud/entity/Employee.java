package cn.xianxian.ssmcrud.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Table(name = "tbl_emp")
@Entity
public class Employee {
    private Integer empId;

    @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})",
            message = "用户名可以是2-5位中文或者6-16位英文和数字的组合 ")
    private String empName;
    private String gender;
    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
            message = "邮箱格式不正确")
    private String email;
    private Integer dId;

    //希望查询员工的同时部门信息也是查询好的
    private Department department;

    public Employee() {
    }

    public Employee(String empName, String gender, String email, Integer dId) {
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }

//    public Employee(Integer empId, String empName, String gender, String email, Department department) {
//        this.empId = empId;
//        this.empName = empName;
//        this.gender = gender;
//        this.email = email;
////        this.dId = dId;
//        this.department = department;
//    }

    public Employee(Integer empId, String empName, String gender, String email, Integer dId) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }

//    public Employee(Integer empId, String empName, String gender, String email) {
//        this.empId = empId;
//        this.empName = empName;
//        this.gender = gender;
//        this.email = email;
//    }

    @Column(name = "emp_id")
    @GeneratedValue
    @Id
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Column(name = "emp_name")
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JoinColumn(name = "d_id",insertable = false,updatable = false)
    @ManyToOne
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Column(name = "d_id")
    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                '}';
    }
}