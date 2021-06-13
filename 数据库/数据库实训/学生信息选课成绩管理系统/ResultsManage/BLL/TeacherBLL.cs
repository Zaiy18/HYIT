using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Model;
using DAL;

namespace BLL
{
    public class TeacherBLL
    {



        /// <summary>
        /// ��֤�û��Ƿ��ܵ�¼�ɹ�
        /// </summary>
        /// <param name="UserName"></param>
        /// <param name="Pwd"></param>
        /// <param name="users"></param>
        /// <returns></returns>
        public static bool GetUsersLogin(string TeacherCode, string Pwd, out Teacher teacher)
        {
            teacher = TeacherDAL.GetIdByTeacherCode(TeacherCode);
            if (teacher != null && teacher.Pwd == Pwd)
            {
                return true;
            }
            return false;
        }



        //�����֤�Ƿ����
        public static bool IsTrue(string TeacherCode)
        {
            Teacher tch = TeacherDAL.GetIdByTeacherCode(TeacherCode);
            if (tch != null && tch.TeacherId != 0)
            {
                return true;
            }
            return false;
        }



        // �޸���֤�Ƿ����
        public static bool IsTrue(string TeacherCode, int TeacherId)
        {
            Teacher tch = TeacherDAL.GetIdByTeacherCode(TeacherCode);
            if (tch != null && tch.TeacherId != 0 && tch.TeacherId != TeacherId)
            {
                return true;
            }
            return false;
        }

        /// <summary>
        /// ��� 
        ///</summary>
        public static int AddTeacher(Teacher TeacherModel)
        {
            return TeacherDAL.AddTeacher(TeacherModel);
        }

        /// <summary> 
        /// ����ID�޸� 
        ///</summary>
        public static int UpdateTeacher(Teacher TeacherModel)
        {
            return TeacherDAL.UpdateTeacher(TeacherModel);
        }

        /// <summary> 
        /// ��������ɾ�� 
        ///</summary>
        public static int DeleteTeacher(int Id)
        {
            return TeacherDAL.DeleteTeacher(Id);
        }





        /// <summary> 
        /// ����������ѯʵ�� 
        ///</summary>
        public static Teacher GetIdByTeacher(int Id)
        {
            return TeacherDAL.GetIdByTeacher(Id);
        }
        /// <summary>
        /// ��ѯȫ��
        /// </summary>
        public static List<Teacher> AllData(string WhereSrc, string PXzd, string PXType)
        {
            return TeacherDAL.AllData(WhereSrc, PXzd, PXType);
        }
    }
}