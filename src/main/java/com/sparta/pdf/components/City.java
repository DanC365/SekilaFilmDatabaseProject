package com.sparta.pdf.components;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city")
    private String cityName;
    @Column(name = "country_id")
    private int countryId;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "country_id")
    private Country country;


    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
