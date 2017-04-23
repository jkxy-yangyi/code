/**
 * 验证输入框输入是否为空
 */
function validateEmpty(eleId){
	var result=document.getElementById(eleId).value;
	if(result==""){
		document.getElementById(eleId+"Div").setAttribute("class", "form-group has-error");
		document.getElementById(eleId+"Span").innerHTML="<span class='text-danger'>不能为空</span>";
		return false;
	}else{
		document.getElementById(eleId+"Div").setAttribute("class", "form-group has-success");
		document.getElementById(eleId+"Span").innerHTML="<span class='text-success'>√</span>";
		return true;
	}	
}
/**
 * 校验所有输入框是否都不为空
 */
function validateSubmit(){
	if(validateEmpty("uname")&&validateEmpty("pwd")&&validateEmpty("vcode")){
		return true;
	}
	return false;
}