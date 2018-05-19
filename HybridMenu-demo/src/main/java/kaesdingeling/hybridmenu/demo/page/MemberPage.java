package kaesdingeling.hybridmenu.demo.page;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import kaesdingeling.hybridmenu.demo.MainView;

@Route(value = "member", layout = MainView.class)
public class MemberPage extends VerticalLayout {
	private static final long serialVersionUID = -3951342379250054941L;

	public MemberPage() {
		Label title = new Label();
		
		title.setTitle("Member");
		title.setText("Member view");
		
		add(title);
	}
}