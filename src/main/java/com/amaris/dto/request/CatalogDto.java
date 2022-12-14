package com.amaris.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class CatalogDto extends BaseDto{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    @NotBlank(message = "catalogId not blank")
    @Length(max = 8)
    private String id;
    @Length(max = 64)
    @NotBlank(message = "catalog name not blank")
    private String name;
    @Length(max = 64)
    private String description;
}
