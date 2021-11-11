
namespace VisualApp
{
    partial class BezeroErosketak
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(BezeroErosketak));
            this.button1 = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.ZematErakutsi = new System.Windows.Forms.NumericUpDown();
            this.label1 = new System.Windows.Forms.Label();
            this.BezeroChart = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.tituloLabel = new System.Windows.Forms.Label();
            this.ErosketaKopurua = new System.Windows.Forms.Label();
            this.BezeroKopurua = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ZematErakutsi)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.BezeroChart)).BeginInit();
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
            this.groupBox1.Controls.Add(this.ZematErakutsi);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.BezeroChart);
            this.groupBox1.Location = new System.Drawing.Point(160, 164);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(597, 384);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            // 
            // ZematErakutsi
            // 
            this.ZematErakutsi.Location = new System.Drawing.Point(413, 16);
            this.ZematErakutsi.Maximum = new decimal(new int[] {
            9,
            0,
            0,
            0});
            this.ZematErakutsi.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.ZematErakutsi.Name = "ZematErakutsi";
            this.ZematErakutsi.Size = new System.Drawing.Size(154, 20);
            this.ZematErakutsi.TabIndex = 1;
            this.ZematErakutsi.Value = new decimal(new int[] {
            9,
            0,
            0,
            0});
            this.ZematErakutsi.ValueChanged += new System.EventHandler(this.ZematErakutsi_ValueChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.SystemColors.Window;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(42, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(310, 24);
            this.label1.TabIndex = 2;
            this.label1.Text = "Erakusten ari diren bezero kopurua:";
            // 
            // BezeroChart
            // 
            this.BezeroChart.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            chartArea1.BackImageAlignment = System.Windows.Forms.DataVisualization.Charting.ChartImageAlignmentStyle.Center;
            chartArea1.Name = "BezeroChart";
            this.BezeroChart.ChartAreas.Add(chartArea1);
            this.BezeroChart.Location = new System.Drawing.Point(0, 24);
            this.BezeroChart.Name = "BezeroChart";
            this.BezeroChart.Palette = System.Windows.Forms.DataVisualization.Charting.ChartColorPalette.None;
            this.BezeroChart.PaletteCustomColors = new System.Drawing.Color[] {
        System.Drawing.Color.Goldenrod};
            series1.ChartArea = "BezeroChart";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Bar;
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            this.BezeroChart.Series.Add(series1);
            this.BezeroChart.Size = new System.Drawing.Size(597, 376);
            this.BezeroChart.TabIndex = 0;
            this.BezeroChart.Text = "chart1";
            // 
            // tituloLabel
            // 
            this.tituloLabel.AutoSize = true;
            this.tituloLabel.BackColor = System.Drawing.Color.Transparent;
            this.tituloLabel.Font = new System.Drawing.Font("Courier New", 27.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tituloLabel.Location = new System.Drawing.Point(83, 48);
            this.tituloLabel.Name = "tituloLabel";
            this.tituloLabel.Size = new System.Drawing.Size(656, 41);
            this.tituloLabel.TabIndex = 7;
            this.tituloLabel.Text = "Gehien erosten duten bezeroak";
            // 
            // ErosketaKopurua
            // 
            this.ErosketaKopurua.AutoSize = true;
            this.ErosketaKopurua.BackColor = System.Drawing.SystemColors.Window;
            this.ErosketaKopurua.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ErosketaKopurua.Location = new System.Drawing.Point(8, 128);
            this.ErosketaKopurua.Name = "ErosketaKopurua";
            this.ErosketaKopurua.Size = new System.Drawing.Size(180, 24);
            this.ErosketaKopurua.TabIndex = 3;
            this.ErosketaKopurua.Text = "Erosketa Kopurua: 8";
            // 
            // BezeroKopurua
            // 
            this.BezeroKopurua.AutoSize = true;
            this.BezeroKopurua.BackColor = System.Drawing.SystemColors.Window;
            this.BezeroKopurua.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BezeroKopurua.Location = new System.Drawing.Point(8, 164);
            this.BezeroKopurua.Name = "BezeroKopurua";
            this.BezeroKopurua.Size = new System.Drawing.Size(177, 24);
            this.BezeroKopurua.TabIndex = 4;
            this.BezeroKopurua.Text = "Bezero Kopurua: 10";
            // 
            // BezeroErosketak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(899, 598);
            this.Controls.Add(this.BezeroKopurua);
            this.Controls.Add(this.tituloLabel);
            this.Controls.Add(this.ErosketaKopurua);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.button1);
            this.ForeColor = System.Drawing.SystemColors.ControlText;
            this.Name = "BezeroErosketak";
            this.Text = "BezeroErosketak";
            this.Load += new System.EventHandler(this.BezeroErosketak_Load);
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Form_Close);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ZematErakutsi)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.BezeroChart)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.GroupBox groupBox1;

        private System.Windows.Forms.DataVisualization.Charting.Chart BezeroChart;
        private System.Windows.Forms.NumericUpDown ZematErakutsi;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label tituloLabel;
        private System.Windows.Forms.Label ErosketaKopurua;
        private System.Windows.Forms.Label BezeroKopurua;
    }
}

