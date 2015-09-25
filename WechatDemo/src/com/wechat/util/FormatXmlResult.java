package com.wechat.util;

import java.util.Date;

import com.wechat.entity.ReceiveXmlEntity;

/**
 * ��װ���ظ�΢�Ŷ˵�xml����
 * @author duankangkang
 *
 */
public class FormatXmlResult {
	/**
	 * ��װxml�������
	 * @param xml  ���ܵ���xml����
	 * @param tlResult  ͼ������˴�����
	 * @return
	 */
	public static String getXmlResult(ReceiveXmlEntity xml,String tlResult){
		StringBuffer sb =new StringBuffer();
		sb.append("<xml><ToUserName><![CDATA[");
		sb.append(xml.getFromUserName());
		sb.append("]]></ToUserName><FromUserName><![CDATA[");
		sb.append(xml.getToUserName());
		sb.append("]]></FromUserName><CreateTime>");
		sb.append(new Date().getTime());
		sb.append("</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[");
		sb.append(tlResult);
		sb.append("]]></Content></xml>");
		return sb.toString();
	}
}
