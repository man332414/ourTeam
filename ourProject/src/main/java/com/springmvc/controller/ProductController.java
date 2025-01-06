package com.springmvc.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.DTO.buyCheckList;
import com.springmvc.DTO.parentingDiary;
import com.springmvc.service.BuyCheckListService;


@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired // 컴포넌트 스캔되어야 함
	private BuyCheckListService buyCheckListService;

	//클래스 수준 매핑으로 모든 컨텐츠 읽어오기
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
	//하나 읽어오기
	@GetMapping("/product")
	public String viewProductDetail(@RequestParam int id, Model model) {
	    buyCheckList product = buyCheckListService.getbuyCheckListkByNum(id); // 제품 ID로 조회
	    model.addAttribute("product", product); // 모델에 추가
	    return "readOneProduct"; // JSP 파일 이름
	}

	//모든 리스트 읽어오기
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
	public String submitAddNewList(@ModelAttribute("NewList") buyCheckList list,BindingResult result, HttpServletRequest request){
			System.out.println("000.rc post submitAddNewList : 진입 "+ list);

			if(result.hasErrors()) {
				return "createProduct";
			}

			 MultipartFile listImage = list.getListImage();
			    System.out.println("003.pc post submitAddNewList : listImage= " + listImage);

			    // 파일이 선택되었는지 확인
			    if (listImage == null || listImage.isEmpty()) {
			        System.out.println("파일이 업로드되지 않았습니다.");
			        request.setAttribute("errorMessage", "파일을 선택해 주세요."); // 사용자에게 알림
			        return "createProduct"; // 폼으로 리턴
			    }

			    String save = request.getServletContext().getRealPath("resources/images");
			    String fileName = listImage.getOriginalFilename();
			    System.out.println("004.pc post submitAddNewList : fileName= " + fileName);

			    File savefile = new File(save, fileName);
			    System.out.println("009.pc post submitAddNewList : savefile= " + savefile);

			    // 파일 처리 로직
			    try {
			        listImage.transferTo(savefile); // 실제 파일 저장
			        list.setFileName(fileName); // 파일 이름 설정
			        System.out.println("020.pc post submitAddNewList : fileName= " + fileName);
			    } catch (Exception e) {
			        e.printStackTrace();
			        request.setAttribute("errorMessage", "파일 저장 중 오류가 발생했습니다.");
			        return "createProduct"; // 오류 발생 시 폼으로 리턴
			    }

			    // DB에 저장
			    if (list.getFileName() == null) {
			        System.out.println("fileName이 null입니다. 파일이 제대로 저장되지 않았습니다.");
			    } else {
			        System.out.println("DB에 저장할 fileName: " + list.getFileName());
			    }

			
			// DB에 저장
			
			buyCheckListService.setNewbuyCheckList(list);

		return "redirect:/products";
	}
	
	@GetMapping("/update")
    public String getUpdateProductForm(@ModelAttribute("updateProduct") buyCheckList list, @RequestParam("id") int num, Model model) {
		buyCheckList listByNum = buyCheckListService.getbuyCheckListkByNum(num);
		
        model.addAttribute("product", listByNum);
        
        System.out.println("/update num= "+num+" listByNum= "+listByNum.getProductName());
        return "updateProduct";  // 수정 폼
    }

	@PostMapping("/update")
    public String submitUpdateDiaryForm(@ModelAttribute("updateDiary") buyCheckList list) {
        MultipartFile listImage = list.getListImage();
        String rootDirectory = "c:/upload/";
        if (listImage!=null && !listImage.isEmpty()) {
            try {
                String fname = listImage.getOriginalFilename();
                listImage.transferTo(new File(rootDirectory + fname));
                list.setFileName(fname);
            } catch (Exception e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }

        buyCheckListService.setUpdatebuyCheckList(list);
        return "redirect:./"+list.getNum();
    }
	

	//@GetMapping("delete/{id}") ajax로 변경
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
		System.out.println("============================");
		System.out.println("000.deleteProduct : 진입 "+ id);
		buyCheckListService.deleteProduct(id);
        return ResponseEntity.noContent().build(); // 204 No Content 응답 반환
    }

	@ModelAttribute
	public void addAttributrs(Model model) {
		model.addAttribute("addTitle","신규품목등록");
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("num","useCategory","gradeCategory","productName","productPrice",
				"quantity","acquisitionPath","acquisitionMethod","fileName","listImage");
	}

}
