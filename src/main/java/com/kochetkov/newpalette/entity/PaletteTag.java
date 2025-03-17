package com.kochetkov.newpalette.entity;

import com.kochetkov.newpalette.entity.base.AuditEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "palette_tag")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@SequenceGenerator(name = "default_seq", sequenceName = "palette_tag_id_seq", allocationSize = 1)
public class PaletteTag extends AuditEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "palette_id", referencedColumnName = "id")
    Palette palette;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    Tag tag;
}
