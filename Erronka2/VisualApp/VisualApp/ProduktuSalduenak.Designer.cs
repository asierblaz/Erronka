
namespace VisualApp
{
    partial class ProduktuSalduenak
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(ProduktuSalduenak));
            this.button1 = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.ProduktuChart = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.produktuSalduenakDataSet = new VisualApp.ProduktuSalduenaDataSet();
            this.checkBox1 = new System.Windows.Forms.CheckBox();
            this.tituloLabel = new System.Windows.Forms.Label();
            this.ProduktuKopurua = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ProduktuChart)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.produktuSalduenakDataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Font = new System.Drawing.Font("Microsoft YaHei UI", 48F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button1.Location = new System.Drawing.Point(12, 470);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(94, 91);
            this.button1.TabIndex = 0;
            this.button1.Text = "<";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.SystemColors.HighlightText;
            this.groupBox1.Controls.Add(this.ProduktuChart);
            this.groupBox1.Location = new System.Drawing.Point(168, 145);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(593, 394);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            // 
            // ProduktuChart
            // 
            this.ProduktuChart.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            chartArea1.BackImageAlignment = System.Windows.Forms.DataVisualization.Charting.ChartImageAlignmentStyle.Center;
            chartArea1.Name = "BezeroaChart";
            this.ProduktuChart.ChartAreas.Add(chartArea1);
            this.ProduktuChart.Location = new System.Drawing.Point(0, 8);
            this.ProduktuChart.Name = "ProduktuChart";
            this.ProduktuChart.Palette = System.Windows.Forms.DataVisualization.Charting.ChartColorPalette.None;
            series1.ChartArea = "BezeroaChart";
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            series1.Palette = System.Windows.Forms.DataVisualization.Charting.ChartColorPalette.Fire;
            this.ProduktuChart.Series.Add(series1);
            this.ProduktuChart.Size = new System.Drawing.Size(593, 386);
            this.ProduktuChart.TabIndex = 0;
            this.ProduktuChart.Text = "chart1";
            // 
            // produktuSalduenakDataSet
            // 
            this.produktuSalduenakDataSet.DataSetName = "ProduktuSalduenakDataSet";
            this.produktuSalduenakDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // checkBox1
            // 
            this.checkBox1.AutoSize = true;
            this.checkBox1.BackColor = System.Drawing.Color.Transparent;
            this.checkBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.checkBox1.Location = new System.Drawing.Point(600, 119);
            this.checkBox1.Name = "checkBox1";
            this.checkBox1.Size = new System.Drawing.Size(177, 28);
            this.checkBox1.TabIndex = 3;
            this.checkBox1.Text = "Kategoriaz Filtratu";
            this.checkBox1.UseVisualStyleBackColor = false;
            this.checkBox1.CheckedChanged += new System.EventHandler(this.KategoriazFiltratu);
            // 
            // tituloLabel
            // 
            this.tituloLabel.AutoSize = true;
            this.tituloLabel.BackColor = System.Drawing.Color.Transparent;
            this.tituloLabel.Font = new System.Drawing.Font("Courier New", 27.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tituloLabel.Location = new System.Drawing.Point(268, 28);
            this.tituloLabel.Name = "tituloLabel";
            this.tituloLabel.Size = new System.Drawing.Size(414, 41);
            this.tituloLabel.TabIndex = 8;
            this.tituloLabel.Text = "Produktu Salduenak";
            // 
            // ProduktuKopurua
            // 
            this.ProduktuKopurua.AutoSize = true;
            this.ProduktuKopurua.BackColor = System.Drawing.SystemColors.Window;
            this.ProduktuKopurua.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ProduktuKopurua.Location = new System.Drawing.Point(48, 123);
            this.ProduktuKopurua.Name = "ProduktuKopurua";
            this.ProduktuKopurua.Size = new System.Drawing.Size(182, 24);
            this.ProduktuKopurua.TabIndex = 9;
            this.ProduktuKopurua.Text = "Produktu Kopurua: 8";
            // 
            // ProduktuSalduenak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(899, 598);
            this.Controls.Add(this.ProduktuKopurua);
            this.Controls.Add(this.tituloLabel);
            this.Controls.Add(this.checkBox1);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.button1);
            this.ForeColor = System.Drawing.SystemColors.ControlText;
            this.Name = "ProduktuSalduenak";
            this.Text = "Bat";
            this.Load += new System.EventHandler(this.ProduktuSalduenak_Load);
            this.groupBox1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.ProduktuChart)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.produktuSalduenakDataSet)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.GroupBox groupBox1;

        private System.Windows.Forms.DataVisualization.Charting.Chart ProduktuChart;
        private ProduktuSalduenaDataSet produktuSalduenakDataSet;
        private System.Windows.Forms.CheckBox checkBox1;
        private System.Windows.Forms.Label tituloLabel;
        private System.Windows.Forms.Label ProduktuKopurua;
    }
}

