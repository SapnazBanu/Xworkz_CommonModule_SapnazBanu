package com.xworkz.commonmodule.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class AbstractAuditEntity implements Serializable {
    private String createdBy;
    private LocalDateTime CreatedDate=LocalDateTime.now();
    private String updateBy;
    private LocalDateTime updatedDate=LocalDateTime.now();
}
