using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Model;
using DAL;

namespace BLL
{
    public class MajorBLL
    {
        /// <summary> 
        /// ��� 
        ///</summary> 
        public static int AddMajor(Major MajorModel)
        {
            return MajorDAL.AddMajor(MajorModel);
        }
        /// <summary> 
        /// ��������ɾ�� 
        ///</summary> 
        public static int DeleteMajor(int Id)
        {
            return MajorDAL.DeleteMajor(Id);
        }
        /// <summary> 
        /// ��ҳ 
        ///</summary> 
        public static List<Major> PageSelectMajor(int pageSize, int pageIndex, string WhereSrc, string PXzd, string PXType)
        {
            pageIndex = pageIndex - 1;
            return MajorDAL.PageSelectMajor(pageSize, pageIndex, WhereSrc, PXzd, PXType);
        }
        /// <summary> 
        /// �޸� 
        ///</summary> 
        public static int UpdateMajor( Major MajorModel)
        {
            return MajorDAL.UpdateMajor(MajorModel);
        }
    

        /// <summary> 
        /// ��ѯȫ��
        ///</summary>
        public static List<Major> AllData(string WhereSrc, string PXzd, string PXType)
        {
            return MajorDAL.AllData(WhereSrc, PXzd, PXType);
        }

        /// <summary> 
        /// ��ѯ���� 
        ///</summary>
        public static int CountNumber(string NewWHere)
        {
            return MajorDAL.CountNumber(NewWHere);
        }
        /// <summary> 
        /// ����������ѯʵ�� 
        ///</summary> 
        public static Major GetIdByMajor(int Id)
        {
            return MajorDAL.GetIdByMajor(Id);
        }
    }
}