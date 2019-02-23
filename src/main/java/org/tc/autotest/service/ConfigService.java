package org.tc.autotest.service;

import org.tc.autotest.dto.AutoTestSettingConfigDto;
import org.tc.autotest.model.domain.TestConfigInfo;

/**
 *  自动化测试配置接口
 *
 */
public interface ConfigService extends IService<TestConfigInfo> {
    /**
     * 获取当前自动化测试配置
     *
     * @param
     * @return the TestConfigInfo
     */
    TestConfigInfo getCurAutoTestConfig();

    int setAutoTestConfigInfo(AutoTestSettingConfigDto setAutoTestConfigDto);










}
