USE [master]
GO

/***** Copy Paste ******/
IF  EXISTS (SELECT name FROM sys.databases WHERE name = N'wmsdb')
ALTER DATABASE [wmsdb] SET SINGLE_USER WITH ROLLBACK IMMEDIATE
GO

IF  EXISTS (SELECT name FROM sys.databases WHERE name = N'wmsdb')
DROP DATABASE [wmsdb]
GO

CREATE DATABASE [wmsdb] 
GO

ALTER DATABASE [wmsdb] SET COMPATIBILITY_LEVEL = 100
GO
/***********/

USE [wmsdb]
GO

/****** Object:  Table [dbo].[order]    Script Date: 04/10/2013 17:36:12 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[order](
	[id] [nvarchar](50) NOT NULL,
	[dockId] [nvarchar](50) NULL,
	[isUnloading] [bit] NOT NULL,
	[toBeCleaned] [bit] NOT NULL,
	[inProcess] [bit] NOT NULL,
 CONSTRAINT [PK_order] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[orderposition]    Script Date: 04/11/2013 14:57:34 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[orderposition](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [nvarchar](50) NOT NULL,
	[material_id] [nvarchar](50) NOT NULL,
	[amount] [numeric](18, 0) NULL,
 CONSTRAINT [PK_orderposition] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[orderpick]    Script Date: 04/16/2013 15:32:57 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[orderpick](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[oposition_id] [int] NOT NULL,
	[position_id] [int] NOT NULL,
	[amount] [numeric](18, 0) NOT NULL,
	[inProcess] [bit] NOT NULL,
 CONSTRAINT [PK_orderPick] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[rack]    Script Date: 06/11/2012 13:52:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[rack](
	[id] [nvarchar](50) NOT NULL,
	[name] [nvarchar](50) NULL,
 CONSTRAINT [PK_rack] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[material]    Script Date: 06/11/2012 13:52:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[material](
	[materialNumber] [nvarchar](50) NOT NULL,
	[name] [nvarchar](50) NULL,
	[description] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[materialNumber] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[locationtype]    Script Date: 06/11/2012 13:52:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[locationtype](
	[id] [nvarchar](50) NOT NULL,
	[name] [nvarchar](50) NULL,
 CONSTRAINT [PK_locationtype] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[location]    Script Date: 06/11/2012 13:52:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[location](
	[id] [nvarchar](50) NOT NULL,
	[type] [nvarchar](50) NOT NULL,
	[reserved] [bit] NULL,
	[rack_id] [nvarchar](50) NULL,
    [abc_cat] [nchar] (1) NOT NULL,	
 CONSTRAINT [PK_location] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[box]    Script Date: 06/11/2012 13:52:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[box](
	[id] [nvarchar](50) NOT NULL,
	[location_id] [nvarchar](50) NOT NULL,
	[abc_cat] [nchar] (1) NOT NULL,	
 CONSTRAINT [PK__box__3213E83F0F975522] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[position]    Script Date: 04/16/2013 13:47:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[position](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[box_id] [nvarchar](50) NOT NULL,
	[material_id] [nvarchar](50) NOT NULL,
	[amount] [numeric](18, 0) NOT NULL,
 CONSTRAINT [PK_position] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [IX_position] UNIQUE NONCLUSTERED 
(
	[box_id] ASC,
	[material_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[transportentry]    Script Date: 07/24/2012 17:15:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transportentry](
	[box_id] [nvarchar](50) NOT NULL,
	[bin_id] [nvarchar](50) NOT NULL,
	[test] [nvarchar](50) NULL,
 CONSTRAINT [PK_transportentity] PRIMARY KEY CLUSTERED 
(
	[box_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  ForeignKey [FK_location_locationtype]    Script Date: 06/11/2012 13:52:26 ******/
