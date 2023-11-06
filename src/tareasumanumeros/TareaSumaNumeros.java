/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tareasumanumeros;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
/**
 *
 * @author felix
 */
public class TareaSumaNumeros extends JFrame{

    
     public TareaSumaNumeros()  {

        XYDataset setDatos = crearSetDatos();
        JFreeChart chart = crearGrafica(setDatos);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 public long sumaNNumeros(long n)
    {
        long suma = 0;
        for (long i = 1; i <= n; i++)
        {
            suma += i;
        }
        return suma;
    }
    public long sumaDeGauss (long n)
    {
        long suma = 0;
        for (long  i = 0; i < n/2; i++)
        {
            suma += n+1;
        }
        return suma;
    }
    public long sumaRecursiva  (long n)
    {
        if (n == 0)
        {
            return n;
        }
        else
        {
            return (n + sumaRecursiva(n-1));
        }
    }
    private XYDataset crearSetDatos() {

        var series1 = new XYSeries("Suma iterativa");
        series1.add(0, 49300);
        series1.add(50, 25100);
        series1.add(100, 27500);
        series1.add(1000, 37900);
        series1.add(10000, 151100);

        var series2 = new XYSeries("Suma de gauss");
        series2.add(0, 19800);
        series2.add(50, 25100);
        series2.add(100, 25000);
        series2.add(1000, 29700);
        series2.add(10000, 109600);
        
        var series3 = new XYSeries("Suma recursiva");
        series3.add(0, 20900);
        series3.add(50, 21800);
        series3.add(100, 30100);
        series3.add(1000, 117700);
        series3.add(10000, 587900);

        var datos = new XYSeriesCollection();
        datos.addSeries(series1);
        datos.addSeries(series2);
        datos.addSeries(series3);

        return datos;
    }

    private JFreeChart crearGrafica(final XYDataset setDatos) {

        JFreeChart chart = ChartFactory.createXYLineChart("Suma de n numeros", "n","Nano segundos", setDatos,
                PlotOrientation.VERTICAL,true,true,false);

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Average Salary per Age",
                        new Font("Serif", Font.BOLD, 18)
                )
        );

        return chart;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new TareaSumaNumeros();
            ex.setVisible(true);
        });
    }
}
