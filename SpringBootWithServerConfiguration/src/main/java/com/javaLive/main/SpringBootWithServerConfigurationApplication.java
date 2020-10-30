package com.javaLive.main;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootWithServerConfigurationApplication {
	
	@Autowired
    private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithServerConfigurationApplication.class, args);
	}
	public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            int port = applicationContext.getBean(Environment.class).getProperty("server.port", Integer.class, 8080);
            System.out.printf("%s:%d", ip, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
