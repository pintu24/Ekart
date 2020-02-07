package ecommerce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.dao.LoginDaoImpl;

import ecommerce.model.User;

@Controller
public class LoginController
{
	@Autowired
	LoginDaoImpl loginDaoImpl;
	
	public LoginController() 
	{
		System.out.println("at login controller");
	}
	@RequestMapping("/login")
	public ModelAndView testLogin()
	{
		ModelAndView modelAndView=new ModelAndView("login");
		User user=new User();
		user.setUserName("xxx");;
		modelAndView.addObject("log", user);
		return modelAndView;
	}
	@RequestMapping(value="/carrylogin" , method=RequestMethod.POST)
	public String login(@ModelAttribute("log") User user )
	{
		
		User s=loginDaoImpl.checkLogin(user);
		if(s!=null)
		{
			if(s.getRole().equals("ROLE_ADMIN"))
			{
				return "home";	
			}
			else if(s.getRole().equals("ROLE_USER"))
			{
				return "userhome";
			}
		}
		else if(s==null)
		{
			return "redirect:login";
		}
		return "";
	}
}
