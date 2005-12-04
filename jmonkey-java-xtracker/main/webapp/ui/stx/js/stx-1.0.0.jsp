	var isSafari = false;
	var isMoz = false;
	var isIE = false;

	if (navigator.userAgent.indexOf("Safari") > 0) {
  		isSafari = true;
  		isMoz = false;
  		isIE = false;
	} else if (navigator.product == "Gecko") {
  		isSafari = false;
  		isMoz = true;
  		isIE = false;
	} else {
  		isSafari = false;
  		isMoz = false;
  		isIE = true;
	}

	function stxCollapsibleBoxToggle(contentName, controlName) {
		var sizeImage = document.getElementById(controlName);
		var divBlock = document.getElementById(contentName);
		if (divBlock.style.display == "none"){
			divBlock.style.display = "block";
			sizeImage.src = "<%=request.getContextPath()%>/images/minimize.png";
		}else{
			divBlock.style.display = "none";
			sizeImage.src = "<%=request.getContextPath()%>/images/maximize.png";
		}
	}
	
	function stxRollerAdd(elementName, amount){
		var element = document.getElementById(elementName);
		var value = stxNumericOnly(element.value);
		if(value == ""){
			value = "0";
		}
		element.value = parseInt(value) + amount;
	}
	
	function stxFormatPhoneNumber(element, pattern, format){
		var phnum = element.value;
		phnum = stxNumericOnly(phnum);
		element.value = phnum.replace(pattern, format);
	}
				
	function stxNumericOnly(str){
    	var numsRegEx = /[^\d]/g; /* anything that's not 0-9 */
    	return str.replace(numsRegEx, ""); /* replace with empty string */
	}
	
	function stxConvertKeypadChars(element){
		var result = element.value;
		result = result.replace(/[a-cA-C]/, "2");
		result = result.replace(/[d-fD-F]/, "3");
		result = result.replace(/[g-iG-I]/, "4");
		result = result.replace(/[j-lJ-L]/, "5");
		result = result.replace(/[m-oM-O]/, "6");
		result = result.replace(/[p-sP-S]/, "7");
		result = result.replace(/[t-vT-V]/, "8");
		result = result.replace(/[w-zW-Z]/, "9");
		result = result.replace(/\s/g, "0");
		result = result.replace(/[^\d]/g, "1");
		element.value = result;
	}