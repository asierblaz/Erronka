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
    public partial class MenuNagusia : Form
    {

        public MenuNagusia()
        {
            InitializeComponent();
            this.FormBorderStyle = FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
        }

        private void batJoan_Click(object sender, EventArgs e)
        {
            BezeroErosketak bat = new BezeroErosketak();
            bat.Show();
            this.Hide();
        }

        private void biJoan_Click(object sender, EventArgs e)
        {
            ProduktuSalduenak bi = new ProduktuSalduenak();
            bi.Show();
            this.Hide();
        }

        private void hiruJoan_Click(object sender, EventArgs e)
        {
            Herrialdeak hiru = new Herrialdeak();
            hiru.Show();
            this.Hide();
        }


    }
}
