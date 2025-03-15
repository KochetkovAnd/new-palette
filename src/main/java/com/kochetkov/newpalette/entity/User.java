package com.kochetkov.newpalette.entity;

import com.kochetkov.newpalette.entity.base.AuditEntity;
import com.kochetkov.newpalette.enums.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@SequenceGenerator(name = "default_seq", sequenceName = "user_id_seq", allocationSize = 1)
public class User extends AuditEntity {

    @Column(name = "name")
    String name;

    @Column(name = "password")
    String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
