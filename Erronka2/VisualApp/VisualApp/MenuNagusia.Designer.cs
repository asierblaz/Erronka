
namespace VisualApp
{
    partial class MenuNagusia
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MenuNagusia));
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.batJoan = new System.Windows.Forms.Button();
            this.biJoan = new System.Windows.Forms.Button();
            this.hiruJoan = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(299, 118);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(300, 137);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // batJoan
            // 
            this.batJoan.BackColor = System.Drawing.Color.Black;
            this.batJoan.Font = new System.Drawing.Font("MV Boli", 21.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.batJoan.ForeColor = System.Drawing.Color.Goldenrod;
            this.batJoan.Location = new System.Drawing.Point(46, 327);
            this.batJoan.Name = "batJoan";
            this.batJoan.Size = new System.Drawing.Size(222, 182);
            this.batJoan.TabIndex = 1;
            this.batJoan.Text = "Gehien erosten duten bezeroak";
            this.batJoan.UseVisualStyleBackColor = false;
            this.batJoan.Click += new System.EventHandler(this.batJoan_Click);
            // 
            // biJoan
            // 
            this.biJoan.BackColor = System.Drawing.Color.Black;
            this.biJoan.Font = new System.Drawing.Font("MV Boli", 21.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.biJoan.ForeColor = System.Drawing.Color.Goldenrod;
            this.biJoan.Location = new System.Drawing.Point(345, 327);
            this.biJoan.Name = "biJoan";
            this.biJoan.Size = new System.Drawing.Size(217, 182);
            this.biJoan.TabIndex = 2;
            this.biJoan.Text = "Produktu salduenak";
            this.biJoan.UseVisualStyleBackColor = false;
            this.biJoan.Click += new System.EventHandler(this.biJoan_Click);
            // 
            // hiruJoan
            // 
            this.hiruJoan.BackColor = System.Drawing.Color.Black;
            this.hiruJoan.Font = new System.Drawing.Font("MV Boli", 21.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.hiruJoan.ForeColor = System.Drawing.Color.Goldenrod;
            this.hiruJoan.Location = new System.Drawing.Point(639, 327);
            this.hiruJoan.Name = "hiruJoan";
            this.hiruJoan.Size = new System.Drawing.Size(217, 182);
            this.hiruJoan.TabIndex = 3;
            this.hiruJoan.Text = "Gehien erosten duten herrialdeak";
            this.hiruJoan.UseVisualStyleBackColor = false;
            this.hiruJoan.Click += new System.EventHandler(this.hiruJoan_Click);
            // 
            // MenuNagusia
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(899, 598);
            this.Controls.Add(this.hiruJoan);
            this.Controls.Add(this.biJoan);
            this.Controls.Add(this.batJoan);
            this.Controls.Add(this.pictureBox1);
            this.ForeColor = System.Drawing.SystemColors.ControlText;
            this.Name = "MenuNagusia";
            this.Text = "MenuNagusia";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Button batJoan;
        private System.Windows.Forms.Button biJoan;
        private System.Windows.Forms.Button hiruJoan;
    }
}

