/*
package com.davida.finalApp.impl;


//import com.davida.finalApp.converter.LocalDateTimeAttributeConverter;
import com.davida.finalApp.model.SignRequest;
import com.davida.finalApp.repository.SignRequestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SignRequestDaoImpl extends JdbcDaoSupport implements SignRequestDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insert(List<? extends SignRequest> SignRequests) {
		String sql = "INSERT INTO sign_request " + "(id, launch_date, program, department, deliverable, copy, edit_deliverable, edit_copy, flagged_deleted, edit_date_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				SignRequest signRequest = SignRequests.get(i);
                if(signRequest.getId()==null)
                    ps.setLong(1, signRequest.getId());
                else
                ps.setString(2, signRequest.getLaunchDate());
				ps.setString(3, signRequest.getProgram());
				ps.setString(4, signRequest.getDepartment());
				ps.setString(5, signRequest.getDeliverable());
				ps.setString(6, signRequest.getCopy());
                if(signRequest.getEditDeliverable()==null)
                    ps.setString(7, null);
                else
                    ps.setString(7, signRequest.getEditDeliverable());
                if(signRequest.getEditCopy()==null)
                    ps.setString(8, null);
                else
                    ps.setString(8, signRequest.getEditCopy());
                ps.setBoolean(9, false);
                ps.setTimestamp(10, null);
			}

			public int getBatchSize() {
				return SignRequests.size();
			}
		});

	}

    @Override
    public void update(List<? extends SignRequest> SignRequests) {
        String sql = "UPDATE sign_request SET edit_deliverable = ?, edit_copy = ?, flagged_deleted = ?, edit_date_time = ? WHERE id=$id";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                SignRequest signRequest = SignRequests.get(i);
                ps.setString(1, signRequest.getEditDeliverable());
                ps.setString(2, signRequest.getEditCopy());
                ps.setBoolean(3, signRequest.isFlaggedDeleted());
                ps.setTimestamp(4, Timestamp.valueOf(signRequest.getEditDateTime()));

*/
/*                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();

                MyEntity e = new MyEntity();
                e.setDate(LocalDate.now());
                e.setDateTime(LocalDateTime.now());
                e.setDuration(Duration.ofDays(2));

                em.persist(e);*//*

            }

            public int getBatchSize() {
                return SignRequests.size();
            }
        });

    }

    @Override
	public List<SignRequest> loadAllSignRequests() {
		String sql = "SELECT * FROM sign_request";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		List<SignRequest> result = new ArrayList<SignRequest>();
		for (Map<String, Object> row : rows) {
			SignRequest signRequest = new SignRequest();
			signRequest.setId((Long) row.get("id"));
			signRequest.setLaunchDate((String) row.get("launch_date"));
			signRequest.setProgram((String) row.get("program"));
			signRequest.setDepartment((String) row.get("department"));
			signRequest.setDeliverable((String) row.get("deliverable"));
			signRequest.setCopy((String) row.get("copy"));
			result.add(signRequest);
		}

		return result;
	}

    @Override
    public <S extends SignRequest> S save(S s) {
        return null;
    }

    @Override
    public <S extends SignRequest> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public SignRequest findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<SignRequest> findAll() {
        return null;
    }

    @Override
    public Iterable<SignRequest> findAll(Iterable<Long> iterable) {
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
    public void delete(SignRequest signRequest) {

    }

    @Override
    public void delete(Iterable<? extends SignRequest> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
*/
