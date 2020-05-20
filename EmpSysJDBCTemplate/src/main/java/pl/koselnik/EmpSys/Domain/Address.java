package pl.koselnik.EmpSys.Domain;

import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.*;

public class Address {

    public Long idAddress;

    public Long idEmployee;

    public String type;

    @NotNull
    @Size(min=3, max=40, message = "Nazwa ulicy musi mieć między 3 a 40 znaków")
    @Pattern(regexp = "[a-zA-Ząśćężźłóń0-9 ]+", message = "Nazwa ulicy nie może zawierać znaków specjalnych.")
    public String street;

    @NotNull
    @Size(min=1, max=4, message = "Numer budynku musi mieć między 1 a 4 znaki")
    @Pattern(regexp = "[a-zA-Ząśćężźłóń0-9/]+", message = "Numer budynku nie może zawierać znaków specjalnych.")
    public String streetNr;

    @Range(min=0, max=9999, message = "Numer lokalu musi być z przedziału 0-4 cyfry")
    public Integer flatNr;

    @NotNull
    @Size(min=6, max=10, message = "Kod pocztowy musi być w formacie 99-999 dla adresów w Polsce")
    @Pattern(regexp = "[0-9]+", message = "Kod pocztowy nie może zawierać znaków specjalnych.")
    public String postalCode;

    @NotNull
    @Size(min=3, max=40, message = "Nazwa miejscowości musi mieć między 3 a 40 znaków")
    @Pattern(regexp = "[a-zA-Ząśćężźłóń ]+", message = "Nazwa miejscowości nie może zawierać znaków specjalnych.")
    public String city;

    @NotNull
    @Size(min=3, max=35, message = "Obywatelstwo musi mieć między 3 a 35 znaków")
    @Pattern(regexp = "[a-zA-Ząśćężźłóń ]+", message = "Obywatelstwo nie może zawierać znaków specjalnych.")
    public String country;

    public Address() {
    }

    public Address(Long idEmployee, String type, String street, Integer flatNr, String streetNr, String postalCode, String city, String country) {
        this.idEmployee = idEmployee;
        this.type = type;
        this.street = street;
        this.streetNr = streetNr;
        this.flatNr = flatNr;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public static class AddressBuilder{
        private Long idAddress;
        private Long idEmployee;
        private String type;
        private String street;
        private String streetNumber;
        private Integer flatNr;
        private String postalCode;
        private String city;
        private String country;

        public AddressBuilder setIdEmployee(Long idEmployee) {
            this.idEmployee = idEmployee;
            return this;
        }

        public AddressBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public AddressBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder setFlatNr(Integer flatNr) {
            this.flatNr = flatNr;
            return this;
        }

        public AddressBuilder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public AddressBuilder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Address build(){
            return new Address(idEmployee, type, street, flatNr, streetNumber, postalCode, city, country);
        }
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setFlatNr(Integer flatNr) {
        this.flatNr = flatNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public String getType() {
        return type;
    }

    public String getStreet() {
        return street;
    }

    public Integer getFlatNr() {
        return flatNr;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "idAddress=" + idAddress +
                ", idEmployee=" + idEmployee +
                ", type='" + type + '\'' +
                ", street='" + street + '\'' +
                ", flattNr=" + flatNr +
                ", streetNumber='" + streetNr + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
