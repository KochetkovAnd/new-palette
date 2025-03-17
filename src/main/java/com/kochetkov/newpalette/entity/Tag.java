package com.kochetkov.newpalette.entity;

import com.kochetkov.newpalette.entity.base.HandbookEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "tag")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@SequenceGenerator(name = "default_seq", sequenceName = "tag_id_seq", allocationSize = 1)
public class Tag extends HandbookEntity { }

