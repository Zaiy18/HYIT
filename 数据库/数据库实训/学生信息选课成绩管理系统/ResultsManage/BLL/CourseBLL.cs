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
        /// 添加 
        ///</summary> 
        public static int AddCourse(Course CourseModel)
        {
            return CourseDAL.AddCourse(CourseModel);
        }
        /// <summary> 
        /// 根据主键删除 
        ///</summary> 
        public static int DeleteCourse(int Id)
        {
            return CourseDAL.DeleteCourse(Id);
        }
        /// <summary> 
        /// 分页 
        ///</summary> 
        public static List<Course> PageSelectCourse(int pageSize, int pageIndex, string WhereSrc, string PXzd, string PXType)
        {
            pageIndex = pageIndex - 1;
            return CourseDAL.PageSelectCourse(pageSize, pageIndex, WhereSrc, PXzd, PXType);
        }
        /// <summary> 
        /// 修改 
        ///</summary> 
        public static int UpdateCourse(Course CourseModel)
        {
            return CourseDAL.UpdateCourse(CourseModel);
        }
       
        /// <summary> 
        /// 查询全部
        ///</summary>
        public static List<Course> AllData(string WhereSrc, string PXzd, string PXType)
        {
            return CourseDAL.AllData(WhereSrc, PXzd, PXType);
        }
        /// <summary> 
        /// 查询条数 
        ///</summary>
        public static int CountNumber(string NewWHere)
        {
            return CourseDAL.CountNumber(NewWHere);
        }
        /// <summary> 
        /// 根据主键查询实体 
        ///</summary> 
        public static Course GetIdByCourse(int Id)
        {
            return CourseDAL.GetIdByCourse(Id);
        }
    }
}