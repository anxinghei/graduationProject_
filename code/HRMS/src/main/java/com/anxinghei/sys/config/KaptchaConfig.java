package com.anxinghei.sys.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@Component
public class KaptchaConfig {

    private final static String CODE_LENGTH = "4";
    private final static String SESSION_KEY = "verification_session_key";

    @Bean
    public DefaultKaptcha defaultKaptcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 设置边框
        properties.setProperty("kaptcha.border", "no");
        // 设置边框颜色
        properties.setProperty("kaptcha.border.color", "105,179,90");
        // 设置字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        // 设置图片宽度
        properties.setProperty("kaptcha.image.width", "173");
        // 设置图片高度
        properties.setProperty("kaptcha.image.height", "40");
        // 设置字体尺寸
        properties.setProperty("kaptcha.textproducer.font.size", "32");
        // 设置图片样式
        properties.setProperty("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");
        // 设置session key
        properties.setProperty("kaptcha.session.key", SESSION_KEY);
        // 设置验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", CODE_LENGTH);
        // 设置字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,黑体");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}