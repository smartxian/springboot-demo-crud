package cn.xianxian.ssmcrud.entity;

import javax.persistence.*;

@Table(name = "tnl_dept")
@Entity
public class Department {
    private Integer deptId;
    private String deptName;
//    private List<Employee> employees;

    public Department() {
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public Department(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    @Column(name = "dept_id")
    @GeneratedValue
    @Id
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Column(name = "dept_name")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

//    //在one-to-many注解配置： @OneToMany (mappedBy = "Articles"),mappedBy指向的是要关联的属性，而不是要关联的类，
//    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE})
//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }

//    @Override
//    public String toString() {
//        return "Department{" +
//                "deptId=" + deptId +
//                ", deptName='" + deptName + '\'' +
//                '}';
//    }
}