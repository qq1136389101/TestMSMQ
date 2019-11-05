package test;

import ionic.Msmq.Message;
import ionic.Msmq.MessageQueueException;
import ionic.Msmq.Queue;

public class SimpleSendMSMQ {
	
	//元原源码包使用此方法初始化
//	static{
//		System.loadLibrary("MsmqJava64");
//	}
	
	public static void main(String[] args) {
		try {
			//初始化指定目录
//			Queue.initSystemLibraries("E:\\Workspaces\\TestMSMQ\\lib\\MsmqJava64.dll");
			//初始化 dll放在项目根目录下
			Queue.initSystemLibraries();
			
			//192.168.1.100为本机的IP地址（经测试不能使用127.0.0.1,不然会报错）
			//private$\\myqueue是队列名字
			String fullname="DIRECT=OS:.\\private$\\test";
//			String fullname="FormatName:DIRECT=TCP:192.168.1.101\\private$\\test";
			Queue queue = new Queue(fullname);
		     //标题
		     String label="testSend";
		     //内容
		     String body= "Hello, World!";
		     //这个属性我还没搞清楚是什么，有大神知道的请告知
		     String correlationId = "123";
//		     byte[] correlationId = { 0, 2, 4, 6, 8, 9 };
//		     //创建消息
		     Message msg = new Message(body, label, correlationId);
//		     System.out.println("发送消息[label={}, body={}]:" + msg.getLabel() + "," + msg.getBodyAsString());
		     queue.send(msg);
		 }
		 catch (MessageQueueException ex1) {
		     System.out.println("Put failure: " + ex1.toString());
		     ex1.printStackTrace();
		 } catch (Exception e) {
			e.printStackTrace();
		}
	}
}
