package org.kultpower;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sebastian on 17.01.16.
 */
@Controller
public class HomeController {


	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}

}
