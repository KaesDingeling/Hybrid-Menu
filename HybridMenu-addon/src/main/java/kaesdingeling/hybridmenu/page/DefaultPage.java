package kaesdingeling.hybridmenu.page;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class DefaultPage extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	
	public DefaultPage() {
		Label title = new Label();
		title.setCaption("Welcome to Default Page");
		title.setValue("To replace this page: UI.getCurrent().getNavigator().setErrorView(<your class>.class);");
		addComponent(title);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}
}