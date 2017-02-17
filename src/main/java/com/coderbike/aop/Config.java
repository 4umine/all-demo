package com.coderbike.aop;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/10/11 11:38
 */
public class Config {

    private String appId;		//应用id
    private String timestamp;	//时间戳
    private String nonceStr;	//随机字符串
    private String jsapiTicket;	//ticket

    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getNonceStr() {
        return nonceStr;
    }
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
    public String getJsapiTicket() {
        return jsapiTicket;
    }
    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket;
    }

    @Override
    public String toString() {
        return "Config{" +
                "appId='" + appId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", jsapiTicket='" + jsapiTicket + '\'' +
                '}';
    }
}
