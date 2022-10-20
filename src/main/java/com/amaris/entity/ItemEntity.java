package com.amaris.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class ItemEntity extends BaseEntity{
    @Id
    private String id;
    @Column
    private String itemName;
    @Column
    private String description;
    @Column
    private int numberof;
    @ManyToOne
    @JoinColumn(name="catalog_id")
            @JsonIgnore
    CatalogEntity catalog;
    @ManyToOne
    @JoinColumn(name="account_id")
            @JsonIgnore
    AccountEntity account;
    public String getId() {
        return id;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberof() {
        return numberof;
    }

    public void setNumberof(int numberof) {
        this.numberof = numberof;
    }

    public CatalogEntity getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogEntity catalog) {
        this.catalog = catalog;
    }
}
