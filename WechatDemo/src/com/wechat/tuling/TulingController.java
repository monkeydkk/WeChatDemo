package com.wechat.tuling;

import net.sf.json.JSONObject;

/**
 * ͼ������˽ӿ����̿�����
 * @author duankangkang
 *
 */
public class TulingController {
	/**
	 * ����ͼ������˽ӿڣ���������������
	 * @param info
	 * @return
	 */
	public String getTulingRe(String info){
		//����ͼ������˽ӿ�api����ȡ���
		String url="http://www.tuling123.com/openapi/api?key=90469316fd3653482b5a917e673dca09&info="+info;
		String tlResult=HttpGetRequest.get(url);
		
		//����ͼ�������ݣ���ȡ��������
		JSONObject json=JSONObject.fromObject(tlResult);
		tlResult=json.getString("text");
		return  tlResult;
		
	}
}
