
namespace Funciones
{
    partial class Funtzioak
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

        #region Código generado por el Diseñador de componentes

        /// <summary> 
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.patosDeGomaDataSet = new Funciones.PatosDeGomaDataSet();
            this.patosDeGomaDataSetBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.bezeroaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.bezeroaTableAdapter = new Funciones.PatosDeGomaDataSetTableAdapters.BezeroaTableAdapter();
            this.erosketaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.erosketaTableAdapter = new Funciones.PatosDeGomaDataSetTableAdapters.ErosketaTableAdapter();
            this.produktuaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.produktuaTableAdapter = new Funciones.PatosDeGomaDataSetTableAdapters.ProduktuaTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.patosDeGomaDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.patosDeGomaDataSetBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bezeroaBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.erosketaBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.produktuaBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(3, 35);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(240, 150);
            this.dataGridView1.TabIndex = 0;
            // 
            // patosDeGomaDataSet
            // 
            this.patosDeGomaDataSet.DataSetName = "PatosDeGomaDataSet";
            this.patosDeGomaDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // patosDeGomaDataSetBindingSource
            // 
            this.patosDeGomaDataSetBindingSource.DataSource = this.patosDeGomaDataSet;
            this.patosDeGomaDataSetBindingSource.Position = 0;
            // 
            // bezeroaBindingSource
            // 
            this.bezeroaBindingSource.DataMember = "Bezeroa";
            this.bezeroaBindingSource.DataSource = this.patosDeGomaDataSet;
            // 
            // bezeroaTableAdapter
            // 
            this.bezeroaTableAdapter.ClearBeforeFill = true;
            // 
            // erosketaBindingSource
            // 
            this.erosketaBindingSource.DataMember = "Erosketa";
            this.erosketaBindingSource.DataSource = this.patosDeGomaDataSet;
            // 
            // erosketaTableAdapter
            // 
            this.erosketaTableAdapter.ClearBeforeFill = true;
            // 
            // produktuaBindingSource
            // 
            this.produktuaBindingSource.DataMember = "Produktua";
            this.produktuaBindingSource.DataSource = this.patosDeGomaDataSet;
            // 
            // produktuaTableAdapter
            // 
            this.produktuaTableAdapter.ClearBeforeFill = true;
            // 
            // Funtzioak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.dataGridView1);
            this.Name = "Funtzioak";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.patosDeGomaDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.patosDeGomaDataSetBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bezeroaBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.erosketaBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.produktuaBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.BindingSource patosDeGomaDataSetBindingSource;
        private PatosDeGomaDataSet patosDeGomaDataSet;
        private System.Windows.Forms.BindingSource bezeroaBindingSource;
        private PatosDeGomaDataSetTableAdapters.BezeroaTableAdapter bezeroaTableAdapter;
        private System.Windows.Forms.BindingSource erosketaBindingSource;
        private PatosDeGomaDataSetTableAdapters.ErosketaTableAdapter erosketaTableAdapter;
        private System.Windows.Forms.BindingSource produktuaBindingSource;
        private PatosDeGomaDataSetTableAdapters.ProduktuaTableAdapter produktuaTableAdapter;
    }
}
