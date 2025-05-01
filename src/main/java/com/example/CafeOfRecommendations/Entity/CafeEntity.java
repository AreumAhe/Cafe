package com.example.CafeOfRecommendations.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coffeerecommendations")  // Ensure this matches your table name
public class CafeEntity {

    @Id
    @Column(name = "s_no")  // Match the actual column name in the database
    private int sNo;

    @Column(name = "preference")  // Ensure the column name matches the database
    private String preference;

    @Column(name = "coffee_name")  // Ensure the column name matches the database
    private String coffeeName;

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }
}
