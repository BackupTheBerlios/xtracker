a {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9px;
	padding-top: 0px;
	padding-right: 1px;
	padding-bottom: 0px;
	padding-left: 1px;
	white-space: nowrap;
	color: Blue;
	text-decoration: none;
	margin-bottom: 4px;
}
a:visited  {
	color: Blue;
	text-decoration: none;
}
a:active   {
	color: Green;
	text-decoration: none;
}
a:hover    {
	color: Blue;
	text-decoration: none;
	border: 1px dashed Green;
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

.content input {
	font-size: 9px;
	border: 1px solid #DBDDE1;
	background: <%=request.getContextPath()%>/images/input_white.gif;
}

.content input.text {
}

.content input.button {

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