package ecommerce;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;

import ecommerce.dao.ProductDaoImpl;
import ecommerce.dao.UserDaoImpl;
import ecommerce.model.Product;
@Controller
public class ProductController 
{
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	public ProductController()
	{
		System.out.println("loading at product controller");
	}
	
	@RequestMapping("/home")
	public String Return()
	{
		return "home";
	}
	@RequestMapping("/userhome")
	public String Return1()
	{
		return "userhome";
	}
	@RequestMapping("/displayproduct")
	public ModelAndView displayProducts()
	{
		
		System.out.println("at productcontroller");
		Product product=new Product();
		List list=productDaoImpl.getProducts();
		ModelAndView modelAndView=new ModelAndView("displayproducts");
		modelAndView.addObject("pro", list);
		return modelAndView;
	}
	
	@RequestMapping("/addproduct")
	public ModelAndView addProducts()
	{
		Product product=new Product();
		ModelAndView modelAndView=new ModelAndView("addproduct");
		product.setProductName("xxxxxx");
		modelAndView.addObject("add", product);
		return modelAndView;
	}
	
	@RequestMapping(value="/carryproduct" , method=RequestMethod.POST)
	public String readProduct(@ModelAttribute("add")Product product)
	{
		System.out.println(product.getProductName());
		System.out.println(product.getProductImage());
		productDaoImpl.InsertProduct(product);
		MultipartFile proimage=product.getProductImage();
		try {
			byte[] imgarr=proimage.getBytes();
			System.out.println(imgarr.length);
			String path="G://NIIT/Eclipse/pgp21/ecommerce/src/main/webapp/resources/"+product.getProductId()+".jpg";
			FileOutputStream fos=new FileOutputStream(path);
			BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fos);
			bufferedOutputStream.write(imgarr);
			bufferedOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return"home";
	}
	
	@GetMapping("/info")
	public ModelAndView goToSingleProduct(@RequestParam("pid") int proId)
	{
		System.out.println(proId);
		Product product=productDaoImpl.getProduct(proId);
		ModelAndView modelAndView=new ModelAndView("singleproduct");
		modelAndView.addObject("pro",product);
		return modelAndView;
	}
	
	//not sure
	@RequestMapping("/adminproducts")
	public ModelAndView displayadminProducts()
	{
		
		System.out.println("at productcontroller");
		Product product=new Product();
		List list=productDaoImpl.getProducts();
		ModelAndView modelAndView=new ModelAndView("displayadminproducts");
		modelAndView.addObject("pro", list);
		return modelAndView;
	}
	
	@GetMapping("/deletepro")
	public ModelAndView deleteSingleProduct(@RequestParam("proid") int proId)
	{
		System.out.println(proId);
		Product product1=productDaoImpl.deleteProduct(proId);
		ModelAndView modelAndView=new ModelAndView("redirect:adminproducts");
		modelAndView.addObject("pro", product1);
		return modelAndView;
	}
}

