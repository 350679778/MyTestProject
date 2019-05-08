package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	private TbItem getItemById(@PathVariable Long itemId){
		System.out.println("进入controller-getItemById---");
		TbItem tbItem = itemService.getItemById(itemId);
		System.out.println("返回controller-getItemById---");
		return tbItem;
	}
	
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows){
		System.out.println("进入controller-getItemList---page:"+page+",rows:"+rows);
		//调用服务查询商品列表
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		System.out.println("返回controller-getItemList---result:"+result.toString());
		return result;
	}
	
	
}
