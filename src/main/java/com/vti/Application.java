package com.vti;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import com.vti.config.AppProperties;
import com.vti.entity.CategoryEntity;
import com.vti.entity.NewEntity;
import com.vti.repository.CategoryRepository;
import com.vti.repository.NewRepository;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
// kích hoạt cho phép chúng ta cấu hình ứng dụng từ bên ngoài và lấy các thông tin đó ra một cách dễ dàng ( trong package config.Appproperties để hiểu ) 
@EnableConfigurationProperties
public class Application  implements CommandLineRunner{
	// Test @ConfigurationPropertie - cấu hình ứng dụng từ bên ngoài và lấy các thông tin đó ra một cách dễ dàng.
	
	 public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
//		 NewRepository newRepositoy = context.getBean(NewRepository.class); 
//		 List<NewEntity> newEntitylist = newRepositoy.findAll(); 
//		 for (NewEntity newEntity : newEntitylist) {
//		     System.out.println(newEntity.getCategory().getCode());
//		 }
//------------------------------------------------------------------------------------------------------
//		 //  newRepositoy.findAll().forEach(System.out::println);
//       	CategoryRepository categoryRepository = context.getBean(CategoryRepository.class); 
//       	System.out.println("-------Test native query by ?1 ?2-------");
//       	CategoryEntity categoryEntity = categoryRepository.myFindOneByCode(1); 
//       	System.out.println(categoryEntity.getCode());
//       	
//       	System.out.println("-------Test native query bằng cách đặt tên cho tham số-------");
//       	CategoryEntity categoryEntity2 = categoryRepository.myFindOneByCode2(1); 
//       	System.out.println(categoryEntity2.getCode());
//       	
//       	System.out.println("-------Test get all list Category--------");
//       	categoryRepository.findAll().forEach(System.out::println);
       	
    }
	 @Autowired AppProperties vtiAppProperties;
			 
	    public void run(String... args) throws Exception {
	        System.out.println("Global variable:");
	        System.out.println("\t Email: "+vtiAppProperties.getEmail());
	        System.out.println("\t GA ID: "+vtiAppProperties.getGoogleAnalyticsId());
	    }
	
}
