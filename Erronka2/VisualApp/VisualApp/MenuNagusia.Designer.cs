
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
            this.pictureBox1.BackColor = System.Drawing.Color.Transparent;
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(179, 29);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(539, 229);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // batJoan
            // 
            this.batJoan.BackColor = System.Drawing.Color.Transparent;
            this.batJoan.FlatAppearance.BorderSize = 0;
            this.batJoan.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Transparent;
            this.batJoan.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Transparent;
            this.batJoan.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.batJoan.Font = new System.Drawing.Font("MV Boli", 18F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.batJoan.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(185)))), ((int)(((byte)(153)))), ((int)(((byte)(50)))));
            this.batJoan.Image = ((System.Drawing.Image)(resources.GetObject("batJoan.Image")));
            this.batJoan.Location = new System.Drawing.Point(73, 361);
            this.batJoan.Name = "batJoan";
            this.batJoan.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.batJoan.Size = new System.Drawing.Size(160, 148);
            this.batJoan.TabIndex = 1;
            this.batJoan.UseVisualStyleBackColor = false;
            this.batJoan.Click += new System.EventHandler(this.batJoan_Click);
            // 
            // biJoan
            // 
            this.biJoan.BackColor = System.Drawing.Color.Transparent;
            this.biJoan.FlatAppearance.BorderSize = 0;
            this.biJoan.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Transparent;
            this.biJoan.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Transparent;
            this.biJoan.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.biJoan.Font = new System.Drawing.Font("MV Boli", 18F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))));
            this.biJoan.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(185)))), ((int)(((byte)(153)))), ((int)(((byte)(50)))));
            this.biJoan.Image = ((System.Drawing.Image)(resources.GetObject("biJoan.Image")));
            this.biJoan.Location = new System.Drawing.Point(378, 361);
            this.biJoan.Name = "biJoan";
            this.biJoan.Size = new System.Drawing.Size(151, 148);
            this.biJoan.TabIndex = 2;
            this.biJoan.UseVisualStyleBackColor = false;
            this.biJoan.Click += new System.EventHandler(this.biJoan_Click);
            // 
            // hiruJoan
            // 
            this.hiruJoan.BackColor = System.Drawing.Color.Transparent;
            this.hiruJoan.FlatAppearance.BorderSize = 0;
            this.hiruJoan.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Transparent;
            this.hiruJoan.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Transparent;
            this.hiruJoan.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.hiruJoan.Font = new System.Drawing.Font("MV Boli", 18F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))));
            this.hiruJoan.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(185)))), ((int)(((byte)(153)))), ((int)(((byte)(50)))));
            this.hiruJoan.Image = ((System.Drawing.Image)(resources.GetObject("hiruJoan.Image")));
            this.hiruJoan.Location = new System.Drawing.Point(680, 361);
            this.hiruJoan.Name = "hiruJoan";
            this.hiruJoan.Size = new System.Drawing.Size(151, 148);
            this.hiruJoan.TabIndex = 3;
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
            this.DoubleBuffered = true;
            this.ForeColor = System.Drawing.Color.White;
            this.Name = "MenuNagusia";
            this.Text = "MenuNagusia";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Form_Close);
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

