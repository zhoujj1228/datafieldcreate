/**
 * 
 */

function initDataField(oper, domainName) {
	var rootElement = $("#my-datafieldform").get(0);
	datafieldService.getDataFieldAndInitDataField(oper, domainName, rootElement);
	
}


function submitDatafield(operUrl) {
	var jsonStr = datafieldService.itorElementToJson();
	datafieldService.submitDatafield(jsonStr, operUrl);
}



