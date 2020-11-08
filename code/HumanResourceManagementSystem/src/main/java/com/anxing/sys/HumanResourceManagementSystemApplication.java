package com.anxing.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

@SpringBootApplication
public class HumanResourceManagementSystemApplication {

	
	public static void main(String[] args) {
		DocsConfig config = new DocsConfig();
		config.setProjectPath("D:\\E_softwareFiles\\Eclipse\\graduationProject_"); // 项目根目录
		config.setProjectName("招聘人事管理系统"); // 项目名称
		config.setApiVersion("V1.0");       // 声明该API的版本
		config.setDocsPath("D:\\E_softwareFiles\\Eclipse\\graduationProject_\\code\\HumanResourceManagementSystem\\src\\main\\resources\\apiDocs"); // 生成API 文档所在目录
		config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
		Docs.buildHtmlDocs(config); // 执行生成文档
		SpringApplication.run(HumanResourceManagementSystemApplication.class, args);
	}

}
