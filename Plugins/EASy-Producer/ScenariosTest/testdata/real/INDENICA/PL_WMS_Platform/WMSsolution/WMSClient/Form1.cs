// /////////////////////////////////////
// 
// © Siemens AG, 2012. All Rights Reserved
// 
// /////////////////////////////////////
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading;
using System.Windows.Forms;
using System.Xml;
using System.Xml.Linq;
using DataAccess;
using Monitoring;
using Spring.Context;
using Spring.Context.Support;
using Apache.NMS;
using Apache.NMS.Util;
using WMSClient.GeneralTransportServiceReference;
using ActiveMQMessaging;
using ACorns.WCF.DynamicClientProxy;
using WMSClient.GoodsInServiceReference;
using WMSClient.MaterialMgtServiceReference;
using WMSClient.RoutingServiceReference;
using WMSClient.StorageBinSearchServiceReference;
using WMSClient.TransportPlanningServiceReference;

namespace WMSClient
{
    public partial class Form1 : Form
    {
        const string QUEUE_UPDATE_SIMULATION = "UpdateSimulationTopic";
        const string BROKER = "tcp://localhost:61616";
        const string QUEUE_WMS_CALLS = "wmscalls";
        const string QUEUE_VSP_CALLS = "vspcalls";
        

        //private const string CREATE_BOX = "CREATE_BOX";

        private MessagePublisher updateSimPublisher;
        private MessagePublisher vspcallsPublisher;
        private MessageSubscriber wmscallsSubscriber;
        private MessagePublisher wmscallsPublisher;
        private readonly StringBuilder builder = new StringBuilder();
        private delegate void SetTextCallback(TextBox textBox, string text);

        public Form1()
        {
            InitializeComponent();
            RefreshTables();

            // create a new thread: workaround for the 10 Min invocation timeout
            //Thread t = new Thread(DummyInvocation);          
            //t.Start();
        }

