package cn.zunsight.web.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zunsight.utils.VerifyCode;



public class VerifyCodeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建验证码类
		VerifyCode vc = new VerifyCode();
		//得到验证码图片
		BufferedImage image = vc.getImage();
//		System.out.println("得到图片");
		//将得到的文本保存到session中
		request.getSession().setAttribute("session_vcode", vc.getText());
//		System.out.println("得到文本");
		//将图片响应到客户端
		VerifyCode.output(image, response.getOutputStream());
//		System.out.println("已相应");

	}

}