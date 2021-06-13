#include <iostream>
#include <windows.h>
#include <sqlext.h>
#include <stdio.h>
#include <math.h>
#include<string>
using namespace std;


int main() {

    SQLHENV env;
    SQLHDBC dbc;
    SQLHSTMT stmt;
    SQLRETURN ret;

    SQLAllocHandle(SQL_HANDLE_ENV, SQL_NULL_HANDLE, &env);
    SQLSetEnvAttr(env, SQL_ATTR_ODBC_VERSION, (void *)SQL_OV_ODBC3, 0);
    SQLAllocHandle(SQL_HANDLE_DBC, env, &dbc);

    SQLDriverConnectW(dbc, NULL, L"DRIVER={SQL Server};SERVER=(local);DATABASE=example;UID=Libraryclerk;PWD=1;", SQL_NTS, NULL, 0, NULL, SQL_DRIVER_COMPLETE);

    if (SQL_SUCCESS != SQLAllocHandle(SQL_HANDLE_STMT, dbc, &stmt))
    {
        std::cout << "Failed to connect" << std::endl;
    }
    else
    {
        std::cout << "Succeed to connect" << std::endl;

        /* ������ÿ��SQLExecDirect()��Ҫ��ʼ����� */
        ret = SQLAllocHandle(SQL_HANDLE_STMT, dbc, &stmt);
        ret = SQLSetStmtAttr(stmt, SQL_ATTR_ROW_BIND_TYPE, (SQLPOINTER)SQL_BIND_BY_COLUMN, SQL_IS_INTEGER);

        //��ѯ

        char sql[512]={0};
        sprintf(sql,"UPDATE student SET sname='С��' WHERE sname='С��' ");
        ret = SQLExecDirect(stmt, (SQLCHAR *)sql, SQL_NTS);

              if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {
            cout << "�ɹ��޸�" << endl;
        }
        else {
            cout << "�޸�ʧ��" << endl;
        }

        /*  �ر����� */
        SQLFreeHandle(SQL_HANDLE_STMT, stmt);
        SQLDisconnect(dbc);
        SQLFreeHandle(SQL_HANDLE_DBC, dbc);
        SQLFreeHandle(SQL_HANDLE_ENV, env);

    }

    std::cin.get();
    return 0;
}
