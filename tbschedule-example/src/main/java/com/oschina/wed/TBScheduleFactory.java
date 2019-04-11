package com.oschina.wed;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * TBSchedule调度器工厂类
 */
public class TBScheduleFactory {

    /**
     * 获取一个调度器实例
     * @param zkAddress 注册中心地址
     * @param taskPath 调度器注册路径
     * @param zkConnctionTimeout 注册中心连接超时时长
     * @param aclUserName 如需加密，此为用户名，tbs默认采用zookeeper digest加密方式
     * @param aclPwd 如需加密，此为密码，tbs默认采用zookeeper digest加密方式
     * @return
     */
    public static TBScheduleManagerFactory getTbsFactory(String zkAddress, String taskPath, String zkConnctionTimeout, String aclUserName, String aclPwd) {
        try {
            //tbs调度器的编程式注册
            TBScheduleManagerFactory tbScheduleManagerFactory = new TBScheduleManagerFactory();
            Map<String, String> zkConfig = new HashMap<String, String>();
            zkConfig.put("zkConnectString", zkAddress);
            zkConfig.put("rootPath", taskPath);
            zkConfig.put("zkSessionTimeout", zkConnctionTimeout);
            zkConfig.put("userName", aclUserName);
            zkConfig.put("password", aclPwd);
            tbScheduleManagerFactory.setZkConfig(zkConfig);
            //初始化zk链接，建立注册信息
            tbScheduleManagerFactory.init();
            return tbScheduleManagerFactory;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
