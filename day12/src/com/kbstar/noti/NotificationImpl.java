package com.kbstar.noti;

import com.kbstar.frame.Notification;

public class NotificationImpl implements Notification{

	@Override
	public void sendEmail(String email, String msg) throws Exception {
		System.out.printf("%s에게 이메일 전송... %s ....\n", email, msg);
		
	}

	@Override
	public void sendSMS(String contact, String msg) throws Exception {
		System.out.printf("%s에게 sms 전송... %s ....\n", contact, msg);
		
	}

}
