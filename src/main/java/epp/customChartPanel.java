package epp;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import java.awt.Color;
import java.awt.Dimension;
import epp.EppUI;
/**
 * ChartPanel with a zoomable background
 * @author placisadmin
 */

public class customChartPanel extends ChartPanel{
    private JFreeChart chart;
    private int wChart,hChart;

    /**
     *
     * @param chart graphics container
     * @param w graphics width
     * @param h graphics height
     */
    public customChartPanel(JFreeChart chart, int w, int h)
    {
        this(chart,
                w,
                h,
                DEFAULT_MINIMUM_DRAW_WIDTH,
                DEFAULT_MINIMUM_DRAW_HEIGHT,
                DEFAULT_MAXIMUM_DRAW_WIDTH,
                DEFAULT_MAXIMUM_DRAW_HEIGHT,
                DEFAULT_BUFFER_USED,
                true,  // properties
                true,  // save
                true,  // print
                true,  // zoom
                true   // tooltips
        );

        this.chart=chart;

    }


    /**
     * Create graphics container
     * <ul>
     *     <li>it chooses points to display and their colour</li>
     *     <li>it sizes the graphics</li>
     * </ul>
     * @param chart graphique
     * @param width longueur du graphique
     * @param height largeur du graphique
     * @param minimumDrawWidth
     * @param minimumDrawHeight
     * @param maximumDrawWidth
     * @param maximumDrawHeight
     * @param useBuffer
     * @param properties
     * @param save
     * @param print
     * @param zoom
     * @param tooltips
     */
    public customChartPanel(JFreeChart chart,
                            int width, int height,
                            int minimumDrawWidth, int minimumDrawHeight,
                            int maximumDrawWidth, int maximumDrawHeight,
                            boolean useBuffer,
                            boolean properties, boolean save, boolean print, boolean zoom,
                            boolean tooltips)
    {
        super(chart,
                width,
                height,
                minimumDrawWidth,
                minimumDrawHeight,
                maximumDrawWidth,
                maximumDrawHeight,
                useBuffer,
                properties,
                save,
                print,
                zoom,
                tooltips);

        this.chart=chart;
        wChart=width;
        hChart=height;

        // Disable inefficient EntityCollection
        this.getChartRenderingInfo().setEntityCollection(null);
        XYPlotWithZoomableBackgroundImage myplot = (XYPlotWithZoomableBackgroundImage) chart.getPlot();

        //Add all Transmitters,Receivers,Interference Links
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(false,true); //We want No lines but shapes

        //Set the color of renderers
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.ORANGE);
        renderer.setSeriesPaint(3, Color.BLACK);
        myplot.setRenderer(renderer);

        //set the preferred size(initial size) of the chart
        this.setPreferredSize(new Dimension(wChart,hChart)); //this.getWidth() and this.getHeight() giving both 0
        this.setVerticalAxisTrace(false);
        this.setHorizontalAxisTrace(false);

    }


}
