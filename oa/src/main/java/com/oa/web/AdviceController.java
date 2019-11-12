package com.oa.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.html.Result;
import com.oa.pojo.Aff;
import com.oa.service.AffService;

/**
 * @author xxl
 * @category 信息中心控制器
 */

@Controller
@RequestMapping("/xinXi")
public class AdviceController {

	@Autowired
	private AffService affService;

	// 待改
	@RequestMapping("/addAdvice")
	public @ResponseBody Result addAdvice(String title, String content, HttpServletResponse response) {
		Result result = new Result();
		Aff aff = new Aff();
		// af.setTitle(title);
		aff.setTitle(title);
		aff.setContent(content);
		Boolean flag = affService.add(aff);
		if (flag) {
			result.setResult("创建成功！");
		} else {
			result.setResult("创建失败！");
		}
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		return result;
	}

	// 待改
	@RequestMapping("/showAdvice")
	public @ResponseBody List<Aff> showAdvice(HttpServletResponse response) {
		List<Aff> affs = affService.findAll();
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		return affs;
	}

	// 待改
	@RequestMapping("/searchByTitle")
	public @ResponseBody List<Aff> searchByTitle(String title,HttpServletResponse response) {
		Aff aff = new Aff();
		aff.setTitle(title);
		List<Aff> affs = affService.findByTitle(aff);
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		return affs;
	}

}
