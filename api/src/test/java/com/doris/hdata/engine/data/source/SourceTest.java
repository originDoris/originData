package com.doris.hdata.engine.data.source;

import com.alibaba.fastjson2.JSON;
import com.doris.hdata.api.ApiApplication;
import com.doris.hdata.common.exception.HDataException;
import com.doris.hdata.common.util.Base64Util;
import com.doris.hdata.engine.data.source.executor.rds.MySqlExecutor;
import com.doris.hdata.engine.data.source.model.Source;
import com.doris.hdata.engine.data.source.model.property.MySqlSource;
import com.doris.hdata.engine.data.source.repository.DataSourceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: origindoris
 * @Title: DataSourceTest
 * @Description:
 * @date: 2022/10/18 10:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class SourceTest {

    @Autowired
    private DataSourceRepository dataSourceRepository;

    @Autowired
    private MySqlExecutor mySqlExecutor;


    @Test
    public void testAdd(){
        Source source = new Source();
        source.setSourceName("test");
        source.setSourceType("mysql");
        source.setSourceCode("test");
        source.setTenantCode("test");
        MySqlSource mySqlSource = new MySqlSource();
        mySqlSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true");
        mySqlSource.setPassword(Base64Util.encoder("020211xhz"));
        mySqlSource.setUserName("root");
        mySqlSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setSourceProperty(JSON.parseObject(JSON.toJSONString(mySqlSource)));
        source.setDeleteFlag(false);
        source.setGmtCreate(new Date());
        Source save = dataSourceRepository.save(source);
        System.out.println("save = " + save);
    }


    @Test
    public void testQuery(){
        Source result = dataSourceRepository.getById(1L);

        System.out.println("result = " + result);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExecutorQuery() throws HDataException {
        Source source = new Source();
        source.setSourceName("test");
        source.setSourceType("mysql");
        source.setSourceCode("test");
        List<Map> query = mySqlExecutor.query(source, "select * from flow_instance");
        System.out.println("query = " + query);
    }
}
