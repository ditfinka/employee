package pl.koselnik.EmpSys.Domain.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;
import pl.koselnik.EmpSys.Domain.Address;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AddressRepository {

    public List<Address> addresses = new ArrayList<>();
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private boolean checkOfAddressIni = false;



    public AddressRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public AddressRepository() {
    }

    public AddressRepository(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address) {

        if (addresses.size() == 1) {
            address.setType("C");
        } else address.setType("P");;
        checkOfAddressIni = true;
        this.addresses.add(address);
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public boolean isCheckOfAddressIni() {
        return checkOfAddressIni;
    }
//    public int[] saveAddressToDB(final List<Address> addressessFromForm) {
//        List<Address> adressessList = addressesFromForm;
//        for(Address add : adressesList){
//            if (add.getIdEmployee() == null) {
//                add.setIdEmployee(employeeRepository.getIdEmployeeKey());
//            }
//        }
//
//        final String INSERT_EMP_QUERY = "INSERT INTO Address (id_employee, type, street, street_nr, flat_nr, postal_code, city, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        List<Object[]> empList = new ArrayList<Object[]>();
//        for(Address addr : adressesList) {
//            Object[] values = new Object[] {
//                    addr.getIdEmployee(),
//                    addr.getType(),
//                    addr.getStreet(),
//                    addr.getStreetNr(),
//                    addr.getFlatNr(),
//                    addr.getPostalCode(),
//                    addr.getCity(),
//                    addr.getCountry()
//            };
//            empList.add(values);
//
//            }
//
//        return this.jdbcTemplate.batchUpdate(INSERT_EMP_QUERY, empList);
//    }


    public int[][] saveAddressToDB(final List<Address> addressessFromForm) {

        List<Address> adressesList = addressessFromForm;
        for(Address add : adressesList){
            if (add.getIdEmployee() == null) {
                add.setIdEmployee(employeeRepository.getIdEmployeeKey());
            }
        }

        final String INSERT_EMP_QUERY = "INSERT INTO Address (id_employee, type, street, street_nr, flat_nr, postal_code, city, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return this.jdbcTemplate.batchUpdate(INSERT_EMP_QUERY, addressessFromForm, 2,
                new ParameterizedPreparedStatementSetter<Address>() {
                    @Override
                    public void setValues(PreparedStatement ps, Address addr) throws SQLException {
                        ps.setLong(1, addr.getIdEmployee());
                        ps.setString(2, addr.getType());
                        ps.setString(3, addr.getStreet());
                        ps.setString(4, addr.getStreetNr());
                        ps.setInt(5, addr.getFlatNr());
                        ps.setString(6, addr.getPostalCode());
                        ps.setString(7, addr.getCity());
                        ps.setString(8, addr.getCountry());
                    }
                });
    }



//        jdbcTemplate.update(query,
//                employeeRepository.getIdEmployeeKey(),
//                address.getType(),
//                address.getStreet(),
//                address.getStreetNr(),
//                address.getFlatNr(),
//                address.getPostalCode(),
//                address.getCity(),
//                address.getCountry()
//                );


    @Override
    public String toString() {
        return "AddressRepository{" +
                "addresses=" + addresses +
                '}';
    }
}
