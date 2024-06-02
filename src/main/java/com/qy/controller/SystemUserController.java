package com.qy.controller;

import com.qy.domain.*;
import com.qy.service.DoctorService;
import com.qy.service.PatientService;
import com.qy.service.SystemUserService;
import com.qy.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/sys_user")
public class SystemUserController {
    Map<String,Object> map=new HashMap<>();
    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody SystemUser systemuser){
        Map<String,Object> map=new HashMap<>();
        SystemUser loginuser = systemUserService.findbyusernameandpasswordandrole(systemuser).get(0);
        if(loginuser!=null){
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(),String.valueOf(loginuser.getId()), null);
            map.put("token",token);
            if(systemuser.getRole().compareTo("doctor")==0) {
                return new ResponseResult(200, "登录成功！", map);
            }
            else{
                return new ResponseResult(100, "登录成功！", map);
            }
        }else{
            return new ResponseResult(300,"用户名或密码或身份错误，请重新登录！");
        }
    }
}