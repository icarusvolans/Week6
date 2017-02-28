package com.davida.finalApp.repository;

import com.davida.finalApp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 2/2/17.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
