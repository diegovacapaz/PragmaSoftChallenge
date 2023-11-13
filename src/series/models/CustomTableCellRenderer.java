/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.models;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Diego
 */
public class CustomTableCellRenderer extends DefaultTableCellRenderer{
    private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column == SeriesTable.RATE_COL_INDEX) {
            if (value instanceof Number) {
                setHorizontalAlignment(JLabel.RIGHT);
                setText(value.toString());
            }
        }

        if (column == SeriesTable.PRICE_COL_INDEX) {
            if (value instanceof Number) {
                setHorizontalAlignment(JLabel.RIGHT);
                setText(currencyFormatter.format(value));
            }
        }

        if (column == SeriesTable.ATP_COL_INDEX) {
            if (value instanceof Boolean) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected((Boolean) value);
                checkBox.setHorizontalAlignment(JLabel.CENTER);
                checkBox.setEnabled(false);
                return checkBox;
            }
        }

        return cellComponent;
    }
}
