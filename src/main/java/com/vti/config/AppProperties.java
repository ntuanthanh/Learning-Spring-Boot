package com.vti.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component // Để Spring biết đây là một bean và khởi tạo nó
@PropertySource("classpath:vti.yml") // để định nghĩa tên của file config. Nếu không có annotation này, Spring sẽ sử
										// dụng file mặc định (classpath:application.yml/ trong thư mục resources)
@ConfigurationProperties(prefix = "vti") // Anotation này đánh dấu class bên dưới là properties, các thuộc tính sẽ được tự động nạp vào khi Spring khởi tạo
                                        // Lưu ý : Các thuộc tính này được xác định bởi prefix = loda. Chỉ lấy các config có tiền tố là "Loda"

// Ngoài những Annotation trên cần phải có để chạy được tính năng này gắn Anotation @EnableConfigurationProperties lên một configuration nào đó. có thể là hàm main 
public class AppProperties {
	private String email;
	private String googleAnalyticsId;

	public AppProperties(String email, String googleAnalyticsId) {
		this.email = email;
		this.googleAnalyticsId = googleAnalyticsId;
	}

	public AppProperties() {
	}

// Spring sẽ tự tìm các hàm setter để set giá trị cho các thuộc tính này, nên quan trọng là bạn phải tạo ra các setter method. 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGoogleAnalyticsId() {
		return googleAnalyticsId;
	}

	public void setGoogleAnalyticsId(String googleAnalyticsId) {
		this.googleAnalyticsId = googleAnalyticsId;
	}

}
