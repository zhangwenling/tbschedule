package com.taobao.console.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: zhangwenling1
 * @Date: 2019/4/4 17:51
 */
@Service
public class ErpService implements InitializingBean {

    @Value("${erp.list}")
    private String erpListStr;

    private List<String> erpList;

    public boolean validErp(String erp) {
        return erpList.contains(erp);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        erpList = Arrays.asList(erpListStr.split(","));
    }
}
