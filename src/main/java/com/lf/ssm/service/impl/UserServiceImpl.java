package com.lf.ssm.service.impl;

import com.lf.ssm.dao.mapping.TbUserMapper;
import com.lf.ssm.dao.pojo.TbOrderDetail;
import com.lf.ssm.dao.pojo.TbUser;
import com.lf.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    TbUserMapper tbUserMapper;

    @Override
    @Transactional
    public Integer addUser(TbUser tbUser) {
        Integer integer =tbUserMapper.insert(tbUser);
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return integer;
    }


    /*@Autowired
    Mapper<TbOrderDetail> mapper;

    @Override
    public List<TbOrderDetail> getTbOrderDetail(Integer orderid) {
        Example example=new Example(TbOrderDetail.class);
        example.createCriteria()
                .andBetween("id",41,44);
        return mapper.selectByExample(example);
    }*/





}
