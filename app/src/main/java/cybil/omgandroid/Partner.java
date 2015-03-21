package cybil.omgandroid;

/**
 * Created by Cybil on 22/01/2015.
 */
public class Partner {

    private String name;
    private String info;
    private String phone;


    public Partner(String name, String info, String phone) {
        this.name = name;
        this.info = info;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public String getInfo() {
        return info;
    }
    public String getPhone() {
        return phone;
    }
}
