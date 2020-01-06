package pssc.flybuy.entities;

public class Address {
    private String city;
    private String country;

    public Address(){}

    public Address(String country, String city){
        this.city = city;
        this.country = country;
    }


    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
