using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Model;
using BLL;

public partial class AdminLeft : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void lnkbOut_Click(object sender, EventArgs e)
    {
        Session["Admin"] = null;
        Response.Write("<script>top.location.href='Login.aspx'</script>");
    }
}