package com.service.impl;

import com.pojo.MyWeb;
import com.mapper.MyWebMapper;
import com.service.MyWebService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    MyWebMapper webMapper;

    @Override
    public MyWeb getData() {
        return webMapper.selectOne(null);
    }

    @Override
    public Integer updateLikes(Integer likes) {
        MyWeb myWeb = new MyWeb();
        myWeb.setId(1);
        myWeb.setLikes(likes);
        return webMapper.updateById(myWeb);
    }

    @Override
    public Integer updatePV(Integer pv) {
        MyWeb myWeb = new MyWeb();
        myWeb.setId(1);
        myWeb.setPv(pv);
        return webMapper.updateById(myWeb);
    }
}
