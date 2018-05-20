package de.kaesdingeling.hybridmenu.demo;

import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletConfiguration;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/*", name = "UIServlet", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false)
public class Servlet extends VaadinServlet {
	private static final long serialVersionUID = -2009645086669155271L;
}