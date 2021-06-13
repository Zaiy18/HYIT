#include <iostream>
#include <windows.h>
#include <sqlext.h>

int main() {

    SQLHENV env;        //environment handle
    SQLHDBC dbc;        //connection handle
    SQLHSTMT stmt;      //state handle

    /* Allocate an environment handle */
    SQLAllocHandle(SQL_HANDLE_ENV, SQL_NULL_HANDLE, &env);
    /* We need ODBC 3 support */
    SQLSetEnvAttr(env, SQL_ATTR_ODBC_VERSION, (void *)SQL_OV_ODBC3, 0);
    /* Allocate a connection handle */
    SQLAllocHandle(SQL_HANDLE_DBC, env, &dbc);
    /* Connect to the odbc */
    SQLDriverConnectW(dbc, NULL, L"DRIVER={SQL Server};SERVER=(local);DATABASE=example;UID=Libraryclerk;PWD=1;", SQL_NTS, NULL, 0, NULL, SQL_DRIVER_COMPLETE);

    /* Check for success */
    if (SQL_SUCCESS != SQLAllocHandle(SQL_HANDLE_STMT, dbc, &stmt))
    {
        std::cout << "Failed to connect" << std::endl;
    }
    else
    {
        std::cout << "Succeed to connect" << std::endl;

        /*  close connection */
        SQLFreeHandle(SQL_HANDLE_STMT, stmt);
        SQLDisconnect(dbc);
        SQLFreeHandle(SQL_HANDLE_DBC, dbc);
        SQLFreeHandle(SQL_HANDLE_ENV, env);
    }

    std::cin.get();
    return 0;
}
