package com.amaris.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@Table(name = "role")
@ToString
public class RoleEntity {
    @Id
    private String id;
    @Column
    private String roleName;


    // mappedBy trỏ tới tên biến persons ở trong Address.
    @ManyToMany(mappedBy = "role",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<AccountEntity> accountEntities;
}
