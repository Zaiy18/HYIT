// clientDemo.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include "pch.h"
#include <iostream>
#pragma comment(lib,"WS2_32.lib")
/* File Name: client.c */
#include <winsock2.h>
#include <stdlib.h>
#define MaxBufSize 1024
#include <stdio.h>
/* 这个程序建立套接字，然后与命令行给出的套接字连接；连接结束时，在连接上发送
一个消息，然后关闭套接字。命令行的格式是：clientDemo 主机名 端口号
端口号要与服务器程序的端口号相同 */

int main(int argc, char *argv[])
{
	if (argc <=2) {
		std::cout << "参数不足，请重新输入。。。";
		return 0;
	}
	SOCKET SocketClient = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
	char  RecvBuff[MaxBufSize];
	int sock;
	struct sockaddr_in server;
	struct hostent *hp;
	WSADATA wsa;
	char buf[1024] = "1234567";
	char buf_rev[1024];
	//初始化环境
	if (WSAStartup(MAKEWORD(2, 2), &wsa) != 0)
	{
		printf("fail to load socket.");
		return 1;
	}

	sock = socket(AF_INET, SOCK_STREAM, 0);
	if (sock < 0) {
		perror("opening stream socket");
		exit(1);
	}
	/* 使用命令行中指定的名字连接套接字 */
	server.sin_family = AF_INET;
	printf_s("准备连接主机 %s 的 %s端口\n", argv[1],argv[2]);
	hp = gethostbyname(argv[1]);
	if (hp == 0) {
		fprintf(stderr, "%s: unknown host \n", argv[1]);
		exit(2);
	}

	memcpy((char*)&server.sin_addr, (char*)hp->h_addr, hp->h_length);
	server.sin_port = htons(atoi(argv[2]));
	
	if (connect(sock, (struct sockaddr*)&server, sizeof(server)) < 0) {
		perror("connecting stream socket");
		exit(3);
	}
	while (strcmp(buf, "exit") != 0)
	{
		scanf("%s", buf);
		if (send(sock, buf, sizeof(buf), 0) < 0)
			perror("sending on stream socket");

		if (recv(sock, buf_rev, 1024, 0) < 0)
		{
			perror("reading stream message");
			break;
		}

		else
			printf("-->%s\n", buf_rev);
	}
	/*int n = 0;
	n = recv(SocketClient, RecvBuff, sizeof(RecvBuff), 0);
	if (n > 0) {
		printf_s ("接收到来自服务器的消息为%s：", RecvBuff);
	}*/
	closesocket(sock);
}

