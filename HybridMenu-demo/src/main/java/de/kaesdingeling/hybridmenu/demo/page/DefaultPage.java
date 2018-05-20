package de.kaesdingeling.hybridmenu.demo.page;

import javax.servlet.http.HttpServletResponse;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.NotFoundException;
import com.vaadin.flow.router.ParentLayout;

import de.kaesdingeling.hybridmenu.demo.DemoRouterLayout;

@ParentLayout(DemoRouterLayout.class)
public class DefaultPage extends VerticalLayout implements HasErrorParameter<NotFoundException> {
	private static final long serialVersionUID = 526172191959497669L;

	public DefaultPage() {
		Label title = new Label();
		
		title.setTitle("Welcome to Default Page");
		title.setText("To replace this page: UI.getCurrent().getNavigator().setErrorView(<your class>.class);");
		
		add(title);
	}

	@Override
	public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
		return HttpServletResponse.SC_NOT_FOUND;
	}
}