package com.vaadin.client.debug.internal.theme;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class DebugWindowStyles_default_InlineClientBundleGenerator implements com.vaadin.client.debug.internal.theme.DebugWindowStyles {
  private static DebugWindowStyles_default_InlineClientBundleGenerator _instance0 = new DebugWindowStyles_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new com.google.gwt.resources.client.CssResource() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "css";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".v-debug-console{background:" + ("#fff")  + ";opacity:" + ("0.9")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#000")  + ";font-family:" + ("sans-serif")  + ";}.v-debug-console-caption{background:" + ("#000")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"grey")  + ";color:" + ("white")  + ";font-weight:" + ("bold")  + ";}.v-debug-console-content{font-size:" + ("x-small")  + ";overflow:" + ("auto")  + ";white-space:") + (("pre")  + ";}.v-debug-console-content input{font-size:" + ("xx-small")  + ";}.v-app .invalidlayout,.v-app .invalidlayout *{background:" + ("#f99")  + " !important;}@font-face{font-family:" + ("\"vdebugfont\"")  + ";src:" + ("url('" + DebugWindowStyles_default_InlineClientBundleGenerator.this.iconFontEot().getSafeUri().asString() + "')")  + ";}@font-face{font-family:" + ("\"vdebugfont\"")  + ";src:" + ("url('" + DebugWindowStyles_default_InlineClientBundleGenerator.this.iconFontWoff().getSafeUri().asString() + "')"+ " " +"format(" + "\"woff\"" + ")"+ ","+ " " +"url('" + DebugWindowStyles_default_InlineClientBundleGenerator.this.iconFontTtf().getSafeUri().asString() + "')"+ " " +"format(" + "\"truetype\"" + ")"+ ","+ " " +"url('" + DebugWindowStyles_default_InlineClientBundleGenerator.this.iconFontSvg().getSafeUri().asString() + "')"+ " " +"format(" + "\"svg\"" + ")")  + ";font-weight:" + ("normal")  + ";font-style:" + ("normal")  + ";}.v-debugwindow [data-icon]:before,.v-debugwindow-menu [data-icon]:before{font-family:" + ("\"vdebugfont\"")  + ";content:" + ("attr(data-icon)") ) + (";speak:" + ("none")  + ";font-weight:" + ("normal")  + ";font-variant:" + ("normal")  + ";text-transform:" + ("none")  + ";line-height:" + ("1")  + ";-webkit-font-smoothing:" + ("antialiased")  + ";font-style:" + ("normal")  + ";vertical-align:" + ("text-bottom")  + ";}.v-debugwindow{-webkit-box-sizing:" + ("border-box")  + ";-moz-box-sizing:" + ("border-box")  + ";box-sizing:") + (("border-box")  + ";opacity:" + ("0.8")  + ";color:" + ("#666")  + ";font-family:" + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"Tahoma"+ ","+ " " +"Verdana"+ ","+ " " +"sans-serif")  + ";font-size:" + ("13px")  + ";}.v-debugwindow-handle{position:" + ("absolute")  + ";bottom:" + ("0")  + ";background-color:" + ("#fff")  + ";opacity:" + ("0")  + ";z-index:" + ("1000")  + ";}.v-debugwindow-handle-sw{width:" + ("7px") ) + (";height:" + ("7px")  + ";}.v-debugwindow-handle-se{left:" + ("0")  + ";width:" + ("14px")  + ";height:" + ("14px")  + ";}.v-debugwindow:hover{opacity:" + ("1")  + ";}.v-debugwindow *{font-size:" + ("inherit")  + " !important;}.v-debugwindow-size0,.v-debugwindow-menu .v-debugwindow-button-size0{font-size:" + ("10px")  + ";}.v-debugwindow-size1,.v-debugwindow-menu .v-debugwindow-button-size1{font-size:" + ("13px")  + ";}.v-debugwindow-size2,.v-debugwindow-menu .v-debugwindow-button-size2{font-size:" + ("16px")  + ";}.v-debugwindow-head{text-align:" + ("left")  + ";background-color:") + (("transparent")  + ";}.v-debugwindow-tabs{display:" + ("inline-block")  + ";}.v-debugwindow-tab,.v-debugwindow-controls>*{width:" + ("2em")  + ";border:" + ("none")  + ";margin:" + ("0")  + ";line-height:" + ("1.5em")  + ";background-color:" + ("#fff")  + ";color:" + ("#666")  + ";}.v-debugwindow-tab{position:" + ("relative")  + ";top:" + ("1px")  + ";border-width:" + ("1px"+ " " +"1px"+ " " +"1px"+ " " +"0") ) + (";border-style:" + ("solid")  + ";border-color:" + ("#666")  + ";border-radius:" + ("2px"+ " " +"2px"+ " " +"0"+ " " +"0")  + ";}.v-debugwindow-tab-selected{color:" + ("#666")  + ";background-color:" + ("#fff")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#fff")  + ";}.v-debugwindow-controls{position:" + ("relative")  + ";top:" + ("1px")  + ";display:" + ("inline-block")  + ";background-color:" + ("#fff")  + ";border:") + (("1px"+ " " +"solid"+ " " +"#666")  + ";border-radius:" + ("2px"+ " " +"2px"+ " " +"0"+ " " +"0")  + ";}.v-debugwindow-section-head{text-align:" + ("right")  + ";background-color:" + ("#fff")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#666")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#999")  + ";box-shadow:" + ("0"+ " " +"0"+ " " +"7px"+ " " +"0"+ " " +"rgba(" + "55"+ ","+ " " +"55"+ ","+ " " +"55"+ ","+ " " +"0.6" + ")")  + ";min-height:" + ("1.5em")  + ";line-height:" + ("1.5em")  + ";padding-right:" + ("5px")  + ";}.v-debugwindow-button{border:" + ("none") ) + (";background-color:" + ("transparent")  + ";color:" + ("#666")  + ";}.v-debugwindow-button:hover{color:" + ("#000")  + ";text-decoration:" + ("underline")  + ";}.v-debugwindow-button-active{color:" + ("#666")  + ";box-shadow:" + ("1px"+ " " +"1px"+ " " +"3px"+ " " +"0"+ " " +"inset")  + ";}.v-debugwindow-content{-webkit-box-sizing:" + ("border-box")  + ";-moz-box-sizing:" + ("border-box")  + ";box-sizing:" + ("border-box")  + ";box-shadow:" + ("0"+ " " +"0"+ " " +"7px"+ " " +"0"+ " " +"rgba(" + "55"+ ","+ " " +"55"+ ","+ " " +"55"+ ","+ " " +"0.6" + ")")  + ";background-color:") + (("#fff")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#666")  + ";border-top:" + ("none")  + ";}.v-debugwindow-menu{background-color:" + ("#fff")  + ";padding:" + ("4px")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#999")  + ";border-top:" + ("none")  + ";border-radius:" + ("0"+ " " +"0"+ " " +"5px"+ " " +"5px")  + ";box-shadow:" + ("0"+ " " +"0"+ " " +"7px"+ " " +"0"+ " " +"rgba(" + "55"+ ","+ " " +"55"+ ","+ " " +"55"+ ","+ " " +"0.6" + ")")  + ";}.v-debugwindow-menu-content{min-width:" + ("100px")  + ";}.v-debugwindow-menu-content .v-debugwindow-button{line-height:" + ("22px") ) + (";}.v-debugwindow-menu-content>div>.v-debugwindow-button{width:" + ("33%")  + ";}.v-debugwindow-row{display:" + ("table-row")  + ";}.v-debugwindow-row:nth-child(odd){background-color:" + ("rgba(" + "0"+ ","+ " " +"61"+ ","+ " " +"255"+ ","+ " " +"0.11" + ")")  + ";}.v-debugwindow-row>span{display:" + ("table-cell")  + ";padding:" + ("4px")  + ";}.v-debugwindow-row.SEVERE{color:" + ("#500")  + ";background-color:" + ("#ffc5c5")  + ";}.v-debugwindow-row.WARNING{background-color:" + ("#ff9")  + ";}.v-debugwindow-row.FINE{color:" + ("#737373")  + ";}.v-debugwindow-row.FINER{color:" + ("gray")  + ";}.v-debugwindow-row.FINEST{color:") + (("#8c8c8c")  + ";}.v-debugwindow-row>span.caption{color:" + ("#999")  + ";text-align:" + ("left")  + ";white-space:" + ("nowrap")  + ";}.v-debugwindow-row>span.value,.v-debugwindow-selector>span.value{width:" + ("100%")  + ";}.v-debugwindow-selector :hover{background:" + ("rgba(" + "255"+ ","+ " " +"32"+ ","+ " " +"32"+ ","+ " " +"0.5" + ")")  + ";}.v-debugwindow-log{font-family:" + ("monospace")  + ";}.v-debugwindow-log .v-debugwindow-reset{color:" + ("#fff")  + ";background-color:" + ("#4c92ed")  + ";padding:" + ("4px")  + ";}.v-debugwindow-log .v-debugwindow-time{text-align:" + ("left") ) + (";color:" + ("#999")  + ";}.v-debugwindow-log .v-debugwindow-message{white-space:" + ("nowrap")  + ";width:" + ("100%")  + ";}.v-debugwindow-log .v-debugwindow-message:hover{white-space:" + ("normal")  + ";word-wrap:" + ("break-word")  + ";}.v-debugwindow-log .v-debugwindow-message em{background-color:" + ("#c4e6f8")  + ";}.v-debugwindow-hierarchy .v-debugwindow-info{padding:" + ("1em")  + ";}.v-debugwindow-network .v-debugwindow-row{display:" + ("block")  + " !important;}.v-debugwindow-network .v-debugwindow-row>span{display:" + ("inline")  + ";}")) : ((".v-debug-console{background:" + ("#fff")  + ";opacity:" + ("0.9")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#000")  + ";font-family:" + ("sans-serif")  + ";}.v-debug-console-caption{background:" + ("#000")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"grey")  + ";color:" + ("white")  + ";font-weight:" + ("bold")  + ";}.v-debug-console-content{font-size:" + ("x-small")  + ";overflow:" + ("auto")  + ";white-space:") + (("pre")  + ";}.v-debug-console-content input{font-size:" + ("xx-small")  + ";}.v-app .invalidlayout,.v-app .invalidlayout *{background:" + ("#f99")  + " !important;}@font-face{font-family:" + ("\"vdebugfont\"")  + ";src:" + ("url('" + DebugWindowStyles_default_InlineClientBundleGenerator.this.iconFontEot().getSafeUri().asString() + "')")  + ";}@font-face{font-family:" + ("\"vdebugfont\"")  + ";src:" + ("url('" + DebugWindowStyles_default_InlineClientBundleGenerator.this.iconFontWoff().getSafeUri().asString() + "')"+ " " +"format(" + "\"woff\"" + ")"+ ","+ " " +"url('" + DebugWindowStyles_default_InlineClientBundleGenerator.this.iconFontTtf().getSafeUri().asString() + "')"+ " " +"format(" + "\"truetype\"" + ")"+ ","+ " " +"url('" + DebugWindowStyles_default_InlineClientBundleGenerator.this.iconFontSvg().getSafeUri().asString() + "')"+ " " +"format(" + "\"svg\"" + ")")  + ";font-weight:" + ("normal")  + ";font-style:" + ("normal")  + ";}.v-debugwindow [data-icon]:before,.v-debugwindow-menu [data-icon]:before{font-family:" + ("\"vdebugfont\"")  + ";content:" + ("attr(data-icon)") ) + (";speak:" + ("none")  + ";font-weight:" + ("normal")  + ";font-variant:" + ("normal")  + ";text-transform:" + ("none")  + ";line-height:" + ("1")  + ";-webkit-font-smoothing:" + ("antialiased")  + ";font-style:" + ("normal")  + ";vertical-align:" + ("text-bottom")  + ";}.v-debugwindow{-webkit-box-sizing:" + ("border-box")  + ";-moz-box-sizing:" + ("border-box")  + ";box-sizing:") + (("border-box")  + ";opacity:" + ("0.8")  + ";color:" + ("#666")  + ";font-family:" + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"Tahoma"+ ","+ " " +"Verdana"+ ","+ " " +"sans-serif")  + ";font-size:" + ("13px")  + ";}.v-debugwindow-handle{position:" + ("absolute")  + ";bottom:" + ("0")  + ";background-color:" + ("#fff")  + ";opacity:" + ("0")  + ";z-index:" + ("1000")  + ";}.v-debugwindow-handle-sw{width:" + ("7px") ) + (";height:" + ("7px")  + ";}.v-debugwindow-handle-se{right:" + ("0")  + ";width:" + ("14px")  + ";height:" + ("14px")  + ";}.v-debugwindow:hover{opacity:" + ("1")  + ";}.v-debugwindow *{font-size:" + ("inherit")  + " !important;}.v-debugwindow-size0,.v-debugwindow-menu .v-debugwindow-button-size0{font-size:" + ("10px")  + ";}.v-debugwindow-size1,.v-debugwindow-menu .v-debugwindow-button-size1{font-size:" + ("13px")  + ";}.v-debugwindow-size2,.v-debugwindow-menu .v-debugwindow-button-size2{font-size:" + ("16px")  + ";}.v-debugwindow-head{text-align:" + ("right")  + ";background-color:") + (("transparent")  + ";}.v-debugwindow-tabs{display:" + ("inline-block")  + ";}.v-debugwindow-tab,.v-debugwindow-controls>*{width:" + ("2em")  + ";border:" + ("none")  + ";margin:" + ("0")  + ";line-height:" + ("1.5em")  + ";background-color:" + ("#fff")  + ";color:" + ("#666")  + ";}.v-debugwindow-tab{position:" + ("relative")  + ";top:" + ("1px")  + ";border-width:" + ("1px"+ " " +"0"+ " " +"1px"+ " " +"1px") ) + (";border-style:" + ("solid")  + ";border-color:" + ("#666")  + ";border-radius:" + ("2px"+ " " +"2px"+ " " +"0"+ " " +"0")  + ";}.v-debugwindow-tab-selected{color:" + ("#666")  + ";background-color:" + ("#fff")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#fff")  + ";}.v-debugwindow-controls{position:" + ("relative")  + ";top:" + ("1px")  + ";display:" + ("inline-block")  + ";background-color:" + ("#fff")  + ";border:") + (("1px"+ " " +"solid"+ " " +"#666")  + ";border-radius:" + ("2px"+ " " +"2px"+ " " +"0"+ " " +"0")  + ";}.v-debugwindow-section-head{text-align:" + ("left")  + ";background-color:" + ("#fff")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#666")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#999")  + ";box-shadow:" + ("0"+ " " +"0"+ " " +"7px"+ " " +"0"+ " " +"rgba(" + "55"+ ","+ " " +"55"+ ","+ " " +"55"+ ","+ " " +"0.6" + ")")  + ";min-height:" + ("1.5em")  + ";line-height:" + ("1.5em")  + ";padding-left:" + ("5px")  + ";}.v-debugwindow-button{border:" + ("none") ) + (";background-color:" + ("transparent")  + ";color:" + ("#666")  + ";}.v-debugwindow-button:hover{color:" + ("#000")  + ";text-decoration:" + ("underline")  + ";}.v-debugwindow-button-active{color:" + ("#666")  + ";box-shadow:" + ("1px"+ " " +"1px"+ " " +"3px"+ " " +"0"+ " " +"inset")  + ";}.v-debugwindow-content{-webkit-box-sizing:" + ("border-box")  + ";-moz-box-sizing:" + ("border-box")  + ";box-sizing:" + ("border-box")  + ";box-shadow:" + ("0"+ " " +"0"+ " " +"7px"+ " " +"0"+ " " +"rgba(" + "55"+ ","+ " " +"55"+ ","+ " " +"55"+ ","+ " " +"0.6" + ")")  + ";background-color:") + (("#fff")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#666")  + ";border-top:" + ("none")  + ";}.v-debugwindow-menu{background-color:" + ("#fff")  + ";padding:" + ("4px")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#999")  + ";border-top:" + ("none")  + ";border-radius:" + ("0"+ " " +"0"+ " " +"5px"+ " " +"5px")  + ";box-shadow:" + ("0"+ " " +"0"+ " " +"7px"+ " " +"0"+ " " +"rgba(" + "55"+ ","+ " " +"55"+ ","+ " " +"55"+ ","+ " " +"0.6" + ")")  + ";}.v-debugwindow-menu-content{min-width:" + ("100px")  + ";}.v-debugwindow-menu-content .v-debugwindow-button{line-height:" + ("22px") ) + (";}.v-debugwindow-menu-content>div>.v-debugwindow-button{width:" + ("33%")  + ";}.v-debugwindow-row{display:" + ("table-row")  + ";}.v-debugwindow-row:nth-child(odd){background-color:" + ("rgba(" + "0"+ ","+ " " +"61"+ ","+ " " +"255"+ ","+ " " +"0.11" + ")")  + ";}.v-debugwindow-row>span{display:" + ("table-cell")  + ";padding:" + ("4px")  + ";}.v-debugwindow-row.SEVERE{color:" + ("#500")  + ";background-color:" + ("#ffc5c5")  + ";}.v-debugwindow-row.WARNING{background-color:" + ("#ff9")  + ";}.v-debugwindow-row.FINE{color:" + ("#737373")  + ";}.v-debugwindow-row.FINER{color:" + ("gray")  + ";}.v-debugwindow-row.FINEST{color:") + (("#8c8c8c")  + ";}.v-debugwindow-row>span.caption{color:" + ("#999")  + ";text-align:" + ("right")  + ";white-space:" + ("nowrap")  + ";}.v-debugwindow-row>span.value,.v-debugwindow-selector>span.value{width:" + ("100%")  + ";}.v-debugwindow-selector :hover{background:" + ("rgba(" + "255"+ ","+ " " +"32"+ ","+ " " +"32"+ ","+ " " +"0.5" + ")")  + ";}.v-debugwindow-log{font-family:" + ("monospace")  + ";}.v-debugwindow-log .v-debugwindow-reset{color:" + ("#fff")  + ";background-color:" + ("#4c92ed")  + ";padding:" + ("4px")  + ";}.v-debugwindow-log .v-debugwindow-time{text-align:" + ("right") ) + (";color:" + ("#999")  + ";}.v-debugwindow-log .v-debugwindow-message{white-space:" + ("nowrap")  + ";width:" + ("100%")  + ";}.v-debugwindow-log .v-debugwindow-message:hover{white-space:" + ("normal")  + ";word-wrap:" + ("break-word")  + ";}.v-debugwindow-log .v-debugwindow-message em{background-color:" + ("#c4e6f8")  + ";}.v-debugwindow-hierarchy .v-debugwindow-info{padding:" + ("1em")  + ";}.v-debugwindow-network .v-debugwindow-row{display:" + ("block")  + " !important;}.v-debugwindow-network .v-debugwindow-row>span{display:" + ("inline")  + ";}"));
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.google.gwt.resources.client.CssResource get() {
      return css;
    }
  }
  public com.google.gwt.resources.client.CssResource css() {
    return cssInitializer.get();
  }
  private void iconFontEotInitializer() {
    iconFontEot = // jar:file:/home/max/.m2/repository/com/vaadin/vaadin-client/8.0.6/vaadin-client-8.0.6.jar!/com/vaadin/client/debug/internal/theme/font.eot
    new com.google.gwt.resources.client.impl.DataResourcePrototype(
      "iconFontEot",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(GWT.getModuleBaseForStaticFiles() + "333A66D5307B1C8C9935C59A877F1993.cache.eot")
    );
  }
  private static class iconFontEotInitializer {
    static {
      _instance0.iconFontEotInitializer();
    }
    static com.google.gwt.resources.client.DataResource get() {
      return iconFontEot;
    }
  }
  public com.google.gwt.resources.client.DataResource iconFontEot() {
    return iconFontEotInitializer.get();
  }
  private void iconFontSvgInitializer() {
    iconFontSvg = // jar:file:/home/max/.m2/repository/com/vaadin/vaadin-client/8.0.6/vaadin-client-8.0.6.jar!/com/vaadin/client/debug/internal/theme/font.svg
    new com.google.gwt.resources.client.impl.DataResourcePrototype(
      "iconFontSvg",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(GWT.getModuleBaseForStaticFiles() + "C81F8CA7CA7012F31BDE883DF6C99E61.cache.svg")
    );
  }
  private static class iconFontSvgInitializer {
    static {
      _instance0.iconFontSvgInitializer();
    }
    static com.google.gwt.resources.client.DataResource get() {
      return iconFontSvg;
    }
  }
  public com.google.gwt.resources.client.DataResource iconFontSvg() {
    return iconFontSvgInitializer.get();
  }
  private void iconFontTtfInitializer() {
    iconFontTtf = // jar:file:/home/max/.m2/repository/com/vaadin/vaadin-client/8.0.6/vaadin-client-8.0.6.jar!/com/vaadin/client/debug/internal/theme/font.ttf
    new com.google.gwt.resources.client.impl.DataResourcePrototype(
      "iconFontTtf",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(GWT.getModuleBaseForStaticFiles() + "D03281BC3FDB49177B485D1DC10A13C4.cache.ttf")
    );
  }
  private static class iconFontTtfInitializer {
    static {
      _instance0.iconFontTtfInitializer();
    }
    static com.google.gwt.resources.client.DataResource get() {
      return iconFontTtf;
    }
  }
  public com.google.gwt.resources.client.DataResource iconFontTtf() {
    return iconFontTtfInitializer.get();
  }
  private void iconFontWoffInitializer() {
    iconFontWoff = // jar:file:/home/max/.m2/repository/com/vaadin/vaadin-client/8.0.6/vaadin-client-8.0.6.jar!/com/vaadin/client/debug/internal/theme/font.woff
    new com.google.gwt.resources.client.impl.DataResourcePrototype(
      "iconFontWoff",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(GWT.getModuleBaseForStaticFiles() + "51DCB1D3F3D956ACC80F89D3CF0AC5BE.cache.woff")
    );
  }
  private static class iconFontWoffInitializer {
    static {
      _instance0.iconFontWoffInitializer();
    }
    static com.google.gwt.resources.client.DataResource get() {
      return iconFontWoff;
    }
  }
  public com.google.gwt.resources.client.DataResource iconFontWoff() {
    return iconFontWoffInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.CssResource css;
  private static com.google.gwt.resources.client.DataResource iconFontEot;
  private static com.google.gwt.resources.client.DataResource iconFontSvg;
  private static com.google.gwt.resources.client.DataResource iconFontTtf;
  private static com.google.gwt.resources.client.DataResource iconFontWoff;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
      iconFontEot(), 
      iconFontSvg(), 
      iconFontTtf(), 
      iconFontWoff(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
        resourceMap.put("iconFontEot", iconFontEot());
        resourceMap.put("iconFontSvg", iconFontSvg());
        resourceMap.put("iconFontTtf", iconFontTtf());
        resourceMap.put("iconFontWoff", iconFontWoff());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@com.vaadin.client.debug.internal.theme.DebugWindowStyles::css()();
      case 'iconFontEot': return this.@com.vaadin.client.debug.internal.theme.DebugWindowStyles::iconFontEot()();
      case 'iconFontSvg': return this.@com.vaadin.client.debug.internal.theme.DebugWindowStyles::iconFontSvg()();
      case 'iconFontTtf': return this.@com.vaadin.client.debug.internal.theme.DebugWindowStyles::iconFontTtf()();
      case 'iconFontWoff': return this.@com.vaadin.client.debug.internal.theme.DebugWindowStyles::iconFontWoff()();
    }
    return null;
  }-*/;
}
