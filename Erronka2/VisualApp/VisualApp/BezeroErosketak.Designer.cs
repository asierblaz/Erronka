
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
            this.BezeroChart = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.label1 = new System.Windows.Forms.Label();
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
            this.groupBox1.Controls.Add(this.BezeroChart);
            this.groupBox1.Location = new System.Drawing.Point(158, 77);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(593, 394);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            // 
            // ZematErakutsi
            // 
            this.ZematErakutsi.Location = new System.Drawing.Point(425, 8);
            this.ZematErakutsi.Maximum = new decimal(new int[] {
            9,
            0,
            0,
            0});
            this.ZematErakutsi.Name = "ZematErakutsi";
            this.ZematErakutsi.Size = new System.Drawing.Size(120, 20);
            this.ZematErakutsi.TabIndex = 1;
            this.ZematErakutsi.Value = new decimal(new int[] {
            9,
            0,
            0,
            0});
            this.ZematErakutsi.ValueChanged += new System.EventHandler(this.ZematErakutsi_ValueChanged);
            // 
            // BezeroChart
            // 
            this.BezeroChart.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            chartArea1.BackImageAlignment = System.Windows.Forms.DataVisualization.Charting.ChartImageAlignmentStyle.Center;
            chartArea1.Name = "BezeroChart";
            this.BezeroChart.ChartAreas.Add(chartArea1);
            this.BezeroChart.Location = new System.Drawing.Point(0, 34);
            this.BezeroChart.Name = "BezeroChart";
            series1.ChartArea = "BezeroChart";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Bar;
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            series1.Palette = System.Windows.Forms.DataVisualization.Charting.ChartColorPalette.BrightPastel;
            this.BezeroChart.Series.Add(series1);
            this.BezeroChart.Size = new System.Drawing.Size(593, 386);
            this.BezeroChart.TabIndex = 0;
            this.BezeroChart.Text = "chart1";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(580, 61);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(142, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Erakusten ari diren bezeroak";
            // 
            // BezeroErosketak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(899, 598);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.button1);
            this.ForeColor = System.Drawing.SystemColors.ControlText;
            this.Name = "BezeroErosketak";
            this.Text = "BezeroErosketak";
            this.Load += new System.EventHandler(this.BezeroErosketak_Load);
            this.groupBox1.ResumeLayout(false);
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
    }
}

