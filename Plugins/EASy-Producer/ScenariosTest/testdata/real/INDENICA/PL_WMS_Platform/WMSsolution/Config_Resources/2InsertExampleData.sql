USE [wmsdb]
GO


/****** Object:  Table [dbo].[rack]    Script Date: 06/11/2012 13:52:26 ******/
INSERT [dbo].[rack] ([id], [name]) VALUES (N'R', N'Rack')


/****** Object:  Table [dbo].[material]    Script Date: 05/09/2012 15:58:14 ******/
INSERT [dbo].[material] ([materialNumber], [name], [description]) VALUES (N'1', N'Eggs', N'Eggs')
INSERT [dbo].[material] ([materialNumber], [name], [description]) VALUES (N'2', N'Milk', N'Milk')


/****** Object:  Table [dbo].[locationtype]    Script Date: 06/11/2012 13:55:58 ******/
INSERT [dbo].[locationtype] ([id], [name]) VALUES (N'1', N'Conveyor')
INSERT [dbo].[locationtype] ([id], [name]) VALUES (N'2', N'RackFeeder')
INSERT [dbo].[locationtype] ([id], [name]) VALUES (N'3', N'PickingStation')
INSERT [dbo].[locationtype] ([id], [name]) VALUES (N'4', N'ReceptionStation')
INSERT [dbo].[locationtype] ([id], [name]) VALUES (N'5', N'TransferStation')
INSERT [dbo].[locationtype] ([id], [name]) VALUES (N'6', N'StorageBin')
INSERT [dbo].[locationtype] ([id], [name]) VALUES (N'7', N'LoadingStation')


/****** Object:  Table [dbo].[location]    Script Date: 06/11/2012 13:55:58 ******/
INSERT [wmsdb].[dbo].[location] ([id], [type], [reserved], [rack_id], [abc_cat]) VALUES (N'11', N'6', 0, N'R', N'B')
INSERT [dbo].[location] ([id], [type], [reserved], [rack_id], [abc_cat]) VALUES (N'12', N'6', 0, N'R', N'C')
INSERT [dbo].[location] ([id], [type], [reserved], [rack_id], [abc_cat]) VALUES (N'13', N'6', 0, N'R', N'B')
INSERT [dbo].[location] ([id], [type], [reserved], [rack_id], [abc_cat]) VALUES (N'14', N'6', 0, N'R', N'C')
INSERT [dbo].[location] ([id], [type], [reserved], [rack_id], [abc_cat]) VALUES (N'15', N'6', 0, N'R', N'B')


INSERT [dbo].[location] ([id], [type], [reserved], [rack_id], [abc_cat]) VALUES (N'C', N'1', NULL, NULL, N'Z')
INSERT [dbo].[location] ([id], [type], [reserved], [rack_id], [abc_cat]) VALUES (N'PS', N'3', NULL, NULL, N'Z')
INSERT [dbo].[location] ([id], [type], [reserved], [rack_id], [abc_cat]) VALUES (N'RF', N'2', NULL, N'R', N'Z')
INSERT [dbo].[location] ([id], [type], [reserved], [rack_id], [abc_cat]) VALUES (N'RS', N'4', NULL, NULL, N'Z')
INSERT [dbo].[location] ([id], [type], [reserved], [rack_id], [abc_cat]) VALUES (N'TS', N'5', NULL, N'R', N'Z')
INSERT [dbo].[location] ([id], [type], [reserved], [rack_id], [abc_cat]) VALUES (N'LS', N'7', NULL, NULL, N'Z')


/****** Object:  Table [dbo].[box]    Script Date: 06/11/2012 13:55:58 ******/
INSERT [dbo].[box] ([id], [location_id], [abc_cat]) VALUES (N'1', N'11', N'B')
INSERT [dbo].[box] ([id], [location_id], [abc_cat]) VALUES (N'2', N'14', N'C')
INSERT [dbo].[box] ([id], [location_id], [abc_cat]) VALUES (N'3', N'12', N'B')



/****** Object:  Table [dbo].[position]    Script Date: 06/11/2012 13:55:58 ******/
INSERT [dbo].[position] ([box_id], [material_id], [amount]) VALUES (N'1', N'1', CAST(20 AS Numeric(18, 0)))
INSERT [dbo].[position] ([box_id], [material_id], [amount]) VALUES (N'2', N'1', CAST(10 AS Numeric(18, 0)))
INSERT [dbo].[position] ([box_id], [material_id], [amount]) VALUES (N'3', N'2', CAST(100 AS Numeric(18, 0)))


/****** Object:  Table [dbo].[order]    Script Date: 04/16/2013 16:00:15 ******/
INSERT [dbo].[order] ([id], [dockId], [isUnloading], [toBeCleaned], [inProcess]) VALUES (N'1', N'testDock', 0, 0, 0)

/****** Object:  Table [dbo].[orderposition]    Script Date: 04/16/2013 16:00:15 ******/
SET IDENTITY_INSERT [dbo].[orderposition] ON
INSERT [dbo].[orderposition] ([id], [order_id], [material_id], [amount]) VALUES (1, N'1', N'1', CAST(1 AS Numeric(18, 0)))
INSERT [dbo].[orderposition] ([id], [order_id], [material_id], [amount]) VALUES (2, N'1', N'2', CAST(20 AS Numeric(18, 0)))
SET IDENTITY_INSERT [dbo].[orderposition] OFF

/****** Object:  Table [dbo].[orderpick]    Script Date: 04/24/2013 ******/
SET IDENTITY_INSERT [dbo].[orderpick] ON
INSERT [dbo].[orderpick] ([id], [oposition_id], [position_id], [amount], [inProcess]) VALUES (1, 1, 1, CAST(1 AS Numeric(18, 0)), 0)
INSERT [dbo].[orderpick] ([id], [oposition_id], [position_id], [amount], [inProcess]) VALUES (2, 1, 2, CAST(1 AS Numeric(18, 0)), 0)
INSERT [dbo].[orderpick] ([id], [oposition_id], [position_id], [amount], [inProcess]) VALUES (3, 2, 3, CAST(20 AS Numeric(18, 0)), 0)
SET IDENTITY_INSERT [dbo].[orderpick] OFF
