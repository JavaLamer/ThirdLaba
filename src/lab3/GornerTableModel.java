package lab3;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 3;
    }


    public int getRowCount() {
        return (int) (Math.ceil((to - from) / step)) + 1;
    }

    public Object getValueAt(int row, int col) {
        Double x = from + step*row;
        Double result = x;
        Double temp = result;
        int i = 0;
        if (col==0)
            return x;
        else if (col==1){
           i = 0;
        result = result * x;
        result = result + x * coefficients[i++];
            return result;
        }
        else {
            result = result * x;
            result = result + x * coefficients[i++];
            temp = Double.valueOf(result.intValue());
            if (result - temp == 0) {
                return true;
            }
            return false;
        }

    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            default:
                return "Точное значение?";
        }
    }

    public Class<?> getColumnClass(int col) {
        if (col!=2)
            return Double.class;
        return Boolean.class;
    }
}