<?php

class StudentAction extends Action {
    public function index(){
	$this->display();
	}	
	public function chooseCourse(){
		$stu=M('student');
		$db_prefix=C('DB_PREFIX');
		$stuno =session('StuNo');
		/*$stuinfo = $stu->join($db_prefix.'think_class on think_class.Classno= think_student.Classno')->find($stuno);*/
		$stuinfo=$stu->alias('st')->join('__CLASS__ as cl on cl.Classno=st.Classno')->find($stuno);
		
		$cou=M('course');
		$where['DepartNo'] =$stuinfo['DepartNo'];
		$coulist =$cou->field('c.*,sc.StuNo')->alias('c')->join("__STUCOU__ as sc on sc.CouNo = c.CouNo and sc.StuNo = '".$stuno."'")->where($while)->select();
		$this->assign('list',$coulist);
		$this->display();
		}
	public function choseCourseDo(){
		$couno=$this->_get('CouNo');
		$stuno=session('StuNo');
		$data['StuNo']=$stuno;
		$data['CouNo']=$couno;
		$data['WillOrder']=1;
		$data['State']='已选';
		$stucou=M('stucou');
		$ad=$stucou->add($data);
		if($ad){
			$this->success('选课成功！');
			}
		}
	public function add(){
	$this->display();
	}
	public function add_do(){
	
 		$stu=D('Student');
  		$res=$stu->create($_POST,1);
  		if(!$res){
	 	$this->error($stu->getError());
	  
	  }
	$stu->StuNo=$_SESSION['StuNo'];
	$re=$stu->add($res);
	  
	if(!$re){	
			$this->error('学生添加失败！');
		}else{
			
			$this->success('学生添加成功！',U('/Teacher/index'));
		}
	}
	
	//学生删除已选课程功能
	public function delete(){
		$stucou=D('Stucou');
		$CouNo=$this->_get('CouNo');
		//var_dump($CouNo);die;
		$stucou=D('Stucou');
		$mod=$stucou->where("CouNo = '$CouNo' ")->delete();
	  if (!$mod){
		  $this->error('已选课程删除失败！');
	     }else{
		   $this->success('已选课程删除成功！',U('/Student/stucoulist'));
		 }
	}

	public function stulist(){
		$stu = M('Student');
		$where['StuNo']=$_SESSION['StuNo'];
		$stulist = $stu->order('StuNo asc')->select();
		$this->assign('list',$stulist);
		$this->display();
	}	
	public function stucoulist(){
		$stu = M('stucou');
		$where['StuNo']=$_SESSION['StuNo'];
		$stucoulist = $stu->order('StuNo asc')->select();
		$this->assign('list',$stucoulist);
		$this->display();
	}	
	 public function edit(){
		$StuNo=$this->get('StuNo');
		$stu=M('student');
		$stuinfo=$stu->find($StuNo);
		$this->assign('info',$stuinfo);
		$this->display();
		}
	public function edit_do(){
		$StuNo=$this->get('StuNo');
		$stu=D('Student');
		if($stu->create($StuNo)){
			$this->error($stu->getError());
			}
		if($stu->save($StuNo)){	
			$this->error('数据写入失败');
		}else{
			
			$this->success('课程创建成功！',U('/Student/stulist'));
		}
	}
}
?>






