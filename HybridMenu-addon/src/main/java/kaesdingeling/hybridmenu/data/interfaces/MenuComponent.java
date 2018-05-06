package kaesdingeling.hybridmenu.data.interfaces;

import com.vaadin.ui.Component;

public interface MenuComponent<C extends Component> extends Component {
	public String getRootStyle();
}