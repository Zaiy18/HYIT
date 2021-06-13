
#include <iostream>
#include <cstring>
#include <iomanip>
using namespace std;

// Birthday �ඨ��
class Birthday
{
public:
	Birthday(int _year, int _month, int _day);              // ���캯��
	void change(int _year, int _month, int _day);           // �޸�������Ϣ
	int getYear();                                          // ��ȡ����Ϣ
	int getMonth();                                         // ��ȡ����Ϣ
	int getDay();                                           // ��ȡ����Ϣ
	void print();                                           // ��ӡ������Ϣ
private:
	int year;                                               // ��
	int month;                                              // ��
	int day;                                                // ��
};

// Student �ඨ��
class Student
{
public:
	Student(char *_name, bool _sex, int _sno, int year, int month, int day, int _num);   // ���캯��
	~Student();                                             // ��������
	void input(double *s);                                  // ¼��רҵ�γɼ�
	void change(int i, double s);                           // �޸�רҵ�γɼ�
	double get(int i);                                      // ��ȡרҵ�γɼ�
	int getNum();                                           // ��ȡרҵ������
	double average();                                       // ����רҵ��ƽ���ɼ�
	int fail();                                             // ���㲻����רҵ������
	void print();                                           // ��ӡѧ��������Ϣ
private:
	char *name;                                             // ѧ������
	bool sex;                                               // �Ա�
	int sno;                                                // ѧ��
	Birthday birth;                                         // ��������
	int num;                                                // רҵ������
	double *score;                                          // רҵ�γɼ�
};

// Birthday ��Ա����ʵ��
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
int Birthday::getYear()
{
	return year;
}
int Birthday::getMonth()
{
	return month;
}
int Birthday::getDay()
{
	return day;
}
void Birthday::print()
{
	cout<<setfill('0')<<setiosflags(ios::right);            // ��������ַ��Ͷ��뷽ʽ
	cout<<year<<"/"<<setw(2)<<month<<"/"<<setw(2)<<day<<endl;
}

// Student ��Ա����ʵ��
Student::Student(char *_name, bool _sex, int _sno, int year, int month, int day, int _num): birth(year, month, day)
{
	int len = strlen(_name);
	name = new char[len+1];                                // ����ѿռ���ѧ������
	strcpy(name, _name);
	sex = _sex;
	sno = _sno;
	num = _num;
	score = new double[num];                               // ����ѿռ���רҵ�γɼ�
}
Student::~Student()
{
	if(name!=NULL)
		delete [] name;                                   // �ͷŶѿռ�
	if(score!=NULL)
		delete [] score;                                  // �ͷŶѿռ�
}
void Student::input(double *s)
{
	for(int i=0; i<num; ++i)
		score[i] = s[i];
}
void Student::change(int i, double s)
{
	score[i] = s;
}
double Student::get(int i)
{
	return score[i];
}
int Student::getNum()
{
	return num;
}
double Student::average()
{
	double sum = 0.0;
	for(int i=0; i<num; ++i)
		sum += score[i];
	return sum/num;
}
int Student::fail()
{
	int n = 0;
	for(int i=0; i<num; ++i)
		if(score[i]<60)
			++n;
	return n;
}
void Student::print()
{
	cout<<"ѧ������: "<<name<<endl;
	cout<<"�Ա�: "<<(sex?"��":"Ů")<<endl;
	cout<<"ѧ��: "<<sno<<endl;
	cout<<"��������: ";
	birth.print();                                            // ͨ��Birthday�ĳ�Ա������ӡ��������
	cout<<"רҵ�γɼ�: ";
	for(int i=0; i<num; ++i)
		cout<<score[i]<<" ";
	cout<<endl;
}

int main()
{
	Student st("�����1151", true, 1151, 2015, 9, 1, 10);    // ����Student����
	double s[] = {10,50,66,80,100,70,52,90,78,99};
	st.input(s);                                             // ¼��ɼ�
	st.print();                                              // ��ӡѧ����Ϣ
	cout<<"ƽ���ɼ�: "<<st.average()<<endl;                  // ����ƽ���ɼ�
	cout<<"����������: "<<st.fail()<<endl;                   // ���㲻��������
	return 0;
}