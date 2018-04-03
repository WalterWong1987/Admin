package com.makeronly.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取客户端网络信息工具类
 * @author Walter Wong
 */
public final class Network {
    /**
     * 获取请求主机IP地址
     * <p>
     *  获取客户端的IP地址的方法是：request.getRemoteAddr()，这种方法在大部分情况下都是有效的。
     * 	但是在通过了Apache，Squid，nginx等反向代理软件就不能获取到客户端的真实IP地址了。
     * 	经过代理以后，由于在客户端和服务之间增加了中间层，因此服务器无法直接拿到客户端的IP，
     *	服务器端应用也无法直接通过转发请求的地址返回给客户端。但是在转发请求的HTTP头信息中，增加了X－FORWARDED－FOR信息。
     *	用以跟踪原有的客户端IP地址和原来客户端请求的服务器地址。当我们访问http://www.xxx.com/index.jsp/ 时，
     *	其实并不是我们浏览器真正访问到了服务器上的index.jsp文件，而是先由代理服务器去访问http://192.168.1.110:2046/index.jsp ，
     *	代理服务器再将访问到的结果返回给我们的浏览器，因为是代理服务器去访问index.jsp的，
     *	所以index.jsp中通过request.getRemoteAddr()的方法获取的IP实际上是代理服务器的地址，并不是客户端的IP地址。
     *	可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 	答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     * 	如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 192.168.1.100,
     * 	用户真实IP为： 192.168.1.110
     * 	</p>
     * @param request request
     * @return String
     */
    public static final String getHost(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }

            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }

            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }

            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }

            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (String _ip : ips ) {
                if (!("unknown".equalsIgnoreCase(_ip))) {
                    ip = _ip;
                    break;
                }
            }
        }
        return ip;
    }
}
