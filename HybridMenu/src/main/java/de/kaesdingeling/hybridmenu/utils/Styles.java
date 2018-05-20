package de.kaesdingeling.hybridmenu.utils;

public class Styles {
	/* CSS Classes */
	public static final String hybridMenu = "hybridMenu";
	public static final String leftMenu = "leftMenu";
	public static final String topMenu = "topMenu";
	public static final String subMenu = "subMenu";
	public static final String rootContent = "rootContent";
	public static final String contentBox = "contentBox";
	public static final String notificationCenter = "notificationCenter";
	public static final String lastNotification = "lastNotification";
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
			".hybridMenu .contentBox {\n" + 
			"    overflow: auto;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter vaadin-button, .hybridMenu .leftMenu vaadin-button, .hybridMenu .topMenu vaadin-button {\n" + 
			"    border-radius: 0;\n" + 
			"    cursor: pointer;\n" + 
			"}\n" + 
			"\n" + 
			"\n" + 
			"/* Top Menu */\n" + 
			".hybridMenu .topMenu {\n" + 
			"	position: fixed;\n" + 
			"	top: 0;\n" + 
			"	right: 100px;\n" + 
			"	z-index: 1000;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .topMenu vaadin-text-field {\n" + 
			"    -webkit-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-moz-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-ms-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-o-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .topMenu vaadin-text-field, .hybridMenu .topMenu vaadin-button {\n" + 
			"    border-top: 0 solid;\n" + 
			"    border-radius: 0;\n" + 
			"    min-width: 35px;\n" + 
			"    margin: 0 4px;\n" + 
			"    height: 40px;\n" + 
			"    width: 35px;\n" + 
			"    padding: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .topMenu vaadin-text-field.active, .hybridMenu .topMenu vaadin-button.active {\n" + 
			"    border-top-width: 3px;\n" + 
			"    height: 43px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .topMenu vaadin-text-field:hover, .hybridMenu .topMenu vaadin-button:hover {\n" + 
			"    border-top-width: 5px;\n" + 
			"    height: 45px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .topMenu .vaadin-text-field {\n" + 
			"    border-radius: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .topMenu vaadin-text-field:hover {\n" + 
			"    width: 180px !important;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .topMenu vaadin-text-field input {\n" + 
			"    -webkit-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;\n" + 
			"	-moz-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;\n" + 
			"	-ms-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;\n" + 
			"	-o-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;\n" + 
			"	transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;\n" + 
			"    opacity: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .topMenu vaadin-text-field:hover input {\n" + 
			"    opacity: 1;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .topMenu vaadin-button {\n" + 
			"    -webkit-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-moz-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-ms-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	-o-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"	transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .topMenu .vaadin-button {\n" + 
			"    -webkit-transition: background 0.3s ease-in-out;\n" + 
			"	-moz-transition: background 0.3s ease-in-out;\n" + 
			"	-ms-transition: background 0.3s ease-in-out;\n" + 
			"	-o-transition: background 0.3s ease-in-out;\n" + 
			"	transition: background 0.3s ease-in-out;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .topMenu vaadin-button .toolTip {\n" + 
			"    padding: 1px 4px 3px;\n" + 
			"    border-radius: 3px;\n" + 
			"    position: absolute;\n" + 
			"    left: 25px;\n" + 
			"    top: 30px;\n" + 
			"}\n" + 
			"\n" + 
			"\n" + 
			"/* Left Menu */\n" + 
			".hybridMenu .leftMenu {\n" + 
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
			".hybridMenu .leftMenu vaadin-button {\n" + 
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
			".hybridMenu .leftMenu .vaadin-button div[part=\"label\"] {\n" + 
			"    position: relative;\n" + 
			"    line-height: 18px;\n" + 
			"    text-align: left;\n" + 
			"    display: block;\n" + 
			"    width: 100%;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .leftMenu .vaadin-button div[part=\"label\"] iron-icon:not(.buttonOtherIcon) {\n" + 
			"    vertical-align: middle;\n" + 
			"    margin-right: 7px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .leftMenu .vaadin-button div[part=\"label\"] span {\n" + 
			"    vertical-align: middle;\n" + 
			"    margin-right: 7px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .leftMenu .vaadin-button div[part=\"label\"] iron-icon.buttonOtherIcon {\n" + 
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
			".hybridMenu .leftMenu vaadin-button .toolTip {\n" + 
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
			".hybridMenu .leftMenu vaadin-button.active {\n" + 
			"    border-left-width: 3px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .leftMenu vaadin-button:hover {\n" + 
			"    border-left-width: 5px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .leftMenu vaadin-vertical-layout.subMenu {\n" + 
			"    width: 100%;\n" + 
			"    margin: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .leftMenu vaadin-vertical-layout.subMenu > vaadin-vertical-layout {\n" + 
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
			".hybridMenu .leftMenu vaadin-vertical-layout.subMenu.open > vaadin-vertical-layout {\n" + 
			"	max-height: 500px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .leftMenu vaadin-vertical-layout.subMenu.open > vaadin-button div.vaadin-button[part=\"label\"] iron-icon.buttonOtherIcon {\n" + 
			"    -webkit-transform: rotate(-180deg);\n" + 
			"	-moz-transform: rotate(-180deg);\n" + 
			"	-ms-transform: rotate(-180deg);\n" + 
			"	-o-transform: rotate(-180deg);\n" + 
			"	transform: rotate(-180deg);\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .leftMenu > label {\n" + 
			"    border-bottom: 1px solid;\n" + 
			"    text-align: center;\n" + 
			"    position: relative;\n" + 
			"    padding: 8px 0;\n" + 
			"    width: 100%;\n" + 
			"    margin: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .leftMenu > label img {\n" + 
			"    vertical-align: middle;\n" + 
			"    margin-right: 5px;\n" + 
			"    height: 32px;\n" + 
			"    width: 32px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .leftMenu > label > p {\n" + 
			"    vertical-align: middle;\n" + 
			"    display: inline-block;\n" + 
			"    margin: 0 0 0 5px;\n" + 
			"}\n" + 
			"\n" + 
			"\n" + 
			"/* Notification Center */\n" + 
			".hybridMenu .notificationCenter {\n" + 
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
			".hybridMenu .notificationCenter .notification {\n" + 
			"    width: calc(100% - 36px);\n" + 
			"	position: relative;\n" + 
			"	margin: 8px 8px 0;\n" + 
			"	display: block;\n" + 
			"	padding: 10px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter .notification > iron-icon {\n" + 
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
			".hybridMenu .notificationCenter .notification.withIcon .content, .hybridMenu .notificationCenter .notification.withIcon .title {\n" + 
			"    padding-left: 50px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter .notification .title {\n" + 
			"    line-height: 12px;\n" + 
			"    font-size: 18px;\n" + 
			"    height: 24px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter .notification .timeAgo {\n" + 
			"    margin: 4px 0 0 8px;\n" + 
			"    position: absolute;\n" + 
			"    font-size: 10px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter .notification .timeAgo:before {\n" + 
			"    display: inline-block;\n" + 
			"    margin: 0 7px 1px 0;\n" + 
			"    border-radius: 50%;\n" + 
			"    content: '';\n" + 
			"    height: 4px;\n" + 
			"    width: 4px;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter .notification .content {\n" + 
			"    font-size: 14px;\n" + 
			"    display: block;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter .notification vaadin-button {\n" + 
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
			".hybridMenu .notificationCenter .footer {\n" + 
			"    text-align: center;\n" + 
			"    position: relative;\n" + 
			"    display: block;\n" + 
			"    width: 100%;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter .footer vaadin-button {\n" + 
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
			".hybridMenu .notificationCenter .lastNotification {\n" + 
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
			".hybridMenu .notificationCenter .lastNotification.top {\n" + 
			"    margin-top: 2px;\n" + 
			"    bottom: unset;\n" + 
			"    top: 0;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter .lastNotification.show {\n" + 
			"    pointer-events: auto;\n" + 
			"    right: 350px;\n" + 
			"    opacity: 1;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter .lastNotification.show:hover {\n" + 
			"    opacity: 0.1;\n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter .lastNotification .notification {\n" + 
			"    width: 300px;\n" + 
			"}\n" + 
			"\n" + 
			"\n" + 
			"/* Others */\n" + 
			".hybridMenu .leftMenu.minimal {\n" + 
			"    \n" + 
			"}\n" + 
			"\n" + 
			".hybridMenu .notificationCenter.open {\n" + 
			"    right: 0;\n" + 
			"}";
}