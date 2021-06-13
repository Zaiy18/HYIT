#include<iostream>
using namespace std;
class student
{
private:
	char *name;
	const int id;
	const bool sex;
public:
	student(char *_name)
	{
		name=new char[strlen(_name)+1];
		strcpy(name,_name);
			}
	 const char* getname()
	{
		return name;
	}
	 ~student()
	 {
		 if(name!=null)
			 delete[] name;
	 }
};
int main()
{
	student stu("zhangsan",1151,true);
	cout<<stu.name<<stu.id<<stu.sex<<endl;
}