package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddress {

    public String getAddress(String ip){
        try{
            URL url = new URL("https://ip.911cha.com/"+ip+".html");
            String address = "" ;
            HttpURLConnection httpURLConnection ;
            BufferedReader bf ;
            String readLine  ;
            String index = "" ;

            httpURLConnection = (HttpURLConnection)url.openConnection() ;
            int responsecode = httpURLConnection.getResponseCode() ;  // 返回码
            if(responsecode==200) {
                bf = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while ((readLine = bf.readLine()) != null) {
                    index += readLine += "\r\n";
                }
                String con = "<p>参考数据："+ip+" → (.*)</p>" ;
                Pattern ah = Pattern.compile(con);
                Matcher mr = ah.matcher(index);

                while(mr.find()) {
                    address = mr.group().replace("<p>参考数据："+ip+" → ","").replace("</p>","");
                }
                return address ;
            }else{
                System.out.println("NOT  "+responsecode);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ""  ;
    }

}
