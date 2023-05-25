package com.example.angularjavaproject.Repository;

import com.example.angularjavaproject.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Transactional
    @Modifying
    @Query("delete from Employee e")
    int deleteFirstBy();
}