ALTER TABLE [dbo].[location]  WITH CHECK ADD  CONSTRAINT [FK_location_locationtype] FOREIGN KEY([type])
REFERENCES [dbo].[locationtype] ([id])
GO
ALTER TABLE [dbo].[location] CHECK CONSTRAINT [FK_location_locationtype]
GO
/****** Object:  ForeignKey [FK_location_rack]    Script Date: 06/11/2012 13:52:26 ******/
ALTER TABLE [dbo].[location]  WITH CHECK ADD  CONSTRAINT [FK_location_rack] FOREIGN KEY([rack_id])
REFERENCES [dbo].[rack] ([id])
GO
ALTER TABLE [dbo].[location] CHECK CONSTRAINT [FK_location_rack]
GO
/****** Object:  ForeignKey [FK_box_location]    Script Date: 06/11/2012 13:52:26 ******/
ALTER TABLE [dbo].[box]  WITH CHECK ADD  CONSTRAINT [FK_box_location] FOREIGN KEY([location_id])
REFERENCES [dbo].[location] ([id])
GO
ALTER TABLE [dbo].[box] CHECK CONSTRAINT [FK_box_location]
GO
/****** Object:  ForeignKey [FK_position_box]    Script Date: 06/11/2012 13:52:26 ******/
ALTER TABLE [dbo].[position]  WITH CHECK ADD  CONSTRAINT [FK_position_box] FOREIGN KEY([box_id])
REFERENCES [dbo].[box] ([id])
GO
ALTER TABLE [dbo].[position] CHECK CONSTRAINT [FK_position_box]
GO
/****** Object:  ForeignKey [FK_position_material]    Script Date: 06/11/2012 13:52:26 ******/
ALTER TABLE [dbo].[position]  WITH CHECK ADD  CONSTRAINT [FK_position_material] FOREIGN KEY([material_id])
REFERENCES [dbo].[material] ([materialNumber])
GO
ALTER TABLE [dbo].[position] CHECK CONSTRAINT [FK_position_material]
GO

/****** Object:  ForeignKey [FK_transportentity_box]    Script Date: 07/24/2012 17:15:27 ******/
ALTER TABLE [dbo].[transportentry]  WITH CHECK ADD  CONSTRAINT [FK_transportentity_box] FOREIGN KEY([box_id])
REFERENCES [dbo].[box] ([id])
GO
ALTER TABLE [dbo].[transportentry] CHECK CONSTRAINT [FK_transportentity_box]
GO
/****** Object:  ForeignKey [FK_transportentity_location]    Script Date: 07/24/2012 17:15:27 ******/
ALTER TABLE [dbo].[transportentry]  WITH CHECK ADD  CONSTRAINT [FK_transportentity_location] FOREIGN KEY([bin_id])
REFERENCES [dbo].[location] ([id])
GO
ALTER TABLE [dbo].[transportentry] CHECK CONSTRAINT [FK_transportentity_location]
GO

/****** Object:  ForeignKey [FK_orderposition_material]    Script Date: copypaste ******/
ALTER TABLE [dbo].[orderposition]  WITH CHECK ADD  CONSTRAINT [FK_orderposition_material] FOREIGN KEY([material_id])
REFERENCES [dbo].[material] ([materialNumber])
GO
ALTER TABLE [dbo].[orderposition] CHECK CONSTRAINT [FK_orderposition_material]
GO

/****** Object:  ForeignKey [FK_orderposition_order]    Script Date: copypaste ******/
ALTER TABLE [dbo].[orderposition]  WITH CHECK ADD  CONSTRAINT [FK_orderposition_order] FOREIGN KEY([order_id])
REFERENCES [dbo].[order] ([id])
GO
ALTER TABLE [dbo].[orderposition] CHECK CONSTRAINT [FK_orderposition_order]
GO

/****** Object:  ForeignKey [FK_orderpick_orderposition]    Script Date: copypaste ******/
ALTER TABLE [dbo].[orderpick]  WITH CHECK ADD  CONSTRAINT [FK_orderpick_orderposition] FOREIGN KEY([oposition_id])
REFERENCES [dbo].[orderposition] ([id])
GO
ALTER TABLE [dbo].[orderpick] CHECK CONSTRAINT [FK_orderpick_orderposition]
GO

/****** Object:  ForeignKey [FK_orderpick_position]    Script Date: copypaste ******/
ALTER TABLE [dbo].[orderpick]  WITH CHECK ADD  CONSTRAINT [FK_orderpick_position] FOREIGN KEY([position_id])
REFERENCES [dbo].[position] ([id])
GO
ALTER TABLE [dbo].[orderpick] CHECK CONSTRAINT [FK_orderpick_position]
GO