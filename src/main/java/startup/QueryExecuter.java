package startup;

import config.Handler;
import javafx.util.Pair;
import jdk.internal.org.objectweb.asm.Handle;
import model.BitmapHour;
import model.Data;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.h2.result.Row;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static config.Handler.HourBasev;
import static config.Handler.HourEndv;

public class QueryExecuter {

    public static void QueryHour(String sensor_id, Long TS1, Long TS2, String[] cols)
    {

        Ignite ignite= Ignition.start("BitmapClusterString-client.xml");

        IgniteCache<Long, BitmapHour> cache = ignite.getOrCreateCache("BitmapHourCache");

        CheckBitmap(cache,TS1,TS2,"power_k_seil_a",cols);


    }

    public static void CheckBitmap(IgniteCache<Long, BitmapHour> cache, Long TS1,Long TS2, String sensor_id, String[] columns)
    {
        int numcols= columns.length;

        String colsapp="";
        for(int it=0;it<numcols;it++)
        {
            colsapp+=columns[it];
            colsapp+=" ";

        }
        QueryCursor<List<?>> cursor=
                cache.query(
                        new SqlFieldsQuery("select "+colsapp+" from BitmapHour where sensor_id='"+sensor_id+"'"));


        System.out.println("PRINTED CURSOR "+ cursor.getAll());

//        Finding 0s in String


//
//        String[] arr={"111","010"};
//        String and=ANDofStrings(arr);
//        System.out.println(and);

        String bitString="";
        for(int i=0;i<65535;i++)
        {
            if(i%3==0)
                bitString+='1';
            else bitString+='0';
        }
        TS1=(TS1-HourBasev)/3600;
        TS2=(TS2-HourBasev)/3600;





        ArrayList<Pair<Long,Long>> dbTSs=new ArrayList<>();

        dbTSs=getDBTimeRanges(bitString,TS1,TS2);

        //Prints 0 ranges
        for(int i1=0;i1<dbTSs.size();i1++){
            System.out.println(dbTSs.get(i1).getKey()+"   "+dbTSs.get(i1).getValue() );
        }


        System.out.println(BreakQuery(dbTSs));


    }

    //Function to get 0 time ranges in bitstring
    public static ArrayList<Pair<Long,Long>> getDBTimeRanges(String bitString,Long TS1,Long TS2)
    {
        ArrayList<Pair<Long,Long>> dbTSs= new ArrayList<Pair<Long,Long>>(); // ArrayList of 0-range pairs

//        bitString=bitString.substring(TS1.intValue(),TS2.intValue());

        Long i,lv=0L,sv=0L,onev=0L;
        boolean b=false;
        System.out.println(bitString);

        for(i=TS1;i<=TS2;i++)
        {
            //to add ranges in DB
            if(bitString.charAt(i.intValue())=='0')
            {
                if(!b) {

                    sv=i;//startvalue of range

                    b = true;

                }
                lv=i;//last value of range

            }
            else
            {

                if(b)
                {
                    Pair <Long,Long> p= new Pair<Long,Long>(sv,lv);
                    dbTSs.add(p);

                    onev=i;

                    b=false;
                }

            }
        }
        if(bitString.charAt(TS2.intValue())=='0')
        {
            Pair <Long,Long> p= new Pair<Long,Long>(onev+1,TS2);
            dbTSs.add(p);

        }

        return  dbTSs;

    }

    public static String BreakQuery(ArrayList<Pair<Long,Long>> dbTSs)
    {

        String dbQuery="select * from Table where ";

        for(int i1=0;i1<dbTSs.size();i1++){

            Long qwe=HourBasev+(dbTSs.get(i1).getValue()*3600);
            Long qwe1=(HourBasev+(dbTSs.get(i1).getKey()*3600 ));
            if(!qwe.equals(qwe1))
                dbQuery+="(TS >= "+qwe1+" and  TS <= "+qwe+" ) ";

            else
                dbQuery+="(TS = "+qwe+" )";

            System.out.println(qwe1+"   "+qwe+"    "+dbTSs.get(i1).getKey()+"   "+dbTSs.get(i1).getValue());

            if(i1!=dbTSs.size()-1)
            {
                dbQuery+=" or ";
            }
        }


        return dbQuery;


    }
    //Function to perform AND operation of Array of Strings
    public static String ANDofStrings(String[] a)
    {
        String bitString="";
        int numcols= a.length;
        boolean b= false;
        Long sizeofString=3L;
//        Long sizeofString=HourEndv-HourBasev;
        for(int j=0;j<sizeofString.intValue();j++) {
            for (int it = 0; it < numcols; it++) {

                if (a[it].charAt(j) == '0') {
                    bitString += '0';
                    b=true;
                    break;
                }


            }
            if(!b)
            {
                bitString+='1';

            }
            else b=false;

        }


        return bitString;
    }


    public static void main(String[] args) {

        String[] cols={"avgW"};


        QueryHour("power_k_seil_a",1529483400L,1529505000L,cols);


    }
}
