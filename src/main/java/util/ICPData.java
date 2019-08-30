package util;

import java.util.HashMap;

public class ICPData {
    /*
    * String 域名
    * String 对应公司
    * */
    private static HashMap<String,String> hashMap = new HashMap<>() ;

    private ICPData(){
        initData();
    }

    private static void initData() {
        hashMap.put(".amap.com","阿里-高德") ;
        hashMap.put(".qq.com","腾讯-腾讯网") ;
        hashMap.put(".127.net","网易127") ;
        hashMap.put(".uc.cn","阿里-UC") ;
        hashMap.put(".hicloud.com","华为-华为终端云") ;
        hashMap.put(".taobao.com","阿里-淘宝") ;
        hashMap.put(".url.cn","腾讯-URL网") ;
        hashMap.put(".googletagmanager.com","Google-GTM标签管理") ;
        hashMap.put(".xycdn.com","网心-星域cdn") ;
        hashMap.put(".alipay.com","支付宝") ;
        hashMap.put(".qpic.cn","腾讯-微博图片网") ;
        hashMap.put(".cmpassport.com","中移-移动账号管理中心");
        hashMap.put(".gtimg.cn","腾讯-gtimg网");
        hashMap.put(".googleapis.com","Google-googleapis服务");
        hashMap.put(".qchannel03.cn","贵士移动");
        hashMap.put(".google.com","Google");
        hashMap.put(".idqqimg.com","腾讯-idqqimg网");
        hashMap.put(".dbank.com","华为-华为网盘");
        hashMap.put(".music.163.com","网易-网易云");
        hashMap.put(".netease.com","网易-网易netease");
        hashMap.put(".alicdn.com","阿里-阿里旺旺");
        hashMap.put(".dbankcdn.com","华为-华为帮助") ;
        hashMap.put(".gstatic.com","北京谷翔信息") ;
    }

    public static HashMap<String,String> instance(){
        return hashMap;
    }

}
