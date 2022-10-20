package com.amaris.dto.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class ItemDto {
    @NotBlank
    @Length(max = 8)
    private String id;
    @NotBlank
    @Length(max = 64)
    private String itemName;
    @Length(max = 64)
    private String description;
    private String catalogId;
    private String accountId;
    private int numberof;

    public int getNumberof() {
        return numberof;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setNumberof(int numberof) {
        this.numberof = numberof;
    }

    public String getId() {
        return id;
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

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }
}
