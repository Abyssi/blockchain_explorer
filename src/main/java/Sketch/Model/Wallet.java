package Sketch.Model;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    public List<String> outAddresses;
    private String address;
    private Double totalReceived;

    public Wallet() {
        this("");
    }

    public Wallet(String address) {
        this(address, 0d, new ArrayList<>());
    }

    public Wallet(String address, Double totalReceived, List<String> outAddresses) {
        this.address = address;
        this.totalReceived = totalReceived;
        this.outAddresses = outAddresses;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(Double totalReceived) {
        this.totalReceived = totalReceived;
    }

    public List<String> getOutAddresses() {
        return outAddresses;
    }

    public void setOutAddresses(List<String> outAddresses) {
        this.outAddresses = outAddresses;
    }
}
