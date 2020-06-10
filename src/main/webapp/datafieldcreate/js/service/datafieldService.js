/**
 * 
 */
var datafieldService = {
		
	itorElementToJson : function() {
		var argsObj = {};
		$(".my-datafield").each(function(){
			var key = $(this).attr("name");
			var value = $(this).val();
			argsObj[key] = value;
		});
		
		var jsonStr = JSON.stringify(argsObj);
		return jsonStr;
	},

	submitDatafield : function(jsonStr, operUrl) {
		$.post(operUrl + "?domain="+jsonStr, {}, function(data,status){
			alert("Data: " + data + "\nStatus: " + status);
		});
	},
	
	getDataFieldAndInitDataField : function(oper, domainName, rootElement){
		$.post("/datafieldcreate/getDataField?domainName="+domainName, {}, function(data, status){
			alert("Data: " + data + "\nStatus: " + status);
			var jsonObj = $.parseJSON(data);
			datafieldService.initField(jsonObj, rootElement);
			datafieldService.intiDataFieldButton(oper, jsonObj, rootElement);
		});
	},
	
	initField : function(jsonObj, rootElement) {
		alert("initDataField");
		var fieldList = jsonObj.fieldList;
		for(var i = 0; i < fieldList.length; i++){
			var field = fieldList[i];
			this.createOneField(field, rootElement);
		}
		
	},
	
	createOneField : function(field, rootElement) {
		var enName = field.enName;
		var cnName = field.cnName;
		var type = field.type;
		
		var formGroupElement = this.createFormGroupElement();
		rootElement.appendChild(formGroupElement);
		
		var labelElement = createElement("label", [], cnName);
		formGroupElement.appendChild(labelElement);
		
		var inputFieldElement = this.createInputFieldElement(enName, cnName);
		formGroupElement.appendChild(inputFieldElement);
	},
	
	createFormGroupElement : function() {
		var attrArray = [];
		attrArray.push({"key" : "class", "value" : "form-group"});
		var element = createElement("div", attrArray, "");
		return element;
	},
	
	createInputFieldElement : function(enName, cnName) {
		var attrArray = [];
		attrArray.push({"key" : "type", "value" : "text"});
		attrArray.push({"key" : "class", "value" : "form-control my-datafield"});
		attrArray.push({"key" : "placeholder", "value" : "输入" + cnName});
		attrArray.push({"key" : "name", "value" : enName});
		var element = createElement("input", attrArray, "");
		return element;
	},
	
	intiDataFieldButton : function(oper, jsonObj, rootElement) {
		alert("intiDataFieldButton");
		var operUrl = this.getOperUrl(jsonObj, oper);
		var dataFieldButtonElement = this.createDataFieldButtonElement(operUrl);
		rootElement.appendChild(dataFieldButtonElement);
		
	},
	
	getOperUrl : function(jsonObj, oper) {
		var operUrl = "";
		if(oper == "add"){
			operUrl = jsonObj.addLink;
		}
		if(oper == "udpate"){
			operUrl = jsonObj.udpateLink;
		}
		return operUrl;
	},
	
	createDataFieldButtonElement : function(operUrl) {
		var attrArray = [];
		attrArray.push({"key" : "type", "value" : "button"});
		attrArray.push({"key" : "class", "value" : "btn btn-primary"});
		attrArray.push({"key" : "onclick", "value" : "submitDatafield('"+ operUrl +"')"});
		var element = createElement("button", attrArray, "提交");
		return element;
	},
};