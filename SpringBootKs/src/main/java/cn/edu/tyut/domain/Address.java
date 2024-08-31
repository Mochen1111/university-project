package cn.edu.tyut.domain;

public class Address {
    private Integer addressId;
    private Integer uid;
    private String address;

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", uid=" + uid +
                ", address='" + address + '\'' +
                '}';
    }

    public Address(Integer addressId, Integer uid, String address) {
        this.addressId = addressId;
        this.uid = uid;
        this.address = address;
    }

    public Address() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
