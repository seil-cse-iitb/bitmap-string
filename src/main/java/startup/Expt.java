package startup;

import model.BitmapHour;
import model.BitmapMinute;
import model.Data;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import config.Handler;
import java.util.List;

public class Expt {



    public static void InsertIntoData(IgniteCache<Long, Data> cachename, Data bm) {

        cachename.query(
                new SqlFieldsQuery("insert into Data (avgW,avgV,sensor_id,granularity,id,TS) values("+bm.getAvgW()+" , "+bm.getAvgV()+" ,'"+bm.getSensor_id()+"','"+bm.getGranularity()+"',"+Handler.dataid+","+bm.getTS()+")"));



    }
    public static void InsertIntoBitmapHour(IgniteCache<Long, BitmapHour> cachename, BitmapHour bm) {


        cachename.query(

                new SqlFieldsQuery("insert into BitmapHour (avgW,avgV,sensor_id,id) values("+bm.getAvgW()+" , "+bm.getAvgV()+" ,'"+bm.getSensor_id()+"',"+Handler.dataid+" )"));



    }

    public static void InsertIntoBitmapMinute(IgniteCache<Long, BitmapMinute> cachename, BitmapMinute bm) {


        cachename.query(

                new SqlFieldsQuery("insert into BitmapMinute (avgW,avgV,sensor_id,id) values("+bm.getAvgW()+" , "+bm.getAvgV()+" ,'"+bm.getSensor_id()+"',"+Handler.dataid+" )"));



    }

    public static void main(String[] args) {

        Ignite ignite= Ignition.start("BitmapClusterString-client.xml");
        IgniteCache<Long, Data> bitmaphour = ignite.getOrCreateCache("DataCache");

        bitmaphour.query(
                new SqlFieldsQuery("insert into Data (avgW,avgV,sensor_id,granularity,id,TS) values(112.0,134.0,'power_k_seil_l','hour',129,143.1241)"));

        QueryCursor<List<?>> cursor=
                bitmaphour.query(
                        new SqlFieldsQuery("select * from Data"));
        System.out.println("PRINTED CURSOR "+ cursor.getAll());

    }
}
