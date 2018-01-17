package com.luv2code.controllers.util;

import org.springframework.ui.Model;

public class ViewTemplate {
	public static final String sendViewTemplate(Model model, String viewName) {
		return sendViewTemplate(model, viewName, null);
	}

	public static final String sendViewTemplate(Model model, String viewName, String title) {
		if (viewName != null && !"".equals(viewName)) {
			model.addAttribute("viewName", viewName);
		} else {
			System.err.println("Invalid viewName: \"" + viewName + "\"");
		}
		title = (title == null ? "" : title); 
		model.addAttribute("title", title);
		return "view-template";
	}
}
