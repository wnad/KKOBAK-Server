package com.dundun213.kkobak.KKOBAKServer.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Comment("최초 생성 시간")
    @Column(name = "created_at",nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Comment("최근 수정 시간")
    @Column(name = "updated_at",nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
