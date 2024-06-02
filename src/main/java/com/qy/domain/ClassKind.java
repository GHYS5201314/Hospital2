package com.qy.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassKind {
    private Integer id;
    private String name;
    private String cost;
    private String duration;
}
