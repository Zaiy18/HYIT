
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <ctime>
using namespace std;

// Complex �ඨ��
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

	// 2. �½�һ������������ļ� binary.bin����������д��5��Complex�����
	ofstream bout;                                 // �����ļ����������
	bout.open("..\\binary.bin", ios::binary|ios::out); // �Զ����������ʽ���ļ�
	if(!bout.fail())                               // �ж��ļ��Ƿ�򿪳ɹ�
	{
		Complex cp1(1.0, 2.0);
		Complex cp2(1.1, 2.5);
		Complex cp3(2.0, 3.0);
		Complex cp4(4.0, 5.5);
		Complex cp5(6.6, 8.8);
		bout.write((char *)&cp1, sizeof(cp1));    // дComplex�����
		bout.write((char *)&cp2, sizeof(cp1));
		bout.write((char *)&cp3, sizeof(cp1));
		bout.write((char *)&cp4, sizeof(cp1));
		bout.write((char *)&cp5, sizeof(cp1));
	}
	bout.close();                                 // �ر�����ļ�

	// 3. �������ı��ļ� data.txt����ȡ���ļ��е����ݲ������ʾ����Ļ��
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

		for(int i=0; i<5; ++i)                    // ��ȡ5��������
		{
			double dvalue;
			fin>>dvalue;
			cout<<dvalue<<'\t';
		}
		cout<<endl;
	}
	fin.close();                                  

	
	ifstream bin;                                 // �����ļ�����������
	bin.open("..\\binary.bin", ios::binary|ios::in); // �Զ��������뷽ʽ���ļ�
	if(!bin.fail())                               // �ж��ļ��Ƿ�򿪳ɹ�
	{
		Complex cp;
		for(int i=0; i<5; ++i)
		{
			bin.read((char *)&cp, sizeof(cp));   // ��Complex�����
			cp.print();
		}
	}
	bin.close();                                

	return 0;
}