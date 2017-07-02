package com.google.gwt.user.client.ui;

public class FormPanel_IFrameTemplateImpl implements com.google.gwt.user.client.ui.FormPanel.IFrameTemplate {
  
  public com.google.gwt.safehtml.shared.SafeHtml get(java.lang.String arg0) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<iframe src=\"about:blank\" name='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
    sb.append("' tabindex='-1' style='position:absolute;width:0;height:0;border:0'>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
