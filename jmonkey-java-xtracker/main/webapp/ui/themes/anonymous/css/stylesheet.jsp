<%@ page language="java" contentType="text/css" %>

a {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9px;
	padding-top: 0px;
	padding-right: 1px;
	padding-bottom: 0px;
	padding-left: 1px;
	white-space: nowrap;
	color: Blue;
	margin-bottom: 4px;
}
a:visited  {
	color: Blue;
}
a:active   {
	color: Green;
}
a:hover    {
	color: Green;
}

body {
	scrollbar-base-color:#8E93BA;
	scrollbar-face-color:#8E93BA;
	scrollbar-highlight-color:#BABCCC;
	scrollbar-3dlight-color:#8E93BA;
	scrollbar-darkshadow-color:#8E93BA;
	scrollbar-shadow-color:#BABCCC;
	scrollbar-arrow-color:#E6E6E6;
	scrollbar-track-color:#DBDDE1;
}

.content{
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9px;
	color: #333333;
	padding-top: 3px;
	padding-right: 5px;
	padding-bottom: 2px;
	padding-left: 7px;
	
}

.content .embeddedlogin {
	voice-family: female;
	speak: normal;
	speak-header: once;
}

.content .alignRight {
	text-align: right;
}
.content th {
	font-size: 9px;
	font-weight: bold;
	background-color: #DBDDE1;
	text-align: left;
}

.content td {
	font-size: 9px;
}

.content hr {
	color: #333333;
	height: 1 px;
}

.content .title {
	text-align: left;
	vertical-align: top;
	height: 20px;
	white-space: nowrap;
	font-weight: bold;
	font-size: 18px;
}

.content .label {
	text-align: left;
	vertical-align: top;
	height: 20px;
	white-space: nowrap;
	font-weight: bold;
	display: inline;
}

.content .menubox {
	list-style-position: inside;
	list-style-type: none;
	white-space: nowrap;
	border: 1px solid #DBDDE1;
	width: 120px;
}

.content .menubox ul {
	list-style-position: inside;
	list-style-type: none;
	padding: 2px 2px 2px 2px;
}

.content .menuboxTitle {
	list-style-position: inside;
	list-style-type: none;
	white-space: nowrap;
	padding: 2px 2px 2px 2px;
	font-weight: bold;
	background-color: #DBDDE1;
}

.content .header {
	text-align: left;
	vertical-align: middle;
	height: 50px;
	white-space: nowrap;
	font-weight: bold;
	font-size: 18px;
	width: 100%;
	padding: 2px 2px 2px 2px;
}

.content .footer {
	text-align: right;
	vertical-align: middle;
	height: auto;
	font-size: xx-small;
	background-color: #DBDDE1;
	width: 100%;
	font-weight: bold;
}

.content .boundsBorderless {
	display: block;
	bottom: 5px;
	margin: 5px 5px 5px 5px;
}

.content .boundsBordered {
	display: block;
	bottom: 5px;
	margin: 5px 5px 5px 5px;
	border: 1px solid #DBDDE1;
}

/* --- PORTLET CSS --- */

.transferHistoryBox {
	width: 98%;
	border: 1px solid #DBDDE1;
	bottom: 5px;
	margin: 5px 5px 5px 5px;
}

.transferHistoryTitle {
	background-color: #DBDDE1;
	border-top: 0;
	border-left: 0;
	border-right: 0;
	border-bottom: 1px solid #ccc;
	color: #666;
	font: bold 10pt Arial;
	padding-left: 2px;
	padding-right: 2px;
	padding-top: 3px;
	padding-bottom: 3px;
}

.transferHistoryTools {
  float: right;
  padding: 2px 4px;
  margin-top: 1px;
  color: #666;
  font: bold 8pt Arial;
  cursor: pointer;
}

.transferHistoryTools img {
  border-left: 1px solid #666;
  padding: 0px 3px;
  cursor: pointer;
}

.transferHistoryTools img:first-child {
  border: none;
}

