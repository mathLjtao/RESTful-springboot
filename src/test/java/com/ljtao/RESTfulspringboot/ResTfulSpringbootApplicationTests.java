package com.ljtao.RESTfulspringboot;

//import com.ljtao.RESTfulspringboot.withRabbitMq.mq_ex1.Sender;
import com.ljtao.RESTfulspringboot.withRabbitMq.ex2_direct.Sender;
import com.ljtao.RESTfulspringboot.withRabbitMq.ex3_mq_topic.Sender_ex3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ljtao.RESTfulspringboot.dao.DepDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class ResTfulSpringbootApplicationTests {
	//@Autowired
	//private DepDao dep;
	@Autowired
	private Sender sender;

	@Autowired
	private Sender_ex3 sender_ex3;
	@Test
	public void contextLoads() {
		//List<Dep> list=new ArrayList<>();
		//list=dep.getAll();
		//System.out.println(list.toString());
	}
	/*
	测试springboot结合rabbitmq发送信息
	 */
	@Test
	public void mqHello(){
		//sender.send();
		System.out.println("aaa");
	}
	/*
	测试springboot结合rabbitmq发送信息,redict形式
	 */
	@Test
	public void mqHello1() throws Exception{
		sender.send();
		System.out.println("mqHello1");
	}

	/*
	测试springboot结合rabbitmq发送信息,topic形式
	 */
	@Test
	public void mqHello2() throws Exception{
		while(true){
			Thread.sleep(5000);
			sender_ex3.orderProcess();
			sender_ex3.productProcess();
			sender_ex3.userProcess();

		}
		//System.out.println("mqHello2");
	}

}

