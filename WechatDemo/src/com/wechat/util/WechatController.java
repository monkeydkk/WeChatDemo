package com.wechat.util;

import com.wechat.entity.ReceiveXmlEntity;
import com.wechat.tuling.TulingController;

/**
 * Ϊ�����̿�����
 * @author duankangkang
 *
 */
public class WechatController {
	/**
	 * ΢�Ŵ������̿�����
	 * @param content �ͻ��˷��͹�����xml����
	 * @return ������ɣ���װ�õ�xml�������
	 */
	public String wechatProcess(String content){
		//�������ܵ���xml���ݣ�תΪ����
		ReceiveXmlEntity xml=ParseReceiceXml.getMsgEntity(content);
		
		//����ͼ������˽ӿڴ���ģ�飬��ȡͼ������˵Ľ��
		String tlResult=new TulingController().getTulingRe(xml.getContent());
		
		//��װxml�ӿڵķ�������
		String xmlResult = FormatXmlResult.getXmlResult(xml, tlResult);
		
		return xmlResult;
	}
}