.transferHistoryContent {
	overflow: visible; /* padding: 4px; */
	padding-left: 0px;
	padding-right: 0px;
	padding-top: 0px;
	padding-bottom: 0px;
}

.transferHistory {
	width: 100%;
	padding-bottom: 0px;
	padding-left: 0px;
	padding-right: 0px;
	padding-top: 0px;
	margin-bottom: 0px;
	margin-left: 0px;
	margin-right: 0px;
	margin-top: 0px;
}

/*
.transferHistory th {
	padding-bottom: 0px;
	padding-left: 0px;
	padding-right: 0px;
	padding-top: 0px;
}

.transferHistory tr {
	padding-bottom: 0px;
	padding-left: 0px;
	padding-right: 0px;
	padding-top: 0px;
}

.transferHistory td {
	padding-bottom: 0px;
	padding-left: 0px;
	padding-right: 0px;
	padding-top: 0px;
}

.transferHistory thead tr {
  background-color: #9c9;
}
.transferHistory tr.even {
  background-color: #ccb;
}
.transferHistory tr.odd {
  background-color: #eec;
}
*/

.transferHistory th.sorted {
    background-color: orange;
}
.transferHistory th.sorted a, th.sortable a {
	background-position: right;
	display: block;
	width: 100%;
}
.transferHistory th.sortable a {
	background-image: url(<%=request.getContextPath()%>/images/arrow_off.png);
}
.transferHistory th.order1 a {
	background-image: url(<%=request.getContextPath()%>/images/arrow_down.png);
}
.transferHistory th.order2 a {
	background-image: url(<%=request.getContextPath()%>/images/arrow_up.png);
}
.transferHistory tr.odd {
  background-color: #fea
}
.transferHistory tr.tableRowEven, tr.even {
  background-color: #fff
}

/* =================================================== */
/* =================================================== */
/* =================================================== */

input, textarea, select {
	font-size: 9px;
	border: 1px solid #DBDDE1;
	background-image: ../images/input_dropshadow.gif;
}

.navcontainer {
	margin: 0;
	padding: 0 0 0 12px;
}

.navcontainer ul {
	list-style: none;
	margin: 0;
	padding: 0;
	border: none;
}

.navcontainer li {
	display: block;
	margin: 0;
	padding: 0;
	float: left;
	width: auto;
}

.navcontainer a {
	color: #444;
	display: block;
	width: auto;
	text-decoration: none;
	background: #DDDDDD;
	margin: 0;
	padding: 2px 10px;
	border-left: 1px solid #fff;
	border-top: 1px solid #fff;
	border-right: 1px solid #aaa;
}

