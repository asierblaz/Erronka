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
    public partial class Herrialdeak : Form
    {
        HerrialdeakDataSet herrialdeakDataSet = new HerrialdeakDataSet();
        HerrialdeakDataSetTableAdapters.HerrialdeBistaTableAdapter herrialdeBistaTableAdapter = new HerrialdeakDataSetTableAdapters.HerrialdeBistaTableAdapter();

        Funtzioak funtzio = new Funtzioak();

        public Herrialdeak()
        {
            InitializeComponent();

            this.FormBorderStyle = FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;

        }

        private void Herrialdeak_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'herrialdeakDataSet2.HerrialdeBista' Puede moverla o quitarla según sea necesario.
            this.herrialdeBistaTableAdapter1.Fill(this.herrialdeakDataSet2.HerrialdeBista);
            this.herrialdeBistaTableAdapter.Fill(this.herrialdeakDataSet.HerrialdeBista);

            HerrialdeChart.DataSource = this.herrialdeBistaTableAdapter.GetDataBy().Select();

            HerrialdeChart.Series[0].YValueMembers = "zenbat";
            HerrialdeChart.Series[0].XValueMember = "herrialdea";
            HerrialdeChart.DataBind();

            float ezezagunPortzentaia = (float.Parse(this.herrialdeBistaTableAdapter.FillByEzezaguna().ToString())  * 100) / float.Parse(funtzio.getErosketaKopurua());

            EzezagunakKant.Text = Math.Round(ezezagunPortzentaia,2) + "% erosketa herrialde ezezagunetatik egin dira";
            ErosketaKopurua.Text = "Erosketa Kopurua: " + funtzio.getErosketaKopurua();
          



            //DataSourceUpdateMode


        }

        private void button1_Click(object sender, EventArgs e)
        {
            MenuNagusia menuNagusia = new MenuNagusia();
            menuNagusia.Show();
            this.Close();
        }

    }
}
