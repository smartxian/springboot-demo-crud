package cn.xianxian.ssmcrud.repository;

import cn.xianxian.ssmcrud.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Department,Integer> {
}