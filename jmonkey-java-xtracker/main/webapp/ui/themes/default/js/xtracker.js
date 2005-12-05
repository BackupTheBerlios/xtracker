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

function registerSelectDraggables(selectName) {
//.style.display = "none"
	var select = document.getElementById(selectName);
	
   for ( var i = 0 ; i < select.options.length ; i++ ){
      dndMgr.registerDraggable( new CustomDraggable(select.options[i], select.options[i].text) );
   }
}

var CustomDraggable = Class.create();

CustomDraggable.prototype = (new Rico.Draggable()).extend( {

   initialize: function( htmlElement, name ) {
      this.type        = 'Custom';
      this.htmlElement = $(htmlElement);
      this.name        = name;
   },

   log: function(str) {
      new Insertion.Bottom( $('logger'), "<span class='logMsg'>" + str + "</span>" );
      $('logger').scrollTop = $('logger').lastChild.offsetTop;

   },

   select: function() {
      this.selected = true;
      var el = this.htmlElement;

      // show the item selected.....
      el.style.color           = "#ffffff";
      el.style.backgroundColor = "#08246b";
      el.style.border          = "1px solid blue";
   },

   deselect: function() {
      this.selected = false;
      var el = this.htmlElement;
      el.style.color           = "#2b2b2b";
      el.style.backgroundColor = "transparent";
      el.style.border = "1px solid #ffffee";
   },

   startDrag: function() {
      var el = this.htmlElement;
      this.log("startDrag: [" + this.name +"]");
   },

   cancelDrag: function() {
      var el = this.htmlElement;
      this.log("cancelDrag: [" + this.name +"]");
   },

   endDrag: function() {
      var el = this.htmlElement;
      this.log("endDrag: [" + this.name +"]");
   },

   getSingleObjectDragGUI: function() {
      var el = this.htmlElement;

      var div = document.createElement("div");
      div.className = 'customDraggable';
      div.style.width = this.htmlElement.offsetWidth - 10;
      new Insertion.Top( div, this.name );
      return div;
   },

   getMultiObjectDragGUI: function( draggables ) {
      var el = this.htmlElement;

      var names = "";
      for ( var i = 0 ; i < draggables.length ; i++ ) {
         names += draggables[i].name;
         if ( i != (draggables.length - 1) )
            names += ",<br/>";
      }

      var div = document.createElement("div");
      div.className = 'customDraggable';
      div.style.width = this.htmlElement.offsetWidth - 10;
      new Insertion.Top( div, names );
      return div;
   },

   getDroppedGUI: function() {
      var el = this.htmlElement;

      var div = document.createElement("div");
      var names = this.name.split(",");
      new Insertion.Top( div, "<span class='nameSpan'>[" + names[1].substring(1) + " " + names[0]+ "]</span>" );
      return div;
   }

} );