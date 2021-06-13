using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Model;
using System.Data.SqlClient;
using System.Data;

namespace DAL
{
    public class MajorDAL
    {


        /// <summary>
        /// ��� 
        ///</summary>
        public static int AddMajor(Major MajorModel)
        {
            string sql = string.Format("insert into  Major (MajorName,DeptId,Note )values('{0}',{1},'{2}')",MajorModel.MajorName,MajorModel.DeptId,MajorModel.Note);
            return DBHelper.ExecuteCommand(sql);
        }

        /// <summary> 
        /// ����ID�޸� 
        ///</summary>
        public static int UpdateMajor(Major MajorModel)
        {
            string sql = string.Format(" UPDATE Major  set MajorName='{0}',DeptId={1},Note='{2}' where MajorId={3} ",MajorModel.MajorName,MajorModel.DeptId,MajorModel.Note  ,MajorModel.MajorId);
            return DBHelper.ExecuteCommand(sql);
        }

        /// <summary> 
        /// ��������ɾ�� 
        ///</summary>
        public static int DeleteMajor(int Id)
        {
            string sql = string.Format("delete from Major where MajorId={0}", Id);
            return DBHelper.ExecuteCommand(sql);
        }

        /// <summary> 
        /// ��ѯ���� 
        ///</summary>
        public static int CountNumber(string NewWHere)
        {
            string sql = "";
            if (!string.IsNullOrEmpty(NewWHere))
            {
                sql = "select count(*) from Major where " + NewWHere;
            }
            else
            {
                sql = "select count(*) from Major";

            }
            return DBHelper.GetIntScalar(sql);
        }

        /// <summary>
        /// ��ҳ 
        ///</summary> 
        public static List<Major> PageSelectMajor(int pageSize, int pageIndex, string WhereSrc, string PXzd, string PXType)
        {
            List<Major> list = new List<Major>(); 
	    string sql = string.Format("SELECT top {0} * FROM Major where MajorId not in( select top {1} MajorId from Major where 1=1 {2} order by {3} {4}) and 1=1 {2} order by {3} {4} ",pageSize, pageSize*pageIndex,WhereSrc, PXzd,PXType);
            using (DataTable table = DBHelper.GetDataSet(sql))
            {
                list = GetList(table);
            }
            return list;
        }

        /// <summary> 
        /// ����������ѯʵ�� 
        ///</summary>
        public static Major GetIdByMajor(int Id)
        {
            string sql = string.Format("SELECT * FROM Major where MajorId={0} ",Id);
            Major MajorModel = new Major();
            using (DataTable table = DBHelper.GetDataSet(sql))
            {
                MajorModel= GetMode(table);
            }
            return MajorModel;
        }
        /// <summary>
        /// ��ѯȫ��
        /// </summary>
        public static List<Major> AllData(string WhereSrc, string PXzd, string PXType)
        {
            List<Major> list = new List<Major>();
            string sql = "select * from Major where 1=1";
            if (!string.IsNullOrEmpty(WhereSrc))
            {
                sql += string.Format(WhereSrc + " order by {0} {1}", PXzd, PXType);
            }
            else
            {
                sql += string.Format(" order by {0} {1}", PXzd, PXType);
            }

            using (DataTable table = DBHelper.GetDataSet(sql))
            {

                list = GetList(table);
            }
            return list;
        }
        /// <summary> 
        /// ˽�з��� 
        ///</summary>
        private static List<Major> GetList(DataTable table)
        {
            List<Major> list = new List<Major>();
            foreach (DataRow row in table.Rows)
            {
                Major MajorModel = new Major(); 
                MajorModel.MajorId = Convert.ToInt32(row["MajorId"]); 
                MajorModel.MajorName = Convert.ToString(row["MajorName"]); 
                MajorModel.DeptId = Convert.ToInt32(row["DeptId"]); 
                MajorModel.Note = Convert.ToString(row["Note"]); 
                list.Add(MajorModel);

            }
            return list;
        }
        /// <summary> 
        /// ˽�з��� 
        ///</summary>
        private static Major GetMode(DataTable table)
        {
            Major MajorModel = new Major();
            foreach (DataRow row in table.Rows)
            {
                MajorModel.MajorId = Convert.ToInt32(row["MajorId"]); 
                MajorModel.MajorName = Convert.ToString(row["MajorName"]); 
                MajorModel.DeptId = Convert.ToInt32(row["DeptId"]); 
                MajorModel.Note = Convert.ToString(row["Note"]); 

            }
            return MajorModel;
        }
    }
}