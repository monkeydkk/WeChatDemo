package com.wechat.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.util.WechatController;

/**
 * Servlet implementation class WechatIoservlet
 */
@WebServlet("/WechatIo.do")
public class WechatIoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WechatIoservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置接口的数据格式和编码方式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//读取微信客户端post发送过来的数据
		InputStream is=request.getInputStream();
		InputStreamReader isr=new InputStreamReader(is,"UTF-8");
		BufferedReader br=new BufferedReader(isr);
		
		String str="";
		StringBuffer sb=new StringBuffer();
		
		//按行读取内容
		while(null!=(str=br.readLine())){
			sb.append(str);
		}
		
		String content=sb.toString();
		
		//调用微信处理流程，获取处理结果
		String result=new WechatController().wechatProcess(content);
		
		//返回处理完成的结果
		OutputStream os=response.getOutputStream();
		os.write(result.getBytes("UTF-8"));
		os.flush();
		os.close();
	}

}
