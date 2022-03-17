package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pojo.MyWeb;
import com.mapper.MyWebMapper;
import com.service.MyWebService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BeamStark
 * @since 2021-11-30
 */
@Service
public class MyWebServiceImpl extends ServiceImpl<MyWebMapper, MyWeb> implements MyWebService {

    @Resource
    MyWebMapper webMapper;


    @Override
    public MyWeb getData() {
        return webMapper.selectOne(new QueryWrapper<MyWeb>().eq("id", 1));
    }

    @Override
    public String plusOneLike() {
        MyWeb entrary = webMapper.selectOne(new QueryWrapper<MyWeb>().eq("id", 1));
        if (StringUtils.isEmpty(entrary)) {
            MyWeb myWeb = new MyWeb();
            myWeb.setLikes(1);
            myWeb.setPv(0);
            myWeb.setId(1);
            webMapper.insert(myWeb);
            return "Success, " + 1;
        }
        entrary.setLikes(entrary.getLikes() + 1);
        webMapper.updateById(entrary);
        return "Success, " + entrary.getLikes();
    }

    @Override
    public String plusOnePV() {
        MyWeb entrary = webMapper.selectOne(new QueryWrapper<MyWeb>().eq("id", 1));
        if (StringUtils.isEmpty(entrary)) {
            MyWeb myWeb = new MyWeb();
            myWeb.setLikes(0);
            myWeb.setPv(1);
            myWeb.setId(1);
            webMapper.insert(myWeb);
            return "Success, " + 1;
        }
        entrary.setPv(entrary.getPv() + 1);
        webMapper.updateById(entrary);
        return "Success, " + entrary.getPv();
    }
}
