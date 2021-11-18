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
        Image batJoanImg;
        Image biJoanImg;
        Image hiruJoanImg;

        String batJoanText = "Gehien erosten duten bezeroak";
        String biJoanText = "Produktu Salduenak";
        String hiruJoanText = "Gehien erosten duten herrialdeak";

        public MenuNagusia()
        {
            InitializeComponent();
            this.FormBorderStyle = FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;


            batJoan.MouseEnter += OnMouseEnterBat;
            batJoan.MouseLeave += OnMouseLeaveBat;

            biJoan.MouseEnter += OnMouseEnterBi;
            biJoan.MouseLeave += OnMouseLeaveBi;

            hiruJoan.MouseEnter += OnMouseEnterHiru;
            hiruJoan.MouseLeave += OnMouseLeaveHiru;

            batJoanImg = batJoan.Image;
            biJoanImg = biJoan.Image;
            hiruJoanImg = hiruJoan.Image;
        }
        private void OnMouseEnterBat(object sender, EventArgs e)
        {
            batJoan.Image = null;
            batJoan.Text = batJoanText;
        }
        private void OnMouseLeaveBat(object sender, EventArgs e)
        {
            batJoan.Image = batJoanImg;
            batJoan.Text = null;
        }

        private void OnMouseEnterBi(object sender, EventArgs e)
        {
            biJoan.Image = null;
            biJoan.Text = biJoanText;
        }
        private void OnMouseLeaveBi(object sender, EventArgs e)
        {
            biJoan.Image = biJoanImg;
            biJoan.Text = null;
        }

        private void OnMouseEnterHiru(object sender, EventArgs e)
        {
            hiruJoan.Image = null;
            hiruJoan.Text = hiruJoanText;
        }
        private void OnMouseLeaveHiru(object sender, EventArgs e)
        {
            hiruJoan.Image = hiruJoanImg;
            hiruJoan.Text = null;
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
        private void Form_Close(object sender, System.EventArgs e)
        {
            System.Windows.Forms.Application.Exit();
        }

        private void MenuNagusia_Load(object sender, EventArgs e)
        {

        }
    }
}
