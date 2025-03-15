package com.kochetkov.newpalette.entity.base;

import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class BaseIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_seq")
    private Long id;

}
