/**
 * 
 */

function initDataField() {
	var jsonStr = '[{"cnName":"姓名","enName":"name","type":"String"},{"cnName":"电话","enName":"mobile","type":"String"}]';
	var jsonObj = $.parseJSON(jsonStr);
	datafieldService.initDataField(jsonObj);
}

function initOperButton(oper) {
	datafieldService.initOperButton(oper);
}


function submitDatafield(oper) {
	var jsonStr = datafieldService.itorElementToJson();
	datafieldService.submitDatafield(jsonStr, oper);
}



