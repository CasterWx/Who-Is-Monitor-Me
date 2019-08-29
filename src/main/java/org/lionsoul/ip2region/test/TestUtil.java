package org.lionsoul.ip2region.test;

import org.lionsoul.ip2region.*;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * project test script
 * 
 * @author chenxin<chenxin619315@gmail.com>
*/
public class TestUtil 
{

    public static void main(String[] args) {

        //ip
        String ip="45.32.136.190";

        // 判断是否为IP地址 (可用)
        boolean isIpAddress = Util.isIpAddress(ip);
        //根据ip进行位置信息搜索
        DbConfig config = null;
        try {
            config = new DbConfig();
            //获取ip库的位置（放在src下）（直接通过测试类获取文件 Ip2RegionTest为测试类）
            DbSearcher searcher = new DbSearcher(config, "ip2region.db");
            //采用Btree搜索
            DataBlock block = searcher.btreeSearch(ip);

            //打印位置信息（格式：国家|大区|省份|城市|运营商）
            System.out.println(block.getRegion());
        } catch (DbMakerConfigException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