        static void DummyInvocation()
        {
            while(true)
            {
                //Console.WriteLine("invocation!");
                IApplicationContext ctx = ContextRegistry.GetContext();
                IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
                List<Box> boxes = materialMgt.GetBoxes().ToList();
                Thread.Sleep(300000); // sllep 5 min 
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            try
            {
                this.updateSimPublisher = new MessagePublisher(QUEUE_UPDATE_SIMULATION, BROKER);

                this.vspcallsPublisher = new MessagePublisher(QUEUE_VSP_CALLS, BROKER);

                this.wmscallsPublisher = new MessagePublisher(QUEUE_WMS_CALLS, BROKER);
                this.wmscallsSubscriber = new MessageSubscriber(QUEUE_WMS_CALLS,BROKER);
                wmscallsSubscriber.OnMessageReceived += new MessageReceivedDelegate(subscriber_OnMessageReceived);

            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
                this.Close();
            }
        }

        // on receiving of mq messages
        void subscriber_OnMessageReceived(string message)
        {
            Console.WriteLine("message received from wmscalls:");
            Console.WriteLine(message);
            IApplicationContext ctx = ContextRegistry.GetContext();

            // TODO: hardcoded search for ready, change!
            if (message.Contains("ready"))
            {
                IMaterialMgtService materialMgt = (IMaterialMgtService) ctx.GetObject("materialMgtServiceObjectWSBinding");


                //parsing xml
                using (XmlReader reader = XmlReader.Create(new StringReader(message)))
                {
                    reader.Read();
                    XElement elem = XElement.Parse(message);
                    int numberOfBoxes = int.Parse(elem.Element("numberOfBoxes").Value);
                    bool toBeCleaned = Boolean.Parse(elem.Element("toBeCleaned").Value);


                    bool result = materialMgt.Ready(false, numberOfBoxes, toBeCleaned);
                    string msg1 = "<readyEvent><status>";
                    string msg2 = "</status></readyEvent>";
                    string msg = msg1 + result + msg2;

                    vspcallsPublisher.SendMessage(msg);
                    SetText(this.readyTextBox1, result.ToString());
                    Console.WriteLine("message send to vspcalls:");
                    Console.WriteLine(msg);
                }
            }

            if (message.Contains("processOrder"))
            {
                IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");


                //parsing xml
                using (XmlReader reader = XmlReader.Create(new StringReader(message)))
                {
                    reader.Read();
                    XElement elem = XElement.Parse(message);
                    string orderId = elem.Element("orderId").Value;
                    int numberOfBoxes = int.Parse(elem.Element("numberOfBoxes").Value);
                    string dockId = elem.Element("dockId").Value;
                    bool isUnloading = Boolean.Parse(elem.Element("isUnloading").Value);
                    bool toBeCleaned = Boolean.Parse(elem.Element("toBeCleaned").Value);

                    bool ready = materialMgt.Ready(false, numberOfBoxes, toBeCleaned);

                    SetText(this.orderIdTextBox3, orderId);
                    SetText(this.numberOfBoxesTextBox3, numberOfBoxes.ToString());
                    SetText(this.readyTextbox3, ready.ToString());

                    var dialogResult = MessageBox.Show("New Order was registered: " + orderId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    
                    if (ready)
                        materialMgt.ProcessOrder(orderId, dockId, isUnloading, toBeCleaned);
                    else
                        Console.WriteLine("could not process the order!!!");

                    // no reply to VSP. reply will be in the Finished Event!
                }
            }

        }

        private void SetText(TextBox textBox, string text)
        {
            // InvokeRequired required compares the thread ID of the 
            // calling thread to the thread ID of the creating thread. 
            // If these threads are different, it returns true. 
            if (textBox.InvokeRequired) //readyTextBox1
            {
                SetTextCallback d = new SetTextCallback(SetText);
                this.Invoke(d,  new object[] { textBox, text });
            }
            else
            {
                textBox.Text = text;
            }
        }

        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
            try
            {
                updateSimPublisher.Dispose();
                vspcallsPublisher.Dispose();
                wmscallsSubscriber.Dispose();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }

        private void Button2Click(object sender, EventArgs e)
        {
            string boxId = this.textBox0.Text;
            if (boxId != "")
            {
                // Getting Service Object from Spring
                IApplicationContext ctx = ContextRegistry.GetContext();
                IMaterialMgtService materialMgt =
                    (IMaterialMgtService) ctx.GetObject("materialMgtServiceObjectWSBinding");

                // Creating a new box
                if (materialMgt.CreateBox(boxId))
                {
                    RefreshTables();
                    // sends command to SimSite!
                    //MessagePublisher publisher = new MessagePublisher(TOPIC_UPDATE_SIMULATION, BROKER);
                    updateSimPublisher.SendMessage(ConstantsLibrary.Constants.CREATE_BOX + " " + boxId);
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not create the box with id=" + boxId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                
            } 
            else
            {
                var dialogResult = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            // cleaning the form
            this.textBox0.Text = "";
        }        

        private void Button3Click(object sender, EventArgs e)
        {
            string materialNumber = this.textBox2.Text;
            string name = this.textBox3.Text;
            string description = this.textBox4.Text;

            if (materialNumber != "" && name != "" && description != "")
            {

                // Getting Service Object from Spring
                IApplicationContext ctx = ContextRegistry.GetContext();
                //IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObject");
                IMaterialMgtService materialMgt =
                    (IMaterialMgtService) ctx.GetObject("materialMgtServiceObjectWSBinding");

                // Creating new material
                if (materialMgt.CreateMaterial(materialNumber, name, description))
                {
                    RefreshTables();
                    //this.publisher.SendMessage(CREATE_MATERIAL + " " + materialNumber);
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not create the material with materialNumber=" + materialNumber + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
            }
            else
            {
                var result = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            // clean the form
            this.textBox2.Text = "";
            this.textBox3.Text = "";
            this.textBox4.Text = "";

            this.updateSimPublisher.SendMessage("new material created: " + name);
        }

        private void RefreshTables()
        {
            // Getting Service Object from Spring
            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");

            List<Box> boxes = materialMgt.GetBoxes().ToList();
            List<Material> materials = materialMgt.GetMaterials().ToList();
            List<Position> positions = materialMgt.GetPositions().ToList();
            List<Location> locations = materialMgt.GetLocations().ToList();
            List<Locationtype> locationTypes = materialMgt.GetLocationTypes().ToList();
            List<Rack> racks = materialMgt.GetRacks().ToList();
            List<Order> orders = materialMgt.GetOrders().ToList();

            List<Transportentry> transportEntries = materialMgt.GetTransportentries().ToList();

            
            this.dataGridView1.DataSource = boxes;
            this.dataGridView2.DataSource = materials;
            this.dataGridView3.DataSource = positions;
            this.locationsDataGridView.DataSource = locations;
            this.transportEntriesDataGridView.DataSource = transportEntries;

            this.materialNumberComboBox1.DataSource = materials;
            this.materialNumberComboBox2.DataSource = materials;
            this.comboBox3.DataSource = materials;
            this.comboBox7.DataSource = materials;
            this.locationIdComboBox2.DataSource = locations;
            this.locationIdComboBox3.DataSource = locations;
            this.locationIdComboBox4.DataSource = locations;
            this.locationIdComboBox5.DataSource = locations;
            this.locationIdComboBox6.DataSource = locations;

            this.locationTypeComboBox1.DataSource = locationTypes;

            this.rackComboBox1.DataSource = racks;

            this.boxIdComboBox0.DataSource = boxes;
            this.boxIdComboBox1.DataSource = boxes;
            this.boxIdComboBox2.DataSource = boxes;
            this.boxIdComboBox3.DataSource = boxes;
            this.boxIdComboBox4.DataSource = boxes;
            this.boxIdComboBox5.DataSource = boxes;
            this.boxIdComboBox6.DataSource = boxes;
            this.comboBox_BinSearch_BoxId.DataSource = boxes;
            this.comboBox4.DataSource = materialMgt.GetBoxesOnRS();
            this.comboBox6.DataSource = materialMgt.GetBoxesOnRS();

            this.comboBox1.DataSource = boxes;
            this.comboBox2.DataSource = locations;
            this.transportEntryComboBox.DataSource = boxes;

            this.orderIdComboBox.DataSource = orders;

        }

        private void Button4Click(object sender, EventArgs e)
        {
            string boxId = "";
            string materialId = "";
            int amount = 0;
            try
            {
                amount = int.Parse(this.textBox7.Text);
            }
            catch(Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }

            if (this.boxIdComboBox1.SelectedItem != null && this.materialNumberComboBox2.SelectedItem != null && amount != 0)
            {
                boxId = this.boxIdComboBox1.Text;
                materialId = this.materialNumberComboBox2.Text;
                // Getting Service Object from Spring
                IApplicationContext ctx = ContextRegistry.GetContext();
                IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
                // inserting material
                
                if (materialMgt.InsertMaterial(boxId, materialId, amount))
                {
                    RefreshTables();
                    //this.publisher.SendMessage(INSERT_MATERIAL + " " + materialNumber);
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not insert the material!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                RefreshTables();
            }
            else
            {
                var result = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            
            // clean the form
            this.textBox7.Text = "";
            if (this.boxIdComboBox1.SelectedItem != null)
                this.boxIdComboBox1.SelectedIndex = 0;
            if (this.materialNumberComboBox2.SelectedItem != null)
                this.materialNumberComboBox2.SelectedIndex = 0;

            this.updateSimPublisher.SendMessage("new material inserted: boxid=" + boxId + " materialId=" + materialId);
        }

        private void Button5Click(object sender, EventArgs e)
        {
            string boxId = "";
            string materialNumber = "";
            int amount = 0;

            boxId = this.textBox8.Text;

            if (this.materialNumberComboBox1.SelectedItem != null)
                materialNumber = this.materialNumberComboBox1.Text;
            try
            {
                amount = int.Parse(this.textBox10.Text);
            } 
            catch(Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
            if (boxId != "" && materialNumber != "" && amount != 0)
            {
                // Getting Service Object from Spring
                IApplicationContext ctx = ContextRegistry.GetContext();
                IGoodsInService goodsInMgt = (IGoodsInService) ctx.GetObject("goodsInServiceObjectWSBinding");
                string locationId = null;
                locationId = goodsInMgt.RegisterBox(boxId, materialNumber, amount);
                if (locationId != "")
                    {
                        RefreshTables();
                        this.updateSimPublisher.SendMessage(ConstantsLibrary.Constants.CREATE_BOX + " " + boxId + " " + locationId);
                        var dialogResult = MessageBox.Show("Box registered. boxId = " + boxId + " locationId = " + locationId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    }
                    else
                    {
                        var dialogResult = MessageBox.Show("Could not register box with boxId = " + boxId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    }
                RefreshTables();
            }
            else
            {
                var result = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            // clean the form
            this.textBox8.Text = "";
            this.textBox10.Text = "";
            if (this.materialNumberComboBox1.SelectedItem != null)
                this.materialNumberComboBox1.SelectedIndex = 0;


            this.updateSimPublisher.SendMessage("new box created: " + boxId + " new material inserted: " + materialNumber);

        /**
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString(), ":)", MessageBoxButtons.OKCancel, MessageBoxIcon.Asterisk);
            }*/
        }

        private void SendActiveMqMessageClick(object sender, EventArgs e)
        {
            string uriString = "activemq:tcp://localhost:61616";
            Uri connecturi = new Uri(uriString);
            Console.WriteLine("About to connect to " + connecturi);

            // NOTE: ensure the nmsprovider-activemq.config file exists in the executable folder.
            IConnectionFactory factory = new NMSConnectionFactory(connecturi);

            try
            {
                using (IConnection connection = factory.CreateConnection())
                using (ISession session = connection.CreateSession())
                {

                    IDestination destination = SessionUtil.GetDestination(session, "queue://FOO.BAR");

                    using (IMessageProducer producer = session.CreateProducer(destination))
                    {
                        // Start the connection so that messages will be processed.
                        connection.Start();
                        //producer.Persistent = true;

                        // Send a message
                        ITextMessage request = session.CreateTextMessage(this.sentMessageTextBox.Text);
                        request.NMSCorrelationID = "abc";
                        request.Properties["NMSXGroupID"] = "messageID";
                        request.Properties["myHeader"] = "someHeader";

                        producer.Send(request);
                        this.sentMessageTextBox.Text = "";

                        this.numberOfMessagesTextBox.Text = (int.Parse(this.numberOfMessagesTextBox.Text) + 1).ToString();

                    }
                }
            }
            catch (NMSConnectionException)
            {
                MessageBox.Show("NMSConnectionException! Is activemq server running?", ":(", MessageBoxButtons.OKCancel, MessageBoxIcon.Asterisk);
                this.sentMessageTextBox.Text = "";
            }
        }

        private void ReceiveMqMessageClick(object sender, EventArgs e)
        {
            Uri connecturi = new Uri("activemq:tcp://localhost:61616");
            Console.WriteLine("About to connect to " + connecturi);

            // NOTE: ensure the nmsprovider-activemq.config file exists in the executable folder.
            IConnectionFactory factory = new NMSConnectionFactory(connecturi);

            try
            {
                using (IConnection connection = factory.CreateConnection())
                using (ISession session = connection.CreateSession())
                {

                    IDestination destination = SessionUtil.GetDestination(session, "queue://FOO.BAR");

                    // Create a consumer
                    using (IMessageConsumer consumer = session.CreateConsumer(destination))
                    {
                        // Start the connection so that messages will be processed.
                        connection.Start();

                        // Consume a message
                        ITextMessage message = consumer.Receive() as ITextMessage;
                        if (message == null)
                        {
                            this.receivedMessageTextBox.Text = "No message received!";
                        }
                        else
                        {
                            this.receivedMessageTextBox.Text = "received: " + message.Text;
                            this.numberOfMessagesTextBox.Text = (int.Parse(this.numberOfMessagesTextBox.Text) - 1).ToString();

                        }
                    }
                }
            }
            catch (NMSConnectionException)
            {
                MessageBox.Show("NMSConnectionException! Is activemq server running?", ":(", MessageBoxButtons.OKCancel, MessageBoxIcon.Asterisk);
                this.receivedMessageTextBox.Text = "";
            }
            
        }

        private void SimServerButton_Click(object sender, EventArgs e)
        {
            this.updateSimPublisher.SendMessage(this.simServerTextBox.Text);
            this.simServerTextBox.Text = "";

        }

        private void SearchNextFreeBinButton_Click(object sender, EventArgs e)
        {

            // Getting Service Object from Spring
            IApplicationContext ctx = ContextRegistry.GetContext();
            IStorageBinSearchService storageBinSearch =
                (IStorageBinSearchService)ctx.GetObject("storageBinSearchServiceObjectWSBinding");

            // search next free bin
            string boxId = this.comboBox_BinSearch_BoxId.Text;
            string freeBinId = storageBinSearch.SearchNextFreeBin(boxId);
            if (freeBinId != null)
                this.freeBinTextBox.Text = freeBinId;
            else
                this.freeBinTextBox.Text = "no free bins";
        }


        private void MoveButton_Click(object sender, EventArgs e)
        {
            // Getting Service Object from Spring
            IApplicationContext ctx = ContextRegistry.GetContext();
            /*
            IConveyorControlService ccsService =
                (IConveyorControlService)ctx.GetObject("CCSServiceObjectWSBinding");
            string boxId = this.textBox5.Text;
            string startLocation = this.textBox6.Text;
            string endLocation = this.textBox9.Text;

            ccsService.Transport(boxId, startLocation, endLocation);
            */
            Console.WriteLine("Calling Move in CCSMock ");
            // cleaning up);
            this.textBox5.Text = "";
            this.textBox11.Text = "";
            this.textBox6.Text = "";
            this.textBox9.Text = "";
        }

        private void StoreBoxButton2_Click(object sender, EventArgs e)
        {
            if (this.boxIdComboBox3.SelectedItem != null)
            {
                IApplicationContext ctx = ContextRegistry.GetContext();
                ITransportPlanningService transportPlanning =
                    (ITransportPlanningService)ctx.GetObject("transportPlanningServiceObjectWSBinding");

                string boxId = this.boxIdComboBox3.Text;
                string reservedBinId = transportPlanning.StoreBox(boxId);
                this.boxIdComboBox3.SelectedIndex = 0;
                RefreshTables();
                if (reservedBinId != "")
                {
                    // cleaning the form
                    this.boxIdComboBox3.SelectedIndex = 0;
                    RefreshTables();
                    var dialogResult = MessageBox.Show("BoxId = " + boxId + " storageBin = " + reservedBinId, "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not store the box with id " + boxId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
            }
            else
            {
                var dialogResult = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }

        private void GetNextDestButton_Click(object sender, EventArgs e)
        {
            IApplicationContext ctx = ContextRegistry.GetContext();
            IRoutingService routing =
                (IRoutingService)ctx.GetObject("routingServiceObjectWSBinding");
            string boxId = this.boxIdComboBox4.Text;
            string binId = this.locationIdComboBox5.Text;
            string locationId = routing.GetNextDestination(boxId, binId);
            Console.WriteLine("next destination = " + locationId);

            string displayText = "";
            if (locationId == "")
                displayText = "at the place";
            else if (locationId == null)
                displayText = "not yet possible";
            else
            {
                Context c = new Context();
                wmsdbEntities entities = c.GetWMSEntities();
                Location location = null;
                var query = from l in entities.Locations where l.id == locationId select l;
                var locations = query.ToList();
                location = locations.First();
                displayText = location.type + ":" + location.id;
            }

            this.textBox16.Text = displayText;
        }

        private void GetNextTransportMediumButton_Click(object sender, EventArgs e)
        {
            IApplicationContext ctx = ContextRegistry.GetContext();
            IRoutingService routing = (IRoutingService)ctx.GetObject("routingServiceObjectWSBinding");
            string boxId = this.boxIdComboBox5.Text;
            string transportMedium = routing.GetNextTransportMedium(boxId);

            string displayText = "";
            if (transportMedium == null)
                displayText = "smth went wrong";
            else
            {
                Context c = new Context();
                wmsdbEntities entities = c.GetWMSEntities();
                Location location = null;
                var query = from l in entities.Locations where l.id == transportMedium select l;
                var locations = query.ToList();
                location = locations.First();
                displayText = location.type + ":" + location.id;
            }

            Console.WriteLine("transportMedium = " + transportMedium);

            this.textBox18.Text = displayText;

        }

        private void CreateLocationButton_Click(object sender, EventArgs e)
        {
            string locId = this.textBox19.Text;
            string typeName = this.locationTypeComboBox1.Text;
            string rackName = this.rackComboBox1.Text;
            bool isReserved = this.checkBox1.Checked;

            // Getting Service Object from Spring
            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt =
                (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");

            string locationTypeId = materialMgt.GetLocationtypeIdByName(typeName);
            string rackId = materialMgt.GetRackIdByName(rackName);


            if (locId != "" && typeName != "")
            {
                

                // Creating a new location
                if (materialMgt.CreateLocation(locId, locationTypeId, rackId, isReserved))
                {
                    RefreshTables();
                    //this.publisher.SendMessage(CREATE_BOX + " " + boxId);
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not create the location with id=" + locId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }

            }
            else
            {
                var dialogResult = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            // cleaning the form
            this.textBox19.Text = "";
            this.locationTypeComboBox1.SelectedIndex = 0;
            this.rackComboBox1.SelectedIndex = 0;
            this.checkBox1.Checked = false;
        }

        private void ReserveBinButton_Click(object sender, EventArgs e)
        {
            if (this.locationIdComboBox2.SelectedItem != null)
            {
                string binId = this.locationIdComboBox2.Text;
                IApplicationContext ctx = ContextRegistry.GetContext();
                IMaterialMgtService materialMgt =
                        (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
            
                if (materialMgt.ReserveBin(binId))
                {
                    RefreshTables();
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not reserve bin the id " + binId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }

            }
            else
            {
                var dialogResult = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            // cleaning the form
            this.locationIdComboBox2.SelectedIndex = 0;
        }

        private void UnReserveBinButton_Click(object sender, EventArgs e)
        {
            if (this.locationIdComboBox3.SelectedItem != null)
            {
                string binId = this.locationIdComboBox2.Text;
                IApplicationContext ctx = ContextRegistry.GetContext();
                IMaterialMgtService materialMgt =
                        (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");

                if (materialMgt.UnReserveBin(binId))
                {
                    RefreshTables();
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not unreserve bin the id " + binId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }

            }
            else
            {
                var dialogResult = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            // cleaning the form
            this.locationIdComboBox2.SelectedIndex = 0;
        }

        private void SetLocationButton_Click(object sender, EventArgs e)
        {
            
            if (this.boxIdComboBox2.SelectedItem != null && this.locationIdComboBox4.SelectedItem != null)
            {
                string boxId = this.boxIdComboBox2.Text;
                string binId = this.locationIdComboBox4.Text;
                IApplicationContext ctx = ContextRegistry.GetContext();
                IMaterialMgtService materialMgt =
                        (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");

                if (materialMgt.SetLocation(boxId, binId))
                {
                    RefreshTables();
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not set location of the box with id = " + boxId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }

            }
            else
            {
                var dialogResult = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            // cleaning the form
            this.boxIdComboBox2.SelectedIndex = 0;
            this.locationIdComboBox4.SelectedIndex = 0;
        }

        private void GeneralTranportButton_Click(object sender, EventArgs e)
        {
            //TODO! aus dem spring context nehmen. nicht hier erzeugen! Workaroung für MessageSecurityException nach dem timeout
            DuplexChannelFactory<IGeneralTransportService> f = new DuplexChannelFactory<IGeneralTransportService>(new GeneralTransportCallbackHandler(), "WSDualHttpBinding_IGeneralTransportService");
            IGeneralTransportService s = f.CreateChannel();


            // TODO! WCF dynamic proxy: WCFClientProxy benutz nur ChannelFactory, keine DuplexChannelFactory
            // IGeneralTransportService service2 = WCFClientProxy<IGeneralTransportService>.GetReusableFaultUnwrappingInstance2(new GeneralTransportCallbackHandler(), "WSDualHttpBinding_IGeneralTransportService");
            //service2.InitiateTransport();
            
            
            string boxId = this.boxIdComboBox6.Text;
            string binId = this.locationIdComboBox6.Text;
            //IApplicationContext ctx = ContextRegistry.GetContext();
            //IGeneralTransportService generalTransport = (IGeneralTransportService)ctx.GetObject("generalTransportServiceObject");
            //generalTransport.InitiateTransport(boxId, binId);
            s.InitiateTransport(boxId, binId);

            RefreshTables();
            this.boxIdComboBox6.SelectedIndex = 0;
            this.locationIdComboBox6.SelectedIndex = 0;
        }

        private void refreshTablesButton_Click(object sender, EventArgs e)
        {
            RefreshTables();
        }

        private void updateSimulationButton_Click(object sender, EventArgs e)
        {
            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt =
                    (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");

            this.updateSimPublisher.SendMessage(ConstantsLibrary.Constants.RELOAD_SIMULATION);

        }

        private void createTransportEntryButton_Click(object sender, EventArgs e)
        {
            string boxId = this.comboBox1.Text;
            string binId = this.comboBox2.Text;
            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
            bool result = materialMgt.CreateTransportentry(boxId, binId);

            RefreshTables();
            //this.comboBox1.SelectedIndex = 0;
            //this.comboBox2.SelectedIndex = 0;
        }

        private void deleteTransportEntryButton_Click(object sender, EventArgs e)
        {
            string boxId = this.transportEntryComboBox.Text;
            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
            bool result = materialMgt.DeleteTransportentry(boxId);

            RefreshTables();
        }

        private void ReadyButton_Click(object sender, EventArgs e)
        {
            bool unloading = this.unloadingCheckBox.Checked;
            bool toBeCleaned = this.toBeCleanedCheckBox.Checked;
            int numberOfBoxes = int.Parse(this.numberOfBoxes.Text);
            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
            bool result = materialMgt.Ready(unloading, numberOfBoxes, toBeCleaned);

            this.readyTextBox2.Text = result.ToString();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string boxId = "";
            string materialNumber = "";
            int amount = 0;

            boxId = this.textBox12.Text;

            if (this.comboBox3.SelectedItem != null)
                materialNumber = this.comboBox3.Text;
            try
            {
                amount = int.Parse(this.textBox13.Text);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
            if (boxId != "" && materialNumber != "" && amount != 0)
            {
                // Getting Service Object from Spring
                IApplicationContext ctx = ContextRegistry.GetContext();
                IGoodsInService goodsInMgt = (IGoodsInService)ctx.GetObject("goodsInServiceObjectWSBinding");
                string locationId = null;
                locationId = goodsInMgt.RegisterBox(boxId, materialNumber, amount);
                if (locationId != "")
                {
                    RefreshTables();
                    this.updateSimPublisher.SendMessage(ConstantsLibrary.Constants.CREATE_BOX + " " + boxId + " " + locationId);
                    var dialogResult = MessageBox.Show("Box registered. boxId = " + boxId + " locationId = " + locationId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not register box with boxId = " + boxId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                RefreshTables();
            }
            else
            {
                var result = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            // clean the form
            this.textBox12.Text = "";
            this.textBox13.Text = "";
            if (this.comboBox3.SelectedItem != null)
                this.comboBox3.SelectedIndex = 0;


            //this.publisher.SendMessage("new box created: " + boxId + " new material inserted: " + materialNumber);
        }

        private void button6_Click(object sender, EventArgs e)
        {
            if (this.comboBox4.SelectedItem != null)
            {
                IApplicationContext ctx = ContextRegistry.GetContext();
                ITransportPlanningService transportPlanning =
                    (ITransportPlanningService)ctx.GetObject("transportPlanningServiceObjectWSBinding");

                string boxId = this.comboBox4.Text;
                string reservedBinId = transportPlanning.StoreBox(boxId);
                this.comboBox4.SelectedIndex = 0;
                RefreshTables();
                if (reservedBinId != "")
                {
                    // cleaning the form
                    this.comboBox4.SelectedIndex = 0;
                    RefreshTables();
                    var dialogResult = MessageBox.Show("BoxId = " + boxId + ", storageBin = " + reservedBinId + ". See SimSite for box movement :)", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not store the box with id " + boxId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
            }
            else
            {
                var dialogResult = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }

        private void finishedButton_Click(object sender, EventArgs e)
        {
            //bool toBeCleaned = this.toBeCleanedCheckBox2.Checked;
            if (this.orderIdComboBox.SelectedItem != null)
            {
                string orderId = this.orderIdComboBox.Text;

                IApplicationContext ctx = ContextRegistry.GetContext();
                IMaterialMgtService materialMgt =
                    (IMaterialMgtService) ctx.GetObject("materialMgtServiceObjectWSBinding");


                List<Order> orders = materialMgt.GetOrders().ToList();
                Order order = orders.Find(
                delegate(Order o)
                {
                    return o.orderId == orderId;
                }
                );
                if (order != null)
                {

                    // has to be done from materialMgt?? TODO
                    FinishedEvent ev = new FinishedEvent(orderId, order.dockId, order.isUnloading, order.toBeCleaned);
                    string eventAsString = Event.SerializeEvent(ev);

                    vspcallsPublisher.SendMessage(eventAsString);
                    Console.WriteLine("message sent to vspcalls:");
                    Console.WriteLine(eventAsString);
                    //var dialogResult = MessageBox.Show("Finished Event was sent to vspcalls", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);

                    // does delete the order
                    materialMgt.Finished(orderId);
                }
                else
                {
                    var dialogResult = MessageBox.Show("No order was found. orderId = " + orderId, "Warning", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                this.orderIdComboBox.SelectedItem = null;
                RefreshTables();
            }
        }

        private void recreateDatabaseButton_Click(object sender, EventArgs e)
        {
            /**
            // WCF dynamic proxy + SPRING
            // ?? TODO
            // SPRING tut:
            ChannelFactory<IMaterialMgtService> channelFac = new ChannelFactory<IMaterialMgtService>("WSHttpBinding_IMaterialMgtService");
            IMaterialMgtService service1 = channelFac.CreateChannel();
            List<Location> locs1 = service1.GetLocations();
            string s1 = locs1.ToString();

            // WCF dynamic proxy:
            IMaterialMgtService service2 = WCFClientProxy<IMaterialMgtService>.GetReusableFaultUnwrappingInstance("WSHttpBinding_IMaterialMgtService");
            List<Location> locs2 = service2.GetLocations();
            string s = locs2.ToString();
            */

            

            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
            // == CommunicationState.Faulted)
            string sqlConnString = @"user id=oxana;password=oxana;server=WINDOWS7-VM-1\SQLEXPRESS;Trusted_Connection=yes;database=wmsdb;";
            if (materialMgt.RecreateSampleDatabase(sqlConnString))
            {
                var dialogResult = MessageBox.Show("The sample database was recreated", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                RefreshTables();
                
                // updating the SimSite!!
                this.updateSimPublisher.SendMessage(ConstantsLibrary.Constants.RELOAD_SIMULATION);
            }
            else
            {
                var dialogResult = MessageBox.Show("Could NOT recreate the sample database", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
             
        }

        private void readyButton2_Click(object sender, EventArgs e)
        {
            try
            {
                int numberOfBoxes = int.Parse(this.numberOfBoxesTextBox.Text);
                bool unloading = this.unloadingCheckBox2.Checked;
                bool toBeCleaned = this.toBeCleanedCheckBox3.Checked;

                ReadyEvent ev = new ReadyEvent(numberOfBoxes, toBeCleaned);
                string eventAsString = Event.SerializeEvent(ev);


                wmscallsPublisher.SendMessage(eventAsString); // simulating Huys event! TODO delete!
                Console.WriteLine("message sent to wmscalls:");
                Console.WriteLine(eventAsString);

                this.readyTextBox1.Text = "msg sent";

                // calling directly!
                //IApplicationContext ctx = ContextRegistry.GetContext();
                //IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
                //bool result = materialMgt.Ready(unloading, numberOfBoxes, toBeCleaned););
                //this.readyTextBox1.Text = result.ToString();
            }
            catch (Exception ex)
            {
                var dialogResult = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            finally
            {

                // cleanup
                this.unloadingCheckBox2.Checked = false;
                this.toBeCleanedCheckBox3.Checked = false;
                this.numberOfBoxesTextBox.Text = "";
            }
        }

        private void processOrderButton_Click(object sender, EventArgs e)
        {
            if (this.orderIdTextBox1.Text != "" && this.dockIdTextBox.Text != "")
            {
                string orderId = this.orderIdTextBox1.Text;
                string dockId = this.dockIdTextBox.Text;
                bool isUnloading = this.isUnloadingCheckBox4.Checked;
                bool toBeCleaned = this.toBeCleanedCheckBox4.Checked;

                ProcessOrderEvent ev = new ProcessOrderEvent(orderId, dockId, isUnloading, toBeCleaned);
                string eventAsString = Event.SerializeEvent(ev);


                wmscallsPublisher.SendMessage(eventAsString); // simulating Huys event! TODO delete!
                Console.WriteLine("message sent to wmscalls:");
                Console.WriteLine(eventAsString);
            }
            else
            {
                var dialogResult = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            // cleanup
            this.isUnloadingCheckBox4.Checked = false;
            this.toBeCleanedCheckBox4.Checked = false;
            this.orderIdTextBox1.Text = "";
            this.dockIdTextBox.Text = "";
            RefreshTables();
        }

        private void deleteBoxButton_Click(object sender, EventArgs e)
        {
            string boxId = this.boxIdComboBox0.Text;
            if (boxId != "")
            {
                // Getting Service Object from Spring
                IApplicationContext ctx = ContextRegistry.GetContext();
                IMaterialMgtService materialMgt =
                    (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");

                // Creating a new box
                if (materialMgt.DeleteBox(boxId))
                {
                    RefreshTables();
                    // sends command to SimSite!
                    //MessagePublisher publisher = new MessagePublisher(TOPIC_UPDATE_SIMULATION, BROKER);
                    updateSimPublisher.SendMessage(ConstantsLibrary.Constants.RELOAD_SIMULATION);
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not delete the box with id=" + boxId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }

            }
            else
            {
                var dialogResult = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            // cleaning the form
            this.textBox0.Text = "";
        }

        private void button11_Click(object sender, EventArgs e)
        {
            string boxId = "";
            string materialNumber = "";
            string materialName = "";
            int amount = 0;

            boxId = textBox17.Text;

            if (this.comboBox7.SelectedItem != null)
                materialName = this.comboBox7.Text;
                materialNumber = this.comboBox7.SelectedValue.ToString();
            try
            {
                amount = int.Parse(this.textBox20.Text);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
            if (boxId != "" && materialNumber != "" && amount != 0)
            {
                // Getting Service Object from Spring
                IApplicationContext ctx = ContextRegistry.GetContext();
                IGoodsInService goodsInMgt = (IGoodsInService)ctx.GetObject("goodsInServiceObjectWSBinding");
                string locationId = null;
                locationId = goodsInMgt.RegisterBox(boxId, materialNumber, amount);
                if (locationId != "")
                {
                    RefreshTables();
                    this.updateSimPublisher.SendMessage(ConstantsLibrary.Constants.CREATE_BOX + " " + boxId + " " + locationId);
                    var dialogResult = MessageBox.Show("Box registered. boxId = " + boxId + " locationId = " + locationId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not register box with boxId = " + boxId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                RefreshTables();
            }
            else
            {
                var result = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            // clean the form
            this.textBox17.Text = "";
            this.textBox20.Text = "";
            if (this.comboBox7.SelectedItem != null)
                this.comboBox7.SelectedIndex = 0;
        }

        private void button10_Click(object sender, EventArgs e)
        {
            if (this.comboBox6.SelectedItem != null)
            {
                IApplicationContext ctx = ContextRegistry.GetContext();
                ITransportPlanningService transportPlanning =
                    (ITransportPlanningService)ctx.GetObject("transportPlanningServiceObjectWSBinding");

                string boxId = this.comboBox6.Text;
                string reservedBinId = transportPlanning.StoreBox(boxId);
                this.comboBox6.SelectedIndex = 0;
                RefreshTables();
                if (reservedBinId != "")
                {
                    // cleaning the form
                    this.comboBox6.SelectedIndex = 0;
                    RefreshTables();
                    var dialogResult = MessageBox.Show("BoxId = " + boxId + ", storageBin = " + reservedBinId + ". See SimSite for box movement :)", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                else
                {
                    var dialogResult = MessageBox.Show("Could not store the box with id " + boxId + "!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
            }
            else
            {
                var dialogResult = MessageBox.Show("Please fill in the form correctly", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }

        private void button9_Click(object sender, EventArgs e)
        {
            //bool toBeCleaned = this.toBeCleanedCheckBox2.Checked;
            if (this.orderIdTextBox3.Text != "")
            {
                string orderId = this.orderIdTextBox3.Text;

                IApplicationContext ctx = ContextRegistry.GetContext();
                IMaterialMgtService materialMgt =
                    (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");


                List<Order> orders = materialMgt.GetOrders().ToList();
                Order order = orders.Find(
                delegate(Order o)
                {
                    return o.orderId == orderId;
                }
                );
                if (order != null)
                {

                    // has to be done from materialMgt?? TODO
                    FinishedEvent ev = new FinishedEvent(orderId, order.dockId, order.isUnloading, order.toBeCleaned);
                    string eventAsString = Event.SerializeEvent(ev);

                    vspcallsPublisher.SendMessage(eventAsString);
                    Console.WriteLine("message sent to vspcalls:");
                    Console.WriteLine(eventAsString);
                    //var dialogResult = MessageBox.Show("Finished Event was sent to vspcalls", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);

                    // does delete the order
                    materialMgt.Finished(orderId);
                }
                else
                {
                    var dialogResult = MessageBox.Show("No order was found. orderId = " + orderId, "Warning", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                

                // clean
                SetText(this.orderIdTextBox3, "");
                SetText(this.numberOfBoxesTextBox3, "");
                SetText(this.readyTextbox3, "");
                
                RefreshTables();
            }
            else
            {
                var dialogResult = MessageBox.Show("No current order", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }

    }
}