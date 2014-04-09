package com.dianping.data.warehouse.masterdata.core.service;

import com.dianping.data.warehouse.domain.McColumnInfo;
import com.dianping.data.warehouse.domain.McTableInfo;
import com.dianping.data.warehouse.domain.McTableQuery;
import com.dianping.data.warehouse.masterdata.service.McMetaService;
import com.dianping.data.warehouse.masterdata.service.MercuryService;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.apache.derby.impl.sql.execute.ColumnInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jdo.annotations.Column;
import java.util.ArrayList;
import java.util.List;

public class McMysqlServiceImplTest extends TestCase {
    
    private static Logger logger = LoggerFactory.getLogger(McMysqlServiceImplTest.class);
    public ApplicationContext context;
    private MercuryServiceImpl mercuryServiceImpl;

    protected void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-applicationcontext.xml","classpath:spring-beans.xml"});
        mercuryServiceImpl = (MercuryServiceImpl) context.getBean("mercuryServiceImpl");
    }

//    public void testInsertMcColumnInfo() {
//        McMysqlService service = (McMysqlService)context.getBean("mcMysqlServiceImpl");
//        service.insertMcColumnInfo(null);
//        
//    }
//
//    public void testInsertMcTableInfo() {
//        fail("Not yet implemented");
//    }
//
//    public void testDeleteMcColumnInfo() {
//        fail("Not yet implemented");
//    }
//
//    public void testDeleteMcTableInfo() {
//        fail("Not yet implemented");
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

//    public void testGettableExistStatus() {
//        McMysqlService service = (McMysqlService)context.getBean("mcMysqlServiceImpl");
//        McTableInfo table = new McTableInfo();
//        table.setDb_name("DianPingDW");
//        table.setTable_name("jinss_test_0218");
//        table.setStorage_type("mysql");
//        List<TableExistStatus> status = service.gettableExistStatus(table);
//        System.out.print(status);
//    }
//
//    public void testGettableExistStatus() {
//        McMysqlMetaService service = (McMysqlMetaService)context.getBean("mcMysqlMetaServiceImpl");
//        McTableInfo table = new McTableInfo();
//        table.setDb_name("bi");
//        table.setTable_name("jinss_test_0218");
//        table.setStorage_type("hive");
//        List<String> status = service.getMysqlDbNameList();
//        System.out.print(status);
//    }

//    public void testGetDbList() throws Exception {
//        McMetaService handler = (McMetaService) context.getBean("McMetaServiceImpl");
//        McTableQuery query = new McTableQuery();
//        query.setStorageType("sqlserver");
//        query.setDbName("shifenzheng");
//        query.setTableName("cds");
////        query.setSchemaName("dbo");
//        List<McTableInfo> list = handler.getTableList(query);
//        System.out.print(list);
////
//        List<String> list = handler.getDbList("sqlserver");
//        System.out.print(list);
//        MercuryService handler = (MercuryService)context.getBean("MercuryServiceImpl");
//        McTableInfo tgttable = new McTableInfo();
//        tgttable.setTable_name("dpods_acl_ldap_map124");
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
//        srctable.setTable_name("acl_ldap_map123");
//        List<McTableInfo> srctables = new ArrayList<McTableInfo>();
//        srctables.add(srctable);
//
//        handler.saveMercuryInfo(srctables,tgttable,2008111);


    public void testGetTableIDbyTaskID() throws Exception {
        List<Integer> result = mercuryServiceImpl.getTableIDbyTaskID(10001);
        Assert.assertEquals(result.size(),1);
        Assert.assertEquals(result.get(0),new Integer(1046343005));
    }

    public void testGetTaskIDbyTableID() throws Exception {
        List<Integer> result = mercuryServiceImpl.getTaskIDbyTableID(395595);
        Assert.assertEquals(true,result.contains(600501));
        Assert.assertEquals(true,result.contains(600491));
        Assert.assertEquals(true,result.contains(600991));
    }

}
