package com.pussinboots.morning.cms.modules.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pussinboots.morning.cms.common.util.SingletonLoginUtils;
import com.pussinboots.morning.cms.modules.administrator.service.IRoleMenuService;
import com.pussinboots.morning.cms.modules.system.vo.MenuVO;
import com.pussinboots.morning.common.controller.BaseController;

/**
 * 
* 项目名称：morning-cms-webapp   
* 类名称：MainController   
* 类描述：后台管理系统主页表示层控制器  
* 创建人：陈星星   
* 创建时间：2017年2月4日 下午5:27:46
 */
@Controller
@RequestMapping("/index")
public class MainController extends BaseController {

	/** 后台管理主界面 */
	private static final String MAIN = getViewPath("modules/main/main");
	/** 后台管理主界面初始化首页 */
	private static final String MAIN_INDEX = getViewPath("modules/main/index");
	
	@Autowired
	private IRoleMenuService roleMenuService;
	
	/**
	 * 进入操作中心
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
//		// 未处理订单数
//		int undisposedOrder = orderService.queryOrderCountBySystem(2);
//		mainCountMap.put("undisposedOrder", undisposedOrder);
//		if (undisposedOrder != 0) {
//			String undisposedOrderTime = DateUtil.dateDiff(
//					orderService.queryOrderTime(2), new Date());
//			mainCountMap.put("undisposedOrderTime", undisposedOrderTime);
//		}
		// 系统目录
		List<MenuVO> menus = roleMenuService.selectMenusByAdmin(SingletonLoginUtils.getUser());
		model.addAttribute("menus", menus);
//		model.addAttribute("mainCountMap", mainCountMap);
		return MAIN;
	}
	
	/**
	 * 后台管理主界面初始化首页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String mainIndex(Model model) {
//		Map<String, Object> webCountMap = new HashMap<>();
//		// 今天未支付订单数
//		int unpayOrder = statisticsDayService.getOrderNumber(new Date(), 1);
//		webCountMap.put("unpayOrder", unpayOrder);
//		// 今天支付订单数
//		int payOrder = statisticsDayService.getOrderNumber(new Date(), 6);
//		webCountMap.put("payOrder", payOrder);
//		// 今天支付订单数
//		int allPayOrder = statisticsDayService.getOrderNumber(new Date(), null);
//		// 订单转化率
//		String orderPercent = NumberUtil.getPercent(allPayOrder, payOrder);
//		webCountMap.put("orderPercent", orderPercent);
//		// 今天已支付金额
//		double payMoney = statisticsDayService.getPayNumber(new Date(), 6);
//		webCountMap.put("payMoney", NumberUtil.fmtMicrometer(String.valueOf(payMoney)));
//		// 昨天已支付金额
//		double ytdPayMoney = statisticsDayService.getPayNumber(DateUtil.getOffsiteDate(new Date(), Calendar.DATE, -1), 6);
//		webCountMap.put("ytdPayMoney", NumberUtil.fmtMicrometer(String.valueOf(ytdPayMoney)));
//		// 支付金额同比
//		String payPercent = NumberUtil.getPercent((int) ytdPayMoney, (int) (payMoney - ytdPayMoney));
//		webCountMap.put("payPercent", payPercent);
//		model.addAttribute("webCountMap", webCountMap);
		return MAIN_INDEX;
	}
	
}