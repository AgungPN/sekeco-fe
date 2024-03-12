/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.kasirfrontend;

import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.text.DefaultFormatter;

/**
 *
 * @author Lenovo
 */
public class QtyCellEditor extends DefaultCellEditor {
    
    private JSpinner input;
    private JTable table;
    private int row;
    private ModelItemSell item;
    private EventCellInputChange event;
    
    
    

    public QtyCellEditor(EventCellInputChange event)  {
        super(new JCheckBox());
        this.event = event;
        input=new JSpinner();
        SpinnerNumberModel numberModel=(SpinnerNumberModel)input.getModel();
        numberModel.setMinimum(1);
        JSpinner.NumberEditor editor=(JSpinner.NumberEditor)input.getEditor();
        DefaultFormatter formatter=(DefaultFormatter)editor.getTextField().getFormatter();
        formatter.setCommitsOnValidEdit(true);
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        input.addChangeListener((ChangeEvent e) -> {
            inputChange();
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table=table;
                this.row=row;
                this.item=(ModelItemSell)table.getValueAt(row, 0);
        super.getTableCellEditorComponent(table, value, isSelected, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        int qty=Integer.parseInt(value.toString());
        input.setValue(qty);
        return input;
    }

    @Override
    public Object getCellEditorValue() {
        return input.getValue(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

   private void inputChange(){
       int qty=Integer.parseInt(input.getValue().toString());
       if (qty != item.getQty()) {
            DecimalFormat df = new DecimalFormat(" #,##0.##");
            item.setQty(qty);
            item.setTotal(item.getPrice() * qty);
            table.setValueAt("Rp " + df.format(item.getTotal()), row, 5);
            event.inputChanged();
        }
   }
}
