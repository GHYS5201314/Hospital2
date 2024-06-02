package com.qy.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSchedule {
    private Integer D_id;
    private Integer C_id;
    private Integer kind_id;
    private String name;
    private String duration;
    private Integer cost;
    private Integer number;
    private Integer leftNumber;
}
