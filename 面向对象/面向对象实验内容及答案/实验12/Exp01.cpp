
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <ctime>
using namespace std;

// Complex 类定义
class Complex
{
public:
	Complex(double _real = 0.0, double _image = 0.0): real(_real), image(_image) 
	{ }
	void set(double _real, double _image)
	{
		real = _real;
		image = _image;
	}
	double getReal() const
	{
		return real;
	}
	double getImage() const
	{
		return image;
	}
	void print() const
	{
		cout<<real<<"+"<<image<<"i"<<endl;
	}
protected:
	double real;
	double image;
};

int main()
{
	srand((unsigned int)time(NULL));

	
	ofstream fout;                                 
	fout.open("..\\data.txt", ios::out);           
	if(!fout.fail())                               
	{
		for(int i=0; i<10; ++i)                   
		{
			fout.width(4);                        
			fout<<rand()%100;
		}
		fout<<endl;

		for(char ch='A'; ch<='Z'; ++ch)           
			fout<<ch<<' ';
		fout<<endl;
		fout<<13.14<<'\t';                         
		fout<<3.14<<'\t';
		fout<<11.51<<'\t';
		fout<<66.88<<'\t';
		fout<<52.01<<endl;
	}
	fout.close();                                 

	// 2. 新建一个输出二进制文件 binary.bin，并向其中写入5个Complex类对象
	ofstream bout;                                 // 定义文件输出流对象
	bout.open("..\\binary.bin", ios::binary|ios::out); // 以二进制输出方式打开文件
	if(!bout.fail())                               // 判断文件是否打开成功
	{
		Complex cp1(1.0, 2.0);
		Complex cp2(1.1, 2.5);
		Complex cp3(2.0, 3.0);
		Complex cp4(4.0, 5.5);
		Complex cp5(6.6, 8.8);
		bout.write((char *)&cp1, sizeof(cp1));    // 写Complex类对象
		bout.write((char *)&cp2, sizeof(cp1));
		bout.write((char *)&cp3, sizeof(cp1));
		bout.write((char *)&cp4, sizeof(cp1));
		bout.write((char *)&cp5, sizeof(cp1));
	}
	bout.close();                                 // 关闭输出文件

	// 3. 打开输入文本文件 data.txt，读取该文件中的数据并输出显示到屏幕上
	ifstream fin;                                 
	fin.open("..\\data.txt", ios::in);           
	if(!fin.fail())                               
	{
		for(int i=0; i<10; ++i)                  
		{
			int ivalue;
			fin>>ivalue;
			cout.width(4);                       
			cout<<ivalue;
		}
		cout<<endl;

		for(int i=0; i<26; ++i)                   
		{
			char cvalue;
			fin>>cvalue;
			cout<<cvalue<<' ';
		}
		cout<<endl;

		for(int i=0; i<5; ++i)                    // 读取5个浮点数
		{
			double dvalue;
			fin>>dvalue;
			cout<<dvalue<<'\t';
		}
		cout<<endl;
	}
	fin.close();                                  

	
	ifstream bin;                                 // 定义文件输入流对象
	bin.open("..\\binary.bin", ios::binary|ios::in); // 以二进制输入方式打开文件
	if(!bin.fail())                               // 判断文件是否打开成功
	{
		Complex cp;
		for(int i=0; i<5; ++i)
		{
			bin.read((char *)&cp, sizeof(cp));   // 读Complex类对象
			cp.print();
		}
	}
	bin.close();                                

	return 0;
}