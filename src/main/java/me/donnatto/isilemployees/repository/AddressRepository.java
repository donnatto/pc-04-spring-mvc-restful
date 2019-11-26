package me.donnatto.isilemployees.repository;

import me.donnatto.isilemployees.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AddressRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Address address) {
        final String sql = "insert into tbl_address(add_id, country, city, street) values(?,?,?,?)";
        jdbcTemplate.update(sql, address.getAddressId(), address.getCountry(), address.getCity(), address.getStreet());

    }

    public void update(Address address) {
        final String sql = "update tbl_address set country = ?, city = ?, street = ? where add_id = ?";
        jdbcTemplate.update(sql, address.getCountry(), address.getCity(), address.getStreet(), address.getAddressId());
    }

    public void delete(Integer id) {
        final String sql = "delete tbl_address where add_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Address> findAll() {
        final String sql = "select * from tbl_address";
        return jdbcTemplate.query(sql, AddressRepository::addressRowMapper);
    }

    public Address findById(Integer id) {
        final String sql = "select * from tbl_address where add_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, AddressRepository::addressRowMapper);
    }

    public static Address addressRowMapper(ResultSet resultSet, int i) throws SQLException {
        Integer aId = resultSet.getInt("add_id");
        String country = resultSet.getString("country");
        String city = resultSet.getString("city");
        String street = resultSet.getString("street");
        return new Address(aId, country, city, street);
    }
}
