package com.lf.ssm.controller;


import com.lf.ssm.utils.ValidationUtil;
import com.lf.ssm.vo.reqEntity.UserLoginReq;
import com.lf.ssm.vo.respEntity.UserLoginResp;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.validation.Valid;

import java.util.List;


@Controller
public class LogisticsController {



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    //用于验证注解是否符合要求，直接加在变量user之前，在变量中添加验证信息的要求，
    // 当不符合要求时就会在方法中返回message 的错误提示信息。
    public UserLoginResp login(@Valid  @RequestBody UserLoginReq userLoginReq, BindingResult errors) {//由valid注解导入的实体类的错误的信息
                     UserLoginResp userLoginResp=new UserLoginResp();
            if(errors.hasErrors()){
            /* 变量所有的异常信息 */
            List<ObjectError> errorList = errors.getAllErrors();
            for (ObjectError error : errorList) {
                FieldError fieldError = (FieldError) error;

                userLoginResp.setCode("400");
                userLoginResp.setMsg(fieldError.getDefaultMessage());
                return  userLoginResp;
            }
        }
        userLoginResp.setCode("200");
        userLoginResp.setMsg("登录成功");
        return userLoginResp;
    }


    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    @ResponseBody
    public UserLoginResp login2(@Valid @RequestBody UserLoginReq userLoginReq,BindingResult errors){
        ValidationUtil.assertValidation(errors);
        UserLoginResp userLoginResp=new UserLoginResp();
        userLoginResp.setCode("200");
        userLoginResp.setMsg("登录成功");
        return userLoginResp;
    }
}
