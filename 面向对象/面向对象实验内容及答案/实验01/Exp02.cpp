
#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>
using namespace std;

class Image
{
public:
    // 图像初始化
	void set(int _width, int _height);
	// 读取某个位置的像素值
	int getPixel(int x, int y);
	// 设置某个位置的像素值
	void setPixel(int x, int y, int val);
	// 计算整个图像中所有像素值的平均值
	double computeAverage();
	// 显示整个图像的像素值
	void print();
private:
	int width;                   // 图像的宽度
	int height;                  // 图像的高度
	int value[200][200];         // 图像的像素值
};

// 图像初始化
void Image::set(int _width, int _height)
{
	srand(time(0));
	width = _width;
	height = _height;
	for(int i=0; i<height; ++i)
		for(int j=0; j<width; ++j)	
			value[i][j] = rand()%256;
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
	Image image;                      // 类对象定义
	image.set(10, 10);                // 类成员访问
	image.setPixel(5,5,200);
	image.print();
	return 0;
}