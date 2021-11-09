using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace VisualApp
{
    public partial class Herrialdeak : Form
    {
        HerrialdeakDataSet herrialdeakDataSet = new HerrialdeakDataSet();
        HerrialdeakDataSetTableAdapters.HerrialdeBistaTableAdapter herrialdeBistaTableAdapter = new HerrialdeakDataSetTableAdapters.HerrialdeBistaTableAdapter();
        public Herrialdeak()
        {
            InitializeComponent();

            this.FormBorderStyle = FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
        }

        private void Herrialdeak_Load(object sender, EventArgs e)
        {
            this.herrialdeBistaTableAdapter.Fill(this.herrialdeakDataSet.HerrialdeBista);

            HerrialdeChart.DataSource = this.herrialdeBistaTableAdapter.GetDataBy().Select().Take(9).Skip(1);

            HerrialdeChart.Series[0].YValueMembers = "zenbat";
            HerrialdeChart.Series[0].XValueMember = "herrialdea";
            HerrialdeChart.DataBind();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MenuNagusia menuNagusia = new MenuNagusia();
            menuNagusia.Show();
            this.Close();
        }
    }
}
