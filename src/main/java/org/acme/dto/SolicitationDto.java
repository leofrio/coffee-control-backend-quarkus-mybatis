package org.acme.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class SolicitationDto {
    private Integer id;
    private String name;
    private LocalDateTime solicitation_date;
    private LocalDateTime solicitation_expiration;
    private Boolean enabled;
}
