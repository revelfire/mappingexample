package com.revelfire.example.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by cmathias on 2/9/16.
 */
@MappedSuperclass
public class Address {

    @Column(length = 100, nullable = false)
    private String line1;

    @Column(length = 100)
    private String line2;

    @Column(length = 3, nullable = false)
    private String stateAbbr;

    @Column(length = 30, nullable = false)
    private String postal;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (!line1.equals(address.line1)) return false;
        if (line2 != null ? !line2.equals(address.line2) : address.line2 != null) return false;
        if (!stateAbbr.equals(address.stateAbbr)) return false;
        return postal.equals(address.postal);

    }

    @Override
    public int hashCode() {
        int result = line1.hashCode();
        result = 31 * result + (line2 != null ? line2.hashCode() : 0);
        result = 31 * result + stateAbbr.hashCode();
        result = 31 * result + postal.hashCode();
        return result;
    }
}
