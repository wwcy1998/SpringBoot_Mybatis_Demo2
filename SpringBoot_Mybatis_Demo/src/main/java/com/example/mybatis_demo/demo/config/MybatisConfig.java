package com.example.mybatis_demo.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class MybatisConfig {
    @Configuration
    @MapperScan(basePackages = {"com.example.mybatis_demo.demo.dao"},
            sqlSessionFactoryRef = "sqlSessionFactoryThree",
            sqlSessionTemplateRef = "sqlSessionTemplateThree")
    public static class DBThree {

        private static final String MAPPER_PATH_STATISTICS = "classpath:mapper/*.xml";

        @Resource
        DataSource statisticsDataSource;

        @Bean
        public SqlSessionFactory sqlSessionFactoryThree() throws Exception {

            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(statisticsDataSource);
            factoryBean.setMapperLocations(
                    new PathMatchingResourcePatternResolver().getResources(MAPPER_PATH_STATISTICS));
            return factoryBean.getObject();
        }

        @Bean
        public SqlSessionTemplate sqlSessionTemplateThree() throws Exception {
            SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryThree()); // 使用上面配置的Factory
            return template;
        }
    }

}
