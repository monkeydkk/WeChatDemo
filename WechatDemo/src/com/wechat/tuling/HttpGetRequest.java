package com.wechat.tuling;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * http get������
 * @author duankangkang
 *
 */
public class HttpGetRequest {
	/**
	 * get ����
	 * @param url ����ĵ�ַ�Ͳ���
	 * @return url�Ľ��
	 */
	public static String get(String url){
		try{
			HttpGet request=new HttpGet(url);
			//ִ��http get ����
			HttpResponse response=HttpClients.createDefault().execute(request);
			
			//���ݷ������жϷ����Ƿ�ɹ�
			String result="";
			if(response.getStatusLine().getStatusCode()==200){
				result=EntityUtils.toString(response.getEntity());
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return "ʧ��";
		}
	}
}
