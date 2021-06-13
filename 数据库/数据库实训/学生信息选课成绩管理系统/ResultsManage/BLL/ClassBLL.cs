using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Model;
using DAL;

namespace BLL
{
    public class ClassBLL
    {
        /// <summary> 
        /// ��� 
        ///</summary> 
        public static int AddClass(Class ClassModel)
        {
            return ClassDAL.AddClass(ClassModel);
        }
        /// <summary> 
        /// ��������ɾ�� 
        ///</summary> 
        public static int DeleteClass(int Id)
        {
            return ClassDAL.DeleteClass(Id);
        }
        /// <summary> 
        /// ��ҳ 
        ///</summary> 
        public static List<Class> PageSelectClass(int pageSize, int pageIndex, string WhereSrc, string PXzd, string PXType)
        {
            pageIndex = pageIndex - 1;
            return ClassDAL.PageSelectClass(pageSize, pageIndex, WhereSrc, PXzd, PXType);
        }
        /// <summary> 
        /// �޸� 
        ///</summary> 
        public static int UpdateClass( Class ClassModel)
        {
            return ClassDAL.UpdateClass(ClassModel);
        }
        /// <summary> 
        /// ��ѯȫ��
        ///</summary>
        public static List<Class> AllData(string WhereSrc, string PXzd, string PXType)
        {
            return ClassDAL.AllData(WhereSrc, PXzd, PXType);
        }
        /// <summary> 
        /// ��ѯ���� 
        ///</summary>
        public static int CountNumber(string NewWHere)
        {
            return ClassDAL.CountNumber(NewWHere);
        }
        /// <summary> 
        /// ����������ѯʵ�� 
        ///</summary> 
        public static Class GetIdByClass(int Id)
        {
            return ClassDAL.GetIdByClass(Id);
        }
    }
}