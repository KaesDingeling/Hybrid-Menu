package de.kaesdingeling.hybridmenu.data.interfaces;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;

public interface HybridMenuRouter {
	public boolean init(VaadinSession vaadinSession, UI ui);
}