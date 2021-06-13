using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Model;
using DAL;

namespace BLL
{
    public class DepartmentBLL
    {
        /// <summary> 
        /// ��� 
        ///</summary> 
        public static int AddDepartment(Department DepartmentModel)
        {
            return DepartmentDAL.AddDepartment(DepartmentModel);
        }
        /// <summary> 
        /// ��������ɾ�� 
        ///</summary> 
        public static int DeleteDepartment(int Id)
        {
            return DepartmentDAL.DeleteDepartment(Id);
        }
        /// <summary> 
        /// ��ҳ 
        ///</summary> 
        public static List<Department> PageSelectDepartment(int pageSize, int pageIndex, string WhereSrc, string PXzd, string PXType)
        {
            pageIndex = pageIndex - 1;
            return DepartmentDAL.PageSelectDepartment(pageSize, pageIndex, WhereSrc, PXzd, PXType);
        }
        /// <summary> 
        /// �޸� 
        ///</summary> 
        public static int UpdateDepartment(Department DepartmentModel)
        {
            return DepartmentDAL.UpdateDepartment(DepartmentModel);
        }
        
        /// <summary> 
        /// ��ѯȫ��
        ///</summary>
        public static List<Department> AllData(string WhereSrc, string PXzd, string PXType)
        {
            return DepartmentDAL.AllData(WhereSrc, PXzd, PXType);
        }

        /// <summary> 
        /// ��ѯ���� 
        ///</summary>
        public static int CountNumber(string NewWHere)
        {
            return DepartmentDAL.CountNumber(NewWHere);
        }
        /// <summary> 
        /// ����������ѯʵ�� 
        ///</summary> 
        public static Department GetIdByDepartment(int Id)
        {
            return DepartmentDAL.GetIdByDepartment(Id);
        }
    }
}