package com.learning.config;

import com.github.davidfantasy.mybatisplus.generatorui.GeneratorConfig;
import com.github.davidfantasy.mybatisplus.generatorui.MybatisPlusToolsApplication;
import com.github.davidfantasy.mybatisplus.generatorui.mbp.NameConverter;

public class GeneratorMain {
 
 public static void main(String[] args) {
//  GeneratorConfig config = GeneratorConfig.builder().jdbcUrl("jdbc:postgresql://127.0.0.1:5432/ghyapp")
//    .userName("ghy01").password("ghy01").driverClassName("org.postgresql.Driver")

     GeneratorConfig config = GeneratorConfig.builder().jdbcUrl("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false")
             .userName("root").password("root").driverClassName("com.mysql.cj.jdbc.Driver")
    // 数据库schema，POSTGRE_SQL,ORACLE,DB2类型的数据库需要指定
    // .schemaName("myBusiness")
    // 如果需要修改各类生成文件的默认命名规则，可自定义一个NameConverter实例，覆盖相应的名称转换方法：
    .nameConverter(new NameConverter() {
     /**
      * 自定义Service类文件的名称规则
      */
     public String serviceNameConvert(String tableName) {
      return this.entityNameConvert(tableName) + "Service";
     }
 
     /**
      * 自定义Controller类文件的名称规则
      */
     public String controllerNameConvert(String tableName) {
      return this.entityNameConvert(tableName) + "Action";
     }
    }).basePackage("com.github.davidfantasy.mybatisplustools.example").port(8068).build();
 
  MybatisPlusToolsApplication.run(config);
 
 }
 
}