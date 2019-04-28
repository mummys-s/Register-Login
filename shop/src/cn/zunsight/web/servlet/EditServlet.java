package cn.zunsight.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.zunsight.domain.Person;
import cn.zunsight.service.PersonService;

public class EditServlet extends HttpServlet {
	private PersonService service = new PersonService();


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//封装表单数据
		Person form = CommonUtils.toBean(request.getParameterMap(), Person.class);
		//调用service方法
		service.edit(form);
		//保存成功信息
		response.getWriter().print("<h1>修改成功</h1><a href='"+
				request.getContextPath() + 
				"/list" + "'>点击查看用户信息</a>");

	}

}