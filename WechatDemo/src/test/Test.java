package test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @author duankangkang
 *
 */
public class Test {
	/**
	 * post ����
	 * @param url �����ַ
	 * @param param ���������
	 * @return �ӿڷ��ص�����
	 */
	private static String post(String url,String param){
		try{
			HttpPost request=new HttpPost(url);
			request.setEntity(new StringEntity(param));
			HttpResponse response=HttpClients.createDefault().execute(request);
			String result="";
			//���ݷ������ж������Ƿ�ɹ�
			if(200==response.getStatusLine().getStatusCode()){
				result=EntityUtils.toString(response.getEntity());
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		String content=URLEncoder.encode("����·����ۿ���","UTF-8");
		String param="<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA["+content+"]]></Content></xml>";
		String url="http://localhost:8080/WechatDemo/WechatIo.do";
		String result=post(url,param);
		System.out.println(result);
	}
}
