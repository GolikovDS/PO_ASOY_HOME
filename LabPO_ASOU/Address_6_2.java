package LabPO_ASOU;

/**
 * Created by Дмитрий on 22.02.2015.
 */
public class Address_6_2 {
    Address_6_2(String sName, String sPhone, String sEmail){
        name = sName;
        phone = sPhone;
        email = sEmail;
    }
    protected String name;
    protected String phone;    protected String email;
    public String getName(){return name;}
    public String getPhone(){return phone;}
    public String getEmail(){return email;}
}
