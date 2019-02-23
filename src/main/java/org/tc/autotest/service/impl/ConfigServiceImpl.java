package org.tc.autotest.service.impl;

import org.tc.autotest.dto.AutoTestSettingConfigDto;
import org.tc.autotest.mapper.ConfigInfoMapper;
import org.tc.autotest.model.domain.TestConfigInfo;
import org.tc.autotest.service.BaseService;
import org.tc.autotest.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Slf4j
@Service
public class ConfigServiceImpl extends BaseService<TestConfigInfo> implements ConfigService {


    @Resource
    ConfigInfoMapper configInfoMapper;


    @Override
    public TestConfigInfo getCurAutoTestConfig() {
        TestConfigInfo testConfigInfo = configInfoMapper.getTestConfigInfo();
        logger.info("自动化测试配置:", testConfigInfo);
        return testConfigInfo;
    }

    @Override
    public int setAutoTestConfigInfo(AutoTestSettingConfigDto setAutoTestConfigDto) {
        int res = -1;
        if (setAutoTestConfigDto == null)return res;
        TestConfigInfo testConfigInfo = configInfoMapper.getTestConfigInfo();
        String autoTestSwitchOld = testConfigInfo.getAutoTestSwitch();
        String autoTestSwitchNew = setAutoTestConfigDto.getAutoTestSwitch();
        TestConfigInfo configInfo = new TestConfigInfo();
        configInfo.setId(setAutoTestConfigDto.getId());
        configInfo.setAutoTestSwitch(setAutoTestConfigDto.getAutoTestSwitch());
        configInfo.setIntervalTimeMode(setAutoTestConfigDto.getIntervalTimeMode());
        configInfo.setOperationNum(setAutoTestConfigDto.getOperationNum());
        configInfo.setRadiosIp(setAutoTestConfigDto.getRadiosIp());
        configInfo.setIntervalTimeMode(setAutoTestConfigDto.getIntervalTimeMode());
        configInfo.setRandomTime(setAutoTestConfigDto.getRandomTime());
        configInfo.setSolidTime(setAutoTestConfigDto.getSolidTime());
        configInfo.setRunningApp(setAutoTestConfigDto.getRunningApp());
        configInfo.setRunningStatus(setAutoTestConfigDto.getRunningStatus());
        configInfo.setRunningTimeLength(setAutoTestConfigDto.getRunningTimeLength());
        configInfo.setStopConditionMode(setAutoTestConfigDto.getStopConditionMode());
        configInfo.setLastModifyTime(new Date());
        res = configInfoMapper.updateByPrimaryKeySelective(configInfo);

        if (res == 1) {
            log.info("修改测试配置信息成功");
            if (!autoTestSwitchOld.equalsIgnoreCase(autoTestSwitchNew)) {
                //
                if (autoTestSwitchNew.equalsIgnoreCase("on")) {
                    // 启动定时任务

                } else {
                    // 停止定时任务

                }
            } else {
                // 更新本地测试配置信息

            }
        }
        return res;
    }









}
