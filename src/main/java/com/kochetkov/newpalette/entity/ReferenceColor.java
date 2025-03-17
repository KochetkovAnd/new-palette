package com.kochetkov.newpalette.entity;

import com.kochetkov.newpalette.entity.base.AuditEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "reference_color")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@SequenceGenerator(name = "default_seq", sequenceName = "reference_color_id_seq", allocationSize = 1)
public class ReferenceColor extends AuditEntity {

    @Column(name = "red")
    Integer red;

    @Column(name = "green")
    Integer green;

    @Column(name = "blue")
    Integer blue;
}

