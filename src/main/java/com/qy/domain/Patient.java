package com.qy.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private Integer P_id;
    private String name;
    private Integer age;
    private String sex;
    private Integer times;
    private String username;
    private String password;
}