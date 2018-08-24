package com.ldh.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Duration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @Author: ldh
 * 自定义Cache配置
   @Cacheable
   @Cacheable("product")
   @Cacheable(value = {"product","order"}, key = "#root.targetClass+'-'+#id")
   @Cacheable(value = "product", key = "#root.targetClass+'-'+#id")
   自定义cacheManager
   @Cacheable(value = "product", key = "#root.targetClass+'-'+#id” cacheManager="cacheManager")
   @CachePut
   应用到写数据的方法上，如新增/修改方法
   @CachePut(value = "product", key = "#root.targetClass+'-'+#product.id")
   @CacheEvict
   即应用到移除数据的方法上，如删除方法
   @CacheEvict(value = "product", key = "#root.targetClass+'-'+#id")
   提供的SpEL上下文数据
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
  /**
   * 自定义redis key值生成策略
   */
  @Bean
  @Override
  public KeyGenerator keyGenerator() {
    return (target, method, params) -> {
      StringBuilder sb = new StringBuilder();
      sb.append(target.getClass().getName());
      sb.append(method.getName());
      for (Object obj : params) {
        sb.append(obj.toString());
      }
      return sb.toString();
    };
  }

  @Bean
  public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    //redis序列化
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    jackson2JsonRedisSerializer.setObjectMapper(om);

    StringRedisTemplate template = new StringRedisTemplate(factory);
    template.setValueSerializer(jackson2JsonRedisSerializer);
    template.afterPropertiesSet();
    return template;
  }

  /**
   * 自定义CacheManager
   */
  @Bean
  public CacheManager cacheManager(RedisTemplate redisTemplate) {
    //全局redis缓存过期时间
    RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().entryTtl(
        Duration.ofDays(1));
    RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
    return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
  }
}