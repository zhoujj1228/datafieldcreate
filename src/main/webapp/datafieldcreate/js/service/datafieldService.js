/**
 * 
 */

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

	submitDatafield : function(jsonStr, oper) {
		$.post("./" + oper + "?domain="+jsonStr, {}, function(data,status){
			alert("Data: " + data + "\nStatus: " + status);
		});
	}
};