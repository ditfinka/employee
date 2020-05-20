package pl.koselnik.EmpSys.Domain.repository;

import javassist.expr.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pl.koselnik.EmpSys.Domain.Employee;

import java.sql.*;
import java.util.List;

@Repository
public class EmployeeRepository {

    private Long idEmployeeKey;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private List<Employee> listEmployees;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Employee> getAllEmployees() {

        String getQueryEmployees = "SELECT * FROM Employee";
        listEmployees = jdbcTemplate.query(getQueryEmployees,
                (rs, row) -> Employee.builder()
                        .setName(rs.getString("NAME"))
                        .setSurname(rs.getString("SURNAME"))
                        .setPosition(rs.getString("POSITION"))
                        .setAge(rs.getInt("AGE"))
                        .setActive(rs.getBoolean("ACTIVE"))
                        .setNationality(rs.getString("NATIONALITY"))
                        .build()
        );
        return listEmployees;
    }

    public void saveEmployeeToDB(Employee employee) {
        final String INSERT_ORDER_STATEMENT
                = "INSERT INTO Employee (name, surname, position, age, active, nationality) VALUES (?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(
                    Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(
                        INSERT_ORDER_STATEMENT, new String[] { "ID_EMPLOYEE" });
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getSurname());
                ps.setString(3, employee.getPosition());
                ps.setInt(4, employee.getAge());
                ps.setBoolean(5, employee.getActive());
                ps.setString(6, employee.getNationality());
                return ps;
            }
        }, keyHolder);
        idEmployeeKey = keyHolder.getKey().longValue();
    }

    public Long getIdEmployeeKey() {
        return idEmployeeKey;
    }

    public void setEmployeeActive(Employee employee) {
        employee.setActive(true);
    }

    public Employee getEmployee() {
        Employee employee = new Employee();

        employee.getIdEmployee();
        employee.getName();
        employee.getSurname();
        employee.getPosition();
        employee.getAge();
        employee.getActive();
        employee.getNationality();

        return employee;
    }
}