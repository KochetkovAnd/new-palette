package com.kochetkov.newpalette.entity;

import com.kochetkov.newpalette.entity.base.AuditEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "collection_palette")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@SequenceGenerator(name = "default_seq", sequenceName = "collection_palette_id_seq", allocationSize = 1)
public class CollectionPalette extends AuditEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collection_id", referencedColumnName = "id")
    Collection collection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "palette_id", referencedColumnName = "id")
    Palette palette;
}

