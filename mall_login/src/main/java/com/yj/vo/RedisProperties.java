package com.yj.vo;

import com.yj.util.MallPropertiesUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class RedisProperties implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8204519831923524074L;

    private static String host;

    private static String password;

    private static Integer port;

    private static Integer timeout;
    private static Integer maxActive;
    private static Integer maxWait;
    private static Integer maxIdle;
    private static Integer minIdle;

    public static String getHost() {
        if (StringUtils.isEmpty(host)) {
            setHost(MallPropertiesUtil.getValueWithoutException("redis.host"));
        }
        return host;
    }

    public static void setHost(String host) {
        RedisProperties.host = host;
    }

    public static String getPassword() {
        if (StringUtils.isEmpty(password)) {
            setPassword(MallPropertiesUtil.getValueWithoutException("redis.password"));
        }
        return password;
    }

    public static void setPassword(String password) {
        RedisProperties.password = password;
    }

    public static Integer getPort() {
        if (port==null) {
            setPort(Integer.parseInt(MallPropertiesUtil.getValueWithoutException("redis.port")));
        }
        return port;
    }

    public static void setPort(Integer port) {
        RedisProperties.port = port;
    }

    public static Integer getTimeout() {
        if (timeout==null) {
            setTimeout(Integer.parseInt(MallPropertiesUtil.getValueWithoutException("redis.timeout")));
        }
        return timeout;
    }

    public static void setTimeout(Integer timeout) {
        RedisProperties.timeout = timeout;
    }

    public static Integer getMaxActive() {
        if (maxActive==null) {
            setMaxActive(Integer.parseInt(MallPropertiesUtil.getValueWithoutException("redis.maxActive")));
        }
        return maxActive;
    }

    public static void setMaxActive(Integer maxActive) {
        RedisProperties.maxActive = maxActive;
    }

    public static Integer getMaxWait() {
        if (maxWait==null) {
            setMaxWait(Integer.parseInt(MallPropertiesUtil.getValueWithoutException("redis.maxWait")));
        }
        return maxWait;
    }

    public static void setMaxWait(Integer maxWait) {
        RedisProperties.maxWait = maxWait;
    }

    public static Integer getMaxIdle() {
        if (maxIdle==null) {
            setMaxIdle(Integer.parseInt(MallPropertiesUtil.getValueWithoutException("redis.maxIdle")));
        }
        return maxIdle;
    }

    public static void setMaxIdle(Integer maxIdle) {
        RedisProperties.maxIdle = maxIdle;
    }

    public static Integer getMinIdle() {
        if (minIdle==null) {
            setMinIdle(Integer.parseInt(MallPropertiesUtil.getValueWithoutException("redis.minIdle")));
        }
        return minIdle;
    }

    public static void setMinIdle(Integer minIdle) {
        RedisProperties.minIdle = minIdle;
    }


}
