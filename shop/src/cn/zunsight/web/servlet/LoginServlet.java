package cn.zunsight.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.zunsight.domain.Person;
import cn.zunsight.service.PersonException;
import cn.zunsight.service.PersonService;

public class LoginServlet extends HttpServlet {
	private PersonService service = new PersonService();
	private Person person;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//封装表单信息
		Person form = CommonUtils.toBean(request.getParameterMap(), Person.class);
		
		try {
			person = service.login(form);
			//将信息存放在seession中
			request.getSession().setAttribute("session_person", person);
			//重定向到index.jsp中
			response.sendRedirect(request.getContextPath() + "/list");
		} catch (PersonException e) {
			//将错误信息放在request中
			request.setAttribute("msg", e.getMessage());
			//将form存放在request中
			request.setAttribute("person", form);
			//转发到login.jsp中
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		

	}

}