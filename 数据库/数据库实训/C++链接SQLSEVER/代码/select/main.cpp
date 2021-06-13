#include <iostream>
#include <windows.h>
#include <sqlext.h>
#include <stdio.h>
#include <math.h>
#include<string>


int main() {

    SQLHENV env;
    SQLHDBC dbc;
    SQLHSTMT stmt;
    SQLRETURN ret;

    //查询的结果返回到这些变量里
    SQLCHAR bno[20], bname[20],bauthor[20];

    SQLINTEGER cbbno = SQL_NTS, cbbname=  SQL_NTS, cbbauthor = SQL_NTS;
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

        /* 基本上每个SQLExecDirect()都要初始化句柄 */
        ret = SQLAllocHandle(SQL_HANDLE_STMT, dbc, &stmt);
        ret = SQLSetStmtAttr(stmt, SQL_ATTR_ROW_BIND_TYPE, (SQLPOINTER)SQL_BIND_BY_COLUMN, SQL_IS_INTEGER);

        //查询

        char sql[512]={0};
        sprintf(sql,"SELECT * FROM Book ");
        ret = SQLExecDirect(stmt, (SQLCHAR *)sql, SQL_NTS);

        if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO)
        {
            /*  句柄、列、变量类型、接收缓冲、缓冲长度、返回的长度   */
            ret = SQLBindCol(stmt, 1, SQL_C_CHAR, bno,  sizeof(bno), &cbbno);
            ret = SQLBindCol(stmt, 2, SQL_C_CHAR, bname,  sizeof(bname), &cbbname);
            ret = SQLBindCol(stmt, 3, SQL_C_CHAR, bauthor,   sizeof(bauthor), &cbbauthor);
        }
        //遍历数据
        while ((ret = SQLFetch(stmt)) != SQL_NO_DATA_FOUND)
        {
            if (ret == SQL_ERROR)  std::cout <<"fetch error"<< std::endl;
            else
            {
                std::cout << bno<< std::endl;
                 std::cout << bname<< std::endl;
                  std::cout << bauthor<< std::endl;
            }
        }

        /*  关闭连接 */
        SQLFreeHandle(SQL_HANDLE_STMT, stmt);
        SQLDisconnect(dbc);
        SQLFreeHandle(SQL_HANDLE_DBC, dbc);
        SQLFreeHandle(SQL_HANDLE_ENV, env);

    }

    std::cin.get();
    return 0;
}
