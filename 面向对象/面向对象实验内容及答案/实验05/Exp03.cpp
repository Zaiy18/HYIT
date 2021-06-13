
#include <iostream>
#include <cmath>
using namespace std;

// Point �ඨ��
class Point
{
public:
	Point(double _x = 0.0, double _y = 0.0);          // ��Ĭ�ϲ����Ĺ��캯��
	Point(const Point &point);                        // �������캯��
	void setX(double _x);                             // ���ú�����
	void setY(double _y);                             // ����������
	double getX() const;                              // ��ȡ�����꣬����Ϊconst��Ա����
	double getY() const;                              // ��ȡ�����꣬����Ϊconst��Ա����
	void print() const;                               // ��ӡ���������Ϣ������Ϊconst��Ա����
	friend double pdistance(const Point &p1, const Point &p2); // ��Ԫ��������
	friend Point midpoint(const Point &p1, const Point &p2);   // ��Ԫ��������
protected:
	double x;
	double y;
};

// Point ���Ա����ʵ��
Point::Point(double _x, double _y)                    // ������ʵ��ʱ����Ĭ�ϲ���
{
	x = _x;
	y = _y;
}

Point::Point(const Point &point)
{
	x = point.x;
	y = point.y;
}

void Point::setX(double _x)
{
	x = _x;
}

void Point::setY(double _y)
{
	y = _y;
}

double Point::getX() const
{
	return x;
}

double Point::getY() const
{
	return y;
}

void Point::print() const
{
	cout<<"("<<x<<", "<<y<<")"<<endl;
}

// ��ͨ��Ԫ�������壬��������Point����ľ���
double pdistance(const Point &p1, const Point &p2)
{
	return sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
}

// ��ͨ��Ԫ�������壬��������Point������е�
Point midpoint(const Point &p1, const Point &p2)
{
	Point mid;
	mid.setX((p1.x+p2.x)/2);
	mid.setY((p1.y+p2.y)/2);
	return mid;
}

int main()
{
	Point p1(1.0, 2.0);
	Point p2(4.0, 6.0);
	cout<<"����: "<<pdistance(p1, p2)<<endl;
	cout<<"�е�: ";
	midpoint(p1, p2).print();
	return 0;
}