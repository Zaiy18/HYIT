USE [master]
GO
/****** Object:  Database [example]    Script Date: 2019/1/12 14:12:48 ******/
CREATE DATABASE [example]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'example', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\example.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'example_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\example_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [example] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [example].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [example] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [example] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [example] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [example] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [example] SET ARITHABORT OFF 
GO
ALTER DATABASE [example] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [example] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [example] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [example] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [example] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [example] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [example] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [example] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [example] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [example] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [example] SET  DISABLE_BROKER 
GO
ALTER DATABASE [example] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [example] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [example] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [example] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [example] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [example] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [example] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [example] SET RECOVERY FULL 
GO
ALTER DATABASE [example] SET  MULTI_USER 
GO
ALTER DATABASE [example] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [example] SET DB_CHAINING OFF 
GO
ALTER DATABASE [example] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [example] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [example]
GO
/****** Object:  Table [dbo].[book]    Script Date: 2019/1/12 14:12:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[book](
	[bno] [nchar](10) NOT NULL,
	[bname] [nchar](20) NULL,
	[bauthor] [nchar](10) NULL,
 CONSTRAINT [PK_book] PRIMARY KEY CLUSTERED 
(
	[bno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[borrow]    Script Date: 2019/1/12 14:12:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[borrow](
	[sno] [nchar](10) NOT NULL,
	[bno] [nchar](10) NOT NULL,
	[bdate] [nchar](10) NULL,
 CONSTRAINT [PK_borrow] PRIMARY KEY CLUSTERED 
(
	[sno] ASC,
	[bno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[student]    Script Date: 2019/1/12 14:12:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student](
	[sno] [nchar](10) NOT NULL,
	[sname] [nchar](10) NULL,
	[ssex] [nchar](10) NULL,
	[sage] [nchar](10) NULL,
 CONSTRAINT [PK_student] PRIMARY KEY CLUSTERED 
(
	[sno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[book] ([bno], [bname], [bauthor]) VALUES (N'b01       ', N'钢铁是怎样炼成的            ', N'高尔基       ')
INSERT [dbo].[book] ([bno], [bname], [bauthor]) VALUES (N'b02       ', N'幻城                  ', N'郭敬明       ')
INSERT [dbo].[book] ([bno], [bname], [bauthor]) VALUES (N'b03       ', N'小学生作文选              ', N'佚名        ')
INSERT [dbo].[book] ([bno], [bname], [bauthor]) VALUES (N'b04       ', N'淘气包马小跳              ', N'杨红缨       ')
INSERT [dbo].[book] ([bno], [bname], [bauthor]) VALUES (N'b05       ', N'玛塔与黄金国              ', N'猪乐桃       ')
INSERT [dbo].[book] ([bno], [bname], [bauthor]) VALUES (N'b06       ', N'安徒生童话               ', N'安徒生       ')
INSERT [dbo].[book] ([bno], [bname], [bauthor]) VALUES (N'b07       ', N'童年                  ', N'高尔基       ')
INSERT [dbo].[book] ([bno], [bname], [bauthor]) VALUES (N'b08       ', N'红楼梦                 ', N'曹雪芹       ')
INSERT [dbo].[book] ([bno], [bname], [bauthor]) VALUES (N'b09       ', N'少儿绘本                ', N'佚名        ')
INSERT [dbo].[book] ([bno], [bname], [bauthor]) VALUES (N'b10       ', N'古希腊神话故事             ', N'佚名        ')
INSERT [dbo].[borrow] ([sno], [bno], [bdate]) VALUES (N's01       ', N'b01       ', N'01.01     ')
INSERT [dbo].[borrow] ([sno], [bno], [bdate]) VALUES (N's01       ', N'b08       ', N'01.01     ')
INSERT [dbo].[borrow] ([sno], [bno], [bdate]) VALUES (N's01       ', N'b10       ', N'01.01     ')
INSERT [dbo].[borrow] ([sno], [bno], [bdate]) VALUES (N's03       ', N'b02       ', N'02.11     ')
INSERT [dbo].[borrow] ([sno], [bno], [bdate]) VALUES (N's05       ', N'b05       ', N'02.24     ')
INSERT [dbo].[student] ([sno], [sname], [ssex], [sage]) VALUES (N's01       ', N'小明        ', N'男         ', N'11        ')
INSERT [dbo].[student] ([sno], [sname], [ssex], [sage]) VALUES (N's02       ', N'小红        ', N'女         ', N'12        ')
INSERT [dbo].[student] ([sno], [sname], [ssex], [sage]) VALUES (N's03       ', N'小强        ', N'男         ', N'10        ')
INSERT [dbo].[student] ([sno], [sname], [ssex], [sage]) VALUES (N's04       ', N'小雨        ', N'女         ', N'11        ')
INSERT [dbo].[student] ([sno], [sname], [ssex], [sage]) VALUES (N's05       ', N'小东        ', N'男         ', N'11        ')
USE [master]
GO
ALTER DATABASE [example] SET  READ_WRITE 
GO
