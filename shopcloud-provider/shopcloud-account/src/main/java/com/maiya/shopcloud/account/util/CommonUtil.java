package com.maiya.shopcloud.account.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

/**
 * @program: shopcloud-master
 * @description:
 * @author: siming.wang
 * @create: 2018-10-14 11:24
 **/

public class CommonUtil {

    /*获取ip*/
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 加密
     * @param pwd
     * @return
     */
    public static String encodePassWord(String pwd) throws Exception{
        byte[] pwdByte = pwd.getBytes("UTF-8");
        return Base64.getEncoder().encodeToString(pwdByte);
    }

    /**
     * 解密
     * @param pwd
     * @return
     */
    public static String decodePassWord(String pwd) throws Exception{
        return new String(Base64.getDecoder().decode(pwd), "UTF-8");
    }

    public static void main(String[] args) throws Exception{
        String pwd = "asdhasbdhasdu";
        String pwdaa = encodePassWord(pwd);
        System.out.println(encodePassWord(pwd));
        System.out.println(decodePassWord(pwdaa));

    }

}
