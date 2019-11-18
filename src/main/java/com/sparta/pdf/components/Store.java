package com.sparta.pdf.components;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "store")
@NamedQuery(
        name = "getStoreDetails",
        query = "SELECT a FROM Store a"
)
public class Store {
    @Id
    @Column(name = "store_id")
    private int storeId;
    @Column(name = "manager_staff_id")
    private int managerStaffId;
    @Column(name = "address_id")
    private int address_id;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "address_id")
    private Address storeAddress;

    @ManyToMany
    @JoinTable(
            name = "inventory",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private Set<Film> filmsInStock;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(int managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Address getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(Address storeAddress) {
        this.storeAddress = storeAddress;
    }

    public Set<Film> getFilmsInStock() {
        return filmsInStock;
    }

    public void setFilmsInStock(Set<Film> filmsInStock) {
        this.filmsInStock = filmsInStock;
    }
}
