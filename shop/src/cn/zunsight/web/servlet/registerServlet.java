package cn.zunsight.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.commons.CommonUtils;
import cn.zunsight.domain.Person;
import cn.zunsight.service.PersonException;
import cn.zunsight.service.PersonService;

public class registerServlet extends HttpServlet {
	private PersonService service = new PersonService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//封装表单数据
		Person form = CommonUtils.toBean(request.getParameterMap(), Person.class);
		Map<String,String> errors = new HashMap<String,String>();
		//设置id
		form.setPid(CommonUtils.uuid());
		
		//对表单用户名校验
		String name = form.getPname();
		if(name == null || name.trim().isEmpty()) {
			errors.put("name", "用户名不能为空!");
		}else if(name.length() < 2 || name.length() > 8) {
			errors.put("name", "用户名长度在5~8之间!");
		}

		//对表单密码校验
		String password = form.getPpassword();
		if(password == null || password.trim().isEmpty()) {
			errors.put("password", "密码名不能为空!");
		}else if(password.length() < 8 || password.length() > 12) {
			errors.put("password", "密码长度在8~12之间!");
		}
		
		//对表单电话校验
		String tel = form.getPtel();
		if(tel == null || tel.trim().isEmpty()) {
			errors.put("tel", "电话号码不能为空!");
		}else if(tel.length() != 11) {
			errors.put("tel", "电话号码必须是11位！");
		}
		
		String verify = (String) request.getSession().getAttribute("session_vcode");
		String verifyCode = form.getVerifyCode();
		if(verifyCode == null || verifyCode.trim().isEmpty()) {
			errors.put("verifyCode", "验证码不能为空!");
		}else if(verifyCode.length() != 4) {
			errors.put("verifyCode", "验证码必须是11位！");
		}else if(!verifyCode.equalsIgnoreCase(verify)) {
			errors.put("verifyCode", "验证码错误!");
		}
		
		if(errors != null && errors.size() > 0) {
			//保存错误信息
			request.setAttribute("errors", errors);
			//保存form信息
			request.setAttribute("person", form);
			//转发到register.jsp
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		
		try {
			service.register(form);
			//无异常,保存成功信息
			response.getWriter().print("<h1>注册成功！</h1><a href='" + 
					request.getContextPath() + 
					"/login.jsp" + "'>点击这里去登录</a>");;
		} catch (PersonException e) {
			//获取异常信息
			request.setAttribute("msg", e.getMessage());
			//保存表单数据到request
			request.setAttribute("person", form);
			//转发到register.jsp
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}

	}

}