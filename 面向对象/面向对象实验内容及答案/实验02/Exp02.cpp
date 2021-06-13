
#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>
using namespace std;

class Image
{
public:
    // 构造函数：进行图像的初始化
	Image(int _width, int _height);
	// 析构函数：释放系统资源
	~Image();
	// 读取某个位置的像素值
	int getPixel(int x, int y);
	// 设置某个位置的像素值
	void setPixel(int x, int y, int val);
	// 计算整个图像中所有像素值的平均值
	double computeAverage();
	// 显示整个图像的像素值
	void print();
private:
	int width;                       // 图像的宽度
	int height;                      // 图像的高度
	int **value;                     // 图像的像素值
};

// 构造函数：进行图像的初始化
Image::Image(int _width, int _height)
{
	srand(time(0));
	width = _width;
	height = _height;
	// 开辟二维数组空间的方法
	value = new int*[height];        // 开辟指针数组空间（对应二维数组的每一行）
	for(int i=0; i<height; ++i)      // 逐行为每个元素开辟数组空间
		value[i] = new int[width];
	for(int i=0; i<height; ++i)
		for(int j=0; j<width; ++j)	
			value[i][j] = rand()%256;
}

// 析构函数：释放系统资源
Image::~Image()
{
	for(int i=0; i<height; ++i)     // 逐行释放数组空间
		delete [] value[i];
	delete [] value;                // 释放指针数组空间
}

// 读取某个位置的像素值
int Image::getPixel(int x, int y)
{
	return value[x][y];
}

// 设置某个位置的像素值
void Image::setPixel(int x, int y, int val)
{
	value[x][y] = val;
}

// 计算整个图像中所有像素值的平均值
double Image::computeAverage()
{
	double sum = 0.0;
	for(int i=0; i<height; ++i)
		for(int j=0; j<width; ++j)
			sum += value[i][j];
	return sum/(width*height);
}

// 显示整个图像的像素值
void Image::print()
{
	for(int i=0; i<height; ++i)
	{
		for(int j=0; j<width; ++j)
			cout<<setw(6)<<value[i][j];
		cout<<endl;
	}
}

int main()
{
	Image image(10, 10);              // 类对象定义，调用构造函数进行初始化
	image.setPixel(5,5,200);
	image.print();
	return 0;

	// 类对象生命期结束前调用析构函数进行清理工作
}