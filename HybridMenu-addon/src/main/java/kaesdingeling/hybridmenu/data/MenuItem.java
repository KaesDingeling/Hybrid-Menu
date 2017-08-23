package kaesdingeling.hybridmenu.data;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;

import kaesdingeling.hybridmenu.enums.EMenuPosition;

public class MenuItem {
	private Label title;
	private NativeButton button;
	private ClickListener buttonClickListener;
	private Image image;
	private Component component;
	private Class<? extends View> targetClass;
	private String navigateTo;
	private boolean allowNavigateToSamePage = false;
	private boolean allowClickToNavigate = true;
	private CssLayout subMenuContent; // Can not be initialized! This progress is automatic
	private List<MenuItem> subMenu;
	private MenuItem parent; // Parent object from a submenu
	private EMenuPosition menuPosition;
	
	public ClickListener getButtonClickListener() {
		return buttonClickListener;
	}
	public void setButtonClickListener(ClickListener buttonClickListener) {
		this.buttonClickListener = buttonClickListener;
	}
	public Class<? extends View> getTargetClass() {
		return targetClass;
	}
	public void setTargetClass(Class<? extends View> targetClass) {
		this.targetClass = targetClass;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Component getComponent() {
		return component;
	}
	public void setComponent(Component component) {
		this.component = component;
	}
	public EMenuPosition getMenuPosition() {
		return menuPosition;
	}
	public void setMenuPosition(EMenuPosition menuPosition) {
		this.menuPosition = menuPosition;
	}
	public MenuItem getParent() {
		return parent;
	}
	public void setParent(MenuItem parent) {
		this.parent = parent;
	}
	public CssLayout getSubMenuContent() {
		return subMenuContent;
	}
	/*
	 * Can not be initialized! This progress is automatic
	 */
	public void setSubMenuContent(CssLayout subMenuContent) {
		this.subMenuContent = subMenuContent;
	}
	public boolean isAllowClickToNavigate() {
		return allowClickToNavigate;
	}
	public void setAllowClickToNavigate(boolean allowClickToNavigate) {
		this.allowClickToNavigate = allowClickToNavigate;
	}
	public Label getTitle() {
		return title;
	}
	public void setTitle(Label title) {
		this.title = title;
	}
	public NativeButton getButton() {
		return button;
	}
	public void setButton(NativeButton button) {
		this.button = button;
	}
	public String getNavigateTo() {
		return navigateTo;
	}
	public void setNavigateTo(String navigateTo) {
		this.navigateTo = navigateTo;
	}
	public boolean isAllowNavigateToSamePage() {
		return allowNavigateToSamePage;
	}
	public void setAllowNavigateToSamePage(boolean allowNavigateToSamePage) {
		this.allowNavigateToSamePage = allowNavigateToSamePage;
	}
	public List<MenuItem> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<MenuItem> subMenu) {
		this.subMenu = subMenu;
	}
	public void addSubMenuItem(MenuItem subMenuItem) {
		if (subMenu == null) {
			subMenu = new ArrayList<MenuItem>();
		}
		if (subMenuContent == null) {
			subMenuContent = new CssLayout();
		}
		subMenu.add(subMenuItem);
		subMenuContent.setStyleName("subMenu");
		subMenuContent.addStyleName("subMenu_" + subMenu.size());
	}
}