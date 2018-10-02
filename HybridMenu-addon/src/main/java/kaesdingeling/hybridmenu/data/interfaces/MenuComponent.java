package kaesdingeling.hybridmenu.data.interfaces;

import java.util.List;

import com.vaadin.ui.Component;

public interface MenuComponent<T extends Component> extends Component {
	public <C extends MenuComponent<?>> C add(C c);
	public <C extends MenuComponent<?>> C addAsFirst(C c);
	public <C extends MenuComponent<?>> C addAt(C c, int index);
	public int count();
	public <C extends MenuComponent<?>> T remove(C c);
	public List<MenuComponent<?>> getList();
	public String getRootStyle();
}