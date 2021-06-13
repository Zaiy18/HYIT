using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Model;
using DAL;
using System.Data;

namespace BLL
{
    public class ResultsBLL
    {
        /// <summary> 
        /// ��� 
        ///</summary> 
        public static int AddResults(Results ResultsModel)
        {
            return ResultsDAL.AddResults(ResultsModel);
        }
        /// <summary> 
        /// ��������ɾ�� 
        ///</summary> 
        public static int DeleteResults(int Id)
        {
            return ResultsDAL.DeleteResults(Id);
        }

        
        /// <summary>
        /// ��ѯȫ��
        /// </summary>
        public static DataTable GetAllData(string WhereSrc, string PXzd, string PXType)
        {
            return ResultsDAL.GetAllData(WhereSrc, PXzd, PXType);
        }

        /// <summary>
        /// �����֤�Ƿ����
        /// </summary>
        /// <param name="SutId"></param>
        /// <param name="CourseId"></param>
        /// <param name="SemesterId"></param>
        /// <returns></returns>
        public static bool IsTrue(int SutId, int CourseId)
        {
            Results res = ResultsDAL.GetByWhere(SutId, CourseId);
            if (res != null && res.ResultsId != 0)
            {
                return true;
            }
            return false;
        }
     
        /// <summary> 
        /// ��ҳ 
        ///</summary> 
        public static List<Results> PageSelectResults(int pageSize, int pageIndex, string WhereSrc, string PXzd, string PXType)
        {
            pageIndex = pageIndex - 1;
            return ResultsDAL.PageSelectResults(pageSize, pageIndex, WhereSrc, PXzd, PXType);
        }
        /// <summary> 
        /// �޸� 
        ///</summary> 
        public static int UpdateResults(Results ResultsModel)
        {
            return ResultsDAL.UpdateResults(ResultsModel);
        }
       
        /// <summary> 
        /// ��ѯȫ��
        ///</summary>
        public static List<Results> AllData(string WhereSrc, string PXzd, string PXType)
        {
            return ResultsDAL.AllData(WhereSrc, PXzd, PXType);
        }
        /// <summary> 
        /// ��ѯ���� 
        ///</summary>
        public static int CountNumber(string NewWHere)
        {
            return ResultsDAL.CountNumber(NewWHere);
        }
        /// <summary> 
        /// ����������ѯʵ�� 
        ///</summary> 
        public static Results GetIdByResults(int Id)
        {
            return ResultsDAL.GetIdByResults(Id);
        }

        /// <summary>
        /// ���ݳɼ�ͳ��
        /// </summary>
        public static List<Results> StatisticalByType(int CourseId, int SemesterId)
        {
            return ResultsDAL.StatisticalByType(CourseId, SemesterId);
        }
    }
}