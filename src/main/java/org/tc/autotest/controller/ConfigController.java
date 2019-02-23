package org.tc.autotest.controller;

import org.tc.autotest.dto.AutoTestSettingConfigDto;
import org.tc.autotest.model.domain.TestConfigInfo;
import org.tc.autotest.service.ConfigService;
import org.tc.autotest.wrapper.WrapMapper;
import org.tc.autotest.wrapper.Wrapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 自动测试参数配置器
 */

@RestController
@RequestMapping(value = "/autotest")
public class ConfigController {


    @Resource
    private ConfigService configService;

    @RequestMapping("/config")
    public Wrapper<TestConfigInfo> getConfig() {
        TestConfigInfo testConfigInfo = configService.getCurAutoTestConfig();

        return WrapMapper.ok(testConfigInfo);
    }

    @PostMapping("/config/setting")
    public Wrapper configSet(@RequestBody AutoTestSettingConfigDto dto) {
        System.out.println("configSet-start");

        int res = configService.setAutoTestConfigInfo(dto);
        if (res == -1) {
            return WrapMapper.error("设置失败!");
        }

        return WrapMapper.ok();
    }






}
