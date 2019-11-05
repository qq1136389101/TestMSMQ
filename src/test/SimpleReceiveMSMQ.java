package test;

import ionic.Msmq.Message;
import ionic.Msmq.MessageQueueException;
import ionic.Msmq.Queue;

public class SimpleReceiveMSMQ {
	
	//元原源码包使用此方法初始化
//	static{
//		System.loadLibrary("MsmqJava64");
//	}
	
	public static void main(String[] args) {
		try {
			//初始化指定目录
//			Queue.initSystemLibraries("E:\\Workspaces\\TestMSMQ\\lib\\MsmqJava64.dll");
			//初始化 dll放在项目根目录下，可以使用此函数初始化，可以不含路径
			Queue.initSystemLibraries();
			
			//192.168.1.100为本机的IP地址（经测试不能使用127.0.0.1,不然会报错）
			//private$\\testmessage是队列名字
			String fullname="direct=OS:.\\private$\\test";
		     Queue queue= new Queue(fullname);
		     Message message=queue.receive();
		     //这里就是回复的内容
		     System.out.println(message.getBodyAsString());
		 }
		 catch (MessageQueueException ex1) {
		     System.out.println("Put failure: " + ex1.toString());
		     ex1.printStackTrace();
		 } catch (Exception e) {
			e.printStackTrace();
		}
	}
}
