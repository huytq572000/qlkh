package com.example.qlkh.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int ID;
    private String name,phone,email,address,username,password, role;
}
