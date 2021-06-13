
#include <iostream>
#include <cstring>
using namespace std;

// Person ���ඨ��
class Person
{
public:                                          // public��Ա����
	// ���๹�캯��
	Person(char *_name, bool _sex, int _age, double _height, double _weight);  
	~Person();                                   // ������������
	void grow();                                 // ��������
	void set(double _height, double _weight);    // ������ߺ�����
	int getAge() const;                          // ��ȡ����
	double getHeight() const;                    // ��ȡ���
	double getWeight() const;                    // ��ȡ����
	void print() const;                          // ��ӡ�˵���Ϣ
protected:                                       // protected���ݳ�Ա
	char *name;                                  // ����
	bool sex;                                    // �Ա�
	int age;                                     // ����
	double height;                               // ���
	double weight;                               // ����
};

// Student �����ඨ��
class Student: public Person                     // public �̳�
{
public:                                          // public��Ա����
	// �����๹�캯��
	Student(char *_name, bool _sex, int _age, double _height, double _weight, int _sid, char *_major);
	~Student();                                  // ��������������
	int getID() const;                           // ��ȡѧ��
	void print() const;                          // ��ӡѧ����Ϣ�����ǳ�Ա������
protected:                                       // protected���ݳ�Ա
	int sid;                                     // ѧ��
	char *major;                                 // רҵ
};

// Person�����Ա����ʵ��
Person::Person(char *_name, bool _sex, int _age, double _height, double _weight)
{
	name = new char[strlen(_name)+1];
	strcpy(name, _name);
	sex = _sex;
	age = _age;
	height = _height;
	weight = _weight;
}

Person::~Person()
{
	if(name!=NULL)
		delete [] name;
}

void Person::grow()
{
	++age;
}

void Person::set(double _height, double _weight)
{
	height = _height;
	weight = _weight;
}

int Person::getAge() const
{
	return age;
}

double Person::getHeight() const
{
	return height;
}

double Person::getWeight() const
{
	return weight;
}

void Person::print() const
{
	cout<<"����: "<<name<<endl;
	cout<<"�Ա�: "<<(sex?"��":"Ů")<<endl;
	cout<<"����: "<<age<<endl;
	cout<<"���: "<<height<<endl;
	cout<<"����: "<<weight<<endl;
}

// Student�������Ա����ʵ��
Student::Student(char *_name, bool _sex, int _age, double _height, double _weight, int _sid, char *_major)
	:Person(_name, _sex, _age, _height, _weight) // ���û��๹�캯����ʼ���������ݳ�Ա             
{
	sid = _sid;
	major = new char[strlen(_major)+1];
	strcpy(major, _major);
}

Student::~Student()
{
	if(major!=NULL)
		delete [] major;
}

int Student::getID() const
{
	return sid;
}

void Student::print() const
{
	Person::print();                            // ���û��౻���ǵĳ�Ա����
	cout<<"ѧ��: "<<sid<<endl;
	cout<<"רҵ: "<<major<<endl;
}

int main()
{
	Student st("Hennessy",true,28,170,100,1151,"�����");
	st.set(172,120);                            // ���û����public��Ա����
	st.print();                                 // �����������public��Ա����
	return 0;
}