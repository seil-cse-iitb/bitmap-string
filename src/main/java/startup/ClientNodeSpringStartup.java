package startup;

import model.BitmapHour;
import model.BitmapMinute;
import model.Data;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import startup.Expt;
import java.sql.Blob;
import java.util.Iterator;
import java.util.List;

/** This file was generated by Ignite Web Console (07/01/2018, 15:17) **/
public class ClientNodeSpringStartup {
    /**
     * Start up node with specified configuration.
     * 
     * @param args Command line arguments, none required.
     * @throws Exception If failed.
     **/
    public static void main(String[] args) throws Exception {


        Logger.getLogger("org").setLevel(Level.OFF);
        Logger.getLogger("akka").setLevel(Level.OFF);

        System.setProperty("IGNITE_QUIET", "false");

        IgniteConfiguration cfg = new IgniteConfiguration();

// Ignite persistence configuration.
        DataStorageConfiguration storageCfg = new DataStorageConfiguration();

// Enabling the persistence.
        storageCfg.getDefaultDataRegionConfiguration().setPersistenceEnabled(true);

// Applying settings.
        cfg.setDataStorageConfiguration(storageCfg);
        cfg.setClientMode(true);
        Ignite ignite= Ignition.start("BitmapClusterString-client.xml");


        //   Ignite ignite=Ignition.start("BitmapCluster-client.xml");


        CacheConfiguration cfgc = new CacheConfiguration("CACHE1");
        cfgc.setCacheMode(CacheMode.PARTITIONED);
        cfgc.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);

//        cfgc.setSqlSchema("CACHE");

        IgniteCache<Long, BitmapMinute> bitmaphour = ignite.getOrCreateCache("BitmapMinuteCache");
//        bitmaphour.query(new SqlFieldsQuery("CREATE OR REPLACE TABLE BITMAP " +
//                "(id int primary key, avgW blob, avgV blob, sensor_id varchar)").setSchema("PUBLIC"));



        BitmapMinute bm= new BitmapMinute();
//        Blob b;
//        byte[] bt1= new byte[]{(byte)0xe0,(byte)0xe0};
        String bt="",bt1="";
        for(int i=0;i<65535;i++)
        {
            if(i%2==0)
            bt+='0';
            else bt+='1';
        }
        for(int i=0;i<65535;i++)
        {
            if(i%3==0)
                bt1+='0';
            else bt1+='1';
        }
        bm.setAvgV(bt);
        bm.setAvgW(bt1);

        bm.setSensor_id("power_k_seil_a");

//        System.out.println(ignite.cacheNames());

//        bitmaphour.put(123L,bm);
//        Data v=bitmaphour.get(123L);



//        Expt.InsertIntoBitmapMinute(bitmaphour,bm);


        FieldsQueryCursor<List<?>> cursor = bitmaphour.query(
                new SqlFieldsQuery("select * from BitmapMinute"));

      //  Iterator<List<?>> iterator = cursor.iterator();
        for(List<?> r:cursor)
        {
            String qwe = (String)r.get(0);
        }
        System.out.println("PRINTED CURSOR "+ cursor);


//        Collection<List<?>> cursor1 =
//                bitmaphour.query(
//                        new SqlFieldsQuery("select * from Data")).getAll();
//
//        System.out.println("HER   "+ cursor1);
//        for (List<?> row : cursor1) {
//            System.out.println("HER  "+row.get(0));
//        }
/*
        Data bm= new Data();
        Blob b;
        byte[] bt1= new byte[]{(byte)0xe0,(byte)0xe0};
        Double bt=123.0;
        bm.setAvgV(bt);
        bm.setAvgW(bt);
        bm.setGranularity("minute123131");
        bm.setTS(145.89745);
        bm.setSensor_id("power_k_seil_a");

//        System.out.println(ignite.cacheNames());

//        bitmaphour.put(123L,bm);
//        Data v=bitmaphour.get(123L);



//        Expt.InsertIntoData(bitmaphour,bm);
        bitmaphour.query(
                new SqlFieldsQuery("insert into Data (avgW,avgV,sensor_id,granularity,id,TS) values(112.0,134.0,'power_k_seil_l','hour',128,143.1241)"));
        QueryCursor<List<?>> cursor=
                bitmaphour.query(
                        new SqlFieldsQuery("select * from Data"));

        System.out.println("PRINTED CURSOR "+ cursor.getAll());


//        bitmaphour.destroy();
*/

    }
}