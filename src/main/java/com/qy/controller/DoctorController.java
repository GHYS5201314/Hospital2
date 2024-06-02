package com.qy.controller;

import com.qy.domain.*;
import com.qy.service.DoctorService;
import com.qy.service.SystemUserService;
import com.qy.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    SystemUserService systemUserService;

    @PostMapping("/enroll")
    public ResponseResult enroll(@RequestBody Doctor doctor){
        List<SystemUser> users = systemUserService.findbyusernameandpasswordandrole(new SystemUser(doctor.getUsername(), doctor.getPassword(), "doctor", 0));
        if(users==null){
            Integer id = doctorService.insert(doctor);
            systemUserService.insert(new SystemUser(doctor.getUsername(),doctor.getPassword(),"doctor",id));
            return new ResponseResult(200,"注册成功！");
        }
        else{
            return new ResponseResult(300,"该账号已存在！");
        }
    }
    @PostMapping("/getinformation")
    public ResponseResult findmsg(HttpServletRequest request){
        String token = request.getHeader("token");
        Integer id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Doctor doctor = doctorService.findmsg(id);
        return new ResponseResult(200,"信息如下：",doctor);
    }

    @PostMapping("/update")
    public ResponseResult updatedoctor(HttpServletRequest request,@RequestBody Doctor doctor){
        String token = request.getHeader("token");
        Integer id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        doctorService.update(id,doctor);
        return new ResponseResult(200,"更新成功！",doctorService.findmsg(id));
    }
}
