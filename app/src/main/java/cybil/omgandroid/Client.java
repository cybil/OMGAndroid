package cybil.omgandroid;

/**
 * Created by Cybil on 22/01/2015.
 */
public class Client {

    private String name;
    private String phone;
    private String address;
    private String postal_code;
    private String city;
    private boolean is_walter;


    public Client(String name, String phone, String address, String postal_code, String city, boolean is_walter) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.postal_code = postal_code;
        this.city = city;
        this.is_walter = is_walter;
    }

    public String getFullAddress() {
        return this.getName() + " - " + this.getAddress() + " " + this.getFullCity() + " - " + this.getPhone();
    }
    public String getFullCity() {
        return this.postal_code + " - " + this.city;
    }

//    GETTERS
    public String getName() {
        return this.name;
    }
    public String getPhone() {
        return this.phone;
    }
    public String getAddress() {
        return this.address;
    }
    public String getPostal_code() {
        return this.postal_code;
    }
    public String getCity() {
        return this.city;
    }
    public boolean isWalter() {
        return this.is_walter;
    }

//    SETTERS
    public void getName(String name) {
        this.name = name;
    }
    public void getPhone(String phone) {
        this.phone = phone;
    }
    public void getAddress(String address) {
        this.address = address;
    }
    public void getPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
    public void getCity(String city) {
        this.city = city;
    }
    public void setIsWalter(boolean is_walter) {
        this.is_walter = is_walter;
    }

}
