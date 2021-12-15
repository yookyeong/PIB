package com.oracle.s20210902.yg.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.s20210902.common.service.Paging;
import com.oracle.s20210902.model.Common;
import com.oracle.s20210902.model.Product;
import com.oracle.s20210902.yg.service.ProductService;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService ps;

	@GetMapping(value = "productTable")
	public String ProductTable(Product product, String currentPage, Model model,HttpServletRequest requset) {
		System.out.println("ProductController Start list..");
	//	int admin=(int) requset.getSession().getAttribute("mem_admin");
		
		int total = ps.total(product);
		
		
		// paging
		Paging pg = new Paging(total, currentPage);

		// list
		product.setStart(pg.getStart());
		product.setEnd(pg.getEnd());
		List<Product> tableProduct = ps.tableproduct(product);
		System.out.println("ProductController ProductTable " + tableProduct.size());

		model.addAttribute("total", total);
		model.addAttribute("tableProduct", tableProduct);
		model.addAttribute("pg", pg);
//		model.addAttribute("admin", admin);
		return "yg/productTable";
	}

	@RequestMapping(value = "productContent")
	public String productContent(Product product, Model model) {
		System.out.println("ProductController productcontent start....");
		Product product1 = null;
		product1 = ps.productContent(product);
		System.out.println("ProductController productcontent product1.getp_name" + product1.getP_name());
		model.addAttribute("product1", product1);

		return "yg/productContent";
	}

	@RequestMapping(value = "productWriteForm")
	public String productWriteForm(Product product, Model model, HttpServletResponse response) {
		//작성폼		
		List<Product> list = ps.listManager();
		System.out.println("ProductController productWriteForm list.size-> " + list.size());
		model.addAttribute("productManager", list);
		

		//공통테이블
		List<Common> commList = ps.cateProductList();
		List<Common> commList2 = ps.cateProductList2();

		
		System.out.println("ProductController ProductTable commList.size()->" + commList.size());

		for (Common comm : commList) {
			System.out.println("ProductController ProductTable for comm.getMcode()->" + comm.getMcode());
			System.out.println("ProductController ProductTable for comm.getContent()->" + comm.getContent());
		}
		
		//파일 업로드	
		
		 System.out.println("productWriteForm file write start...");
		 logger.info("file write start");
		
		
		
		System.out.println("ProductController insert start...");
		model.addAttribute("cateProductList1", commList);
		model.addAttribute("cateProductList2", commList2);
		return "yg/productWriteForm";
	}

	@RequestMapping(value = "productWrite", method = RequestMethod.POST)
	public String productWrite(HttpServletRequest request, MultipartFile file1,  Product product, Model model) 
			throws Exception{
		
		//write 실행?
		System.out.println("ProductController write Start");
		System.out.println("ProductController write product.getp_code" + product.getP_code());
		

		//파일작성 실행?
		System.out.println("");
		String uploadPath=request.getSession().getServletContext().getRealPath("/upload/");
		logger.info("originalName: "+file1.getOriginalFilename());
		logger.info("size : "+file1.getSize());
		logger.info("contentsize: "+file1.getContentType());
		logger.info("uploadPath:"+uploadPath);
		
		String savedName = uplaodFile(file1.getOriginalFilename(),file1.getBytes(),uploadPath);
		logger.info("savedName: "+savedName);
		
		int result = 0;
		product.setP_img("upload/"+savedName);
		result = ps.productInsert(product);
	
		
		
		/*
		 * List<Common> commList = ps.cateProductList();
		 * 
		 * System.out.println("ProductController ProductTable commList.size()->" +
		 * commList.size());
		 * 
		 * for (Common comm : commList) {
		 * System.out.println("ProductController ProductTable for comm.getMcode()->" +
		 * comm.getMcode());
		 * System.out.println("ProductController ProductTable for comm.getContent()->" +
		 * comm.getContent()); }
		 */
		System.out.println("ProductController insert start...");
		/* model.addAttribute("commList", commList); */
		model.addAttribute("product", product);
		model.addAttribute("savedName", savedName);
		model.addAttribute("result", result);
		return "forward:productWriteForm";
	}
	
	private String uplaodFile (String OriginalName, byte[] fileData,String uploadPath) 
			throws Exception {
		UUID uid=UUID.randomUUID();
		System.out.println("uploadPath->"+uploadPath);
		File fileDirectory =new File(uploadPath);
		if(!fileDirectory.exists()) {
			fileDirectory.mkdirs();
			System.out.println("업로드용 폴더 생성 : "+uploadPath);
		}
		String savedName=uid.toString()+"_"+OriginalName;
		logger.info("UUID saveName: "+savedName);
		File target = new File (uploadPath,savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;

	}
	
	
	
	
	

	@GetMapping(value = "productUpdateForm")
	public String productUpdateForm(Product product, Model model) {
		System.out.println("ProductController Start productUpdateForm........");
		product = ps.productContent(product);
		System.out.println("ProductController productUpdateForm product.getP_code()-->"+product.getP_code());
		System.out.println("ProductController productUpdateForm product.getP_code()-->"+product.getP_size());
		List<Common> commList = ps.cateProductList();
		List<Common> commList2 = ps.cateProductList2();
		
		System.out.println("ProductController productUpdateForm commList.size()->" + commList.size());

		for (Common comm : commList) {
			System.out.println("ProductController productUpdateForm for comm.getMcode()->" + comm.getMcode());
			System.out.println("ProductController productUpdateForm for comm.getContent()->" + comm.getContent());
		}
		System.out.println("ProductController productUpdateForm start...");
		model.addAttribute("cateProductList1", commList);
		model.addAttribute("cateProductList2", commList2);
		model.addAttribute("product", product);
		return "yg/productUpdateForm";
	}

	@RequestMapping(value = "productUpdate", method = RequestMethod.POST)
	public String productUpdate(Product product, Model model, MultipartFile file1, HttpServletRequest requset) throws IOException, Exception {
		System.out.println("ProductController productUpdate product.p_code->"+product.getP_code());
		System.out.println("ProductController productUpdate product.p_size->"+product.getP_size());
		System.out.println("ProductController productUpdate product.p_price->"+product.getP_price());
		System.out.println("ProductController productUpdate product.p_qty->"+product.getP_qty());
		System.out.println("ProductController productUpdate product.p_img->"+product.getP_img());
		
		System.out.println("ProductController productUpdate product.file1->"+file1);
		int a = 0;		
		if (file1.getSize() == 0) {
			System.out.println("ProductController productUpdate fileNull Start...");
			if(product.getP_img() == null) {
				product.setP_img("");
			}
			a=ps.productUpdate(product);
		}else {
			System.out.println("ProductController productUpdate file1 Start...");
			String uploadPath=requset.getSession().getServletContext().getRealPath("/upload/");
			String deleteFileName=uploadPath+product.getP_img().substring(7);
			System.out.println("productController productUpdate deleteFileName -->"+deleteFileName);
			int delresult=upFileDelete(deleteFileName);
			System.out.println("productController productUpdate delresult->"+delresult);
			
			logger.info("originalName: "+file1.getOriginalFilename());
			logger.info("size : "+file1.getSize());
			logger.info("contentsize: "+file1.getContentType());
			logger.info("uploadPath:"+uploadPath);
			
			String savedName = uplaodFile(file1.getOriginalFilename(),file1.getBytes(),uploadPath);
			logger.info("savedName: "+savedName);
			product.setP_img("upload/"+savedName);
			a =ps.productUpdate(product);
		}
		
		model.addAttribute("a", a);
		model.addAttribute("p_code", product.getP_code());
		model.addAttribute("p_size", product.getP_size());
		
		return "forward:productContent";
		
	}

	private int upFileDelete(String deleteFileName) {
		int result = 0;
		File file =new File (deleteFileName);
		System.out.println("delteFileName1->"+deleteFileName);
        if(file.exists()) {
			if(file.delete()) {
				System.out.println("파일삭제 성공");
				result =1;
			}else {
				System.out.println("파일삭제 실패");
				result =0;
			}
		}else {
			System.out.println("파일이 존재하지않습니다.");
			result =-1;
		}
		return result;
	}

	@GetMapping(value = "productDelete")
	public String productDelete(Product product,HttpServletRequest request, String deleteFileName, Model model) {
		//db데이터 삭제
		System.out.println("ProductController productDelete Start...");
		String uploadPath = request.getSession().getServletContext().getRealPath("/");
        String deleteFileName1 = uploadPath + product.getP_img();
		System.out.println("getP_img"+product.getP_img());
       
		int result=0;
		
		result = ps.productDelete(product);
		System.out.println("ProductController productDelete result->"+result);
		
		model.addAttribute("result", result);
		model.addAttribute("p_code", product.getP_code());
		model.addAttribute("p_size", product.getP_size());
		
		logger.info("filedelete result->"+deleteFileName);
		
		
		
        File file =new File (deleteFileName1);
		System.out.println("delteFileName1->"+deleteFileName1);
        if(file.exists()) {
			if(file.delete()) {
				System.out.println("파일삭제 성공");
				result =1;
			}else {
				System.out.println("파일삭제 실패");
				result =0;
			}
		}else {
			System.out.println("파일이 존재하지않습니다.");
			result =-1;
		}
		return "forward:productTable";
	}
	
	
//	@RequestMapping(value="uploadFileDelete",method = RequestMethod.GET)
//	private int upFileDelete(String deleteFileName) throws Exception {
//		int result =0;
//		logger.info("filedelete result->"+deleteFileName);
//		File file =new File (deleteFileName);
//		
//		if(file.exists()) {
//			if(file.delete()) {
//				System.out.println("파일삭제 성공");
//				result =1;
//			}else {
//				System.out.println("파일삭제 실패");
//				result =0;
//			}
//		}else {
//			System.out.println("파일이 존재하지않습니다.");
//			result =-1;
//		}
//		return result;
//	}
//	
//	
		

	@GetMapping(value = "cateProductList")
	public String cateProductList(Common common, Model model) {
		List<Common> cateProductList1 = null;
		List<Common> cateProductList2 = null;
		
		cateProductList1 = ps.cateProductList();
		cateProductList2 = ps.cateProductList2();
		model.addAttribute("cateProductList1", cateProductList1);
		model.addAttribute("cateProductList2", cateProductList2);
		System.out.println("cateProductList1 commom.getcentent->" + cateProductList1.size());
		System.out.println("cateProductList2 commom.getcentent->" + cateProductList2.size());
		return "yg/cateProductList";
	}


}