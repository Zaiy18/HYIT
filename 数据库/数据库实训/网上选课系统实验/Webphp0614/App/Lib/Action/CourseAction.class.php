<?php
// 本类由系统自动生成，仅供测试用途
class CourseAction extends Action {
	/*public function __initialize(){
		$islogin = is_login('teacher');
	if(!$islogin['status']){
		$this->error($islogin['msg'],U('/Index'));}
		}*/
   
    public function index(){
	$this->display();
	}
	public function add(){
	$this->display();
	}
	public function add_do(){
 	 $cou=D('Course');
 	 $re=$cou->create($_POST,1);
 		if(!$re){
		  $this->error($cou->getError());
	  
	  }
	  $Cou->DepartNo=$_SESSION['departno'];
	  $r=$cou->add($re);
	  
	if(!$r){	
			$this->error('课程创建失败！');
		}else{
			
			$this->success('课程创建成功！',U('/Teacher/index'));
		}
	}
	public function coulist(){
		$cou = M('Course');
		$where['DepartNo']=$_SESSION['DepartNo'];
		$coulist = $cou->order('CouID asc')->select();
		$this->assign('list',$coulist);
		$this->display();
	}	


    public function edit(){
		$CouNo=$this->get('CouNo');
		$cou=M('course');
		$couinfo=$cou->find($CouNo);
		$this->assign('info',$couinfo);
		$this->display();
		}
	public function edit_do(){
		$CouNo=$this->get('CouNo');
		$cou=D('Course');
		if($cou->create()){
			$this->error($cou->getError());
			}
		if($cou->save($CouNo)){	
			$this->error('数据写入失败');
		}else{
			
			$this->success('课程创建成功！',U('/Course/coulist'));
		}
	}
	public function delete(){
		$CouNo=$this->_get('CouNo');
		$cou=M('course');
		$mod=$cou->where("CouNo = '$CouNo'")->delete();
		if($mod){
			$this->success('课程删除成功',U('/Course/coulist'));
	 
		}else{
			$this->success('课程删除失败！');
		}
	}

}
	
?>