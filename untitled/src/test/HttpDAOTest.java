package test;

import dao.IHttpDAO;
import dao.impl.HttpDAOImpl;
import domain.Http;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HttpDAOTest {
    IHttpDAO iHttpDAO = new HttpDAOImpl();
    @Test
    public void testSave() {
        Http http = new Http() ;
        http.setId(1L);
        http.setHostname("pic.cnblogs.com");
        http.setIp("101.37.115.180");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String str = df.format(new Date());// new Date()为获取当前系统时间
        http.setDate(str);
        iHttpDAO.save(http);
    }

    @Test
    public void testList() {
        ArrayList<Http> list = iHttpDAO.list() ;
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
}
