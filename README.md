# graduationProject

## 一、启动项目前配置修改 
### 1、application.properties：
1.1 修改端口号 
server.port=8080 

1.2 修改连接数据库
spring.datasource.url=jdbc:mysql://localhost:3306/hotel?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai  

spring.datasource.username=root 

spring.datasource.password=root  

1.3 freemarker模板路径 
spring.freemarker.template-loader-path=classpath:/templates/  
 
 ### 2、logback-spring.xml： 
 
 2.1 mybatis的sql查询日志  
 
 <logger name="com.anxing.sys.mapper" level="DEBUG" addtivity="false">
    	<appender-ref ref="file" />
	</logger>  
	
  2.2 日志输出文件的命名
   <fileNamePattern>${log.path}/springboot-logging.%d{yyyy-MM-dd}.log</fileNamePattern>

