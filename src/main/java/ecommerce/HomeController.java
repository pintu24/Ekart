package ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.dao.ConnectionToDB;
import ecommerce.dao.UserDaoImpl;
import ecommerce.model.User;


@Controller
public class HomeController 
{
	@Autowired
	UserDaoImpl userDaoImpl;
	
	public HomeController()
	{
		System.out.println("at home controller");
	}
	
	@RequestMapping("/register")
	public ModelAndView Register()
	{
		
		ModelAndView modelAndView=new ModelAndView("reg");
		User user=new User();
		user.setEmail("abc@gmail.com");
		modelAndView.addObject("usr",user);
				return modelAndView;
	}
	@RequestMapping(value="/carryuser",method=RequestMethod.POST)
	public String readUser(@ModelAttribute("usr") User user)
	{
		userDaoImpl.InsertUser(user);
		return"home";
	}
	public void Login()
	{
		
	}
}
