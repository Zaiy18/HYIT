<?php
function is_login($usertype){
	if($usertype == 'teacher'){
		$c=session('TeatNo');
		if($c){
			return array('status'=> false,'msg' =>'用户登录');
			}
		if(session('$usertype') !='teacher'){
				return array('status'=> false,'msg' =>'没有权限访问该页面！'); }
				return array('status'=> true);
		
		
		}else{
			
			}
		
	}
?>