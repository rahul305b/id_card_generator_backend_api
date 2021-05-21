package com.id.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdInfoDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String branch;
    private String image;
    private String qrCode;
}
