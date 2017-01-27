package com.example.batchcsvpostgresql.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.example.batchcsvpostgresql.model.SignRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.batchcsvpostgresql.dao.SignRequestDao;

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
		String sql = "INSERT INTO signRequest " + "(id, launch_date, program, department, deliverable, copy) VALUES (?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				SignRequest signRequest = SignRequests.get(i);
				ps.setLong(1, signRequest.getId());
				ps.setString(2, signRequest.getLaunchDate());
				ps.setString(3, signRequest.getProgram());
				ps.setString(4, signRequest.getDepartment());
				ps.setString(5, signRequest.getDeliverable());
				ps.setString(6, signRequest.getCopy());
			}

			public int getBatchSize() {
				return SignRequests.size();
			}
		});

	}

	@Override
	public List<SignRequest> loadAllSignRequests() {
		String sql = "SELECT * FROM signRequest";
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
}
