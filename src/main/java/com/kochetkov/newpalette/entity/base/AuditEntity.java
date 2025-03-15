package com.kochetkov.newpalette.entity.base;

import com.kochetkov.newpalette.security.SecurityHelper;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class AuditEntity extends BaseIdEntity {

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by")
    private String deletedBy;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        createdBy = SecurityHelper.getLoggedUserName();
        updatedAt = LocalDateTime.now();
        updatedBy = SecurityHelper.getLoggedUserName();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
        updatedBy = SecurityHelper.getLoggedUserName();
    }
}
