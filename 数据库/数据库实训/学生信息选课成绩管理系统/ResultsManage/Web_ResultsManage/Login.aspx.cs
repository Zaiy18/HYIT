using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Model;
using BLL;

public partial class Login : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void imgbLogin_Click(object sender, ImageClickEventArgs e)
    {
        
        if (ddlType.SelectedValue == "学生")
        {
            Sudents sudents = new Sudents();
            if (SudentsBLL.GetUsersLogin(txtUserName.Value.Trim(), txtPwd.Value.Trim(), out sudents))
            {
                Session["Sudents"] = sudents;
                Response.Redirect("SudentsMain.aspx", false);
            }
            else
            {
                this.Page.ClientScript.RegisterStartupScript(this.GetType(), "myalert", "<script>alert('用户名或者密码错误！');</script>");
                return;
            }
        }
        else if (ddlType.SelectedValue == "教师")
        {

            Teacher teacher = new Teacher();
            if (TeacherBLL.GetUsersLogin(txtUserName.Value.Trim(), txtPwd.Value.Trim(), out teacher))
            {
                Session["Teacher"] = teacher;
                Response.Redirect("TeacherMain.aspx", false);
            }
            else
            {
                this.Page.ClientScript.RegisterStartupScript(this.GetType(), "myalert", "<script>alert('用户名或者密码错误！');</script>");
                return;
            }
        }
        else if (ddlType.SelectedValue == "管理员")
        {
            Admin admin = new Admin();
            if (AdminBLL.GetUsersLogin(txtUserName.Value.Trim(), txtPwd.Value.Trim(), out admin))
            {
                Session["Admin"] = admin;
                Response.Redirect("AdminMain.aspx", false);
            }
            else
            {
                this.Page.ClientScript.RegisterStartupScript(this.GetType(), "myalert", "<script>alert('用户名或者密码错误！');</script>");
                return;
            }
        }

    }
    protected void imgbReset_Click(object sender, ImageClickEventArgs e)
    {
        txtUserName.Value = "";
        txtPwd.Value = "";
    }
}