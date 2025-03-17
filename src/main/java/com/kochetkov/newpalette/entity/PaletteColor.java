package com.kochetkov.newpalette.entity;

import com.kochetkov.newpalette.entity.base.AuditEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "palette_color")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@SequenceGenerator(name = "default_seq", sequenceName = "palette_color_id_seq", allocationSize = 1)
public class PaletteColor extends AuditEntity {

    @Column(name = "red")
    Integer red;

    @Column(name = "green")
    Integer green;

    @Column(name = "blue")
    Integer blue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "palette_id", referencedColumnName = "id")
    Palette palette;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_role_id", referencedColumnName = "id")
    ColorRole colorRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_color_id", referencedColumnName = "id")
    ReferenceColor referenceColor;
}
