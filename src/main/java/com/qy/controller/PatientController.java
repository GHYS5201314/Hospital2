package com.qy.controller;

import com.qy.domain.DoctorSchedule;
import com.qy.domain.Patient;
import com.qy.domain.ResponseResult;
import com.qy.domain.SystemUser;
import com.qy.service.DoctorScheduleService;
import com.qy.service.DoctorService;
import com.qy.service.PatientService;
import com.qy.service.SystemUserService;
import com.qy.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {


    @Autowired
    PatientService patientService;
    @Autowired
    SystemUserService systemUserService;

    @Autowired
    DoctorScheduleService doctorScheduleService;
    @PostMapping("/enroll")
    public ResponseResult enroll(@RequestBody Patient patient) {
        List<SystemUser> users = systemUserService.findbyusernameandpasswordandrole(new SystemUser(patient.getUsername(), patient.getPassword(), "patient", 0));
        if (users.isEmpty()) {
            Integer id = patientService.insert(patient);
            systemUserService.insert(new SystemUser(patient.getUsername(), patient.getPassword(), "patient", id));
            System.out.println(id);
            return new ResponseResult(200, "注册成功！");
        } else {
            return new ResponseResult(300, "该账号已存在！");
        }
    }

    @PostMapping("/update")
    public ResponseResult update(HttpServletRequest request, @RequestBody Patient patient){
        String token = request.getHeader("token");
        Integer id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        patient.setP_id(id);
        patientService.update(patient);
        return new ResponseResult(200,"更新成功！");
    }

    @PostMapping("/get")
    public ResponseResult get(HttpServletRequest request){
        String token = request.getHeader("token");
        Integer id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Patient patient = patientService.findmsg(id);
        return new ResponseResult(200,"个人信息如下：",patient);
    }

    @PostMapping("/book")
    public ResponseResult book(HttpServletRequest request,@RequestBody Map<String,Integer>ids){
        String token = request.getHeader("token");
        Integer P_id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            P_id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Integer D_id=ids.get("D_id");
        Integer C_id=ids.get("C_id");
        patientService.insertbook(P_id,D_id,C_id);
        patientService.updatebook(D_id,C_id);
        return new ResponseResult(200,"预约成功！");
    }

    @PostMapping("/time2")//患者已付款
    public ResponseResult time2(HttpServletRequest request,@RequestBody Map<String,Integer>ids){
        String token = request.getHeader("token");
        Integer P_id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            P_id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Integer D_id=ids.get("D_id");
        Integer C_id=ids.get("C_id");
        patientService.updatebook2(P_id,D_id,C_id);
        return new ResponseResult(200,"更新成功！");
    }
    @PostMapping("/time3")//患者已失约
    public ResponseResult time3(HttpServletRequest request,@RequestBody Map<String,Integer>ids){
        String token = request.getHeader("token");
        Integer P_id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            P_id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Integer D_id=ids.get("D_id");
        Integer C_id=ids.get("C_id");
        patientService.updatebook4(P_id,D_id,C_id);
        patientService.updatepatient4(P_id);
        return new ResponseResult(200,"更新成功！");
    }

    @PostMapping("/press")//患者已赴约
    public ResponseResult pressbutton(HttpServletRequest request,@RequestBody Map<String,Integer>ids){
        String token = request.getHeader("token");
        Integer P_id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            P_id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Integer D_id=ids.get("D_id");
        Integer C_id=ids.get("C_id");
        patientService.updatebook3(P_id,D_id,C_id);
        return new ResponseResult(200,"更新成功！");
    }

    @PostMapping("/findAll")
    public ResponseResult findAllSchedule(HttpServletRequest request){
        String token = request.getHeader("token");
        Integer P_id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            P_id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseResult(200,"信息如下：",doctorScheduleService.findByP_id(P_id));
    }
}