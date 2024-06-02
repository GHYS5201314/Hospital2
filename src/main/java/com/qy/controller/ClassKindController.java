package com.qy.controller;


import com.qy.domain.ClassKind;
import com.qy.domain.Classid;
import com.qy.domain.ResponseResult;
import com.qy.service.impl.ClassKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class ClassKindController {

    @Autowired
    ClassKindService classKindService;

    @PostMapping("/add")
    public ResponseResult add(@RequestBody ClassKind classKind){
        classKindService.add(classKind);
        return new ResponseResult(200,"添加成功！");
    }
    @PostMapping("/delete")
    public ResponseResult delete(@RequestBody Integer id){
        classKindService.delete(id);
        return new ResponseResult(200,"删除成功！");
    }

    @PostMapping("/findAll")
    public ResponseResult findAll(){
        return new ResponseResult(200,"信息如下：",classKindService.findAll());
    }

    @PostMapping("/update")
    public ResponseResult update(@RequestBody ClassKind classKind){
        classKindService.update(classKind);
        return new ResponseResult(200,"修改成功！");
    }
}
