package org.tc.autotest.mapper;


import org.tc.autotest.model.domain.TestConfigInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface ConfigInfoMapper extends MyMapper<TestConfigInfo> {

    TestConfigInfo getTestConfigInfo();


}
