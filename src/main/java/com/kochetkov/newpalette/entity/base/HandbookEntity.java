package com.kochetkov.newpalette.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class HandbookEntity extends AuditEntity {
    @Column(name = "name")
    String name;
}
