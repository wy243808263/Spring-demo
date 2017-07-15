package com.roadrantz.marketing;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
public class Sender {
	private JmsTemplate jmsTemplate;
   public void sendInfo()
   {
	 jmsTemplate.send(new MessageCreator(){
		 public Message createMessage(Session session) throws JMSException
		 {   MapMessage message=session.createMapMessage();
		       message.setString("lastName", "pp");
			   return message;
		 }
		 
	 });
   }
public JmsTemplate getJmsTemplate() {
	return jmsTemplate;
}
public void setJmsTemplate(JmsTemplate jmsTemplate) {
	this.jmsTemplate = jmsTemplate;
}
}
