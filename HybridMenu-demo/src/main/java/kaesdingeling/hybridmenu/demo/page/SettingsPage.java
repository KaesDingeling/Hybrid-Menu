package kaesdingeling.hybridmenu.demo.page;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import kaesdingeling.hybridmenu.demo.MainView;

@Route(value = "settings", layout = MainView.class)
public class SettingsPage extends VerticalLayout {
	private static final long serialVersionUID = -2129831803083629071L;

	public SettingsPage() {
		Label title = new Label();
		
		title.setTitle("Settings");
		title.setText("Settings view");
		
		add(title);
	}
}