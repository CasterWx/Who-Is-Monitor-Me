package util;

import dao.IHttpDAO;
import dao.impl.HttpDAOImpl;
import domain.Http;
import org.lionsoul.ip2region.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static IHttpDAO iHttpDAO = new HttpDAOImpl();

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("ssserver.log","rw") ;

            String line ;
            System.out.println(randomAccessFile.length());
            while((line=randomAccessFile.readLine())!=null){
                if (line.contains("connecting"))
                    parse(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void parse(String log){
        Http http = new Http() ;

        String data = log.split(" ")[0] + " "+ log.split(" ")[1] ;
        http.setDate(data);

        String con = "\\(([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+)\\)" ;
        Pattern ah = Pattern.compile(con);
        Matcher mr = ah.matcher(log);
        while(mr.find()) {
            http.setIp(mr.group().replace("(","").replace(")",""));
        }

        http.setAddress(ipToAddress(http.getIp()));

        String con1 = "connecting (.*)?\\(" ;
        Pattern ah1 = Pattern.compile(con1);
        Matcher mr1 = ah1.matcher(log);
        while(mr1.find()) {
            http.setHostname(mr1.group().replace("connecting ","").replace("(",""));
        }


        iHttpDAO.save(http);
    }

    public static String ipToAddress(String ip) {

        // 判断是否为IP地址 (可用)
        boolean isIpAddress = Util.isIpAddress(ip);
        if (!isIpAddress){
            return "" ;
        }
        //根据ip进行位置信息搜索
        DbConfig config = null;
        try {
            config = new DbConfig();
            //获取ip库的位置（放在src下）（直接通过测试类获取文件 Ip2RegionTest为测试类）
            DbSearcher searcher = new DbSearcher(config, "ip2region.db");
            //采用Btree搜索
            DataBlock block = searcher.btreeSearch(ip);

            //打印位置信息（格式：国家|大区|省份|城市|运营商）
            return  block.getRegion() ;
        } catch (DbMakerConfigException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "" ;
    }


}
