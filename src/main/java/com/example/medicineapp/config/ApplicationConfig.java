//package com.example.medicineapp.config;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.concurrent.ConcurrentMapCache;
//import org.springframework.cache.support.SimpleCacheManager;
//import org.springframework.context.annotation.*;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableCaching
//@EnableAspectJAutoProxy
//@ComponentScan({"com.globits.core.utils"})
//public class ApplicationConfig extends CachingConfigurerSupport {
//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties (){
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//    @Bean
//    @Override
//    public CacheManager cacheManager(){
//        SimpleCacheManager cacheManager = new SimpleCacheManager();
//        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("default")));
//        return cacheManager;
//    }
//}
