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
    public partial class ProduktuSalduenak : Form
    {
        ProduktuSalduenaDataSet produktuSalduenakDataSet1 = new ProduktuSalduenaDataSet();
        ProduktuSalduenaDataSetTableAdapters.ProduktuBistaTableAdapter produktuBistaTableAdapter = new ProduktuSalduenaDataSetTableAdapters.ProduktuBistaTableAdapter();


        public ProduktuSalduenak()
        {
            InitializeComponent();


            this.FormBorderStyle = FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MenuNagusia menuNagusia = new MenuNagusia();
            menuNagusia.Show();
            this.Close();
        }

        private void ProduktuSalduenak_Load(object sender, EventArgs e)
        {



            this.produktuBistaTableAdapter.Fill(this.produktuSalduenakDataSet1.ProduktuBista);

            ProduktuChart.DataSource = this.produktuBistaTableAdapter.GetDataBy().Select().Take(9);

            ProduktuChart.Series[0].YValueMembers = "zenbat";
            ProduktuChart.Series[0].XValueMember = "name";
            ProduktuChart.DataBind();





        }

        private void KategoriazFiltratu(object sender, EventArgs e)
        {
            if (checkBox1.Checked == true)
            {
                this.produktuBistaTableAdapter.Fill(this.produktuSalduenakDataSet1.ProduktuBista);

                ProduktuChart.DataSource = this.produktuBistaTableAdapter.GetDataByCat().Select().Take(9);

                ProduktuChart.Series[0].YValueMembers = "zenbat";
                ProduktuChart.Series[0].XValueMember = "categoria";
                ProduktuChart.DataBind();
            }
            else
            {
                this.produktuBistaTableAdapter.Fill(this.produktuSalduenakDataSet1.ProduktuBista);

                ProduktuChart.DataSource = this.produktuBistaTableAdapter.GetDataBy().Select().Take(9);

                ProduktuChart.Series[0].YValueMembers = "zenbat";
                ProduktuChart.Series[0].XValueMember = "name";
                ProduktuChart.DataBind();
            }
        }
    }
}
