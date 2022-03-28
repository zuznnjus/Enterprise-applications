/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@Named(value = "chartBean")
@RequestScoped
public class ChartBean {

    private LineChartModel lineModel;
    
    public ChartBean() {
    }

    @PostConstruct
    private void init() {
        createLineModel();
    }
    
    private void createLineModel() {
        lineModel = new LineChartModel();
        lineModel.setTitle("Sine and cosine chart");
        lineModel.setLegendPosition("ws");
        lineModel.getAxis(AxisType.Y).setLabel("y");
        Axis xAxis = lineModel.getAxis(AxisType.X);
        xAxis.setLabel("x");
        xAxis.setMin(0);
        xAxis.setMin(360);
        lineModel.setZoom(true);
        
        LineChartSeries sine = new LineChartSeries();
        sine.setLabel("sin(x)");
        
        LineChartSeries cosine = new LineChartSeries();
        cosine.setLabel("cos(x)");
        
        for (int i = 0; i <= 360; i += 10) {
            double radians = Math.toRadians(i);
            sine.set(i, Math.sin(radians));
            cosine.set(i, Math.cos(radians));
        }
        
        lineModel.addSeries(sine);
        lineModel.addSeries(cosine);
    }
    
    public LineChartModel getLineModel() {
        return lineModel;
    }
}
