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
	 * post 请求
	 * @param url 请求地址
	 * @param param 请求的内容
	 * @return 接口返回的内容
	 */
	private static String post(String url,String param){
		try{
			HttpPost request=new HttpPost(url);
			request.setEntity(new StringEntity(param));
			HttpResponse response=HttpClients.createDefault().execute(request);
			String result="";
			//根据返回码判断请求是否成功
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
		String content=URLEncoder.encode("这件衣服有折扣吗","UTF-8");
		String param="<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA["+content+"]]></Content></xml>";
		String url="http://localhost:8080/WechatDemo/WechatIo.do";
		String result=post(url,param);
		System.out.println(result);
	}
}
