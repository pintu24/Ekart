package ecommerce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CategoryController 
{
	public CategoryController() {
	System.out.println("Category Controller is loading");
	}
	@RequestMapping("/hi")
	public String test()
	{
		System.out.println("at hi request");
		return "hello";
	}
	@RequestMapping("/how")
	
		public String test2()
		{
			System.out.println("at how request");
			return "how";
		}
	@RequestMapping("/showproduct")
	public ModelAndView test3()
	{
		System.out.println("at showproduct");
		//to receive data from controller to jsp
		ModelAndView modelAndView=new ModelAndView("products");
		modelAndView.addObject("nm", 230);
		return modelAndView;
	}
	
}
