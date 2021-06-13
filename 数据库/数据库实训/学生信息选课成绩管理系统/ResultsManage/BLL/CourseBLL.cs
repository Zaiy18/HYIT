using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Model;
using DAL;

namespace BLL
{
    public class CourseBLL
    {
        /// <summary> 
        /// ��� 
        ///</summary> 
        public static int AddCourse(Course CourseModel)
        {
            return CourseDAL.AddCourse(CourseModel);
        }
        /// <summary> 
        /// ��������ɾ�� 
        ///</summary> 
        public static int DeleteCourse(int Id)
        {
            return CourseDAL.DeleteCourse(Id);
        }
        /// <summary> 
        /// ��ҳ 
        ///</summary> 
        public static List<Course> PageSelectCourse(int pageSize, int pageIndex, string WhereSrc, string PXzd, string PXType)
        {
            pageIndex = pageIndex - 1;
            return CourseDAL.PageSelectCourse(pageSize, pageIndex, WhereSrc, PXzd, PXType);
        }
        /// <summary> 
        /// �޸� 
        ///</summary> 
        public static int UpdateCourse(Course CourseModel)
        {
            return CourseDAL.UpdateCourse(CourseModel);
        }
       
        /// <summary> 
        /// ��ѯȫ��
        ///</summary>
        public static List<Course> AllData(string WhereSrc, string PXzd, string PXType)
        {
            return CourseDAL.AllData(WhereSrc, PXzd, PXType);
        }
        /// <summary> 
        /// ��ѯ���� 
        ///</summary>
        public static int CountNumber(string NewWHere)
        {
            return CourseDAL.CountNumber(NewWHere);
        }
        /// <summary> 
        /// ����������ѯʵ�� 
        ///</summary> 
        public static Course GetIdByCourse(int Id)
        {
            return CourseDAL.GetIdByCourse(Id);
        }
    }
}