/**
 *
 */
package com.anxing.sys.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.anxing.sys.session.MySessionListener;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* @Description Shiro配置类
* @Author Sans
* @CreateTime 2019/6/10 17:42
*/
@Configuration
public class ShiroConfig {

   private final String CACHE_KEY = "shiro:cache:";
   private final String SESSION_KEY = "shiro:session:";
   private final int EXPIRE = 1800;

   //Redis配置
   @Value("${spring.redis.host}")
   private String host;
   @Value("${spring.redis.port}")
   private int port;
   @Value("${spring.redis.timeout}")
   private int timeout;
//   @Value("${spring.redis.password}")
//   private String password;

   /**
    * 开启Shiro-aop注解支持
    * @Attention 使用代理方式所以需要开启代码支持
    * @Author Sans
    * @CreateTime 2019/6/12 8:38
    */
   @Bean
   public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager) {
       AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
       authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
       return authorizationAttributeSourceAdvisor;
   }

   /**
    * Shiro基础配置
    * @Author Sans
    * @CreateTime 2019/6/12 8:42
    */
   @Bean
   public ShiroFilterFactoryBean shiroFilterFactory(org.apache.shiro.mgt.SecurityManager securityManager){
       ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
       shiroFilterFactoryBean.setSecurityManager(securityManager);
       Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
       // 注意过滤器配置顺序不能颠倒
       // 配置过滤:不会被拦截的链接
       filterChainDefinitionMap.put("/login", "anon");
       filterChainDefinitionMap.put("/logining", "anon");
       filterChainDefinitionMap.put("/getCode","anon");

       //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
       filterChainDefinitionMap.put("/logouting", "authc");
       //rememberMe 登录即可访问
       filterChainDefinitionMap.put("/toHome", "user");
       //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
       filterChainDefinitionMap.put("/*", "authc");

       // 配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
       shiroFilterFactoryBean.setLoginUrl("/login");
       shiroFilterFactoryBean.setSuccessUrl("/toHome");


       shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
       return shiroFilterFactoryBean;
   }

   /**
    * 安全管理器
    * @Author Sans
    * @CreateTime 2019/6/12 10:34
    */
   @Bean
   public DefaultWebSecurityManager securityManager() {
       DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
       // 自定义Ssession管理
       securityManager.setSessionManager(sessionManager());
       // 自定义Cache实现
       securityManager.setCacheManager(cacheManager());
       // 自定义Realm验证
       securityManager.setRealm(shiroRealm());
       return securityManager;
   }

   /**
    * 身份验证器
    * @Author Sans
    * @CreateTime 2019/6/12 10:37
    */
   @Bean
   public ShiroRealm shiroRealm() {
       ShiroRealm shiroRealm = new ShiroRealm();
//       shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
       return shiroRealm;
   }

   /**
    * 凭证匹配器
    * 将密码校验交给Shiro的SimpleAuthenticationInfo进行处理,在这里做匹配配置
    * @Author Sans
    * @CreateTime 2019/6/12 10:48
    */
//   @Bean
//   public HashedCredentialsMatcher hashedCredentialsMatcher() {
//       HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
//       // 散列算法:这里使用SHA256算法;
//       shaCredentialsMatcher.setHashAlgorithmName(SHA256Util.HASH_ALGORITHM_NAME);
//       // 散列的次数，比如散列两次，相当于 md5(md5(""));
//       shaCredentialsMatcher.setHashIterations(SHA256Util.HASH_ITERATIONS);
//       return shaCredentialsMatcher;
//   }

   /**
    * 配置Redis管理器
    * @Attention 使用的是shiro-redis开源插件
    * @Author Sans
    * @CreateTime 2019/6/12 11:06
    */
   @Bean
   public RedisManager redisManager() {
       RedisManager redisManager = new RedisManager();
       redisManager.setHost(host);
       redisManager.setPort(port);
       redisManager.setTimeout(timeout);
//       redisManager.setPassword(password);
       return redisManager;
   }

   /**
    * 配置Cache管理器
    * 用于往Redis存储权限和角色标识
    * @Attention 使用的是shiro-redis开源插件
    * @Author Sans
    * @CreateTime 2019/6/12 12:37
    */
   @Bean
   public RedisCacheManager cacheManager() {
       RedisCacheManager redisCacheManager = new RedisCacheManager();
       redisCacheManager.setRedisManager(redisManager());
//       redisCacheManager.setKeyPrefix(CACHE_KEY);
       // 配置缓存的话要求放在session里面的实体类必须有个id标识
//       redisCacheManager.setPrincipalIdFieldName("userId");
       return redisCacheManager;
   }

   /**
    * SessionID生成器
    * @Author Sans
    * @CreateTime 2019/6/12 13:12
    */
   @Bean
   public ShiroSessionIdGenerator sessionIdGenerator(){
       return new ShiroSessionIdGenerator();
   }

   /**
    * 配置RedisSessionDAO
    * @Attention 使用的是shiro-redis开源插件
    * @Author Sans
    * @CreateTime 2019/6/12 13:44
    */
   @Bean
   public RedisSessionDAO redisSessionDAO() {
       RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
       redisSessionDAO.setRedisManager(redisManager());
//       redisSessionDAO.setSessionIdGenerator(sessionIdGenerator());
//       redisSessionDAO.setKeyPrefix(SESSION_KEY);
//       redisSessionDAO.setExpire(EXPIRE);
       return redisSessionDAO;
   }

   /**
    * 配置Session管理器
    * @Author Sans
    * @CreateTime 2019/6/12 14:25
    */
   @Bean("sessionManager")
   public DefaultWebSessionManager sessionManager() {
       DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
       sessionManager.setSessionDAO(redisSessionDAO());

       //自定义监听 fht 不能使用@WebListern的 HttpSessionListerner 因为shiro重写了session 2020-03-05
       Collection<SessionListener> sessionListeners = new ArrayList<>();
       sessionListeners.add(sessionListener());
       sessionManager.setSessionListeners(sessionListeners);

       return sessionManager;
   }

    @Bean("sessionListener")
    public MySessionListener sessionListener(){
        MySessionListener loginoutListener = new MySessionListener();
        return loginoutListener;
    }
}
