package com.ua.project.android_homework_recyclerview.models;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    private Integer id;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private Date birthDate;

}
