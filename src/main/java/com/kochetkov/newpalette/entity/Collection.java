package com.kochetkov.newpalette.entity;

import com.kochetkov.newpalette.entity.base.AuditEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "collection")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@SequenceGenerator(name = "default_seq", sequenceName = "collection_id_seq", allocationSize = 1)
public class Collection extends AuditEntity {

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    User creator;
}
