package com.oa.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.html.Result;
import com.oa.pojo.Daily;
import com.oa.service.DailyService;
import com.oa.vo.DailyVO;

/**
 * @author song
 * @category 个人日报控制器
 *
 */
@Controller
@RequestMapping("/riZhi")
public class DailyController {
	Logger log = Logger.getLogger(DailyController.class);
	@Resource
	private DailyService dailyService;

	/**
	 * @return 查询所有日报
	 */
	@RequestMapping("/list")
	public @ResponseBody List<DailyVO> list(HttpServletResponse response) {
		List<DailyVO> Dailylist = dailyService.findAll();
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		return Dailylist;
	}

	/**
	 * @param daily
	 *            增加一个日报信息
	 * @return 重定向到查询所有日志信息控制器
	 */
	@RequestMapping("/addSave")
	public @ResponseBody Result addSave(Daily daily,HttpSession session, HttpServletResponse response) {
		boolean flag = dailyService.add(daily);
		Result result = new Result();
		if (flag) {
			result.setResult("添加成功！");
		} else {
			result.setResult("添加失败！");
		}
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		return result;

	}

	/**
	 * @param id
	 *            部门编号
	 * @return 根据部门编号查询所有日报信息
	 */
	@RequestMapping("/listDaily")
	public @ResponseBody List<DailyVO> listDaily(int id, HttpServletResponse response) {
		List<DailyVO> dailyVOs = dailyService.findByDepId(id);
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		return dailyVOs;

	}

	/**
	 * @param date
	 *            日期（格式为“yyyy-MM-dd”）
	 * @return 根据日期查询当日所有日报信息
	 */
	@RequestMapping("/listDailyVO")
	public @ResponseBody List<DailyVO> listDailyVO(String date, HttpServletResponse response) {
		List<DailyVO> dListVO = dailyService.findByListDate(date);
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		return dListVO;

	}

	/**
	 * @param date
	 *            日期（格式为“yyyy-MM-dd”）
	 * @param eid
	 *            员工编号
	 * @return 根据日期和员工编号查询自己的日报信息
	 */
	@RequestMapping("/dailyVO")
	public @ResponseBody List<DailyVO> dailyVO(String date, Integer eid, HttpServletResponse response) {
		List<DailyVO> dVos = dailyService.findDateOne(date, eid);
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		return dVos;

	}

	/**
	 * @param eid
	 *            员工编号
	 * @return 根据员工编号查询日报信息
	 */
	@RequestMapping("/listDailydd")
	public @ResponseBody List<DailyVO> listDailydd(Integer eid, HttpServletResponse response) {
		List<DailyVO> dailies = dailyService.findById(eid);
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		return dailies;

	}

	/**
	 * 
	 * @param did
	 *            日报编号
	 * @return 根据日报编号查询日报信息
	 */
	@RequestMapping("/dailyRB")
	public @ResponseBody DailyVO dailyRB(int did) {
		DailyVO dailyVO = dailyService.findByDailyId(did);
		return dailyVO;
	}

	/**
	 * 根据日报编号删除日报信息
	 * 
	 * @param did
	 *            日报编号
	 * @return
	 */
	@RequestMapping("/deleteDaily")
	public @ResponseBody Result deleteDaily(Integer did, HttpServletResponse response) {
		boolean flag = dailyService.deleteById(did);
		Result result = new Result();
		if (flag) {
			result.setResult("删除成功！");
		} else {
			result.setResult("删除失败！");
		}
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		return result;
	}

	/**
	 * 更新一个日报对象
	 * 
	 * @param did
	 *            日报编号
	 * @param wdef
	 *            日报内容
	 * @return
	 */
	@RequestMapping("/updateDaily")
	public @ResponseBody Result updateDaily(Integer did, String wdef, HttpServletResponse response) {
		DailyVO dailyVO = dailyService.findByDailyId(did);
		dailyVO.setWdef(wdef);
		boolean flag = dailyService.update(dailyVO);
		Result result = new Result();
		if (flag) {
			result.setResult("更新成功！");
		} else {
			result.setResult("更新失败！");
		}
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		return result;

	}

}
