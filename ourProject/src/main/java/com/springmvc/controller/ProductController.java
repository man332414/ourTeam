package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.DTO.buyCheckList;
import com.springmvc.service.BuyCheckListService;


@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired // 컴포넌트 스캔되어야 함
	private BuyCheckListService buyCheckListService;

	@GetMapping
	public String requestlistList(Model model) {
		System.out.println("000.rc : requestlistList 진입");

		List<buyCheckList> list= buyCheckListService.getALLbuyCheckList();
		System.out.println("뷰이동: " + list);
		model.addAttribute("productlist",list);

		return "readAllProducts";
	}


//	@RequestMapping("/product")
//	public String welcome(Model model) {
//		model.addAttribute(model);
//		return "readOneProduct";
//	}

	@GetMapping("/product")
	public String viewProductDetail(@RequestParam int id, Model model) {
	    buyCheckList product = buyCheckListService.getbuyCheckListkByNum(id); // 제품 ID로 조회
	    model.addAttribute("product", product); // 모델에 추가
	    return "readOneProduct"; // JSP 파일 이름
	}


	@GetMapping("/all")
	public ModelAndView requestAllLists() {
		System.out.println("000.rc requestAlllists : 진입");
		ModelAndView modelAndView = new ModelAndView();
		List<buyCheckList> list= buyCheckListService.getALLbuyCheckList();
		modelAndView.addObject("productlist",list);
		modelAndView.setViewName("products");
		return modelAndView;
	}

	@GetMapping("/{useCategory}")
	public String requestListsByAddress(@PathVariable("useCategory") String useCategory,Model model) {
		System.out.println("000.rc requestListsByuseCategory : 진입"+ useCategory);
		List<buyCheckList> listsByuseCategory= buyCheckListService.getbuyCheckListByuseCategory(useCategory);

		if (listsByuseCategory == null || listsByuseCategory.isEmpty()){
//			throw new AddressException();
		}
		model.addAttribute("productlist",listsByuseCategory);
		System.out.println("000.rc requestListsByuseCategory : listsByuseCategory= "+ listsByuseCategory);

		return "readAllProducts";
	}

	@GetMapping("/add")
	public String requestAddListForm(@ModelAttribute("NewList") buyCheckList list,BindingResult result, HttpServletRequest request) {
		System.out.println("===============================");
		System.out.println("000.rc get requestAddListForm : 진입");

		//form에 입력
		if(result.hasErrors()) {
			return "createProduct";
		}

		return "createProduct";
	}


	@PostMapping("/add")
	public String submitAddNewBook(@ModelAttribute("NewList") buyCheckList list,BindingResult result, HttpServletRequest request){
			System.out.println("000.rc post submitAddNewList : 진입 "+ list);

			if(result.hasErrors()) {
				return "createProduct";
			}

			// DB에 저장
			System.out.println("DB에 저장 setNewbuyCheckList : 실행 ");
			buyCheckListService.setNewbuyCheckList(list);

		return "redirect:/products";
	}


	@ModelAttribute
	public void addAttributrs(Model model) {
		model.addAttribute("addTitle","신규품목등록");
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("num","useCategory","gradeCategory","productName","productPrice",
				"quantity","acquisitionPath","acquisitionMethod");
	}

}
