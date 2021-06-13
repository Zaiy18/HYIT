<?php
class CourseModel extends Model{
	protected $_validate = array(
		array('CouNo','couNoUnique','课程名称已经存在',0,'unique',1), //默认情况下用正则进行验证
		array('name','require','课程名必须填写!'), // 在新增的时候验证name字段是否唯一		
	);
	public function couNoUnique($CouNo){
		$info = $this->find($CouNo);
			if($info){
				return false;
			}else{
				return true;
			}
		}
	}
?>