package com.jkxy.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建画布
		BufferedImage image=new BufferedImage(100, 30, BufferedImage.TYPE_INT_BGR);
		//获取绘图工具
		Graphics graphics=image.getGraphics();
		//设置颜色
		Random r=new Random();
		//绘制矩形
		graphics.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		graphics.fillRect(0, 0, 100, 30);		
		//显示验证码
		graphics.setColor(new Color(0,0,0));
		graphics.setFont(new Font(null, Font.BOLD, 24));
		String num=getNums(5);
		req.getSession().setAttribute("num", num);
		graphics.drawString(num, 10, 25);
		//绘制干扰线
		for (int i = 0; i < 8; i++) {
			graphics.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			graphics.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));	
		}
		
		//设置文件格式
		resp.setContentType("image/jpeg");
		//打开输出流
		OutputStream optStream=resp.getOutputStream();
		//输出图片
		ImageIO.write(image, "jpeg", optStream);
		
	}
	private String getNums(int size) {
		String numsString="QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123456789";
		String num="";
		for (int i = 0; i < size; i++) {
			num+=numsString.charAt(new Random().nextInt(numsString.length()));		
		}
		return num;
	}

}
