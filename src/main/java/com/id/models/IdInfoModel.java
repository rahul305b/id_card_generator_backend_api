package com.id.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdInfoModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String branch;
    private String image;
    private String qrCode;
}
