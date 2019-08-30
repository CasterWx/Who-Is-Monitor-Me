package util;

import dao.IHttpDAO;
import dao.impl.HttpDAOImpl;
import domain.Http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataResource {
    static String data = "";

    static IHttpDAO iHttpDAO = new HttpDAOImpl() ;

    public static void main(String[] args) {
        HashMap<String,Integer> httpMap = new HashMap<String, Integer>() ;

        List<Http> httpList = iHttpDAO.list() ;

        for (int i = 0; i < httpList.size(); i++) {
            String time = httpList.get(i).getDate().split(" ")[1].replace(":","");
            Integer timeInt = Integer.parseInt(time);
            if ((timeInt<10000)||(timeInt>70000)){
                continue;
            }

            if (httpMap.get(httpList.get(i).getHostname())!=null){
                httpMap.put(httpList.get(i).getHostname(),httpMap.get(httpList.get(i).getHostname())+1);
            }else {
                httpMap.put(httpList.get(i).getHostname(),1);
            }
        }

        data = "" ;
        HashMap<String,String> icpData = ICPData.instance() ;
        IpAddress ipAddress = new IpAddress()  ;
        httpMap.forEach((key,value)->{
            String read = key + "," +  ipAddress.getAddress(key) + ","+value + "\r\n";
            data = data + read ;
        });
        System.out.println(data);

    }


}
