<?php
// 本类由系统自动生成，仅供测试用途
class IndexAction extends Action {
    public function index(){
	$this->display();
	}	
	public function addok(){
				$cou=D('Course');
		$re=$cou->create();
		if(!$re){
			$this->error($cou->getError());
			}
			if($cou->add()){
			
			}
	}	
	public function checkLogin(){
		$username = $this->_post("username");
		$pwd =$this->_post("password");
		$usertype =$this->_post('role');
		if(!$username){
		$this->error('请输入用户名！');
			}
			
			if(!$pwd){
				$this->error('请输入密码');
				}
				//如果角色是学生
			if($usertype =='student'){
				$student =M('student');//初始化一个对象
					
				//查询条件
				$condition['StuName']=$username;
				$condition['Pwd']=$pwd;
				//查询数据
				$userinfo =$student->where($condition)->find();
				
				if(!$userinfo)
					$this->error('用户名不存在');
				if(!$userinfo['Pwd']==$pwd)
						$this->error('用户密码错误');
						else{
							session('StuNo',$userinfo['StuNo']);
							session('StuName',$userinfo['StuName']);
							session('role',$userinfo['student']);
						$this->success('登录成功',U('/Student/index'));
				}
			}
			if($usertype =='teacher'){
				$teacher = M ('teacher');//初始化一个对象
					
				//查询条件
				$condition['TeaName']=$username;
				$condition['Pwd']=$pwd;
				//查询数据
				
				$userinfo = $teacher->where($condition)->find();
				if(!$userinfo)
					$this->error('用户名不存在');
				if(!$userinfo['Pwd']==$pwd)
						$this->error('用户密码错误');
						else{
							session('TeatNo',$userinfo['TeatNo']);
							session('TeaName',$userinfo['TeaName']);
							session('role',$userinfo['teacher']);
						$this->success('登录成功',U('/Teacher/index'));
				}
			}
		}
	}

?>






