<?php
function is_login($usertype){
	if($usertype == 'teacher'){
		$c=session('TeatNo');
		if($c){
			return array('status'=> false,'msg' =>'�û���¼');
			}
		if(session('$usertype') !='teacher'){
				return array('status'=> false,'msg' =>'û��Ȩ�޷��ʸ�ҳ�棡'); }
				return array('status'=> true);
		
		
		}else{
			
			}
		
	}
?>