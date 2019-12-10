package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.User;
import service.UserService;

public class UserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService userService= new UserService();
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取请求参数， 保存user表中
		 * 2.保存上传的文件
		 * */
		//新建SmartUpload对象
		SmartUpload smartUpload = new SmartUpload();
		ServletConfig config = this.getServletConfig();
		//初始化配置
		smartUpload.initialize(config, request, response);
		//获取请求对象
		SmartRequest req = smartUpload.getRequest();

		//上传图片
		try {
			smartUpload.upload();
			SmartFile picFile = smartUpload.getFiles().getFile(0);

			//获取请求参数
			String name = req.getParameter("name");
			String burden = req.getParameter("burden");
			String price = req.getParameter("price");
			String price1 = req.getParameter("price1");
			String brief = req.getParameter("brief");
			String typeid = req.getParameter("typeid");
			String imgpath = "img/" + picFile.getFileName();
			
			Menus menu = new Menus();
			menu.setName(name);
			menu.setBurden(burden);
			menu.setPrice(price1);
			menu.setPrice1(price1);
			menu.setBrief(brief);
			menu.setTypeid(typeid);
			menu.setImgpath(imgpath);
			
			int result = menusService.add(menu);
			PrintWriter out = response.getWriter();
			if(result == 1) {
				smartUpload.save("img/");
				out.print("<script>"
						+ "alert('注册成功');" 
						+ "window.location.href='" 
						+ request.getContextPath()
						+ "/MenusServlet?method=findByPage';" 
						+ "</script>");
			} else {
				out.print("<script>"
						+ "alert('注册失败');" 
						+ "window.location.href='" 
						+ request.getContextPath()
						+ "/MenusServlet?method=findByPage';" 
						+ "</script>");
			}
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
