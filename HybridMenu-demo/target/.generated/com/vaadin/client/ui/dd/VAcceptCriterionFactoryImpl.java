package com.vaadin.client.ui.dd;

import com.google.gwt.core.client.GWT;

public class VAcceptCriterionFactoryImpl extends com.vaadin.client.ui.dd.VAcceptCriterionFactory {
  public VAcceptCriterion get(String name) {
    name = name.intern();
    if ("com.vaadin.event.dd.acceptcriteria.AcceptAll" == name) return GWT.create(com.vaadin.client.ui.dd.VAcceptAll.class );
    else if ("com.vaadin.event.dd.acceptcriteria.And" == name) return GWT.create(com.vaadin.client.ui.dd.VAnd.class );
    else if ("com.vaadin.event.dd.acceptcriteria.ContainsDataFlavor" == name) return GWT.create(com.vaadin.client.ui.dd.VContainsDataFlavor.class );
    else if ("com.vaadin.event.dd.acceptcriteria.SourceIs" == name) return GWT.create(com.vaadin.client.ui.dd.VDragSourceIs.class );
    else if ("com.vaadin.event.dd.acceptcriteria.Not" == name) return GWT.create(com.vaadin.client.ui.dd.VNot.class );
    else if ("com.vaadin.event.dd.acceptcriteria.Or" == name) return GWT.create(com.vaadin.client.ui.dd.VOr.class );
    else if ("com.vaadin.event.dd.acceptcriteria.ServerSideCriterion" == name) return GWT.create(com.vaadin.client.ui.dd.VServerAccept.class );
    else if ("com.vaadin.event.dd.acceptcriteria.SourceIsTarget" == name) return GWT.create(com.vaadin.client.ui.dd.VSourceIsTarget.class );
    else if ("com.vaadin.event.dd.acceptcriteria.TargetDetailIs" == name) return GWT.create(com.vaadin.client.ui.dd.VTargetDetailIs.class );
    else return null;
  }
}
