package com.maiya.shopcloud.account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @program: shopcloud-master
 * @description:
 * @author: siming.wang
 * @create: 2018-10-09 19:48
 **/

@Configuration
//maxInactiveIntervalInSeconds session超时时间,单位秒
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 600)
public class RedisSessionConfig {

}
