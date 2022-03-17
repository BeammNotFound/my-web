package com.service;

import com.pojo.MyWeb;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BeamStark
 * @since 2021-11-30
 */
public interface MyWebService extends IService<MyWeb> {
    MyWeb getData();
    String plusOneLike();
    String plusOnePV();
}
