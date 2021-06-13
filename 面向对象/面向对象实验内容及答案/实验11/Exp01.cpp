
class Birthday
{
public:
	Birthday(int _year, int _month, int _day);             
	void change(int _year, int _month, int _day);           
	void print() const;                                    
protected:
	int year;                                               
	int month;                                              
	int day;                                                
};


class Student
{
public:
	Student(char *_name, bool _sex, int _sno, int year, int month, int day, int _num);   
	Student(const Student &st);                             
	~Student();                                             
	void input(double *s);                                 
	void changeScore(int i, double s);                     
	void changeNum(int _num);                              
	double average() const;                                 
	int fail() const;                                      
	void print() const;                                     
protected:
	char *name;                                             
	bool sex;                                              
	int sno;                                               
	Birthday birth;                                        
	int num;                                               
	double *score;                                          
};


Birthday::Birthday(int _year, int _month, int _day)
{
	year = _year;
	month = _month;
	day = _day;
}
void Birthday::change(int _year, int _month, int _day)
{
	year = _year;
	month = _month;
	day = _day;
}
void Birthday::print() const
{
	cout<<setfill('0')<<setiosflags(ios::right);           
	cout<<year<<"/"<<setw(2)<<month<<"/"<<setw(2)<<day<<endl;
}

Student::Student(char *_name, bool _sex, int _sno, int year, int month, int day, int _num): birth(year, month, day)
{
	sex = _sex;
	sno = _sno;
	num = _num;
	try                                                   
	{
		name = new char[strlen(_name)+1];                  
		if(name==NULL)
			throw name;                                   
		strcpy(name, _name);

		score = new double[num];                           
		if(score==NULL)
			throw score;                                   
	}
	catch(char*)                                          
	{
		cout<<"No enough space for storing student\'s name!"<<endl;
	}
	catch(double*)                                         
	{
		cout<<"No enough space for storing student\'s score!"<<endl;
	}	
}
Student::Student(const Student &st): birth(st.birth)       
{
	sex = st.sex;
	sno = st.sno;
	num = st.num;
	try                                                    
	{
		name = new char[strlen(st.name)+1];                
		if(name==NULL)
			throw name;                                  
		strcpy(name, st.name);
	
		score = new double[num];                           
		if(score==NULL)
			throw score;                                
			score[i] = st.score[i];
	}
	catch(char*)                                           
	{
		cout<<"Exception! No enough space for storing student\'s name!"<<endl;
	}
	catch(double*)                                        
	{
		cout<<"Exception! No enough space for storing student\'s score!"<<endl;
	}
}
Student::~Student()
{
	if(name!=NULL)
		delete [] name;                                  
	if(score!=NULL)
		delete [] score;                                  
}
void Student::input(double *s)
{
	for(int i=0; i<num; ++i)
		score[i] = s[i];
}
void Student::changeScore(int i, double s)
{
	score[i] = s;
}
void Student::changeNum(int _num)
{
	num = _num;
}
double Student::average() const
{
	double sum = 0.0;
	for(int i=0; i<num; ++i)
		sum += score[i];
	double result = 0.0;
	try                                                  
	{
		if(num==0)
			throw num;                                  
		result = sum/num;                                
	}
	catch(int)                                         
	{
		cout<<"Exception! Divided by zero!"<<endl;
	}
	return result;
}
int Student::fail() const
{
	int n = 0;
	for(int i=0; i<num; ++i)
		if(score[i]<60)
			++n;
	return n;
}
void Student::print() const
{
	cout<<"学生姓名: "<<name<<endl;
	cout<<"性别: "<<(sex?"男":"女")<<endl;
	cout<<"学号: "<<sno<<endl;
	cout<<"出生日期: ";
	birth.print();                                            
	cout<<"专业课成绩: ";
	for(int i=0; i<num; ++i)
		cout<<score[i]<<" ";
	cout<<endl;
}

int main()
{
	Student st("计算机1151", true, 1151, 2015, 9, 1, 10);   
	double s[] = {10,50,66,80,100,70,52,90,78,99};          
	st.input(s);                                             
	st.print();                                             
	cout<<"平均成绩: "<<st.average()<<endl;                
	cout<<"不及格门数: "<<st.fail()<<endl;                   
	cout<<endl;

	st.changeScore(1, 100);                                  
	st.print();                                             
	cout<<"平均成绩: "<<st.average()<<endl;                 
	cout<<"不及格门数: "<<st.fail()<<endl;                  
	cout<<endl;

	st.changeNum(0);                                         
	st.print();                                              
	cout<<"平均成绩: "<<st.average()<<endl;                  
	cout<<"不及格门数: "<<st.fail()<<endl;                   
	return 0;
}