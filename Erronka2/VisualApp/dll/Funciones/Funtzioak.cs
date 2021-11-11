using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Funciones
{
    public partial class Funtzioak : UserControl
    {
        public Funtzioak()
        {
            InitializeComponent();
            
        }

        public string getproduktuKantitatea() {
            produktuaTableAdapter.Fill(this.patosDeGomaDataSet.Produktua);
           return this.produktuaTableAdapter.ProduktuaQuery() +"";

        }

        public string getBezeroKopurua() {
            bezeroaTableAdapter.Fill(this.patosDeGomaDataSet.Bezeroa);
            return this.bezeroaTableAdapter.BezeroQuery()+"";

        }

        public string getErosketaKopurua() {
            erosketaTableAdapter.Fill(this.patosDeGomaDataSet.Erosketa);
            return this.erosketaTableAdapter.EroskeraKopQuery() + "";
        }

        public string getHerrialdeKopurua() {
            bezeroaTableAdapter.Fill(this.patosDeGomaDataSet.Bezeroa);
            return this.bezeroaTableAdapter.HerrialdeaQuery() + "";
        }

    }
}
