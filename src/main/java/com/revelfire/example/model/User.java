package com.revelfire.example.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cmathias on 2/9/16.
 */
@Entity
@Table(name="user")
public class User extends Identifiable {

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    /**
     * This COULD be @OneToOne as an "owned" relationship if we felt strongly
     * about having a separate table.
     *
     * This COULD be a one-many scenario in which case it would not be modeled on this
     * end, rather a repository.loadAddressForUser with address.user_id being the join point
     * via the foreign key reference.
     */
    @Embedded
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (accountId != user.accountId) return false;
        if (!name.equals(user.name)) return false;
        return !(address != null ? !address.equals(user.address) : user.address != null);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (int) (accountId ^ (accountId >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
