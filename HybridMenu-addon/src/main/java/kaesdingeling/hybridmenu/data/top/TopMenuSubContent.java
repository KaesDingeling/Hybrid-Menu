package kaesdingeling.hybridmenu.data.top;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import kaesdingeling.hybridmenu.data.MenuTopItem;

public class TopMenuSubContent extends MenuTopItem {
	private CssLayout component = null;
	private TopMenuButton button = null;
	private VerticalLayout subContent = null;
	
	public TopMenuSubContent() {
		subContent = new VerticalLayout();
		subContent.setStyleName("menuSubMenuContent");
		subContent.setMargin(false);
		subContent.setSpacing(false);
		component = new CssLayout();
		component.setStyleName("menuSubMenu");
		setComponent(component);
	}
	
	public TopMenuButton getButton() {
		return button;
	}
	
	public void setButton(TopMenuButton button) {
		this.button = button;
	}
	
	public VerticalLayout getSubContent() {
		return subContent;
	}
	
	public Button addButton(String caption) {
		Button button = new Button(caption);
		button.setPrimaryStyleName("menuSubMenuButton");
		subContent.addComponent(button);
		return button;
	}
	
	public Label addLabel(String caption) {
		Label label = new Label(caption);
		label.setPrimaryStyleName("menuSubMenuLabel");
		subContent.addComponent(label);
		return label;
	}
	
	public void addHr() {
		Label label = new Label();
		label.setPrimaryStyleName("menuSubMenuHr");
		subContent.addComponent(label);
	}
	
	public void setOpen(boolean open) {
		if (open) {
			if (!isOpen()) {
				button.setActive(true);
				subContent.addStyleName("open");
			}
		} else {
			if (isOpen()) {
				button.setActive(false);
				subContent.removeStyleName("open");
			}
		}
	}
	
	public boolean isOpen() {
		return subContent.getStyleName().contains("open");
	}
	
	public void build() {
		component.addComponents(button.getComponent(), subContent);
		button.addClickListener(new ClickListener() {
			private static final long serialVersionUID = -9004963918205097129L;
			@Override
			public void buttonClick(ClickEvent event) {
				setOpen(!isOpen());
			}
		});
		super.build();
	}
}