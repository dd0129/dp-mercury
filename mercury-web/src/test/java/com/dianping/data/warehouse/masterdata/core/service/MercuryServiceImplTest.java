package com.dianping.data.warehouse.masterdata.core.service;

import com.dianping.data.warehouse.domain.McColumnInfo;
import com.dianping.data.warehouse.domain.McTableInfo;
import com.dianping.data.warehouse.masterdata.service.MercuryService;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by shanshan.jin on 14-3-28.
 */
public class MercuryServiceImplTest extends TestCase {
    public ApplicationContext context;
    public Logger logger = LoggerFactory.getLogger(MercuryServiceImplTest.class);
    public void setUp() throws Exception{
        context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-applicationcontext.xml","classpath:spring-beans.xml"});
    }
    public void testUpdateMercuryInfo() throws Exception {
        MercuryService service = (MercuryService) context.getBean("MercuryServiceImpl");
        McTableInfo tgttable = new McTableInfo();
        tgttable.setTable_name("dpods_etl_task_cfg");
        tgttable.setDb_name("bi");
        tgttable.setStorage_type("hive");
        tgttable.setSchema_name("dpods");
        tgttable.setRefresh_cycle("D");
        tgttable.setUpdate_time("2014-03-07 11:44:59");
        tgttable.setAdd_time("2014-03-07 11:44:59");
        McColumnInfo column = new McColumnInfo();
        column.setColumn_name("id1");
        column.setColumn_type("int");
        column.setColumn_rn(1);
        column.setIs_partition_column(0);
        List<McColumnInfo> columns = new ArrayList<McColumnInfo>();
        columns.add(column);
        tgttable.setColumns(columns);
        service.updateMercuryInfo(tgttable);
        List<McColumnInfo> expect = service.getTgtColumnList(tgttable);
        assertEquals(expect.get(0).getColumn_name() ,"id1");
    }
}
