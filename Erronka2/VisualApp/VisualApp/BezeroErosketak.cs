using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Funciones;
namespace VisualApp
{
    public partial class BezeroErosketak : Form
    {
        BezeroErosketakDataSet bezeroErosketakDataSet = new BezeroErosketakDataSet();
        BezeroErosketakDataSetTableAdapters.BezeroBistaTableAdapter bezeroBistaTableAdapter = new BezeroErosketakDataSetTableAdapters.BezeroBistaTableAdapter();

        Funtzioak f = new Funtzioak();

        public BezeroErosketak()
        {
            InitializeComponent();


            this.FormBorderStyle = FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            ErosketaKopurua.Text = "Erosketa Kopurua: " + f.getErosketaKopurua();
            BezeroKopurua.Text = "Bezero Kopurua: " + f.getBezeroKopurua();
        }

        private void BezeroErosketak_Load(object sender, EventArgs e)
        {



            this.bezeroBistaTableAdapter.Fill(this.bezeroErosketakDataSet.BezeroBista);

            BezeroChart.DataSource = this.bezeroBistaTableAdapter.GetDataBy().Select().Take(9);

            BezeroChart.Series[0].YValueMembers = "zenbat";
            BezeroChart.Series[0].XValueMember = "izena";
            BezeroChart.DataBind();




        }

        private void Form_Close(object sender, System.EventArgs e)
        {
            MenuNagusia menuNagusia = new MenuNagusia();
            menuNagusia.Show();
        }


        private void ZematErakutsi_ValueChanged(object sender, EventArgs e)
        {
            int erakutsiBalio = (int)ZematErakutsi.Value;

            this.bezeroBistaTableAdapter.Fill(this.bezeroErosketakDataSet.BezeroBista);

            BezeroChart.DataSource = this.bezeroBistaTableAdapter.GetDataBy().Select().Take(erakutsiBalio);

            BezeroChart.Series[0].YValueMembers = "zenbat";
            BezeroChart.Series[0].XValueMember = "izena";
            BezeroChart.DataBind();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            this.Close();

        }
    }
}
