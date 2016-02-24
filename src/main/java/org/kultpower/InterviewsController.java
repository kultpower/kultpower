package org.kultpower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/interviews")
public class InterviewsController {

	@Autowired
	InterviewRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public String interviews(Model model) {
		model.addAttribute("interviews", repository.findAll());
		return "interviews";
	}


	@RequestMapping(value = "/{interviewId}", method = RequestMethod.GET)
	public String singleInterview(
			@PathVariable String interviewId,
			Model model) {
		model.addAttribute("interview", repository.findOne(interviewId));
		return "interview";
	}



}
