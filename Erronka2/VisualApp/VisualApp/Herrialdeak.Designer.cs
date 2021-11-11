
namespace VisualApp
{
    partial class Herrialdeak
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Herrialdeak));
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.HerrialdeChart = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.herrialdeakDataSet1BindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.herrialdeakDataSet1 = new VisualApp.HerrialdeakDataSet();
            this.herrialdeBistaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.herrialdeakDataSet2 = new VisualApp.HerrialdeakDataSet();
            this.herrialdeBistaTableAdapter1 = new VisualApp.HerrialdeakDataSetTableAdapters.HerrialdeBistaTableAdapter();
            this.EzezagunakKant = new System.Windows.Forms.Label();
            this.ErosketaKopurua = new System.Windows.Forms.Label();
            this.tituloLabel = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.HerrialdeChart)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.herrialdeakDataSet1BindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.herrialdeakDataSet1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.herrialdeBistaBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.herrialdeakDataSet2)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.SystemColors.HighlightText;
            this.groupBox1.Controls.Add(this.HerrialdeChart);
            this.groupBox1.Location = new System.Drawing.Point(147, 129);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(577, 393);
            this.groupBox1.TabIndex = 2;
            this.groupBox1.TabStop = false;
            // 
            // HerrialdeChart
            // 
            this.HerrialdeChart.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            chartArea1.Area3DStyle.Enable3D = true;
            chartArea1.Area3DStyle.Inclination = 40;
            chartArea1.Area3DStyle.LightStyle = System.Windows.Forms.DataVisualization.Charting.LightStyle.Realistic;
            chartArea1.BackImageAlignment = System.Windows.Forms.DataVisualization.Charting.ChartImageAlignmentStyle.Center;
            chartArea1.Name = "HerrialdeChart";
            this.HerrialdeChart.ChartAreas.Add(chartArea1);
            this.HerrialdeChart.Cursor = System.Windows.Forms.Cursors.Default;
            this.HerrialdeChart.Location = new System.Drawing.Point(-6, 19);
            this.HerrialdeChart.Name = "HerrialdeChart";
            this.HerrialdeChart.Palette = System.Windows.Forms.DataVisualization.Charting.ChartColorPalette.Chocolate;
            series1.ChartArea = "HerrialdeChart";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Pie;
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            this.HerrialdeChart.Series.Add(series1);
            this.HerrialdeChart.Size = new System.Drawing.Size(577, 374);
            this.HerrialdeChart.TabIndex = 0;
            this.HerrialdeChart.Text = "chart1";
            // 
            // herrialdeakDataSet1BindingSource
            // 
            this.herrialdeakDataSet1BindingSource.DataSource = this.herrialdeakDataSet1;
            this.herrialdeakDataSet1BindingSource.Position = 0;
            // 
            // herrialdeakDataSet1
            // 
            this.herrialdeakDataSet1.DataSetName = "HerrialdeakDataSet";
            this.herrialdeakDataSet1.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // herrialdeBistaBindingSource
            // 
            this.herrialdeBistaBindingSource.DataMember = "HerrialdeBista";
            this.herrialdeBistaBindingSource.DataSource = this.herrialdeakDataSet2;
            // 
            // herrialdeakDataSet2
            // 
            this.herrialdeakDataSet2.DataSetName = "HerrialdeakDataSet";
            this.herrialdeakDataSet2.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // herrialdeBistaTableAdapter1
            // 
            this.herrialdeBistaTableAdapter1.ClearBeforeFill = true;
            // 
            // EzezagunakKant
            // 
            this.EzezagunakKant.AutoSize = true;
            this.EzezagunakKant.BackColor = System.Drawing.Color.White;
            this.EzezagunakKant.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.EzezagunakKant.Location = new System.Drawing.Point(142, 525);
            this.EzezagunakKant.Name = "EzezagunakKant";
            this.EzezagunakKant.Size = new System.Drawing.Size(481, 25);
            this.EzezagunakKant.TabIndex = 4;
            this.EzezagunakKant.Text = "14 % erosketa herrialde ezezagunetatik egin dira";
            // 
            // ErosketaKopurua
            // 
            this.ErosketaKopurua.AutoSize = true;
            this.ErosketaKopurua.BackColor = System.Drawing.Color.White;
            this.ErosketaKopurua.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ErosketaKopurua.Location = new System.Drawing.Point(660, 193);
            this.ErosketaKopurua.Name = "ErosketaKopurua";
            this.ErosketaKopurua.Size = new System.Drawing.Size(208, 25);
            this.ErosketaKopurua.TabIndex = 5;
            this.ErosketaKopurua.Text = "Erosketa Kopurua: 5";
            // 
            // tituloLabel
            // 
            this.tituloLabel.AutoSize = true;
            this.tituloLabel.BackColor = System.Drawing.SystemColors.Window;
            this.tituloLabel.Font = new System.Drawing.Font("Courier New", 27.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tituloLabel.Location = new System.Drawing.Point(86, 66);
            this.tituloLabel.Name = "tituloLabel";
            this.tituloLabel.Size = new System.Drawing.Size(722, 41);
            this.tituloLabel.TabIndex = 6;
            this.tituloLabel.Text = "Gehien erosten duten herrialdeak";
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.Color.Transparent;
            this.button1.FlatAppearance.BorderSize = 0;
            this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button1.Font = new System.Drawing.Font("Microsoft YaHei UI", 48F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button1.Image = ((System.Drawing.Image)(resources.GetObject("button1.Image")));
            this.button1.Location = new System.Drawing.Point(2, 475);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(133, 91);
            this.button1.TabIndex = 9;
            this.button1.UseVisualStyleBackColor = false;
            this.button1.Click += new System.EventHandler(this.button1_Click_1);
            // 
            // Herrialdeak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(899, 598);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.tituloLabel);
            this.Controls.Add(this.ErosketaKopurua);
            this.Controls.Add(this.EzezagunakKant);
            this.Controls.Add(this.groupBox1);
            this.Name = "Herrialdeak";
            this.Text = "Herrialdeak";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Form_Close);
            this.Load += new System.EventHandler(this.Herrialdeak_Load);
            this.groupBox1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.HerrialdeChart)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.herrialdeakDataSet1BindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.herrialdeakDataSet1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.herrialdeBistaBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.herrialdeakDataSet2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.DataVisualization.Charting.Chart HerrialdeChart;
        private System.Windows.Forms.BindingSource herrialdeakDataSet1BindingSource;
        private HerrialdeakDataSet herrialdeakDataSet1;
        private HerrialdeakDataSet herrialdeakDataSet2;
        private System.Windows.Forms.BindingSource herrialdeBistaBindingSource;
        private HerrialdeakDataSetTableAdapters.HerrialdeBistaTableAdapter herrialdeBistaTableAdapter1;
        private System.Windows.Forms.Label EzezagunakKant;
        private System.Windows.Forms.Label ErosketaKopurua;
        private System.Windows.Forms.Label tituloLabel;
        private System.Windows.Forms.Button button1;
    }
}