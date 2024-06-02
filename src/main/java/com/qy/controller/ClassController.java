package com.qy.controller;


import com.qy.domain.Classid;
import com.qy.domain.DoctorSchedule;
import com.qy.domain.ResponseResult;
import com.qy.service.DoctorScheduleService;
import com.qy.service.DoctorService;
import com.qy.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    DoctorScheduleService doctorScheduleService;

    @PostMapping("/findAll")
    public ResponseResult findAll(HttpServletRequest request){
        String token = request.getHeader("token");
        Integer id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<DoctorSchedule> schedules=doctorScheduleService.findAll(id);
        return new ResponseResult(200,"排班信息如下：",schedules);
    }

    @PostMapping("/add")
    public ResponseResult add(HttpServletRequest request,@RequestBody List<DoctorSchedule> doctorSchedules){
        String token = request.getHeader("token");
        Integer id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(DoctorSchedule doctorSchedule:doctorSchedules){
            Classid classid = doctorScheduleService.findByname(doctorSchedule.getName());
            if(classid==null){
                doctorScheduleService.Insertclassname(doctorSchedule.getName());
                classid = doctorScheduleService.findByname(doctorSchedule.getName());
            }
            doctorSchedule.setD_id(id);
            doctorSchedule.setKind_id(classid.getC_id());
            doctorScheduleService.insert(doctorSchedule);
        }
        return new ResponseResult(200,"添加成功！",doctorScheduleService.findAll(id));
    }
    @PostMapping("/delete")
    public ResponseResult delete(HttpServletRequest request,@RequestBody List<Integer> ids){
        String token = request.getHeader("token");
        Integer id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(Integer C_id:ids){
            doctorScheduleService.delete(id,C_id);
        }
        return new ResponseResult(200,"删除成功！",doctorScheduleService.findAll(id));
    }

    @PostMapping("/update")
    public ResponseResult update(HttpServletRequest request,@RequestBody DoctorSchedule doctorSchedule){
        String token = request.getHeader("token");
        Integer id;
        try {
            Claims claims= JwtUtil.parseJWT(token);
            id=Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        doctorScheduleService.update(id,doctorSchedule);
        return new ResponseResult(200,"更新成功！");
    }

    @PostMapping("/findAllidandname")
    public ResponseResult postC_idandC_name(){
        return new ResponseResult(200,"挂号种类如下：",doctorScheduleService.findAllnameandid());
    }

}
