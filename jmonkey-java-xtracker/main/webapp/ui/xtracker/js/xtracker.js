function transferSelectItem(sourceName, destName) {
	var sourceSelect = document.getElementById(sourceName);
	var destSelect = document.getElementById(destName);

	var index = sourceSelect.selectedIndex;
	var inc = destSelect.options.length;
	destSelect[inc]= new Option(sourceSelect.options[index].text, sourceSelect.options[index].value, false);
	sourceSelect.options[index] = null;
}

function selectAll(selectName){
	var selectBox = document.getElementById(selectName);
	 for ( var i = 0 ; i < selectBox.options.length ; i++ ){
      selectBox.options[i].selected = true;
   }
}

function switchTab(count, index){
     for(var a = 0;a < count;a++) {
     	document.getElementById("tabpane0panels0view" + a).style.display = "none";
     }
	 
     for(var a = 0;a < count;a++) {
  	   document.getElementById("tabpane0tabs0tab" + a).style.background = "white";
     }

	var tab = document.getElementById("tabpane0tabs0tab" + index);
	var panel = document.getElementById("tabpane0panels0view" + index);
	tab.style.background = "Silver";
	panel.style.display = "block";
}

function rollupFieldset(fieldsetId, insideId){
	var fieldsetBox = document.getElementById(fieldsetId);
	var insideBox = document.getElementById(insideId);
	if(insideBox.style.display == "block" || insideBox.style.display == ""){
		insideBox.style.display = "none";
		// fieldsetBox.style.background = "red";
	}else{
		insideBox.style.display = "block";
		// fieldsetBox.style.background = null;
	}
}
