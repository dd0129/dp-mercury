package com.dianping.data.warehouse.masterdata.core.handler.impl;

import com.dianping.data.warehouse.domain.McColumnInfo;
import com.dianping.data.warehouse.domain.McTableInfo;
import com.dianping.data.warehouse.domain.McTableQuery;
import com.dianping.data.warehouse.masterdata.core.handler.DataBaseMetaHandler;
import com.dianping.data.warehouse.masterdata.service.McMetaService;
import com.dianping.data.warehouse.masterdata.service.MercuryService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanshan.jin on 14-2-27.
 */
public class SQLServerMetaHandlerImplTest extends TestCase {
    public ApplicationContext context;

//    protected void setUp() throws Exception {
//        context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-applicationcontext.xml","classpath:spring-beans.xml"});
//    }
//    public void testGetTableList() throws Exception {
//        McMetaService handler = (McMetaService)context.getBean("McMetaServiceImpl");
//        McTableQuery query = new McTableQuery();
//        query.setDbName("DianPingDW2");
//        query.setStorageType("mysql");
////        query.setTableName("etl_task");
//        List<McTableInfo> list = handler.getTableList(query);
//        System.out.println(list);
//    }

//    public void testGetTableList() throws Exception {
//        DataBaseMetaHandler handler = (DataBaseMetaHandler)context.getBean("MySQLMetaHandlerImpl");
//        McTableQuery query = new McTableQuery();
//        query.setDbName("DianPingDW");
//        query.setTableName("etl_task");
//        List<McTableInfo> list = handler.getTableList(query);
//        System.out.println(list);
//    }

//    public void testGetParentTaskId() {
//        McMysqlService service = (McMysqlService)context.getBean("mcMysqlServiceImpl");
//        McTableInfo table = new McTableInfo();
//        table.setDb_name("bi");
//        table.setTable_name("jinss_test_0218");
//        table.setStorage_type("hive");
//        List<Integer> taskid = service.getParentTaskId(table);
//        System.out.print(taskid);
//    }

//    public void testGetColumnList() throws Exception {
//
//    }

//    public void testGetDbList() throws Exception {
//    DataBaseMetaHandler handler = (DataBaseMetaHandler)context.getBean("MySQLMetaHandlerImpl");
//    System.out.print(handler.getDbList());
//
//    }

//    public void testGetDbList() throws Exception {
//        MercuryService handler = (MercuryService)context.getBean("MercuryServiceImpl");
//        McTableInfo tgttable = new McTableInfo();
//        tgttable.setTable_name("dpods_etl_task_cfg_sadass");
//        tgttable.setDb_name("bi");
//        tgttable.setStorage_type("hive");
//        tgttable.setSchema_name("dpods");
//        tgttable.setRefresh_cycle("D");
//        tgttable.setUpdate_time("2014-03-07 11:44:59");
//        tgttable.setAdd_time("2014-03-07 11:44:59");
//        McColumnInfo column = new McColumnInfo();
//        column.setColumn_name("id");
//        column.setColumn_type("int");
//        column.setColumn_rn(1);
//        column.setIs_partition_column(0);
//        List<McColumnInfo> columns = new ArrayList<McColumnInfo>();
//        columns.add(column);
//        tgttable.setColumns(columns);
//        McTableInfo srctable = new McTableInfo();
//        srctable.setStorage_type("mysql");
//        srctable.setDb_name("dianpingDW2");
//        srctable.setSchema_name("");
//        srctable.setTable_name("etl_task_cfg9845984gh");
//        List<McTableInfo> srctables = new ArrayList<McTableInfo>();
//        srctables.add(srctable);
//
//        handler.deleteMercuryInfo(srctables,tgttable,2008111);

//    }
}
