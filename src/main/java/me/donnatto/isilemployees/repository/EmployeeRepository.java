package me.donnatto.isilemployees.repository;

import me.donnatto.isilemployees.model.Address;
import me.donnatto.isilemployees.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Employee employee) {
        final String sql = "insert into tbl_employee(name, addr_id) values(?,?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getAddressId());

    }

    public void update(Employee employee) {
        final String sql = "update tbl_employee set name = ?, addr_id = ?, where emp_id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getAddressId(), employee.getId());
    }

    public void delete(Long id) {
        final String sql = "delete tbl_employee where emp_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Employee> findAll() {
        final String sql = "select * from tbl_employee";
        return jdbcTemplate.query(sql, EmployeeRepository::employeeRowMapper);
    }

    public Employee findById(Long id) {
        final String sql = "select * from tbl_employee where addr_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, EmployeeRepository::employeeRowMapper);
    }

    public static Employee employeeRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long eId = resultSet.getLong("emp_id");
        String name = resultSet.getString("name");
        Long aId = resultSet.getLong("addr_id");
        return new Employee(eId, name, aId);
    }
}
