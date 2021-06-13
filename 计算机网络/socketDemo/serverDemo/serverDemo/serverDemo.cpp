#include "pch.h"
#include <cstdio>
#include<iostream>
#include<string>
#include<WinSock2.h>
#include <WS2tcpip.h>
#include <ctime>
#include <time.h>
#include <stdio.h>
#pragma comment(lib,"ws2_32.lib")
using namespace std;
const int PORT = 1234;
#define MaxClient 10
#define MaxBufSize 1024
#define _CRT_SECURE_NO_WARINGS
//服务线程
DWORD WINAPI ServerThread(LPVOID lpParameter) {
	SOCKET *ClientSocket = (SOCKET*)lpParameter;
	int receByt = 0;
	char buf_time[100];
	char RecvBuf[MaxBufSize];
	char SendBuf[MaxBufSize];
	while (1) {
		receByt = recv(*ClientSocket, RecvBuf, sizeof(RecvBuf), 0);
		//buf[receByt]='\0';
		if (receByt > 0) {
			time_t tnow;
			time(&tnow);
			tm *st_tm = localtime(&tnow);
			sprintf_s(buf_time, "%d-%d-%d:%d:%d:%d", st_tm->tm_year + 1900, st_tm->tm_mon + 1, st_tm->tm_mday, st_tm->tm_hour, st_tm->tm_min, st_tm->tm_sec);
			cout <<"来自客户端:" << *ClientSocket<<"-->"<<buf_time << "接收到的消息是：" << RecvBuf << endl;
			// cout<<receByt<<endl;
		}
		else
		{
			cout << "接收消息结束！" << endl;
			break;
		}
		memset(RecvBuf, 0, sizeof(RecvBuf));
		cout << "请输入要发送到客户端"<<*ClientSocket<<"的信息：" << endl;
		gets_s(SendBuf);
		int k = 0;
		k = send(*ClientSocket, SendBuf, sizeof(SendBuf), 0);
		if (k < 0) {
			cout << "发送失败" << endl;
		}
		memset(SendBuf, 0, sizeof(SendBuf));
	}//while
	closesocket(*ClientSocket);
	free(ClientSocket);
	return 0;
}

int main() {
	WSAData wsd;
	WSAStartup(MAKEWORD(2, 2), &wsd);
	SOCKET ListenSocket = socket(AF_INET, SOCK_STREAM, 0);
	SOCKADDR_IN ListenAddr;
	ListenAddr.sin_family = AF_INET;
	ListenAddr.sin_addr.S_un.S_addr = INADDR_ANY;//表示填入本机ip
	ListenAddr.sin_port = htons(PORT);
	int n;
	n = bind(ListenSocket, (LPSOCKADDR)&ListenAddr, sizeof(ListenAddr));

	if (n == SOCKET_ERROR) {
		cout << "端口绑定失败！" << endl;
		return -1;
	}
	else {
		cout << "server IP:192.168.138.1,socket port #1234" << endl;
	}
	int l = listen(ListenSocket, 20);
	cout << "服务端准备就绪，等待连接请求" << endl;

	while (1) {
		//循环接收客户端连接请求并创建服务线程
		SOCKET *ClientSocket = new SOCKET;
		ClientSocket = (SOCKET*)malloc(sizeof(SOCKET));
		//接收客户端连接请求
		int SockAddrlen = sizeof(sockaddr);
		*ClientSocket = accept(ListenSocket, 0, 0);
		cout << "一个客户端已连接到服务器，socket是：" << *ClientSocket << endl;
		CreateThread(NULL, 0, &ServerThread, ClientSocket, 0, NULL);
	}//while
	closesocket(ListenSocket);
	WSACleanup();
	return(0);
}//main
