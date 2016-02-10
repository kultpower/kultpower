package org.kultpower;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/interviews")
public class InterviewsController {

	@RequestMapping(method = RequestMethod.GET)
	public String interviews(Model model) {
		return "interviews";
	}
}
