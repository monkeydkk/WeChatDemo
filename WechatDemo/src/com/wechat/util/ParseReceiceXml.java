package com.wechat.util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.wechat.entity.ReceiveXmlEntity;

/**
 * ����΢�Ŷ�XML���ݣ�ת��Ϊ����
 * @author duankangkang
 *
 */
public class ParseReceiceXml {
	/**
	 * ����΢��xml��Ϣ
	 * @param content ΢�Ŷ˵�xml����
	 * @return ת��֮��Ķ���
	 */
	public static ReceiveXmlEntity getMsgEntity(String content){
		ReceiveXmlEntity msg=null;
		try{
			//���ַ���ת��ΪXML����
			Document doc = DocumentHelper.parseText(content);
			
			//��ȡ�ĵ��Ľڵ�
			Element root = doc.getRootElement();
			
			//�������ڵ������е��ӽڵ�
			Iterator<?> iter=root.elementIterator();
			
			//���÷�����ƣ����ö����set����
			Class<?> c=Class.forName("com.wechat.entity.ReceiveXmlEntity");
			
			//����ʵ����
			msg=(ReceiveXmlEntity)c.newInstance();
			
			while(iter.hasNext()){
				Element ele=(Element)iter.next();
				//��ȡset�����еĲ����ֶΣ�ʵ��������ԣ�
				Field filed=c.getDeclaredField(ele.getName());
				//��ȡset����
				Method method=c.getDeclaredMethod("set"+ele.getName(),filed.getType());
				//����set����
				method.invoke(msg,ele.getText());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return msg;
	}
	 
}
