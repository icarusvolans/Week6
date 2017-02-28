/*
package com.davida.finalApp.impl;


//import com.davida.finalApp.converter.LocalDateTimeAttributeConverter;
import com.davida.finalApp.model.Department;
import com.davida.finalApp.model.SignRequest;
import com.davida.finalApp.repository.DepartmentDao;
import com.davida.finalApp.repository.SignRequestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DepartmentDaoImpl extends JdbcDaoSupport implements DepartmentDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }



    @Override
    public List<Department> loadAllDepartments() {
        String sql = "SELECT * FROM department";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Department> result = new ArrayList<Department>();
        for (Map<String, Object> row : rows) {
            Department department = new Department();
            department.setId((long) row.get("id"));
            department.setName((String) row.get("name"));

            result.add(department);
        }

        return result;
    }


    @Override
    public <S extends Department> S save(S s) {
        return null;
    }

    @Override
    public <S extends Department> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Department findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Department> findAll() {
        return null;
    }

    @Override
    public Iterable<Department> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Department department) {

    }

    @Override
    public void delete(Iterable<? extends Department> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
*/
