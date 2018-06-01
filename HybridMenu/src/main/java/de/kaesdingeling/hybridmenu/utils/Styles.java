package de.kaesdingeling.hybridmenu.utils;

public class Styles {
	/* CSS Classes */
	public static final String hybridMenu = "hybridMenu";
	public static final String leftMenu = "hmLeftMenu";
	public static final String topMenu = "hmTopMenu";
	public static final String subMenu = "subMenu";
	public static final String rootContent = "rootContent";
	public static final String contentBox = "hmContentBox";
	public static final String notificationCenter = "hmNotificationCenter";
	public static final String lastNotification = "lastNotification";
	public static final String breadCrumbs = "hmBreadcrumbs";
	public static final String content = "content";
	public static final String footer = "footer";
	public static final String toolTip = "toolTip";
	public static final String buttonOtherIcon = "buttonOtherIcon";
	
	
	/* General */
	public static final String active = "active";
	public static final String open = "open";
	public static final String show = "show";
	public static final String top = "top";
	

	/* HybridMenu Style */
	public static String style = "/* General */\n" + 
			".hybridMenu {\n" + 
			"	position: relative;\n" + 
			"    overflow: hidden;\n" + 
			"	z-index: 1;\n" + 
			"}\n" + 
			"\n" + 
			".hmContentBox {\n" + 
			"    overflow: auto;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter vaadin-button, .hmLeftMenu vaadin-button, .hmTopMenu vaadin-button {\n" + 
			"    border-radius: 0;\n" + 
			"    cursor: pointer;\n" + 
			"}\n" + 
			"\n" + 
			"\n" + 
			"/* Top Menu */\n" + 
			".hmTopMenu {\n" + 
			"	position: fixed;\n" + 
			"	top: 0;\n" + 
			"	right: 100px;\n" + 
			"	z-index: 1000;\n" + 
			"}\n" + 
			"\n" + 
			".hmTopMenu vaadin-text-field {\n" + 
			"    -webkit-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-moz-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-ms-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-o-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"}\n" + 
			"\n" + 
			".hmTopMenu vaadin-text-field, .hmTopMenu vaadin-button {\n" + 
			"    border-top: 0 solid;\n" + 
			"    border-radius: 0;\n" + 
			"    min-width: 35px;\n" + 
			"    margin: 0 4px;\n" + 
			"    height: 40px;\n" + 
			"    width: 35px;\n" + 
			"    padding: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmTopMenu vaadin-text-field.active, .hmTopMenu vaadin-button.active {\n" + 
			"    border-top-width: 3px;\n" + 
			"    height: 43px;\n" + 
			"}\n" + 
			"\n" + 
			".hmTopMenu vaadin-text-field:hover, .hmTopMenu vaadin-button:hover {\n" + 
			"    border-top-width: 5px;\n" + 
			"    height: 45px;\n" + 
			"}\n" + 
			"\n" + 
			".hmTopMenu .vaadin-text-field {\n" + 
			"    border-radius: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmTopMenu vaadin-text-field:hover {\n" + 
			"    width: 180px !important;\n" + 
			"}\n" + 
			"\n" + 
			".hmTopMenu vaadin-text-field input {\n" + 
			"    -webkit-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;\n" + 
			"	-moz-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;\n" + 
			"	-ms-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;\n" + 
			"	-o-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;\n" + 
			"	transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;\n" + 
			"    opacity: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmTopMenu vaadin-text-field:hover input {\n" + 
			"    opacity: 1;\n" + 
			"}\n" + 
			"\n" + 
			".hmTopMenu vaadin-button {\n" + 
			"    -webkit-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-moz-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-ms-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-o-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"}\n" + 
			"\n" + 
			".hmTopMenu .vaadin-button {\n" + 
			"    -webkit-transition: background 0.3s ease-in-out;\n" + 
			"	-moz-transition: background 0.3s ease-in-out;\n" + 
			"	-ms-transition: background 0.3s ease-in-out;\n" + 
			"	-o-transition: background 0.3s ease-in-out;\n" + 
			"	transition: background 0.3s ease-in-out;\n" + 
			"}\n" + 
			"\n" + 
			".hmTopMenu vaadin-button .toolTip {\n" + 
			"    padding: 1px 4px 3px;\n" + 
			"    border-radius: 3px;\n" + 
			"    position: absolute;\n" + 
			"    left: 25px;\n" + 
			"    top: 30px;\n" + 
			"}\n" + 
			"\n" + 
			"\n" + 
			"/* Left Menu */\n" + 
			".hmLeftMenu {\n" + 
			"    -webkit-transition: width 0.5s ease-in-out, min-width 0.5s ease-in-out, max-width 0.5s ease-in-out;\n" + 
			"	-moz-transition: width 0.5s ease-in-out, min-width 0.5s ease-in-out, max-width 0.5s ease-in-out;\n" + 
			"	-ms-transition: width 0.5s ease-in-out, min-width 0.5s ease-in-out, max-width 0.5s ease-in-out;\n" + 
			"	-o-transition: width 0.5s ease-in-out, min-width 0.5s ease-in-out, max-width 0.5s ease-in-out;\n" + 
			"	transition: width 0.5s ease-in-out, min-width 0.5s ease-in-out, max-width 0.5s ease-in-out;\n" + 
			"    border-radius: 1px solid;\n" + 
			"    overflow-y: visible;\n" + 
			"    overflow-x: auto;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu vaadin-button {\n" + 
			"    -webkit-transition: background 0.3s ease-in-out, border-left-color 0.3s ease-in-out, border-left-width 0.3s ease-in-out;\n" + 
			"	-moz-transition: background 0.3s ease-in-out, border-left-color 0.3s ease-in-out, border-left-width 0.3s ease-in-out;\n" + 
			"	-ms-transition: background 0.3s ease-in-out, border-left-color 0.3s ease-in-out, border-left-width 0.3s ease-in-out;\n" + 
			"	-o-transition: background 0.3s ease-in-out, border-left-color 0.3s ease-in-out, border-left-width 0.3s ease-in-out;\n" + 
			"	transition: background 0.3s ease-in-out, border-left-color 0.3s ease-in-out, border-left-width 0.3s ease-in-out;\n" + 
			"    padding: 8px 0 8px 10px !important;\n" + 
			"    border-left: 0 solid;\n" + 
			"    height: 45px;\n" + 
			"    width: 100%;\n" + 
			"    padding: 0;\n" + 
			"    margin: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu .vaadin-button div[part=\"label\"] {\n" + 
			"    position: relative;\n" + 
			"    line-height: 18px;\n" + 
			"    text-align: left;\n" + 
			"    display: block;\n" + 
			"    width: 100%;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu .vaadin-button div[part=\"label\"] iron-icon:not(.buttonOtherIcon) {\n" + 
			"    vertical-align: middle;\n" + 
			"    margin-right: 7px;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu .vaadin-button div[part=\"label\"] span {\n" + 
			"    vertical-align: middle;\n" + 
			"    margin-right: 7px;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu .vaadin-button div[part=\"label\"] iron-icon.buttonOtherIcon {\n" + 
			"    -webkit-transition: transform 0.3s ease-in-out;\n" + 
			"	-moz-transition: transform 0.3s ease-in-out;\n" + 
			"	-ms-transition: transform 0.3s ease-in-out;\n" + 
			"	-o-transition: transform 0.3s ease-in-out;\n" + 
			"	transition: transform 0.3s ease-in-out;\n" + 
			"	-webkit-transform: rotate(0deg);\n" + 
			"	-moz-transform: rotate(0deg);\n" + 
			"	-ms-transform: rotate(0deg);\n" + 
			"	-o-transform: rotate(0deg);\n" + 
			"	transform: rotate(0deg);\n" + 
			"    position: absolute;\n" + 
			"    right: 5px;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu vaadin-button .toolTip {\n" + 
			"    -webkit-transform: translateY(-50%);\n" + 
			"	-moz-transform: translateY(-50%);\n" + 
			"	-ms-transform: translateY(-50%);\n" + 
			"	-o-transform: translateY(-50%);\n" + 
			"	transform: translateY(-50%);\n" + 
			"    padding: 1px 4px 3px;\n" + 
			"    border-radius: 3px;\n" + 
			"    position: absolute;\n" + 
			"    right: 8px;\n" + 
			"    top: 50%;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu vaadin-button.active {\n" + 
			"    border-left-width: 3px;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu vaadin-button:hover {\n" + 
			"    border-left-width: 5px;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu vaadin-vertical-layout.subMenu {\n" + 
			"    width: 100%;\n" + 
			"    margin: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu vaadin-vertical-layout.subMenu > vaadin-vertical-layout {\n" + 
			"    -webkit-transition: max-height 0.5s ease-in-out;\n" + 
			"	-moz-transition: max-height 0.5s ease-in-out;\n" + 
			"	-ms-transition: max-height 0.5s ease-in-out;\n" + 
			"	-o-transition: max-height 0.5s ease-in-out;\n" + 
			"	transition: max-height 0.5s ease-in-out;\n" + 
			"	width: calc(100% - 24px) !important;\n" + 
			"	border-left: 1px solid transparent;\n" + 
			"	position: relative;\n" + 
			"	margin-left: 24px;\n" + 
			"	overflow: hidden;\n" + 
			"	display: block;\n" + 
			"	max-height: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu vaadin-vertical-layout.subMenu.open > vaadin-vertical-layout {\n" + 
			"	max-height: 500px;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu vaadin-vertical-layout.subMenu.open > vaadin-button div.vaadin-button[part=\"label\"] iron-icon.buttonOtherIcon {\n" + 
			"    -webkit-transform: rotate(-180deg);\n" + 
			"	-moz-transform: rotate(-180deg);\n" + 
			"	-ms-transform: rotate(-180deg);\n" + 
			"	-o-transform: rotate(-180deg);\n" + 
			"	transform: rotate(-180deg);\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu > label {\n" + 
			"    border-bottom: 1px solid;\n" + 
			"    text-align: center;\n" + 
			"    position: relative;\n" + 
			"    padding: 8px 0;\n" + 
			"    width: 100%;\n" + 
			"    margin: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu > label img {\n" + 
			"    vertical-align: middle;\n" + 
			"    margin-right: 5px;\n" + 
			"    height: 32px;\n" + 
			"    width: 32px;\n" + 
			"}\n" + 
			"\n" + 
			".hmLeftMenu > label > p {\n" + 
			"    vertical-align: middle;\n" + 
			"    display: inline-block;\n" + 
			"    margin: 0 0 0 5px;\n" + 
			"}\n" + 
			"\n" + 
			"\n" + 
			"/* Notification Center */\n" + 
			".hmNotificationCenter {\n" + 
			"    -webkit-transition: right 0.5s cubic-bezier(0.77, 0, 0.18, 1);\n" + 
			"	-moz-transition: right 0.5s cubic-bezier(0.77, 0, 0.18, 1);\n" + 
			"	-ms-transition: right 0.5s cubic-bezier(0.77, 0, 0.18, 1);\n" + 
			"	-o-transition: right 0.5s cubic-bezier(0.77, 0, 0.18, 1);\n" + 
			"	transition: right 0.5s cubic-bezier(0.77, 0, 0.18, 1);\n" + 
			"    width: 350px !important;\n" + 
			"    position: fixed;\n" + 
			"    z-index: 100000;\n" + 
			"    right: -350px;\n" + 
			"    top: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .notification {\n" + 
			"    width: calc(100% - 36px);\n" + 
			"	position: relative;\n" + 
			"	margin: 8px 8px 0;\n" + 
			"	display: block;\n" + 
			"	padding: 10px;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .notification > iron-icon {\n" + 
			"    height: calc(100% - 16px);\n" + 
			"    border-right: 1px solid;\n" + 
			"    vertical-align: middle;\n" + 
			"    position: absolute;\n" + 
			"    padding: 0 8px 0 0;\n" + 
			"    font-size: 28px;\n" + 
			"    display: block;\n" + 
			"    margin: 8px;\n" + 
			"    width: 34px;\n" + 
			"    left: 0;\n" + 
			"    top: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .notification.withIcon .content, .hmNotificationCenter .notification.withIcon .title {\n" + 
			"    padding-left: 50px;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .notification .title {\n" + 
			"    line-height: 12px;\n" + 
			"    font-size: 18px;\n" + 
			"    height: 24px;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .notification .timeAgo {\n" + 
			"    margin: 4px 0 0 8px;\n" + 
			"    position: absolute;\n" + 
			"    font-size: 10px;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .notification .timeAgo:before {\n" + 
			"    display: inline-block;\n" + 
			"    margin: 0 7px 1px 0;\n" + 
			"    border-radius: 50%;\n" + 
			"    content: '';\n" + 
			"    height: 4px;\n" + 
			"    width: 4px;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .notification .content {\n" + 
			"    font-size: 14px;\n" + 
			"    display: block;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .notification vaadin-button {\n" + 
			"    -webkit-transition: background 0.3s ease-in-out;\n" + 
			"	-moz-transition: background 0.3s ease-in-out;\n" + 
			"	-ms-transition: background 0.3s ease-in-out;\n" + 
			"	-o-transition: background 0.3s ease-in-out;\n" + 
			"	transition: background 0.3s ease-in-out;\n" + 
			"    position: absolute;\n" + 
			"    margin: 0;\n" + 
			"    right: 0;\n" + 
			"    top: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .footer {\n" + 
			"    text-align: center;\n" + 
			"    position: relative;\n" + 
			"    display: block;\n" + 
			"    width: 100%;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .footer vaadin-button {\n" + 
			"    -webkit-transition: background 0.3s ease-in-out, color 0.3s ease-in-out;\n" + 
			"	-moz-transition: background 0.3s ease-in-out, color 0.3s ease-in-out;\n" + 
			"	-ms-transition: background 0.3s ease-in-out, color 0.3s ease-in-out;\n" + 
			"	-o-transition: background 0.3s ease-in-out, color 0.3s ease-in-out;\n" + 
			"	transition: background 0.3s ease-in-out, color 0.3s ease-in-out;\n" + 
			"    display: inline-block;\n" + 
			"    position: relative;\n" + 
			"    margin: 5px;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .lastNotification {\n" + 
			"    -webkit-transition: right 1s cubic-bezier(0.79, 0.14, 0.15, 0.86), opacity 0.3s ease-in-out;\n" + 
			"	-moz-transition: right 1s cubic-bezier(0.79, 0.14, 0.15, 0.86), opacity 0.3s ease-in-out;\n" + 
			"	-ms-transition: right 1s cubic-bezier(0.79, 0.14, 0.15, 0.86), opacity 0.3s ease-in-out;\n" + 
			"	-o-transition: right 1s cubic-bezier(0.79, 0.14, 0.15, 0.86), opacity 0.3s ease-in-out;\n" + 
			"	transition: right 1s cubic-bezier(0.79, 0.14, 0.15, 0.86), opacity 0.3s ease-in-out;\n" + 
			"    height: auto !important;\n" + 
			"    pointer-events: none;\n" + 
			"    position: absolute;\n" + 
			"    margin: 10px 5px;\n" + 
			"    right: -350px;\n" + 
			"    opacity: 0;\n" + 
			"    bottom: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .lastNotification.top {\n" + 
			"    margin-top: 2px;\n" + 
			"    bottom: unset;\n" + 
			"    top: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .lastNotification.show {\n" + 
			"    pointer-events: auto;\n" + 
			"    right: 350px;\n" + 
			"    opacity: 1;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .lastNotification.show:hover {\n" + 
			"    opacity: 0.1;\n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter .lastNotification .notification {\n" + 
			"    width: 300px;\n" + 
			"}\n" + 
			"\n" + 
			"\n" + 
			"/* Others */\n" + 
			".hmLeftMenu.minimal {\n" + 
			"    \n" + 
			"}\n" + 
			"\n" + 
			".hmNotificationCenter.open {\n" + 
			"    right: 0;\n" + 
			"}";
}