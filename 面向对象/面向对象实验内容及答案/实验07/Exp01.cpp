
#include <iostream>
#include <cstring>
#include <cmath>
using namespace std;

// Point �ඨ��
class Point
{
public:
	Point(double _x = 0.0, double _y = 0.0);                 // ���캯��
	void set(double _x, double _y);                          // ��������
	double getX() const;                                     // ��ȡ������
	double getY() const;                                     // ��ȡ������
	void print() const;                                      // ��ӡ����
protected:
	double x;                                                // ������
	double y;                                                // ������
};

// ������� Shape ����
class Shape
{
public:
	Shape(const char *_color = "red");                       // ���캯��
	virtual ~Shape();                                        // ����������
	virtual void draw() const = 0;                           // ��ͼ�����麯����
	virtual double area() const = 0;                         // ������������麯����
	virtual double perimeter() const = 0;                    // �����ܳ������麯����
	void setColor(const char *_color);                       // ������ɫ
	const char* getColor() const;                            // ��ȡ��ɫ
protected:
	char *color;                                             // ��ɫ
};

// �߶������� Line ����
class Line: public Shape                                     // ���м̳�
{
public:
	// ���캯��
	Line(const char *_name, double x1, double y1, double x2, double y2, const char *color = "red");
	virtual ~Line();                                         // ����������
	virtual void draw() const;                               // ��ͼ���麯����
	virtual double area() const;                             // ����������麯����
	virtual double perimeter() const;                        // �����ܳ����麯����
	double length() const;                                   // �����߶γ���
	Point getStart() const;                                  // ��ȡ�߶����
	Point getEnd() const;                                    // ��ȡ�߶��յ�
protected:
	Point start;                                             // ���
	Point end;                                               // �յ�
	char *name;                                              // ����
};

// Բ������ Circle ����
class Circle: public Shape                                   // ���м̳�
{
public:
	// ���캯��
	Circle(const char *_name, double x, double y, double _radius, const char *color = "red", double _PI = 3.1415);
	virtual ~Circle();                                       // ����������
	virtual void draw() const;                               // ��ͼ���麯����
	virtual double area() const;                             // ����������麯����
	virtual double perimeter() const;                        // �����ܳ����麯����
	double getRadius() const;                                // ��ȡ�뾶
	Point getCenter() const;                                 // ��ȡԲ��
protected:
	Point center;                                            // Բ��
	double radius;                                           // �뾶
	const double PI;                                         // Բ����PI
	char *name;                                              // ����
};

// Point ���Ա����ʵ�ֲ���
Point::Point(double _x, double _y)
{
	x = _x;
	y = _y;
}

void Point::set(double _x, double _y)
{
	x = _x;
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

// Shape ���Ա����ʵ�ֲ���
Shape::Shape(const char *_color)
{
	color = new char[strlen(_color)+1];
	strcpy(color, _color);
}

Shape::~Shape()
{
	if(color!=NULL)
		delete [] color;
}

void Shape::setColor(const char *_color)
{
	delete [] color;                                         // �ͷ�ԭ�жѿռ�
	color = new char[strlen(_color)+1];                      // ���¿��ٶѿռ�
	strcpy(color, _color);
}

const char* Shape::getColor() const
{
	return color;
}

// Line ���Ա����ʵ�ֲ���
Line::Line(const char *_name, double x1, double y1, double x2, double y2, const char *color)
	: Shape(color), start(x1, y1), end(x2, y2)              // ���û��๹�캯����ʼ�������Ա
{
	name = new char[strlen(_name)+1];
	strcpy(name, _name);
}

Line::~Line()
{
	if(name!=NULL)
		delete [] name;
}

// ʵ�ֻ��ി�麯��
void Line::draw() const
{
	cout<<"ͼ������: "<<name<<endl;
	cout<<"ͼ������: �߶�"<<endl;
	cout<<"ͼ����ɫ: "<<color<<endl;
	cout<<"���: ";
	start.print();
	cout<<"�յ�: ";
	end.print();
}

// ʵ�ֻ��ി�麯��
double Line::area() const
{
	return 0;
}

// ʵ�ֻ��ി�麯��
double Line::perimeter() const
{
	return length();
}

double Line::length() const
{
	return sqrt((start.getX()-end.getX())*(start.getX()-end.getX())+(start.getY()-end.getY())*(start.getY()-end.getY()));
}

Point Line::getStart() const
{
	return start;
}

Point Line::getEnd() const
{
	return end;
}

// Circle ���Ա����ʵ�ֲ���
Circle::Circle(const char *_name, double x, double y, double _radius, const char *color, double _PI)
	: Shape(color), center(x, y), PI(_PI)                   // ���û��๹�캯����ʼ�������Ա
{
	name = new char[strlen(_name)+1];
	strcpy(name, _name);
	radius = _radius;
}

Circle::~Circle()
{
	if(name!=NULL)
		delete [] name;
}

// ʵ�ֻ��ി�麯��
void Circle::draw() const
{
	cout<<"ͼ������: "<<name<<endl;
	cout<<"ͼ������: Բ"<<endl;
	cout<<"ͼ����ɫ: "<<color<<endl;
	cout<<"Բ��: ";
	center.print();
	cout<<"�뾶: "<<radius<<endl;
}

// ʵ�ֻ��ി�麯��
double Circle::area() const
{
	return PI*radius*radius;
}

// ʵ�ֻ��ി�麯��
double Circle::perimeter() const
{
	return 2*PI*radius;
}

double Circle::getRadius() const
{
	return radius;
}

Point Circle::getCenter() const
{
	return center;
}

// ȫ�ֺ�������
void printShape(const Shape &shape)                        // ��̬����������Ϊ����ָ������ã�
{
	shape.draw();                                          // ���ô��麯�������ж�̬�ԣ�
	cout<<"ͼ�����: "<<shape.area()<<endl;                // ���ô��麯�������ж�̬�ԣ�
	cout<<"ͼ���ܳ�: "<<shape.perimeter()<<endl;           // ���ô��麯�������ж�̬�ԣ�
}

int main()
{
	Line line("Dynamic Line", 2.0, 2.0, 5.0, 6.0, "Yellow");
	Circle circle("Vivid Circle", 3.0, 3.0, 4.0, "Blue");

	printShape(line);                                     // ���ö�̬����
	cout<<"�߶γ���: "<<line.length()<<endl;              // �����������Ա����
	
	printShape(circle);                                   // ���ö�̬����
	circle.setColor("Green");                             // ���û����Ա����
	printShape(circle);                                   // ���ö�̬����

	return 0;
}