.navcontainer a:hover, .navcontainer a:active { background: #BBBBBB; }

.navcontainer a.active:link, .navcontainer a.active:visited {
	position: relative;
	/* z-index: 102; */
	background: #BBBBBB;
	font-weight: bold;
}

.subnav {
	position: relative;
	top: -1px;
	/* z-index: 101; */
	margin: 0;
	padding: 0px 0 3px 0;
	background: #BBBBBB;
	border-top: 1px solid #fff;
	border-bottom: 1px solid #aaa;
}

.subnav ul {
	list-style: none;
	margin: 1px 0 0px 13px;
	padding: 0px;
	border-right: 1px solid #fff;
	border-left: 1px solid #aaa;
}

.subnav li {
	position: relative;
	/* z-index: 102; */
	display: block;
	margin: 0;
	padding: 0;
	float: left;
	width: auto;
}

.subnav a {
	color: #444;
	display: block;
	width: auto;
	text-decoration: none;
	margin: 0;
	padding: 2px 12px 2px 10px;
}

.subnav a:hover, .subnav a:active { color: #444; }
.subnav a.active:link, .subnav a.active:visited { color: #444; }
.subnav br, .navcontainer br { clear: both; }


.tabcontainer {
	margin: 5px 5px 5px 5px;
	padding: 0 0 0 12px;
	/* border: 1px solid Red; */
}

.tabcontainer .tablist {
	padding: 0 1px 1px;
	margin-left: 0;
	font: bold 12px Verdana, sans-serif;
}

.tabcontainer .tablist li {
	list-style: none;
	margin: 0;
	/* border-top: 1px solid gray; */
	display: inline;
	cursor: pointer;
}

.tabcontainer .tablist li a {
	padding: 0.25em 0.5em 0.25em 0.75em;
	/* border-left: 1em solid #AAB; */
	/* background: #CCD; */
	text-decoration: none;
}

.tabcontainer .tablist li a:link { color: #448; }
.tabcontainer .tablist li a:visited { color: #667; }

.tabcontainer .tablist li a:hover {
	/* border-color: #FE3; */
	/* color: #FFF; */
	/* background: #332; */
	border-bottom: 2px solid #F0E030;
}

.tabcontainer .tabpanel {
	/* border: 1px solid Green; */
}

.grouppanel {
	display: inline;
}

.groupbox {
	margin: 4px 4px 4px 4px;
	width: 400px;
	
}

.groupbox .title {
	margin-top: 0px;
	font-weight: bold;
	font-family: sans-serif;
}

.groupbox .panel {
	border: 1px solid Gray; 
	padding: 4px 4px 4px 4px;
}

.warningbox {
	padding: 0px; /*width: 100%;*/
	background-color: #FFFFE0;
	border-top: 2px solid Gray;
	border-bottom: 2px solid Gray;
	margin: 4px 4px 4px 4px;
	padding-top: 4px;
	padding-right: 4px;
	padding-left: 4px;
	padding-bottom: 4px;
}

.errorbox {
	padding: 0px; /*width: 100%;*/
	background-color: #FFC8ED;
	border-top: 2px solid Gray;
	border-bottom: 2px solid Gray;
	margin: 4px 4px 4px 4px;
	padding-top: 4px;
	padding-right: 4px;
	padding-left: 4px;
	padding-bottom: 4px;
}

.dialogbox {
	margin: 4px 4px 4px 4px;
	display: compact;
}

.dialogbox ul {
	list-style-position: inside;
	list-style-type: none;
	white-space: nowrap;
}

.dialogbox .title {
	margin-top: 0px;
	font-weight: bold;
	font-family: sans-serif;
}

.dialogbox .panel {
	border: 1px solid Gray; 
	padding: 4px 4px 4px 4px;
}

.dialogbox .commands {
	padding: 4px 4px 4px 4px;
	text-align: right;
}

.inputcontainer { 
	/* background: #BBBBBB; */
}

.inputcontainer ul {
	list-style: none inside none;
	margin: 0px 0px 0px 0px;
	padding: 0px 0px 0px 0px;
	border-right: 1px solid White;
	border-left: 1px solid #a0a0a0;
	display: block;
}

.inputcontainer li {
	position: relative; /* z-index: 102; */
	display: inline;
	margin: 0px 0px 0px 5px;
	padding: 0px;
	width: auto;
}

.bodycontainer {
	margin-top: 30px; 
	margin-bottom: 30px; 
	width: 100%; 
	display: block;
}

.quicklisttd {
	width: 150px; 
	vertical-align: top;
}

.quicklisttd ul {
	list-style: none inside none;
	margin: 0px 0px 0px 0px;
	padding: 0px 0px 0px 0px;
	border-right: 1px solid White;
	border-left: 1px solid #a0a0a0;
	display: block;
}

.quicklisttd li {
	position: relative; /* z-index: 102; */
	display: inline;
	margin: 0px 0px 0px 5px;
	padding: 0px;
	width: auto;
}

.quicklisttd a:hover, .quicklisttd a:active { background: #BBBBBB; }


.historycontainer {
}

.historycontainer .header {
	margin: 0;
	padding: 0 0 0 12px;
}

.historycontainer .header ul {
	list-style: none;
	margin: 0;
	padding: 0;
	border: none;
}

.historycontainer .header li {
	display: block;
	margin: 0px 0px 0px 0px;
	padding: 0px 5px 0px 0px;
	float: left;
	width: auto;
}