/**
 * 通用的方法集合
 */

/**
 * 
 * @param tagName 标签名
 * @param attrArray 类似这样 [{"key":"key1", "value":"value1"}, {"key":"key2", "value":"value2"}]
 * @param text 文本内容
 * @returns 生成的 HTML DOM Element对象
 */
function createElement(tagName, attrArray, text){
	var element = document.createElement(tagName);
	for(i = 0; i < attrArray.length; i++){
		element.setAttribute(attrArray[i].key, attrArray[i].value);
	}
	element.textContent=text;
	return element;
}
