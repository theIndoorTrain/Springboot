package com.xm.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelloJob {
	
	//@Scheduled(initialDelay=5000,fixedRate=10000)
	//@Scheduled(initialDelay=5000,fixedDelay=10000)
	@Scheduled(cron="0/5 0-21 16 * * ?")
	public void run() {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		try {
			//Thread.sleep(11000);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello world");
	}

}
