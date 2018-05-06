package kaesdingeling.hybridmenu.data.interfaces;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbstractOrderedLayout;

public interface ViewChangeManager {

	boolean manage(AbstractOrderedLayout menuContent, ViewChangeEvent event);

}
