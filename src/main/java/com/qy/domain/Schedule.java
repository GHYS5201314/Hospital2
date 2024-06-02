package com.qy.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Schedule {
    private String doctorname;
    private String patientname;
    private String classname;
    private String duration;
    private String status;
}
